<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="../../css/join.css" />
     <link rel="stylesheet" href="../../css/table.css" />
    <title>관리자 페이지 - 회원 정보 수정</title>
  </head>
  <header>
      <h1 id="logo">
        <a href="../../index.jsp"><img src="../../img/Logo.png" alt="로고" /> 관리자 페이지</a>
      </h1> </header>
  <body>
<h2>회원 정보 수정</h2>

<form action="<%= request.getContextPath() %>/test/admin/editMember.do" method="post">
    <label for="memberId">회원 ID</label>
    <input type="text" id="memberId" name="memberId" required readonly value="<%= request.getParameter("memberId") %>"><br>

    <label for="memberNickname">닉네임</label>
    <input type="text" id="memberNickname" name="memberNickname" required value="<%= request.getParameter("memberNickname") %>"><br>

    <label for="memberGender">성별</label>
    <input type="text" id="memberGender" name="memberGender" required value="<%= request.getParameter("memberGender") %>"><br>

    <label for="memberGrade">등급</label>
    <input type="text" id="memberGrade" name="memberGrade" required value="<%= request.getParameter("memberGrade") %>"><br>

    <input type="submit" value="수정">
</form>

</body>
</html>
