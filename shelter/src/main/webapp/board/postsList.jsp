<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>최신글목록</title>
    <!-- 부트스트랩 CDN 추가 -->

    <link rel="stylesheet" href="../css/table.css" />
    	 <link rel="stylesheet" href="../css/index.css" />
    <style>
.container {
	margin: 0 auto;
	width: 1400px;
    flex-wrap: wrap; /* Allows items to wrap to the next line */
}
h2 {
	text-align: center;
	font-size: 48px;
	font-weight: 800;
}
.row {
	 margin: 15px auto;
    width: 100%; /* Make sure the row takes the full width of the container */
    display: flex;
   justify-content: space-between;
    
}

.col-md-4 {
   background: #fff;
    flex: 0 0 30%; /* Set the width of each column to 30% of the container */
    margin: 10px; /* Add margin between columns */
}

.card {
    width: 100%;
}
button {
	margin: 0 auto;
	text-align: center;
	font-size: 21px;
}
/* Add more styles as needed for card, card-body, etc. */

    </style>
</head>
<body>
<jsp:include page="../header.jsp"/>
    <div class="container">
        <h2>최신글 목록</h2>
        
        <div class="row">
            <c:forEach var="board" items="${posts}">
                <div class="col-md-4 mb-4">
                    <div class="card">
                        <img src="<c:url value='/board/image.do?imageId=${board.imageDtos[0].imageId}' />" class="card-img-top" alt="게시물 이미지">
                        <div class="card-body">
                            <h5 class="card-title">${board.boardTitle}</h5>
                            <p class="card-text">작성자: ${board.boardWriter}</p>
                            <p class="card-text">날짜: ${board.boardDate}</p>
                            <a href="<c:url value='/board/detail.do?bid=${board.boardId}' />" class="btn btn-primary">자세히 보기</a>
                            
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div><a href="/shelter/board/record.jsp">
        <button>글쓰기</button></a>
    </div>

    <!-- 부트스트랩 JS 및 Popper.js, jQuery CDN 추가 -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>
