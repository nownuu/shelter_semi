<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Shelter Information</title>
</head>
<body>
    <h2>Shelter Information</h2>

    <c:if test="${not empty apiResult}">
        <table border="1">
            <tr>
                <th>Care Name</th>
                <th>Organization Name</th>
                <th>Division Name</th>
                <!-- Add more headers based on your data structure -->
            </tr>
            
            <c:forEach var="item" items="${apiResult.body.items.item}">
                <tr>
                    <td>${item.careNm}</td>
                    <td>${item.orgNm}</td>
                    <td>${item.divisionNm}</td>
                    <!-- Add more cells based on your data structure -->
                </tr>
            </c:forEach>
        </table>
    </c:if>

</body>
</html>
