<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="../css/join.css" />
    <title>회원가입</title>
    <style>
        .error-message {
            color: red;
        }
    </style>
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
        <input type="text" id="memberPhone" name="memberPhone" />
        <span id="phoneError" class="error-message"></span><br />

        <label for="memberEmail">Email</label>
        <input type="email" id="memberEmail" name="memberEmail" required />
        <span id="emailError" class="error-message"></span><br />

        <label for="memberGender">Gender</label>
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
            const inputs = document.querySelectorAll("input");
            const submitBtn = document.querySelector("form button");
            const phoneInput = document.getElementById("memberPhone");
            const emailInput = document.getElementById("memberEmail");
            const phoneError = document.getElementById("phoneError");
            const emailError = document.getElementById("emailError");

            function areInputsValid() {
                return Array.from(inputs).every(input => input.value.trim() !== '');
            }

            function isValidPhone() {
                const phoneValue = phoneInput.value.replace(/-/g, '');
                return /^\d{11}$/.test(phoneValue);
            }

            function isValidEmail() {
                return /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(emailInput.value);
            }

            function handleInput() {
                if (!areInputsValid()) {
                    submitBtn.classList.remove("active");
                    return;
                }

                if (isValidPhone()) {
                    phoneError.innerHTML = "";
                } else {
                    phoneError.innerHTML = "<p style='margin-top: 10px;'>'-'를 제외하고 입력해주세요.</p>";
                }

                if (isValidEmail()) {
                    emailError.innerHTML = "";
                } else {
                    emailError.innerHTML = "<p style='margin-top: 10px;'>올바른 이메일 주소를 입력해주세요.</p>";
                }

                if (isValidPhone() && isValidEmail()) {
                    submitBtn.classList.add("active");
                } else {
                    submitBtn.classList.remove("active");
                }
            }

            inputs.forEach(input => {
                input.addEventListener("input", handleInput);
            });

            // Initial input validation
            handleInput();
        });
    </script>
</body>
</html>
