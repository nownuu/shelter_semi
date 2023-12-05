package shelter.beans.image;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

    // 단일 이미지 업로드
    public void uploadImage(ImageDto imageDto) {
        String sql = "INSERT INTO your_image_table (boardId, fileUpload, fileSave, fileSize, fileType) VALUES (?, ?, ?, ?, ?)";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, imageDto.getboardId());
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
        String sql = "SELECT * FROM your_image_table WHERE imageId = ?";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, imageNo);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    ImageDto imageDto = new ImageDto();
                    imageDto.setimageId(rs.getInt("imageId"));
                    imageDto.setboardId(rs.getInt("boardId"));
                    imageDto.setFileUpload(rs.getString("fileUpload"));
                    imageDto.setFileSave(rs.getString("fileSave"));
                    imageDto.setFileSize(rs.getLong("fileSize"));
                    imageDto.setFileType(rs.getString("fileType"));
                    return imageDto;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	JdbcUtil.close(this.conn, null, null);
        }

        return null; // Return null if no image found
    }

    
    // 게시판에 글 작성시 업로드 될 이미지
    public void uploadBoardWithImages(BoardImageVo boardImageVo) {
        try {
            conn.setAutoCommit(false);

            // 1. 게시글 정보 저장
            String boardSql = "INSERT INTO your_board_table (boardTitle, boardContent, boardWriter, boardDate, boardLocation, firstCategory, secondCategory) VALUES (?, ?, ?, ?, ?, ?, ?)";
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
            String imageSql = "INSERT INTO your_image_table (boardId, fileUpload, fileSave, fileSize, fileType) VALUES (?, ?, ?, ?, ?)";
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

}
