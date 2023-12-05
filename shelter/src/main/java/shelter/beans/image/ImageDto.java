package shelter.beans.image;

import java.sql.Timestamp;

public class ImageDto {
	private int imageId; 
	private int boardId;
	private String fileUpload; // 저장된 파일명
	private String fileSave; // 저장된  경로
	private Long fileSize;
	private String fileType;
	public int getimageId() {
		return imageId;
	}
	public void setimageId(int imageId) {
		this.imageId = imageId;
	}
	public int getboardId() {
		return boardId;
	}
	public void setboardId(int boardId) {
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
