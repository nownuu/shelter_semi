package shelter.beans.image;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import shelter.beans.board.BoardDto;
import shelter.beans.board.BoardImageVo;
import shelter.util.JdbcUtil;

public class ImageDao {

	private Connection conn;

    public ImageDao() {
        try {
            this.conn = JdbcUtil.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("데이터베이스 연결 실패");
        }
    }

    // 이미지 업로드
    public void uploadImage(ImageDto imageDto) {
        String sql = "INSERT INTO image (board_id, file_upload, file_save, file_size, file_type) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, imageDto.getBoardId());
            ps.setString(2, imageDto.getFileUpload());
            ps.setString(3, imageDto.getFileSave());
            ps.setLong(4, imageDto.getFileSize());
            ps.setString(5, imageDto.getFileType());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(this.conn, null, null);
        }
    }

    // 이미지 수정 - 글 수정 시에 파일 내 삭제
    public void updateImage(ImageDto imageDto) {
        // Implement the update logic here
    }

    // 이미지 삭제 - 글 삭제 시에 파일 내 같이 삭제
    public void deleteImage(int imageNo) {
        // Implement the delete logic here
    }

 // 이미지 조회 (단일)
    public ImageDto getImage(int imageNo) {
        String sql = "SELECT * FROM image WHERE image_id = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, imageNo);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    ImageDto imageDto = new ImageDto();
                    imageDto.setImageId(rs.getInt("image_id"));
                    imageDto.setBoardId(rs.getInt("board_id"));
                    imageDto.setFileUpload(rs.getString("file_upload"));
                    imageDto.setFileSave(rs.getString("file_save"));
                    imageDto.setFileSize(rs.getLong("file_size"));
                    imageDto.setFileType(rs.getString("file_type"));
                    return imageDto;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(this.conn, null, null);
        }

        return null; 
    }


    
 // 게시판에 글 작성 시 업로드 될 이미지
    public void uploadBoardWithImages(BoardImageVo boardImageVo) {
        try {
            conn.setAutoCommit(false);

            // 1. 게시글 정보 저장
            String boardSql = "INSERT INTO board (board_title, board_content, board_writer, board_date, board_location, first_category, second_category) VALUES (?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement boardps = conn.prepareStatement(boardSql, Statement.RETURN_GENERATED_KEYS)) {
                BoardDto boardDto = boardImageVo.getBoardDto();

                boardps.setString(1, boardDto.getBoardTitle());
                boardps.setString(2, boardDto.getBoardContent());
                boardps.setString(3, boardDto.getBoardWriter());
                boardps.setTimestamp(4, boardDto.getBoardDate());
                boardps.setString(5, boardDto.getBoardLocation());
                boardps.setString(6, boardDto.getFirstCategory());
                boardps.setString(7, boardDto.getSecondCategory());

                int affectedRows = boardps.executeUpdate();

                if (affectedRows == 0) {
                    throw new SQLException("Creating board failed, no rows affected.");
                }

                // 생성된 게시글의 ID를 얻어옴
                try (ResultSet generatedKeys = boardps.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        boardDto.setBoardId(generatedKeys.getInt(1));
                    } else {
                        throw new SQLException("Creating board failed, no ID obtained.");
                    }
                }
            }

            // 2. 이미지 정보 저장
            String imageSql = "INSERT INTO image (board_id, file_upload, file_save, file_size, file_type) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement imageps = conn.prepareStatement(imageSql)) {
                List<ImageDto> imageDtos = boardImageVo.getImageDtos();

                for (ImageDto imageDto : imageDtos) {
                    imageps.setInt(1, boardImageVo.getBoardDto().getBoardId());
                    imageps.setString(2, imageDto.getFileUpload());
                    imageps.setString(3, imageDto.getFileSave());
                    imageps.setLong(4, imageDto.getFileSize());
                    imageps.setString(5, imageDto.getFileType());

                    imageps.addBatch();
                }

                imageps.executeBatch();
            }

            conn.commit();
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                conn.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            JdbcUtil.close(this.conn, null, null);
        }
    }

 // 특정 게시물에 등록된 이미지 목록 조회
    public List<ImageDto> getImagesByBoardId(int boardId) {
        List<ImageDto> imageDtos = new ArrayList<>();
        String sql = "SELECT * FROM image WHERE board_id = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, boardId);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    ImageDto imageDto = new ImageDto();
                    imageDto.setImageId(rs.getInt("image_id"));
                    imageDto.setBoardId(rs.getInt("board_id"));
                    imageDto.setFileUpload(rs.getString("file_upload"));
                    imageDto.setFileSave(rs.getString("file_save"));
                    imageDto.setFileSize(rs.getLong("file_size"));
                    imageDto.setFileType(rs.getString("file_type"));
                    imageDtos.add(imageDto);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(this.conn, null, null);
        }

        return imageDtos;
    }


}