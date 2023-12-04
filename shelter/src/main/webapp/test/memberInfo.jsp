<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="../css/index.css" />
    <link rel="stylesheet" href="../css/table.css" />
    <title>사지마세요, 입양하세요.</title>
</head>
<body>
    <jsp:include page="testHeader.jsp" />

    <h2>회원 정보</h2>
    
    <c:if test="${not empty memberDto}">
        <table border="1">
            <tr>
                <th>회원 ID</th>
                <td>${memberDto.memberId}</td>
            </tr>
            <tr>
                <th>이름</th>
                <td>${memberDto.memberName}</td>
            </tr>
            <tr>
                <th>닉네임</th>
                <td>${memberDto.memberNickname}</td>
            </tr>
            <tr>
                <th>전화번호</th>
                <td>${memberDto.memberPhone}</td>
            </tr>
            <tr>
                <th>이메일</th>
                <td>${memberDto.memberEmail}</td>
            </tr>
            <tr>
                <th>성별</th>
                <td>${memberDto.memberGender}</td>
            </tr>
            <tr>
                <th>주소</th>
                <td>${memberDto.memberAddress}</td>
            </tr>
            <tr>
                <th>가입일</th>
                <td>${memberDto.memberJoin}</td>
            </tr>
            <tr>
                <th>등급</th>
                <td>${memberDto.memberGrade}</td>
            </tr>
        </table>
    </c:if>

    <c:if test="${empty memberDto}">
        <p>회원 정보가 없습니다.</p>
    </c:if>
    
    <a href="${pageContext.request.contextPath}/test/logout.do">로그아웃</a>
</body>
</html>
