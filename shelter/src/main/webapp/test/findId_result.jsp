<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>아이디 찾기 결과</title>
</head>
<body>

<% String memberId = request.getParameter("mem_id"); %>
<% if (memberId != null && !memberId.isEmpty() && !memberId.equals("검색 결과가 없습니다.")) { %>
    <h2>아이디 찾기 결과</h2>
    <p>회원님의 아이디는 <%= memberId %> 입니다.</p>
<% } else { %>
    <h2>아이디 찾기 결과</h2>
    <p style="color: red;"><%= request.getAttribute("error") %></p>
<% } %>

</body>
</html>
