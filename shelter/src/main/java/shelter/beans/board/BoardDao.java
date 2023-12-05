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
        String sql = "INSERT INTO your_board_table (boardTitle, boardContent, boardWriter, boardLocation, firstCategory, secondCategory) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, board.getBoardTitle());
            ps.setString(2, board.getBoardContent());
            ps.setString(3, board.getBoardWriter());
            ps.setString(4, board.getBoardLocation());
            ps.setString(5, board.getFirstCategory());
            ps.setString(6, board.getSecondCategory());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }  finally {
		    JdbcUtil.close(this.conn, null, null);
		}
    }

    // 게시물 삭제
    public void deleteBoard(int boardId) {
        String sql = "DELETE FROM your_board_table WHERE boardId = ?";

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
        String sql = "UPDATE your_board_table SET boardTitle = ?, boardContent = ?, boardWriter = ?, boardLocation = ?, firstCategory = ?, secondCategory = ? WHERE boardId = ?";

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

        String sql = "SELECT * FROM your_board_table WHERE boardId = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, boardId);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    boardDto = new BoardDto();
                    boardDto.setBoardId(rs.getInt("boardId"));
                    boardDto.setBoardTitle(rs.getString("boardTitle"));
                    boardDto.setBoardContent(rs.getString("boardContent"));
                    boardDto.setBoardWriter(rs.getString("boardWriter"));
                    boardDto.setBoardDate(rs.getTimestamp("boardDate"));
                    boardDto.setBoardLocation(rs.getString("boardLocation"));
                    boardDto.setFirstCategory(rs.getString("firstCategory"));
                    boardDto.setSecondCategory(rs.getString("secondCategory"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	JdbcUtil.close(this.conn, null, null);
        }

        return boardDto;
    }
    
    // 게시글 전체 글 카운트
    
    // 게시글 대분류 검색

    // 게시글 중분류 검색
    
    // 게시물 목록 보기 - 최신글
    public List<BoardDto> getLatestPosts(int numberOfPosts) {
        List<BoardDto> latestPosts = new ArrayList<>();
        String sql = "SELECT * FROM your_board_table ORDER BY boardDate DESC LIMIT ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, numberOfPosts);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    BoardDto board = new BoardDto();
                    board.setBoardId(rs.getInt("boardId"));
                    board.setBoardTitle(rs.getString("boardTitle"));
                    board.setBoardContent(rs.getString("boardContent"));
                    board.setBoardWriter(rs.getString("boardWriter"));
                    board.setBoardDate(rs.getTimestamp("boardDate"));
                    board.setBoardLocation(rs.getString("boardLocation"));
                    board.setFirstCategory(rs.getString("firstCategory"));
                    board.setSecondCategory(rs.getString("secondCategory"));

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

        String sql = "SELECT boardId " +
                     "FROM your_board_table " +
                     "WHERE boardWriter = ? " +
                     "ORDER BY boardDate DESC " +
                     "LIMIT 1";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userId);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    lastInsertedId = rs.getInt("boardId");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	JdbcUtil.close(this.conn, null, null);
        }

        return lastInsertedId;
    }
    // 게시글 조회
    
    // 게시글 조회수 증가 여부 (본인 제외)
}
