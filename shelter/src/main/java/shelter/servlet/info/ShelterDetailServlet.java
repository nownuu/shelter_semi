package shelter.servlet.info;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

@WebServlet("/board_care/shelterDetail.do")
public class ShelterDetailServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // 클릭한 동물 보호소의 이름(careNm)을 받아옴
            String careNm = request.getParameter("careNm");
            // 동물 보호소 상세 정보 ------ > API 호출
            String apiResponse = getShelterDetailApi(careNm);
            
//            System.out.println("detail apiResoponse : "+apiResponse);

            // JSON 파싱
            JSONObject jsonResponse = new JSONObject(apiResponse);
            JSONObject items = jsonResponse.getJSONObject("response").getJSONObject("body").getJSONObject("items");
            
            if (items.has("item")) {
                JSONArray itemArray = items.getJSONArray("item");

                if (itemArray.length() > 0) {
                    JSONObject shelterInfo = itemArray.getJSONObject(0);

                    request.setAttribute("shelterInfo", shelterInfo);
                    
//                    System.out.println("detail info : "+shelterInfo);
                    request.getRequestDispatcher("/board_care/shelterDetail.jsp").forward(request, response);
                } else {
                    System.out.println("No items found in the 'item' array.");
                }
            } else {
                System.out.println("Key 'item' not found in the 'items' object.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error occurred while processing the request.");
        }
    }


    private String getShelterDetailApi(String careNm) throws IOException {
        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1543061/animalShelterSrvc/shelterInfo");
        urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=epxYDvk4vczaYLuVFmYa0tGwx3hmzUEjY%2FVLAtxB3iK3WiCCIR2L7WuUszCTqrFWmHCrDJ4AdhI58%2BsHO9y0fA%3D%3D");
        urlBuilder.append("&" + URLEncoder.encode("care_nm", "UTF-8") + "=" + URLEncoder.encode(careNm, "UTF-8"));
        urlBuilder.append("&" + URLEncoder.encode("_type", "UTF-8") + "=" + URLEncoder.encode("json", "UTF-8"));

        return getApiResponse(urlBuilder.toString());
    }

    private String getApiResponse(String apiUrl) throws IOException {
        URL url = new URL(apiUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");

        StringBuilder sb = new StringBuilder();
        try (BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
            String line;
            while ((line = rd.readLine()) != null) {
                sb.append(line);
            }
        } finally {
            conn.disconnect();
        }

        return sb.toString();
    }
}
