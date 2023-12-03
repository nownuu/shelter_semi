<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Member View</title>
</head>
<body>

<h2>Member List</h2>

<table border="1">
    <thead>
        <tr>
            <th>ID</th>
            <th>Password</th>
            <th>Name</th>
            <th>Nickname</th>
            <th>Phone</th>
            <th>Email</th>
            <th>Gender</th>
            <th>Address</th>
            <th>Action</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="member" items="${members}">
            <tr>
                <td>${member.memberId}</td>
                <td>${member.memberPw}</td>
                <td>${member.memberName}</td>
                <td>${member.memberNickname}</td>
                <td>${member.memberPhone}</td>
                <td>${member.memberEmail}</td>
                <td>${member.memberGender}</td>
                <td>${member.memberAddress}</td>
                <td>
                    <a href="<%= request.getContextPath() %>/test/admin/editMember.jsp?memberId=${member.memberId}">Edit</a>
                    |
                    <a href="<%= request.getContextPath() %>/test/admin/deleteMember.do?memberId=${member.memberId}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>

</body>
</html>
