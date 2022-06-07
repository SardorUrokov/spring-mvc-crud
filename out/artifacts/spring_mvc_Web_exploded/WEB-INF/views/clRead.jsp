<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 6/6/2022
  Time: 11:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>Class Read</title>
</head>
<body>
<h2>Spring MVC Create, Read, Update and Delete (CRUD) Example</h2>
<p><strong>Classes List is Here | <a href="/class/add">Click for Create a Class</a></strong></p>
<table border="1">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Action</th>
    </tr>
    <c:forEach var="ketmon" items="${listClass}">
        <tr>
            <td>${ketmon.id}</td>
            <td>${ketmon.name}</td>
            <td><a href="update/<c:out value='${ketmon.id}'/>">Update</a> |
                <a href="delete/<c:out value='${ketmon.id}'/>">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
