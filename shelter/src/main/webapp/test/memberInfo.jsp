<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Member Information</title>
</head>
<body>
    <h2>Member Information</h2>

<% shelter.beans.member.MemberDto memberDto = (shelter.beans.member.MemberDto) request.getAttribute("memberDto");
if (memberDto != null) {
    out.println("Member ID: " + memberDto.getMemberId());
    // 다른 멤버 정보 출력
} else {
    out.println("Member information not available.");
}
%>


        <table border="1">
            <tr>
                <td>ID</td>
                <td><%= memberDto.getMemberId() %></td>
            </tr>
            <tr>
                <td>Name</td>
                <td><%= memberDto.getMemberName() %></td>
            </tr>
            <tr>
                <td>Nickname</td>
                <td><%= memberDto.getMemberNickname() %></td>
            </tr>
            <tr>
                <td>Phone</td>
                <td><%= memberDto.getMemberPhone() %></td>
            </tr>
            <tr>
                <td>Email</td>
                <td><%= memberDto.getMemberEmail() %></td>
            </tr>
            <tr>
                <td>Gender</td>
                <td><%= memberDto.getMemberGender() %></td>
            </tr>
            <tr>
                <td>Address</td>
                <td><%= memberDto.getMemberAddress() %></td>
            </tr>
            <!-- Add more rows for other member information -->
        </table>
</body>
</html>
