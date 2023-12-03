package shelter.servlet.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shelter.beans.member.MemberDao;
import shelter.beans.member.MemberDto;

@WebServlet("/test/memberInfo.do")
public class MemberInfoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String memberId = (String) req.getSession().getAttribute("uid");
            
            // 콘솔 확인용
//            System.out.println("회원 정보 보기: " + memberId);

            if (memberId != null) {
                MemberDao memberDao = new MemberDao();
                MemberDto memberDto = memberDao.getMemberById(memberId);
                
                // 콘솔 확인용
//                System.out.println("인포 서블릿"+memberDto);
                
                req.setAttribute("memberDto", memberDto);
                req.getRequestDispatcher("/test/memberInfo.jsp").forward(req, resp);
            } else {
                resp.sendRedirect(req.getContextPath() + "/test/login.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
