<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시물 상세 정보</title>
    <!-- 부트스트랩 CDN 추가 -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h2>게시물 상세 정보</h2>

        <c:if test="${not empty boardDto}">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">${boardDto.boardTitle}</h5>
                    <p class="card-text">${boardDto.boardContent}</p>
                    <p class="card-text">작성자: ${boardDto.boardWriter}</p>
                    <p class="card-text">작성일: ${boardDto.boardDate}</p>
                    <p class="card-text">위치: ${boardDto.boardLocation}</p>
                    <p class="card-text">대분류: ${boardDto.firstCategory}</p>
                    <p class="card-text">중분류: ${boardDto.secondCategory}</p>
                </div>
            </div>
        </c:if>

        <c:if test="${not empty imageDtos}">
            <h3>이미지 목록</h3>
            <c:forEach var="imageDto" items="${imageDtos}">
                <img src="<c:url value='/image/${imageDto.fileSave}'/>" alt="Image" class="img-thumbnail">
            </c:forEach>
        </c:if>

        <a href="<c:url value='/board/postsList.do'/>" class="btn btn-primary">목록으로 돌아가기</a>
    </div>

    <!-- 부트스트랩 JS 및 Popper.js, jQuery CDN 추가 -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>
