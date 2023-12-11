package shelter.servlet.info;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/care/shelterInfo.do")
public class ShelterInfoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        // API 호출을 위한 정보
        String apiUrl = "http://apis.data.go.kr/1543061/animalShelterSrvc/shelterInfo";
        String serviceKey = "epxYDvk4vczaYLuVFmYa0tGwx3hmzUEjY%2FVLAtxB3iK3WiCCIR2L7WuUszCTqrFWmHCrDJ4AdhI58%2BsHO9y0fA%3D%3D";
        String numOfRows = "10"; // 원하는 페이지 결과 수
        String pageNo = "1";
        String responseType = "_type=json";

     // API 호출 및 결과 가져오기
        String apiRequestUrl = apiUrl + "?serviceKey=" + serviceKey +
                "&numOfRows=" + numOfRows + "&pageNo=" + pageNo + "&" + responseType;

        URL url = new URL(apiRequestUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        int responseCode = conn.getResponseCode();
        System.out.println("Response Code: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) {
            Scanner scanner = new Scanner(conn.getInputStream());
            StringBuilder apiResult = new StringBuilder();
            while (scanner.hasNext()) {
                apiResult.append(scanner.nextLine());
            }
            scanner.close();
            conn.disconnect();

            // JSP 페이지로 전달할 데이터 설정
            request.setAttribute("apiResult", apiResult.toString());
        } else {
            System.out.println("API request failed with response code: " + responseCode);
        }

        System.out.println("API Request URL: " + apiRequestUrl);
        System.out.println("Response Code: " + responseCode);

        // JSP 페이지로 포워딩
        request.getRequestDispatcher("/care/shelterInfo.jsp").forward(request, response);
    }
}
