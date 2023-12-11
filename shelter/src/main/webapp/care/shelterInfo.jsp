<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Shelter Information</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 20px;
        }
        
        .container {
            max-width: 800px;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        
        h1 {
            color: #333;
        }
        
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>

<div class="container">
    <h1>Shelter Information</h1>
    
    <table>
        <tr>
            <th>ID</th>
            <th>Status</th>
            <th>Service</th>
            <th>Organization</th>
            <th>Location</th>
        </tr>
        <c:forEach var="shelter" items="${shelterInfo}">
            <tr>
                <td>${shelter.id}</td>
                <td>${shelter.status}</td>
                <td>${shelter.service}</td>
                <td>${shelter.organization}</td>
                <td>${shelter.location}</td>
            </tr>
        </c:forEach>
    </table>
    
</div>

</body>
</html>
