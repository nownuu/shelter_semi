<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>비밀번호 찾기</title>
</head>
<body>

<h2>비밀번호 찾기</h2>

<form action="findPw.do" method="post">
    <label for="memberId">아이디:</label>
    <input type="text" id="memberId" name="memberId" required><br>

    <label for="memberName">이름:</label>
    <input type="text" id="memberName" name="memberName" required><br>

    <label for="memberPhone">전화번호:</label>
    <input type="text" id="memberPhone" name="memberPhone" required><br>

    <button type="submit">비밀번호 찾기</button>
</form>

<% String error = (String)request.getAttribute("error"); %>
<% if (error != null) { %>
    <p style="color: red;"><%= error %></p>
<% } %>

</body>
</html>
