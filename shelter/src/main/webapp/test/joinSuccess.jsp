<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원가입 성공</title>
    <script>
        document.addEventListener('DOMContentLoaded', function() {
            // 회원가입 성공 메시지를 alert 창으로 표시합니다.
            alert('회원가입이 성공적으로 완료되었습니다. 다음 로그인 화면에서 로그인해주세요.');

            // index.jsp로 리디렉션합니다.
            window.location.href = '../index.jsp';
        });
    </script>
</head>
<body>

    <h2>회원가입 성공</h2>
    <p>회원가입이 성공적으로 완료되었습니다.</p>
    <p>다음 로그인 화면에서 로그인해주세요.</p>
</body>
</html>
