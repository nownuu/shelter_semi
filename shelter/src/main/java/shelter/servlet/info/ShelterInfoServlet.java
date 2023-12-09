package shelter.servlet.info;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import shelter.util.ShelterInfoApiUtil;

@WebServlet("/care/shelterInfo.jsp")
public class ShelterInfoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	System.out.println("서블릿 호출");

        JsonObject jsonResponse = ShelterInfoApiUtil.getShelterInfo();

        if (jsonResponse != null) {
            // 필요한 데이터 추출
            JsonArray items = jsonResponse.getAsJsonObject("response").getAsJsonObject("body").getAsJsonArray("items");
            request.setAttribute("shelterItems", items);

            // JSP로 포워딩
            RequestDispatcher dispatcher = request.getRequestDispatcher("/care/shelterInfo.jsp");
            dispatcher.forward(request, response);
        } else {
            // API 호출 실패 시 처리
            response.getWriter().println("Failed to retrieve shelter information.");
        }
    }

}
