package shelter.servlet.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shelter.beans.admin.AdminDao;

@WebServlet("/test/admin/deleteMember.do")
public class AdminDeleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String memberId = req.getParameter("memberId");

            // 회원 삭제
            AdminDao adminDao = new AdminDao();
            boolean deleteSuccess = adminDao.deleteMember(memberId);

            if (deleteSuccess) {
                // 삭제 성공 시 메시지를 request에 추가
                req.setAttribute("message", "회원이 성공적으로 삭제되었습니다.");
            } else {
                // 삭제 실패 시 메시지를 request에 추가
                req.setAttribute("message", "회원 삭제에 실패하였습니다.");
            }

            // 삭제 결과 페이지로 이동
            RequestDispatcher dispatcher = req.getRequestDispatcher("/test/admin/deleteResult.jsp");
            dispatcher.forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Internal Server Error");
        }
    }
}

