package shelter.servlet.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shelter.beans.member.MemberDao;
import shelter.beans.member.MemberDto;

@WebServlet("/test/updateInfo.do")
public class MemberUpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setCharacterEncoding("UTF-8");
            
            // 세션에서 회원 ID 가져오기
            String memberId = (String) req.getSession().getAttribute("uid");
            
            String memberPw = req.getParameter("memberPw");
            String memberNickname = req.getParameter("memberNickname");
            String memberPhone = req.getParameter("memberPhone");
            String memberEmail = req.getParameter("memberEmail");
            String memberGender = req.getParameter("memberGender");
            String memberAddress = req.getParameter("memberAddress");

            // 수정된 정보를 MemberDto에 설정
            MemberDto updatedMember = new MemberDto();
            updatedMember.setMemberId(memberId);
            updatedMember.setMemberPw(memberPw);
            updatedMember.setMemberNickname(memberNickname);
            updatedMember.setMemberPhone(memberPhone);
            updatedMember.setMemberEmail(memberEmail);
            updatedMember.setMemberGender(memberGender);
            updatedMember.setMemberAddress(memberAddress);

            // 회원 정보 업데이트
            MemberDao memberDao = new MemberDao();
            boolean success = memberDao.updateMemberById(updatedMember);

            if (success) {
                // 성공
                resp.sendRedirect(req.getContextPath() + "/test/updateInfo.jsp");
            } else {
                //  실패 시 에러 처리
                resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
}
