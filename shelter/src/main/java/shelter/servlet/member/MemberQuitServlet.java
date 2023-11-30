package shelter.servlet.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shelter.beans.member.MemberDao;

@WebServlet("/test/memberQuit.do")
public class MemberQuitServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			 req.setCharacterEncoding("UTF-8");
			 
			 	// 세션에서 회원 ID 가져오기
	            String memberId = (String) req.getSession().getAttribute("uid");
			
	            MemberDao memberDao = new MemberDao();
	            boolean success = memberDao.quitMemberById(memberId);

	            if (success) {
	                req.getSession().invalidate();
	                resp.sendRedirect(req.getContextPath() + "/index.jsp");
	            } else {
	                resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
	            }
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
	}
}
