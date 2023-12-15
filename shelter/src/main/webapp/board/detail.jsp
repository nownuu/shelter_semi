<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/index.css" />
    <link rel="stylesheet" href="../css/table.css" />
    <style>
        body {
            margin: 0;
            padding: 0;
        }

        .container {
        
        background: #fff;
            max-width: 800px;
            margin: 50px auto;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
            border-radius: 5px;
        }

        h2 {
            text-align: center;
            font-size: 36px;
            color: #333;
        }

        .card {
            margin-top: 20px;
            border: 1px solid #ddd;
            border-radius: 5px;
            overflow: hidden;
        }

        .card-body {
            padding: 20px;
        }

        .card-title {
            font-size: 24px;
            color: #333;
            margin-bottom: 10px;
        }

        .card-text {
            color: #555;
            margin-bottom: 10px;
        }

        .img-thumbnail {
            margin: 10px;
            max-width: 100%;
            height: auto;
            border: 1px solid #ddd;
            border-radius: 5px;
        }

        .btn-primary {
            display: block;
            width: 100%;
            padding: 10px;
            text-align: center;
            background-color: #007bff;
            color: #fff;
            text-decoration: none;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
        }

        .btn-primary:hover {
            background-color: #0056b3;
        }
    </style>
    <title>게시물 상세 정보</title>
</head>
<body>
    <jsp:include page="../header.jsp" />
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
            <div>
                <c:forEach var="imageDto" items="${imageDtos}">
                    <img src="<c:url value='/image/${imageDto.fileSave}'/>" alt="Image" class="img-thumbnail">
                </c:forEach>
            </div>
        </c:if>

        <a href="<c:url value='/board/postsList.do'/>" class="btn-primary">목록으로 돌아가기</a>
    </div>
</body>
</html>
