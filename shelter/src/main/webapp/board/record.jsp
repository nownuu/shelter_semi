<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
    <meta charset="UTF-8">
    <title>게시글 등록</title>
    <!-- 부트스트랩 CDN 추가 -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h2>게시글 등록</h2>
        
        <form action="${pageContext.request.contextPath}/board/record.do" method="post" enctype="multipart/form-data">
            <div class="form-group">
                <label for="boardTitle">제목:</label>
                <input type="text" class="form-control" id="boardTitle" name="boardTitle" required>
            </div>
            <div class="form-group">
                <label for="boardContent">내용:</label>
                <textarea class="form-control" id="boardContent" name="boardContent" rows="5" required></textarea>
            </div>
            <div class="form-group">
                <label for="boardLocation">위치:</label>
                <input type="text" class="form-control" id="boardLocation" name="boardLocation" required>
            </div>
            <div class="form-group">
                <label for="firstCategory">대분류:</label>
                <input type="text" class="form-control" id="firstCategory" name="firstCategory" required>
            </div>
            <div class="form-group">
                <label for="secondCategory">중분류:</label>
                <input type="text" class="form-control" id="secondCategory" name="secondCategory" required>
            </div>
            <div class="form-group">
                <label for="images">이미지 업로드:</label>
                <input type="file" class="form-control-file" id="images" name="images" accept="image/*" multiple required>
            </div>
            <button type="submit" class="btn btn-primary">등록</button>
        </form>
    </div>

    <!-- 부트스트랩 JS 및 Popper.js, jQuery CDN 추가 -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>
