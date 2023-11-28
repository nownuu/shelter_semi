package shelter.servlet.member;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shelter.beans.member.MemberDao;
import shelter.beans.member.MemberDto;

@WebServlet("/test/join.do")
public class MemberJoinServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setCharacterEncoding("UTF-8");
			
			MemberDto memberDto = new MemberDto();
			memberDto.setMemberId(req.getParameter("memberId"));
			memberDto.setMemberPw(req.getParameter("memberPw"));
			memberDto.setMemberName(req.getParameter("memberName"));
			memberDto.setMemberNickname(req.getParameter("memberNickname"));
			memberDto.setMemberPhone(req.getParameter("memberPhone"));
			memberDto.setMemberEmail(req.getParameter("memberEmail"));
			memberDto.setMemberGender(req.getParameter("memberGender"));
			memberDto.setMemberAddress(req.getParameter("memberAddress"));
		    memberDto.setMemberJoin(new Timestamp(System.currentTimeMillis())); //헌재 시간
			memberDto.setMemberGrade(req.getParameter("memberGrade"));

			// 처리
			MemberDao memberDao = new MemberDao();
			memberDao.joinMember(memberDto);
			
			resp.sendRedirect("joinSuccess.jsp"); // 성공 시 리다이렉트
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		    resp.sendError(500); // 에러페이지 500번
		}
	}
}
