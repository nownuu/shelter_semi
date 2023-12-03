<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원 정보 수정 결과</title>
    <!-- Include JavaScript to show an alert and redirect -->
    <script>
        window.onload = function() {
            // Retrieve the message from the server-side
            var message = '<%= request.getAttribute("message") %>';

            // Show an alert with the message
            alert(message);

            // Redirect to the memberView.do page after 3 seconds
            setTimeout(function() {
                window.location.href = '<%= request.getContextPath() %>/test/admin/memberView.do';
            }, 1000); // 3000 milliseconds (3 seconds)
        };
    </script>
</head>
<body>

<h2>회원 정보 수정 결과</h2>

<%
    // 서블릿에서 전달된 메시지를 가져옴
    String message = (String) request.getAttribute("message");
%>

<p><%= message %></p>

</body>
</html>
