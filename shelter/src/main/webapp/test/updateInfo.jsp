<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="../css/join.css" />
    <meta charset="UTF-8">
    <title>회원 정보 수정</title>
</head>
<body>
    <h2>회원 정보 수정</h2>
    
    <form action="updateMember.do" method="post">
        <!-- 수정할 회원 정보 입력 폼 -->
        <label for="memberPw">Password</label>
        <input type="password" id="memberPw" name="memberPw" required><br>
        
        <label for="memberNickname">Nickname</label>
        <input type="text" id="memberNickname" name="memberNickname" required><br>
        
        <label for="memberPhone">Phone</label>
        <input type="text" id="memberPhone" name="memberPhone" required><br>
                <label for="memberEmail">Email</label>
        <input type="email" id="memberEmail" name="memberEmail" required><br>
        
        <label for="memberGender">Gender</label>
        <select id="memberGender" name="memberGender" required>
            <option value="Male">남</option>
            <option value="Female">여</option>
        </select><br>
        
        <label for="memberAddress">Address</label>
        <input type="text" id="memberAddress" name="memberAddress" required><br>
        
        <button type="submit">수정하기</button>
    </form>
</body>
</html>
