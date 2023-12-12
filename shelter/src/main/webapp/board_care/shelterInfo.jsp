<%@page import="org.json.JSONArray"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="org.json.JSONObject"%>
<!DOCTYPE html>
<html>
<head>
    <title>동물 보호소 정보</title>
    <style>
        table {
            border-collapse: collapse;
            width: 100%;
            margin-top: 20px;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <h1>동물 보호소 정보</h1>

    <% 
        String apiResponse = (String) request.getAttribute("apiResponse");
        if (apiResponse != null) {
            // JSON 파싱
            JSONObject jsonResponse = new JSONObject(apiResponse);
            JSONObject items = jsonResponse.getJSONObject("response").getJSONObject("body").getJSONObject("items");
            JSONArray itemArray = items.getJSONArray("item");

            if (itemArray != null) {
    %>
                <table>
                    <thead>
                        <tr>
                            <th>동물보호센터명</th>
                            <th>관리기관명</th>
                            <th>동물보호센터유형</th>
                            <th>구조대상동물</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% for (int i = 0; i < itemArray.length(); i++) {
                               JSONObject item = itemArray.getJSONObject(i);
                        %>
                        <%-- carNm 클릭시에 상세페이지(shelterDetail.jsp)로 이동 --%>
                               <tr onclick="location.href='/shelter/board_care/shelterDetail.do?careNm=<%= URLEncoder.encode(item.optString("careNm", ""), "UTF-8") %>'">
                                   <td><%= item.optString("careNm", "") %></td>
                                   <td><%= item.optString("orgNm", "") %></td>
                                   <td><%= item.optString("divisionNm", "") %></td>
                                   <td><%= item.optString("saveTrgtAnimal", "") %></td>
                               </tr>
                        <% } %>
                    </tbody>
                </table>
                <div style="text-align: center;">
                    <% 
                        // 페이지 링크 추가
                        int totalPages = jsonResponse.getJSONObject("response").getJSONObject("body").getInt("totalCount") / 20; // 페이지당 20개의 행을 가정
                        for (int i = 1; i <= totalPages; i++) {
                    %>
                            <a href="/shelter/board_care/shelterInfo.do?page=<%= i %>"><%= i %></a>
                    <%
                        }
                    %>
                </div>
    <%
            } else {
    %>
                <p>데이터가 없습니다</p>
    <%
            }
        } else {
    %>
            <p>데이터를 가져오는 중에 오류가 발생했습니다</p>
    <% } %>
</body>
</html>
