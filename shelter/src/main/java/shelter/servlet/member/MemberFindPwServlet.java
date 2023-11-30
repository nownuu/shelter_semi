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
            String memberEmail = req.getParameter("memberEmail");

            // 처리
            MemberDao memberDao = new MemberDao();
            MemberDto member = memberDao.getMemberById(memberId);

            if (member != null && memberEmail.equals(member.getMemberEmail())) {
                // 이메일로 임시 비밀번호 발송
                sendPassword(member.getMemberEmail(), memberId, memberDao);

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
    private void sendPassword(String toAddress, String memberId, MemberDao memberDao) throws MessagingException {
        // 구글 계정 정보
        String host = "smtp.gmail.com";
        String username = "수정"; // 발송자 Gmail 계정
        String password = "수정"; // Gmail 비밀번호

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
                return new javax.mail.PasswordAuthentication(username, password);
            }
        });

        // 메시지 생성
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(username));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(toAddress));
        message.setSubject("임시 비밀번호 발송");
        message.setText("안녕하세요, " + memberId + "님!\n\n"
                + "임시 비밀번호는 " + generateTemporaryPassword() + " 입니다.\n"
                + "로그인 후에는 비밀번호를 변경해 주세요.");

        // 메일 전송
        Transport.send(message);
    }

    // 임시 비밀번호 생성 
    private String generateTemporaryPassword() {
        
        return "tempPassword123"; // 수정 필요...
    }
}
