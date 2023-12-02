package shelter.beans.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import shelter.beans.member.MemberDao;
import shelter.beans.member.MemberDto;
import shelter.util.JdbcUtil;

public class AdminDao extends MemberDao {
	
	private Connection conn;
	
    public AdminDao() {
        try {
            this.conn = JdbcUtil.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("데이터베이스 연결 실패");
        }
    }

    // 전체 회원 목록 보기
    public List<MemberDto> getAllMembers() {
        List<MemberDto> members = new ArrayList<>();
        String sql = "SELECT * FROM member";

        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                MemberDto memberDto = new MemberDto();
                memberDto.setMemberId(rs.getString("member_id"));
                memberDto.setMemberPw(rs.getString("member_pw"));
                memberDto.setMemberName(rs.getString("member_name"));
                memberDto.setMemberNickname(rs.getString("member_nickname"));
                memberDto.setMemberPhone(rs.getString("member_phone"));
                memberDto.setMemberEmail(rs.getString("member_email"));
                memberDto.setMemberGender(rs.getString("member_gender"));
                memberDto.setMemberAddress(rs.getString("member_address"));

                members.add(memberDto);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            JdbcUtil.close(this.conn, null, null);
        }

        System.out.println(members);
        return members;
    }

    // 회원 정보 수정
    public boolean updateMember(MemberDto member) {
        String sql = "UPDATE member SET member_nickname=?, member_gender=?, member_grade=? WHERE member_id=?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, member.getMemberNickname());
            ps.setString(2, member.getMemberGender());
            ps.setString(3, member.getMemberGrade());
            ps.setString(4, member.getMemberId());

            int rowsAffected = ps.executeUpdate();

            return rowsAffected > 0;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            JdbcUtil.close(this.conn, null, null);
        }
    }

    // 회원 삭제
    public boolean deleteMember(String memberId) {
        String sql = "DELETE FROM member WHERE member_id=?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, memberId);

            int rowsAffected = ps.executeUpdate();

            return rowsAffected > 0;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            JdbcUtil.close(this.conn, null, null);
        }
    }
}

