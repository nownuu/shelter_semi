<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
    <h2>Login</h2>
    
    <form action="login.do" method="post">
        <label for="memberId">ID:</label>
        <input type="text" id="memberId" name="memberId" required><br>
        
        <label for="memberPw">Password:</label>
        <input type="password" id="memberPw" name="memberPw" required><br>
        
        <button type="submit">Login</button>
    </form>
    <% String error = (String)request.getAttribute("error"); %>
    <% if (error != null) { %>
        <p style="color: red;"><%= error %></p>
    <% } %>
</body>
</html>
