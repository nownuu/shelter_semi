package shelter.servlet.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shelter.beans.member.MemberDao;
import shelter.beans.member.MemberDto;

@WebServlet("/test/findId.do")
public class MemberFindIdServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    try {
	        req.setCharacterEncoding("UTF-8");

	        String memberName = req.getParameter("memberName");
	        String memberPhone = req.getParameter("memberPhone");

	        MemberDto memberDto = new MemberDto();
	        memberDto.setMemberName(memberName);
	        memberDto.setMemberPhone(memberPhone);

	        //처리
	        MemberDao memberDao = new MemberDao();
	        String memberId = memberDao.findId(memberName, memberPhone);

	        if (memberId != null) { // 찾아지면 결과 보여주기
	            resp.sendRedirect("findId_result.jsp?mem_id=" + memberId);
	        } else {
	            memberId = "검색 결과가 없습니다.";
	            req.setAttribute("error", memberId);
	            req.getRequestDispatcher("findId_result.jsp").forward(req, resp);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        resp.sendError(500);
	    }
	}

}
