<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원 정보 수정 결과</title>
    <meta http-equiv="refresh" content="3;url=<%= request.getContextPath() %>/test/admin/memberView.do">
</head>
<body>

<h2>회원 정보 수정 결과</h2>

<%
    // 서블릿에서 전달된 메시지를 가져옴
    String message = (String) request.getAttribute("message");
%>

<p><%= message %></p>

</body>
</html>
