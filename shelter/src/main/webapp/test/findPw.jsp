<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="../css/join.css" />
    <title>비밀번호 찾기</title>
  </head>
  <body>
    <h1>
      <a href="../index.jsp"><img src="../img/Logo.png" alt="로고" /></a>
    </h1>
    <h2>비밀번호 찾기</h2>

    <form action="findPw.do" method="post">
        <label for="memberId">아이디</label>
        <input type="text" id="memberId" name="memberId" required><br>

        <label for="memberName">이름</label>
        <input type="text" id="memberName" name="memberName" required><br>

        <label for="memberPhone">전화번호</label>
        <input type="text" id="memberPhone" name="memberPhone" required><br>
        <div id="phoneError"></div> <!-- 전화번호 부분 지워야할듯. -->
        

        <button type="submit" disabled>비밀번호 찾기</button>
    </form>

    <% String error = (String)request.getAttribute("error"); %>
    <% if (error != null) { %>
        <p style="color: red;"><%= error %></p>
    <% } %>

    <script>
        document.addEventListener('DOMContentLoaded', function() {
            // Get the input elements
            const inputs = document.querySelectorAll("input");

            // Get the button element
            const submitBtn = document.querySelector("form button");

            // Get the memberPhone input
            const memberPhoneInput = document.getElementById("memberPhone");

            // Function to check if an input has a valid value
            function isInputValid(input) {
                return input.value.trim() !== '';
            }

            // Function to check if all inputs have valid values
            function areInputsValid() {
                // Check if memberId and memberName have valid values
                const memberIdValid = isInputValid(inputs[0]);
                const memberNameValid = isInputValid(inputs[1]);

                // Check if memberPhone has a valid format (11 digits without '-')
                const memberPhoneValue = memberPhoneInput.value.trim();
                const memberPhoneValid = /^\d{11}$/.test(memberPhoneValue);

                // Display phone error message if needed
                const phoneError = document.getElementById("phoneError");
                if (!memberPhoneValid) {
                    phoneError.innerHTML = "<p style='color: red; margin: 0 0 10px;'>'-'를 제외하고 11자리로 입력해주세요.</p>";
                } else {
                    phoneError.innerHTML = ""; // Clear the error message
                }

                // Return true only if all inputs are valid
                return memberIdValid && memberNameValid && memberPhoneValid;
            }

            // Function to handle the input event for memberPhone
            function handleMemberPhoneInput() {
                // Check if all inputs have valid values
                if (areInputsValid()) {
                    // Add the "active" class to the button element
                    submitBtn.classList.add("active");
                    // Enable the button
                    submitBtn.removeAttribute("disabled");
                } else {
                    // Remove the "active" class from the button element
                    submitBtn.classList.remove("active");
                    // Disable the button
                    submitBtn.setAttribute("disabled", "disabled");
                }
            }

            // Add event listener to memberPhone input
            memberPhoneInput.addEventListener("input", handleMemberPhoneInput);
        });
    </script>
  </body>
</html>
