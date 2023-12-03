package shelter.servlet.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shelter.beans.admin.AdminDao;
import shelter.beans.member.MemberDto;

@WebServlet("/test/admin/editMember.do")
public class AdminEditServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setCharacterEncoding("UTF-8");

            // 폼에서 전달된 회원 정보를 가져옴
            String memberId = req.getParameter("memberId");
            String memberNickname = req.getParameter("memberNickname");
            String memberGender = req.getParameter("memberGender");
            String memberGrade = req.getParameter("memberGrade");

            // 수정할 회원 정보를 MemberDto에 설정
            MemberDto updatedMember = new MemberDto();
            updatedMember.setMemberId(memberId);
            updatedMember.setMemberNickname(memberNickname);
            updatedMember.setMemberGender(memberGender);
            updatedMember.setMemberGrade(memberGrade);

            // 회원 정보 업데이트
            AdminDao adminDao = new AdminDao();
            boolean updateSuccess = adminDao.updateMember(updatedMember);

            if (updateSuccess) {
                // 업데이트 성공 시 메시지를 request에 추가
                req.setAttribute("message", "회원 정보가 성공적으로 수정되었습니다.");
            } else {
                // 업데이트 실패 시 메시지를 request에 추가
                req.setAttribute("message", "회원 정보 수정에 실패하였습니다.");
            }

            // 수정 결과 페이지로 이동
            RequestDispatcher dispatcher = req.getRequestDispatcher("/test/admin/editResult.jsp");
            dispatcher.forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Internal Server Error");
        }
    }
}


