<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<header>
  <h1 id="logo">
    <a href="#"><img src="img/Logo.png" alt="로고" /></a>
  </h1>
  <ul class="menu-area">
    <li><a href="#">실종동물 찾기</a></li>
    <li><a href="#">유기동물 보호</a></li>
    <li><a href="#">유기동물 입양</a></li>
    <li><a href="#">자원봉사 모집</a></li>

    <% String uid = (String) session.getAttribute("uid");
    String memberGrade = (String) session.getAttribute("grade");
    if (uid == null || uid.isEmpty()) { %>
    <li>
      <a href="test/login.jsp"
        ><img src="img/btn-login.png" alt="로그인/마이페이지"
      /></a>
    </li>
    <% } else { %>
    <li><%= uid %>님, 환영합니다!</li>
    <li>
      <a href="test/memberInfo.do"
        ><img
          src="img/btn-login.png"
          alt="로그인/마이페이지"
      /></a>
    </li>
    <% if ("관리자".equals(memberGrade)) { %>
    <li>
      <a href="test/admin/memberView.do">회원 전체 정보 보기</a>
    </li>
    <% } %> <% } %>

  </ul>
</header>
