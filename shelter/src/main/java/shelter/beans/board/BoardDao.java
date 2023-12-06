package shelter.beans.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import shelter.util.JdbcUtil;

public class BoardDao {

	private Connection conn;

    public BoardDao() {
        try {
            this.conn = JdbcUtil.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("데이터베이스 연결 실패");
        }
    }

    // 게시물 등록
    public void recordBoard(BoardDto board) {
        String sql = "INSERT INTO board (board_title, board_content, board_writer, board_date, board_location, first_category, second_category) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, board.getBoardTitle());
            ps.setString(2, board.getBoardContent());
            ps.setString(3, board.getBoardWriter());
            ps.setTimestamp(4, board.getBoardDate());
            ps.setString(5, board.getBoardLocation());
            ps.setString(6, board.getFirstCategory());
            ps.setString(7, board.getSecondCategory());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }  finally {
            JdbcUtil.close(this.conn, null, null);
        }
    }

    // 게시물 삭제
    public void deleteBoard(int boardId) {
        String sql = "DELETE FROM board WHERE board_id = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, boardId);

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(this.conn, null, null);
        }
    }

    // 게시물 수정
    public void updateBoard(BoardDto board) {
        String sql = "UPDATE board SET board_title = ?, board_content = ?, board_writer = ?, board_location = ?, first_category = ?, second_category = ? WHERE board_id = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, board.getBoardTitle());
            ps.setString(2, board.getBoardContent());
            ps.setString(3, board.getBoardWriter());
            ps.setString(4, board.getBoardLocation());
            ps.setString(5, board.getFirstCategory());
            ps.setString(6, board.getSecondCategory());
            ps.setInt(7, board.getBoardId());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(this.conn, null, null);
        }
    }

    // 게시물 상세 정보 보기
    public BoardDto getBoardDetail(int boardId) {
        BoardDto boardDto = null;

        String sql = "SELECT * FROM board WHERE board_id = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, boardId);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    boardDto = new BoardDto();
                    boardDto.setBoardId(rs.getInt("board_id"));
                    boardDto.setBoardTitle(rs.getString("board_title"));
                    boardDto.setBoardContent(rs.getString("board_content"));
                    boardDto.setBoardWriter(rs.getString("board_writer"));
                    boardDto.setBoardDate(rs.getTimestamp("board_date"));
                    boardDto.setBoardLocation(rs.getString("board_location"));
                    boardDto.setFirstCategory(rs.getString("first_category"));
                    boardDto.setSecondCategory(rs.getString("second_category"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(this.conn, null, null);
        }

        return boardDto;
    }

    // 게시물 목록 보기 - 최신글
    public List<BoardDto> getLatestPosts(int numberOfPosts) {
        List<BoardDto> latestPosts = new ArrayList<>();
        String sql = "SELECT * FROM board ORDER BY board_date DESC LIMIT ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, numberOfPosts);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    BoardDto board = new BoardDto();
                    board.setBoardId(rs.getInt("board_id"));
                    board.setBoardTitle(rs.getString("board_title"));
                    board.setBoardContent(rs.getString("board_content"));
                    board.setBoardWriter(rs.getString("board_writer"));
                    board.setBoardDate(rs.getTimestamp("board_date"));
                    board.setBoardLocation(rs.getString("board_location"));
                    board.setFirstCategory(rs.getString("first_category"));
                    board.setSecondCategory(rs.getString("second_category"));

                    latestPosts.add(board);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(this.conn, null, null);
        }

        return latestPosts;
    }

    // 마지막으로 삽입된 게시물의 ID - 게시물 등록 후에 보여지기 위한
    // 본인(회원)의 아이디를 기준으로 가장 최신이 보여지게 함
    public int getLastInsertedBoardIdForUser(String userId) {
        int lastInsertedId = -1;

        String sql = "SELECT board_id " +
                     "FROM board " +
                     "WHERE board_writer = ? " +
                     "ORDER BY board_date DESC " +
                     "LIMIT 1";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userId);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    lastInsertedId = rs.getInt("board_id");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(this.conn, null, null);
        }

        return lastInsertedId;
    }
}
