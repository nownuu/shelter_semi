<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원가입</title>
</head>
<body>
    <h2>회원가입</h2>
    
    <form action="join.do" method="post">

        <label for="memberId">ID:</label>
        <input type="text" id="memberId" name="memberId" required><br>
        
        <label for="memberPw">Password:</label>
        <input type="password" id="memberPw" name="memberPw" required><br>
        
        <label for="memberPhone">Phone:</label>
        <input type="text" id="memberPhone" name="memberPhone"><br>
        
        <label for="memberEmail">Email:</label>
        <input type="email" id="memberEmail" name="memberEmail" required><br>
        
        <label for="memberGender">Gender:</label>
        <!-- memberGender에 대한 드롭다운 값 업데이트 -->
		<select id="memberGender" name="memberGender">
		    <option value="남">남</option>
		    <option value="녀">녀</option>
		</select><br>
        
        
        <label for="memberAddress">Address:</label>
        <input type="text" id="memberAddress" name="memberAddress"><br>

        <button type="submit">Join</button>
    </form>
</body>
</html>
