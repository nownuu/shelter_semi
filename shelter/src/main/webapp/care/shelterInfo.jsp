<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.google.gson.JsonArray" %>
<%@ page import="com.google.gson.JsonObject" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>	보호소 정보</title>
</head>
<body>

<%
    // 서블릿에서 전달된 데이터를 가져옴
    JsonArray items = (JsonArray) request.getAttribute("shelterItems");

    // items가 null이 아닌 경우에만 처리
    if (items != null) {
        // items 배열을 순회하며 정보 표시
        for (int i = 0; i < items.size(); i++) {
            JsonObject item = items.get(i).getAsJsonObject();
%>
            <p>Care Reg No: <%= item.get("care_reg_no").getAsString() %></p>
            <p>Care Name: <%= item.get("care_nm").getAsString() %></p>
            <hr>
<%
        }
    } else {
        // items가 null일 경우 처리
        out.println("<p>No data available</p>");
    }
%>

</body>
</html>
