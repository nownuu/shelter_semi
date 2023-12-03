<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="../css/join.css" />
    <title>탈퇴</title>
    <style>
        .error-message {
            color: red;
        }
    </style>
</head>
<body>
    <h2>Withdraw Member</h2>
    
    <p>정말로 탈퇴하시겠습니까?</p>
    
    <form action="memberQuit.do" method="post">
        <button type="submit" value="Withdraw">탈퇴하기</button>
    </form>
</body>
</html>
