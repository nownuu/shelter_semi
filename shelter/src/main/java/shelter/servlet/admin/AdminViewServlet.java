package shelter.servlet.admin;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import shelter.beans.admin.AdminDao;
import shelter.beans.member.MemberDto;

@WebServlet("/test/admin/memberView.do")
public class AdminViewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            // 관리자 여부 확인
            String grade = (String) req.getSession().getAttribute("grade");

            if (grade == null || !"관리자".equals(grade)) {
                // 관리자가 아닌 경우 로그인 페이지로 리다이렉트
                resp.sendRedirect(req.getContextPath() + "/test/login.jsp");
                return;
            }

            AdminDao adminDao = new AdminDao();
            List<MemberDto> members = adminDao.getAllMembers();

            // 가져온 회원 정보를 request에 저장
            req.setAttribute("members", members);

            RequestDispatcher dispatcher = req.getRequestDispatcher("/test/admin/memberView.jsp");
            dispatcher.forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Internal Server Error");
        }
    }
}

