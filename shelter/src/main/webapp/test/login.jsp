<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="../css/join.css" />
    <title>로그인</title>
  </head>
  <body>
    <h1>
      <a href="../index.jsp"><img src="../img/Logo.png" alt="로고" /></a>
    </h1>
    <h2>로그인</h2>

    <form action="login.do" method="post">
      <label for="memberId">ID</label>
      <input type="text" id="memberId" name="memberId" required /><br />

      <label for="memberPw">Password</label>
      <input type="password" id="memberPw" name="memberPw" required /><br />

      <button type="submit" disabled>Login</button>
    </form>
    <% String error = (String)request.getAttribute("error"); %> <% if (error !=
    null) { %>
    <p style="color: red"><%= error %></p>
    <% } %>
    
    <div style="margin-top: 20px;">
		  <a href="findId.jsp">아이디 찾기</a>
		  <a href="findPw.jsp">비밀번호 찾기</a>
</div>
    <p style="margin-top: 20px;">회원이 아니십니까? <a href="join.jsp" style="text-decoration: underline;">회원가입 하기</a></p>

    <script>
      document.addEventListener('DOMContentLoaded', function() {
        // Get the input elements and the submit button
        const inputs = document.querySelectorAll("input");
        const submitBtn = document.querySelector("form button");

        // Function to check if all inputs have valid values
        function areInputsValid() {
          return Array.from(inputs).every(input => input.value.trim() !== '');
        }

        // Function to update button state and add/remove 'active' class
        function updateButtonState() {
          // Check if all inputs have valid values
          if (areInputsValid()) {
            // Enable the button and add 'active' class
            submitBtn.removeAttribute("disabled");
            submitBtn.classList.add("active");
          } else {
            // Disable the button and remove 'active' class
            submitBtn.setAttribute("disabled", "true");
            submitBtn.classList.remove("active");
          }
        }

        // Function to handle the input event
        function handleInput() {
          // Update button state
          updateButtonState();
        }

        // Add event listeners to each input
        inputs.forEach(input => {
          input.addEventListener("input", handleInput);
        });

        // Initial button state check
        updateButtonState();
      });
    </script>
  </body>
</html>
