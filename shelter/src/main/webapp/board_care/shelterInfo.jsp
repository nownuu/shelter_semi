<%@page import="org.json.JSONArray"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="org.json.JSONObject"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="../css/index.css" />
    <link rel="stylesheet" href="../css/table.css" />
    <title>사지마세요, 입양하세요. - 동물 보호소 정보</title>
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
        height: 150px;
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
<body>
<jsp:include page="/header.jsp" />
<main>
    <h2>동물 보호소 정보</h2>

    <form class="search" action="/shelter/board_care/shelterDetail.do" method="get">
        <input type="text" name="careNm" value="">
        <input type="submit" value="검색">
    </form>

    <% 
        String apiResponse = (String) request.getAttribute("apiResponse");
        if (apiResponse != null) {
            // JSON 파싱
            JSONObject jsonResponse = new JSONObject(apiResponse);
            JSONObject items = jsonResponse.getJSONObject("response").getJSONObject("body").getJSONObject("items");
            JSONArray itemArray = items.getJSONArray("item");

            if (itemArray != null) {
    %>
                <table class="content">
                      
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
    </main>
