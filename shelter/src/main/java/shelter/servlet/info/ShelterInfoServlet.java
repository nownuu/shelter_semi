package shelter.servlet.info;

import shelter.service.info.ShelterInfoService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/care/shelterInfo.do")
public class ShelterInfoServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ShelterInfoService shelterInfoService = new ShelterInfoService();
        String shelterInfo = shelterInfoService.getShelterInfo();

        System.out.println("서블릿에서의 ShelterInfo: " + shelterInfo);

        if (shelterInfo != null) {
            request.setAttribute("shelterInfo", shelterInfo);

            // 경로를 /care/shelterInfo.jsp로 설정
            RequestDispatcher dispatcher = request.getRequestDispatcher("/care/shelterInfo.jsp");
            dispatcher.forward(request, response);
        } else {
            System.out.println("에러: ShelterInfo가 null입니다.");
            response.getWriter().write("에러: ShelterInfo가 null입니다.");
        }
    }
}

