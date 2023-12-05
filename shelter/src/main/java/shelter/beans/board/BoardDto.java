package shelter.beans.board;

import java.sql.Timestamp;
import java.util.List;

public class BoardDto {
	private int boardId; 
    private String boardTitle; 
    private String boardContent; 
    private String boardWriter; 
    private Timestamp boardDate; 
    private String boardLocation;
    private String firstCategory; // 대분류
    private String secondCategory; //중분류
    
    private List<String> imagePaths; //이미지 경로

	@Override
	public String toString() {
		return "BoardDto [boardId=" + boardId + ", boardTitle=" + boardTitle + ", boardContent=" + boardContent
				+ ", boardWriter=" + boardWriter + ", boardDate=" + boardDate + ", boardLocation=" + boardLocation
				+ ", firstCategory=" + firstCategory + ", secondCategory=" + secondCategory + "]";
	}
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public String getBoardWriter() {
		return boardWriter;
	}
	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}
	public Timestamp getBoardDate() {
		return boardDate;
	}
	public void setBoardDate(Timestamp boardDate) {
		this.boardDate = boardDate;
	}
	public String getBoardLocation() {
		return boardLocation;
	}
	public void setBoardLocation(String boardLocation) {
		this.boardLocation = boardLocation;
	}
	public String getFirstCategory() {
		return firstCategory;
	}
	public void setFirstCategory(String firstCategory) {
		this.firstCategory = firstCategory;
	}
	public String getSecondCategory() {
		return secondCategory;
	}
	public void setSecondCategory(String secondCategory) {
		this.secondCategory = secondCategory;
	}
	public List<String> getImagePaths() {
		return imagePaths;
	}
	public void setImagePaths(List<String> imagePaths) {
		this.imagePaths = imagePaths;
	}
    
    
}
