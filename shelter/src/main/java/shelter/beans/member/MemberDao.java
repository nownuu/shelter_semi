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
    public String findId(String memberName, String memberPhone) {
        String sql = "SELECT member_id FROM member WHERE member_name=? AND member_phone=?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, memberName);
            ps.setString(2, memberPhone);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("member_id");
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            JdbcUtil.close(this.conn, null, null);
        }

        return null;
    }

    // 비밀번호 찾기
    public String findPw(String memberId, String memberName, String memberPhone) {
    	String sql = "SELECT member_pw FROM member WHERE member_id=? AND member_name=? AND member_phone=?";
    	
    	try(PreparedStatement ps = conn.prepareStatement(sql)){
    		
    		ps.setString(1, memberId);
    		ps.setString(2, memberName);
            ps.setString(3, memberPhone);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("member_pw");
                }
            }
    		
    	} catch(SQLException ex) {
    		ex.printStackTrace();
    	} finally {
    		JdbcUtil.close(this.conn, null, null);
    	}
    	return null;
    }
    
    // 정보 보기
    public MemberDto getMemberById(String memberId) {
        String sql = "SELECT * FROM member WHERE member_id=?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, memberId);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    MemberDto memberDto = new MemberDto();

                    memberDto.setMemberId(rs.getString("member_id"));
                    memberDto.setMemberPw(rs.getString("member_pw"));
                    memberDto.setMemberPhone(rs.getString("member_phone"));
                    memberDto.setMemberEmail(rs.getString("member_email"));
                    memberDto.setMemberGender(rs.getString("member_gender"));
                    memberDto.setMemberAddress(rs.getString("member_address"));

                    return memberDto;
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            JdbcUtil.close(this.conn, null, null);
        }
        return null;
    }

    
    // 정보 수정
    public void editMember(MemberDto member) {
        String sql = "UPDATE member SET member_pw=?, member_phone=?, member_email=?, member_gender=?, member_address=? WHERE member_id=?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, member.getMemberPw());
            ps.setString(2, member.getMemberPhone());
            ps.setString(3, member.getMemberEmail());
            ps.setString(4, member.getMemberGender());
            ps.setString(5, member.getMemberAddress());
            ps.setString(6, member.getMemberId());

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Member information updated successfully");
            } else {
                System.out.println("No member found with the specified ID");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            JdbcUtil.close(this.conn, null, null);
        }
    }

    
    //  회원 탈퇴
    
    
}
