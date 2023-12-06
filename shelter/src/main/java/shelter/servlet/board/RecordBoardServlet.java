package shelter.servlet.board;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import shelter.beans.board.BoardDao;
import shelter.beans.board.BoardDto;
import shelter.beans.board.BoardImageVo;
import shelter.beans.image.ImageDao;
import shelter.beans.image.ImageDto;

@WebServlet("/board/record.do")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 10,      // 10MB
maxRequestSize = 1024 * 1024 * 50)   // 50MB
public class RecordBoardServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setCharacterEncoding("UTF-8");

         // 로그인 여부 확인
            String boardWriter = (String) req.getSession().getAttribute("uid");
            if (boardWriter == null) {
                // 로그인되지 않았으면 로그인 페이지로 이동
                resp.sendRedirect(req.getContextPath() + "/test/login.jsp");
                return;
            }

            String boardTitle = req.getParameter("boardTitle");
            String boardContent = req.getParameter("boardContent");
            String boardLocation = req.getParameter("boardLocation");
            String firstCategory = req.getParameter("firstCategory");
            String secondCategory = req.getParameter("secondCategory");

            // BoardDto 생성
            BoardDto boardDto = new BoardDto();
            boardDto.setBoardTitle(boardTitle);
            boardDto.setBoardContent(boardContent);
            boardDto.setBoardWriter(boardWriter);
            boardDto.setBoardDate(new Timestamp(System.currentTimeMillis()));
            boardDto.setBoardLocation(boardLocation);
            boardDto.setFirstCategory(firstCategory);
            boardDto.setSecondCategory(secondCategory);

            // 파일 업로드 처리
            List<String> imagePaths = new ArrayList<>();
            for (Part part : req.getParts()) {
                String fileName = getSubmittedFileName(part);
                if (fileName != null && !fileName.isEmpty()) {
                    String imagePath = saveImage(part, boardWriter);
                    imagePaths.add(imagePath);
                }
            }

            // boardDto에 이미지 경로 추가
            boardDto.setImagePaths(imagePaths);

            // ImageDao를 사용하여 게시글과 이미지 정보 DB에 저장
            ImageDao imageDao = new ImageDao();
            List<ImageDto> imageDtos = new ArrayList<>();
            for (String imagePath : imagePaths) {
                ImageDto imageDto = new ImageDto();
                imageDto.setFileUpload(new File(imagePath).getName());
                imageDto.setFileSave(imagePath);
                imageDto.setFileSize(new File(imagePath).length());
                // MIME 타입을 얻을 수 있다면 설정해야함... 이미지 깨지는 것 같음
                imageDtos.add(imageDto);
            }

            // BoardImageVo 생성
            BoardImageVo boardImageVo = new BoardImageVo();
            boardImageVo.setBoardDto(boardDto);
            boardImageVo.setImageDtos(imageDtos);

            // ImageDao를 사용하여 게시글과 이미지 정보 DB에 저장
            imageDao.uploadBoardWithImages(boardImageVo);

         // 등록 성공 후 상세 정보를 보여주는 페이지
            int lastInsertedBoardId = new BoardDao().getLastInsertedBoardIdForUser(boardWriter);
            resp.sendRedirect(req.getContextPath() + "/board/detail.do?bid=" + lastInsertedBoardId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getSubmittedFileName(Part part) {
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }

    private String saveImage(Part part, String boardWriter) throws IOException {
        String uploadPath = "D://images/upload";  // 임시 경로
        String fileName = getSubmittedFileName(part);
        String imagePath = uploadPath + File.separator + boardWriter + File.separator + fileName;

        File file = new File(imagePath);
        file.getParentFile().mkdirs();

        part.write(imagePath);

        return imagePath;
    }
}
