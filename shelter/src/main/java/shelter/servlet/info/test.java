package shelter.servlet.info;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class test {
    private static final String API_URL = "https://apis.data.go.kr/1543061/animalShelterSrvc/shelterInfo";
    private static final String API_KEY = "epxYDvk4vczaYLuVFmYa0tGwx3hmzUEjY%2FVLAtxB3iK3WiCCIR2L7WuUszCTqrFWmHCrDJ4AdhI58%2BsHO9y0fA%3D%3D"; // 본인의 API 키로 대체

    public String getShelterInfo() throws IOException {
        StringBuilder urlBuilder = new StringBuilder(API_URL);
        urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=" + API_KEY);
        urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode("10", "UTF-8"));
        urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8"));

        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");

        StringBuilder result = new StringBuilder();
        try (BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
        } catch (IOException e) {
            throw e; // 예외를 던지도록 수정
        } finally {
            conn.disconnect();
        }

        return result.toString();
    }
}