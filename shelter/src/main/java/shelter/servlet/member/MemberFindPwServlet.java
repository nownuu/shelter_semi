package shelter.servlet.member;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.security.SecureRandom;
import java.util.Random;

import shelter.beans.member.MemberDao;
import shelter.beans.member.MemberDto;

@WebServlet("/test/findPw.do")
public class MemberFindPwServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setCharacterEncoding("UTF-8");

            String memberId = req.getParameter("memberId");
            String memberName = req.getParameter("memberName");
            String memberPhone = req.getParameter("memberPhone");

            // 처리
            MemberDao memberDao = new MemberDao();
            String foundPassword = generatePassword();
            System.out.println(memberDao.toString());
            MemberDto member = memberDao.getMemberById(memberId);

            if (member != null && memberPhone.equals(member.getMemberPhone())) {
                // 이메일로 임시 비밀번호 발송
                sendPassword(member.getMemberEmail(), memberId, foundPassword);

                // 비밀번호 찾기 결과 페이지로 이동
                resp.sendRedirect("findPw_result.jsp?result=success");
            } else {
                req.setAttribute("error", "입력한 정보와 일치하는 회원이 없습니다.");
                req.getRequestDispatcher("findPw_result.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendError(500);
        }
    }


 // 이메일로 임시 비밀번호 발송
    private void sendPassword(String toAddress, String memberId, String password) throws MessagingException {
        // 구글 계정 정보
        String host = "smtp.gmail.com";
        String username = "sh8top@dongyang.ac.kr"; // 발송자 Gmail 계정
        String password1 = "@senash0106"; // Gmail 비밀번호

        // 메일 속성 설정
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");

        // 세션 생성
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new javax.mail.PasswordAuthentication(username, password1);
            }
        });

     // 메시지 생성
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(username));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(toAddress));  // toAddress 수정
        message.setSubject("임시 비밀번호 발송");
        message.setText("안녕하세요, " + memberId + "님!\n\n"
                + "임시 비밀번호는 " + password + " 입니다.\n"
                + "로그인 후에는 비밀번호를 변경해 주세요.");

        // 메일 전송
        Transport.send(message);
        
        // 데이터베이스에 새로운 비밀번호 업데이트
        MemberDao memberDao = new MemberDao();
        memberDao.updatePassword(memberId, password);
    }

    // 임시 비밀번호 발급
    private String generatePassword() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+";
        
        int length = 12;
        Random random = new SecureRandom();
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < length; i++) {
            password.append(characters.charAt(random.nextInt(characters.length())));
        }

        return password.toString();
    }
}
