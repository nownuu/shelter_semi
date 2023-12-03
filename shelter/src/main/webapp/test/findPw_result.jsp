<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="../css/join.css" />
    <title>비밀번호 찾기 결과</title>
  </head>
  <body>
    <h1>
      <a href="../index.jsp"><img src="../img/Logo.png" alt="로고" /></a>
    </h1>

<% String result = request.getParameter("result"); %>
<% if ("success".equals(result)) { %>
    <h2>비밀번호 찾기 결과</h2>
    <p>입력하신 이메일 주소로 임시 비밀번호가 발송되었습니다. 로그인 후에는 비밀번호를 변경해 주세요.</p>
<% } else { %>
    <h2>비밀번호 찾기 결과</h2>
    <p style="color: red;"><%= request.getAttribute("error") %></p>
<% } %>

</body>
</html>
