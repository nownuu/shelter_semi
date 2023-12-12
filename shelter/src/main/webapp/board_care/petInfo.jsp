<%@page import="org.json.JSONArray"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="org.json.JSONObject"%>


<%
    String apiResponse = (String) request.getAttribute("apiResponse");
    if (apiResponse != null) {
        // JSON 파싱
        JSONObject jsonResponse = new JSONObject(apiResponse);
        JSONObject items = jsonResponse.getJSONObject("response").getJSONObject("body").getJSONObject("items");
        JSONArray itemArray = items.getJSONArray("item");

        if (itemArray != null) {
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>유기동물 공고 현황</title>
    <style>
        table {
            border-collapse: collapse;
            width: 100%;
            margin-top: 20px;
        }

        th, td {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <h2>유기동물 공고 현황</h2>
    <table>
        <thead>
            <tr>
                <th>유기번호</th>
                <th>이미지</th>
                <th>접수일</th>
                <th>발견장소</th>
                <th>공고시작일</th>
                <th>특징</th>
                <th>품종</th>
            </tr>
        </thead>
        <tbody>
            <% for (int i = 0; i < itemArray.length(); i++) {
                JSONObject item = itemArray.getJSONObject(i);
            %>
            <tr>
                <td><%= item.optString("desertionNo", "") %></td>
                <td><img src="<%= item.optString("filename", "") %>" alt="Thumbnail"></td>
                <td><%= item.has("happenDt") ? item.getString("happenDt") : "" %></td>
                <td><%= item.has("happenPlace") ? item.getString("happenPlace") : "" %></td>
                <td><%= item.has("noticeSdt") ? item.getString("noticeSdt") : "" %></td>
                <td><%=item.has("specialMark")?item.getString("specialMark"):"" %></td>
				<td><%= item.has("kindCd") ? item.getString("kindCd") : "" %></td>
            </tr>
            <% } %>
        </tbody>
    </table>
</body>
</html>

<%
        }
    }
%>
