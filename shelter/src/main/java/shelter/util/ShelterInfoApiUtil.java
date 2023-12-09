package shelter.util;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import shelter.beans.info.ShelterInfoDto;

import java.util.List;

public class ShelterInfoApiUtil {

    public static JsonObject getShelterInfo() {
    	
    	System.out.println("호출 전");
        // API 호출
        String apiUrl = "http://apis.data.go.kr/1543061/animalShelterSrvc";
        String serviceKey = "epxYDvk4vczaYLuVFmYa0tGwx3hmzUEjY%2FVLAtxB3iK3WiCCIR2L7WuUszCTqrFWmHCrDJ4AdhI58%2BsHO9y0fA%3D%3D";
        String requestUrl = apiUrl + "?serviceKey=" + serviceKey + "&numOfRows=3&pageNo=1&_type=json";

        try {
            URL url = new URL(requestUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // API 응답 데이터 읽기
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = br.readLine()) != null) {
                response.append(line);
            }
            br.close();

         // JSON 파싱
            JsonParser parser = new JsonParser();
            JsonObject json = parser.parse(response.toString()).getAsJsonObject();

            // Gson을 사용하여 JSON을 Java 객체로 변환
            Gson gson = new Gson();
            ShelterInfoDto shelterInfoDto = gson.fromJson(json, ShelterInfoDto.class);

            // JSON 파일로 저장
            try (FileWriter file = new FileWriter("shelter_info.json")) {
                file.write(gson.toJson(shelterInfoDto));
                System.out.println("Data saved to shelter_info.json");
            } catch (Exception e) {
                e.printStackTrace();
            }

            return json;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}