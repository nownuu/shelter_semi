<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="../css/join.css" />
    <title>아이디 찾기 결과</title>
  </head>
  <body>
    <h1>
      <a href="../index.jsp"><img src="../img/Logo.png" alt="로고" /></a>
    </h1>

<% String memberId = request.getParameter("mem_id"); %>
<% if (memberId != null && !memberId.isEmpty() && !memberId.equals("검색 결과가 없습니다.")) { %>
    <h2>아이디 찾기 결과</h2>
    <p>회원님의 아이디는 <%= memberId %> 입니다.</p>
<% } else { %>
    <h2>아이디 찾기 결과</h2>
    <p style="color: red;"><%= request.getAttribute("error") %></p>
<% } %>

</body>
</html>
