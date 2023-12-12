<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="org.json.JSONObject" %>
<!DOCTYPE html>
<html>
<head>
    <title>동물 보호소 상세 정보</title>
    <style>
    </style>
    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=432095999a186049d9c443e98e4a8e69"></script>
</head>
<body>
    <h1>동물 보호소 상세 정보</h1>

    <%
        JSONObject shelterInfo = (JSONObject) request.getAttribute("shelterInfo");

        if (shelterInfo != null) {
    %>
            <table>
                <tr>
                    <th>동물보호센터명</th>
                    <td><%= shelterInfo.optString("careNm", "") %></td>
                </tr>
                <tr>
                    <th>관리기관명</th>
                    <td><%= shelterInfo.optString("orgNm", "") %></td>
                </tr>
                <tr>
                    <th>동물보호센터유형</th>
                    <td><%= shelterInfo.optString("divisionNm", "") %></td>
                </tr>
                <tr>
                    <th>구조대상동물</th>
                    <td><%= shelterInfo.optString("saveTrgtAnimal", "") %></td>
                </tr>
                <tr>
                    <th>소재지도로명주소</th>
                    <td><%= shelterInfo.optString("careAddr", "") %></td>
                </tr>
                <tr>
                    <th>소재지번주소</th>
                    <td><%= shelterInfo.optString("jibunAddr", "") %></td>
                </tr>
                <tr>
                    <th>전화번호</th>
                    <td><%= shelterInfo.optString("careTel", "") %></td>
                </tr>
                <tr>
                    <th>수의사인원수</th>
                    <td><%= shelterInfo.optString("vetPersonCnt", "") %></td>
                </tr>
            </table>

            <!-- 카카오 맵...-->
            <div id="map" style="width: 80%; height: 500px;"></div>

           <script>
		        //위도(lat) 값을 가져오기
		        var lat = <%= shelterInfo.optString("lat", "0") %>;
		
		        // 경도(lng) 값을 가져오기
		        var lng = <%= shelterInfo.optString("lng", "0") %>;
		
		        var mapContainer = document.getElementById('map');
		        var options = {
		            center: new kakao.maps.LatLng(lat, lng),
		            level: 3
		        };
		
		        var map = new kakao.maps.Map(mapContainer, options);
		
		        var markerPosition = new kakao.maps.LatLng(lat, lng);
		        var marker = new kakao.maps.Marker({
		            position: markerPosition
		        });
		
		        marker.setMap(map);
		
		        var infowindow = new kakao.maps.InfoWindow({
		            content: '<div style="width:150px;text-align:center;padding:6px 0;"><%= shelterInfo.optString("careNm", "") %></div>'
		        });
		
		        infowindow.open(map, marker);
		    </script>
    <%
        } else {
    %>
            <p>상세 정보를 가져오는 중에 오류가 발생했습니다</p>
    <% } %>
</body>
</html>
