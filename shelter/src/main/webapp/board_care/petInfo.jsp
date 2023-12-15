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
    <link rel="stylesheet" href="../css/index.css" />
    <link rel="stylesheet" href="../css/table.css" />
    <title>유기동물 공고 현황</title>
    <style>
      h2 {
        margin: 0 auto;
        text-align: center;
        font-size: 36px;
      }
      .search {
        float: right;
        margin-bottom: 15px;
      }
      .search input {
        font-family: "Noto Serif KR", serif;
        font-size: 18px;
      }
      table th,
      td,
      table {
        border: 0;
      }
      tbody {
        display: flex;
        flex-wrap: wrap;
        justify-content: space-between;
        background: #eeeae2;
      }
     tr {
        background: #fff;
        border-radius: 15px;
        display: flex;
        flex-flow: column;
        padding: 10px 0;
        width: 19%;
        height: 340px;
        cursor: pointer;
        box-sizing: border-box;
        margin-bottom: 15px;
      }
      td:nth-of-type(1) {
        font-weight: 800;
        font-size: 18px;
        margin-bottom: 10px;
      }
      .content span {
        display: inline-block;
        border: 1px solid blue;
        width: 50px;
        padding: 3px;
        border-radius: 5px;
        margin-right: 3px;
        font-size: 13px;
      }
      a.active {
        text-decoration: underline;
      }
    </style>
</head>
<body>
<jsp:include page="/header.jsp"/>
<main>
    <h2>유기동물 공고 현황</h2>
    <table>
        <tbody>
            <% for (int i = 0; i < itemArray.length(); i++) {
                JSONObject item = itemArray.getJSONObject(i);
            %>
            <tr>
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
</main>
