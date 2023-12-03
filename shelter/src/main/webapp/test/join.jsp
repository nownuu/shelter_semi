<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="../css/join.css" />
    <title>회원가입</title>
  </head>
  <body>
    <h1>
      <a href="../index.jsp"><img src="../img/Logo.png" alt="로고" /></a>
    </h1>
    <h2>회원가입</h2>

    <form action="join.do" method="post">
      <label for="memberId">ID</label>
      <input type="text" id="memberId" name="memberId" required /><br />

      <label for="memberPw">Password</label>
      <input type="password" id="memberPw" name="memberPw" required /><br />

      <label for="memberPhone">Phone</label>
      <input type="text" id="memberPhone" name="memberPhone" /><br />

      <label for="memberEmail">Email</label>
      <input type="email" id="memberEmail" name="memberEmail" required /><br />

      <label for="memberGender">Gender</label>
      <!-- memberGender에 대한 드롭다운 값 업데이트 -->
      <select id="memberGender" name="memberGender">
        <option value="남">남</option>
        <option value="여">여</option></select
      ><br />

      <label for="memberAddress">Address</label>
      <input type="text" id="memberAddress" name="memberAddress" /><br />

      <button type="submit">Join</button>
    </form>
     <p style="margin-top: 20px;">이미 회원이십니까? <a href="login.jsp" style="text-decoration: underline;">로그인 하기</a></p>
    <script>
      document.addEventListener('DOMContentLoaded', function() {
        // Get the input elements
        const inputs = document.querySelectorAll("input");

        // Function to check if all inputs have valid values
        function areInputsValid() {
          return Array.from(inputs).every(input => input.value.trim() !== '');
        }

        // Function to handle the input event
        function handleInput() {
          // Get the button element
          const submitBtn = document.querySelector("form button");

          // Check if all inputs have valid values
          if (areInputsValid()) {
            // Add the "active" class to the button element
            submitBtn.classList.add("active");
          } else {
            // Remove the "active" class from the button element
            submitBtn.classList.remove("active");
          }
        }

        // Add event listeners to each input
        inputs.forEach(input => {
          input.addEventListener("input", handleInput);
        });
      });
    </script>
  </body>
</html>
