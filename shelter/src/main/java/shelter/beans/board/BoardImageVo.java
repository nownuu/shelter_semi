package shelter.beans.board;

import java.util.List;

import shelter.beans.image.ImageDto;

public class BoardImageVo {
    private BoardDto boardDto;
    private List<ImageDto> imageDtos;

    public BoardDto getBoardDto() {
        return boardDto;
    }

    public void setBoardDto(BoardDto boardDto) {
        this.boardDto = boardDto;
    }

    public List<ImageDto> getImageDtos() {
        return imageDtos;
    }

    public void setImageDtos(List<ImageDto> imageDtos) {
        this.imageDtos = imageDtos;
    }
}
