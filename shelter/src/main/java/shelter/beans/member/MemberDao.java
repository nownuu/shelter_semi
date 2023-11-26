package shelter.beans.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import shelter.util.JdbcUtil;

public class MemberDao {
	
	private Connection conn;
	
    public MemberDao() {
        try {
            this.conn = JdbcUtil.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("데이터베이스 연결 실패");
        }
    }
    
    // 회원가입
    public void joinMember(MemberDto member) {
    	String sql = "INSERT INTO member (member_id, member_pw, member_phone, member_email, member_gender, member_address) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, member.getMemberId());
			ps.setString(2, member.getMemberPw());
			ps.setString(3, member.getMemberPhone());
			ps.setString(4, member.getMemberEmail());
			ps.setString(5, member.getMemberGender());
			ps.setString(6, member.getMemberAddress());
		
			ps.execute();
//			conn.commit();
			
		} catch (SQLException ex) {
		    ex.printStackTrace();
		} finally {
		    JdbcUtil.close(this.conn, null, null);
		}
    }
    
    // 로그인
    public MemberDto login(String memberId, String memberPw) {
        String sql = "SELECT member_id, member_grade FROM member WHERE member_id=? AND member_pw=?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, memberId);
            ps.setString(2, memberPw);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    MemberDto memberDto = new MemberDto();
                    
                    memberDto.setMemberId(rs.getString("member_id"));
                    memberDto.setMemberGrade(rs.getString("member_grade"));
                    
                    return memberDto;
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            JdbcUtil.close(this.conn, null, null);
        }
        
        // error
        return null;
    }

    // 아이디 찾기
    
    // 비밀번호 찾기
    
    // 정보 수정
    
    // 정보 보기
    
    //  회원 탈퇴
}
