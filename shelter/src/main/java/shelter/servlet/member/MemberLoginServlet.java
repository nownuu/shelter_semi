package shelter.servlet.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shelter.beans.member.MemberDao;
import shelter.beans.member.MemberDto;

@WebServlet("/test/login.do")
public class MemberLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			req.setCharacterEncoding("UTF-8");
			String memberId = req.getParameter("memberId");
			String memberPw = req.getParameter("memberPw");

			//처리
			MemberDao memberDao = new MemberDao();
			MemberDto memberDto = memberDao.login(memberId, memberPw);
			
			// 콘솔 확인용
			System.out.println("로그인 확인 : "+memberDto);
			
			// 세션 저장
			if(memberDto != null) {
				req.getSession().setAttribute("uid", memberId);
				req.getSession().setAttribute("grade", memberDto.getMemberGrade());
				resp.sendRedirect(req.getContextPath() + "/index.jsp");
			} // else 여부 생각 -> login.jsp?error
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			resp.sendError(500); //
		}
	}

}
