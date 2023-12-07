package shelter.beans.image;

import java.sql.Timestamp;

/*
 * CREATE TABLE image (
    image_id INT PRIMARY KEY AUTO_INCREMENT,
    board_id INT,
    file_upload VARCHAR(255) ,
    file_save VARCHAR(255) ,
    file_size BIGINT ,
    file_type VARCHAR(50) ,
    FOREIGN KEY (board_id) REFERENCES board(board_id) ON DELETE CASCADE
);
 * */

public class ImageDto {
	private int imageId; 
	private int boardId;
	private String fileUpload; // 저장된 파일명
	private String fileSave; // 저장된  경로
	private Long fileSize;
	private String fileType;
	
	public int getImageId() {
		return imageId;
	}

	public void setImageId(int imageId) {
		this.imageId = imageId;
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public String getFileUpload() {
		return fileUpload;
	}

	public void setFileUpload(String fileUpload) {
		this.fileUpload = fileUpload;
	}

	public String getFileSave() {
		return fileSave;
	}

	public void setFileSave(String fileSave) {
		this.fileSave = fileSave;
	}

	public Long getFileSize() {
		return fileSize;
	}

	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public ImageDto() {
		super();
	}
}
