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
    String memberGrade = (String) session.getAttribute("grade");
    
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
        <a href="test/memberInfo.do">마이페이지-본인 정보 보기</a>
        <p><%= uid %>님, 환영합니다!</p>
        <a href="logout.do">로그아웃</a>

        <% if ("관리자".equals(memberGrade)) { %>
            <a href="test/admin/memberView.do">회원 전체 정보 보기</a>
        <% } %>
    </div>
<%
    }
%>

</body>
</html>
