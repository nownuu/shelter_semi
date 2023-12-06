package shelter.servlet.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shelter.beans.board.BoardDao;
import shelter.beans.board.BoardDto;
import shelter.beans.image.ImageDao;
import shelter.beans.image.ImageDto;

@WebServlet("/board/detail.do")
public class BoardDetailServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int boardId = Integer.parseInt(req.getParameter("bid"));

            BoardDto boardDto = new BoardDao().getBoardDetail(boardId);

            List<ImageDto> imageDtos = new ImageDao().getImagesByBoardId(boardId);

            req.setAttribute("boardDto", boardDto);
            req.setAttribute("imageDtos", imageDtos);

            RequestDispatcher dispatcher = req.getRequestDispatcher("/board/detail.jsp");
            dispatcher.forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendError(500); // Internal Server Error
        }
    }
}

