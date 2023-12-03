<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="../css/index.css" />
    <link rel="stylesheet" href="../css/table.css" />
    <title>사지마세요, 입양하세요.</title>
</head>
<body>
    <jsp:include page="testHeader.jsp" />
    <% 
        shelter.beans.member.MemberDto memberDto = (shelter.beans.member.MemberDto) request.getAttribute("memberDto");

        if (memberDto != null) {
    %>
            <!-- Display Member ID if available -->
            <p>Member ID: <%= memberDto.getMemberId() %></p>
    <%
            // Display other member information
        } else {
    %>
            <p>Member information not available.</p>
    <%
        }
    %>
    <main>
        <h2>Member Information</h2>
        <table border="1">
            <tr>
                <td>ID</td>
                <!-- Use ternary operator for null check and display "N/A" if memberDto is null -->
                <td><%= (memberDto != null) ? memberDto.getMemberId() : "N/A" %></td>
            </tr>
            <tr>
                <td>Name</td>
                <!-- Use ternary operator for null check and display "N/A" if memberDto is null -->
                <td><%= (memberDto != null && memberDto.getMemberName() != null) ? memberDto.getMemberName() : "N/A" %></td>
            </tr>
            <tr>
                <td>Nickname</td>
                <!-- Use ternary operator for null check and display "N/A" if memberDto is null -->
                <td><%= (memberDto != null && memberDto.getMemberNickname() != null) ? memberDto.getMemberNickname() : "N/A" %></td>
            </tr>
            <tr>
                <td>Phone</td>
                <!-- Use ternary operator for null check and display "N/A" if memberDto is null -->
                <td><%= (memberDto != null && memberDto.getMemberPhone() != null) ? memberDto.getMemberPhone() : "N/A" %></td>
            </tr>
            <tr>
                <td>Email</td>
                <!-- Use ternary operator for null check and display "N/A" if memberDto is null -->
                <td><%= (memberDto != null && memberDto.getMemberEmail() != null) ? memberDto.getMemberEmail() : "N/A" %></td>
            </tr>
            <tr>
                <td>Gender</td>
                <!-- Use ternary operator for null check and display "N/A" if memberDto is null -->
                <td><%= (memberDto != null && memberDto.getMemberGender() != null) ? memberDto.getMemberGender() : "N/A" %></td>
            </tr>
            <tr>
                <td>Address</td>
                <!-- Use ternary operator for null check and display "N/A" if memberDto is null -->
                <td><%= (memberDto != null && memberDto.getMemberAddress() != null) ? memberDto.getMemberAddress() : "N/A" %></td>
            </tr>
            <!-- Add more rows for other member information -->
        </table>
    </main>
</body>
</html>
