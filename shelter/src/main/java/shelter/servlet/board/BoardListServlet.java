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

@WebServlet("/board/postsList.do")
public class BoardListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<BoardDto> latestPosts = new BoardDao().getLatestPosts(10); // 글 수  (10)

            // 최신 글 목록 request에 저장
            req.setAttribute("posts", latestPosts);

            RequestDispatcher dispatcher = req.getRequestDispatcher("/board/postsList.jsp");
            dispatcher.forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendError(500); // Internal Server Error
        }
    }
}
