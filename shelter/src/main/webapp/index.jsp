<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>메인페이지</title>
</head>
<body>

<%
    String uid = (String) session.getAttribute("uid");
    if (uid == null || uid.isEmpty()) {
%>
    <div>
        <a href="test/login.jsp">로그인</a>
        <a href="test/join.jsp">회원가입</a>
    </div>
<%
    } else {
%>
    <div>
        <a href="test/mypage.jsp">마이페이지</a>
        <p><%= uid %>님, 환영합니다!</p>
        <a href="logout.do">로그아웃</a>
    </div>
<%
    }
%>

</body>
</html>