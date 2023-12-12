<%@page import="org.json.JSONArray"%>
<%@page import="org.json.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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
            // JSON 파싱 및 "item" 어레이 얻기
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
                            <th>소재지도로명주소</th>
                            <th>소재지번주소</th>
                            <!-- 필요한 만큼의 헤더 추가 -->
                        </tr>
                    </thead>
                    <tbody>
                        <% for (int i = 0; i < itemArray.length(); i++) {
                               JSONObject item = itemArray.getJSONObject(i);
                        %>
                               <tr>
                                   <td><%= item.optString("careNm", "") %></td>
                                   <td><%= item.optString("orgNm", "") %></td>
                                   <td><%= item.optString("divisionNm", "") %></td>
                                   <td><%= item.optString("saveTrgtAnimal", "") %></td>
                                   <td><%= item.optString("careAddr", "") %></td>
                                   <td><%= item.optString("jibunAddr", "") %></td>
                                   <!-- 필요한 만큼의 셀 추가 -->
                               </tr>
                        <% } %>
                    </tbody>
                </table>
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
