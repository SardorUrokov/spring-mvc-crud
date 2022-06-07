<%--
  Created by IntelliJ IDEA.
  User: Onecomputers
  Date: 6/4/2022
  Time: 5:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Update</title>
</head>
<body>
<h2>Spring MVC Create, Read, Update and Delete (CRUD) Example</h2>
<p><strong>Update Here | <a href="/student/all">Click for Read</a></strong></p>
<form action="/student/update" method="post">
<pre>
<c:forEach var="student" items="${ketmon}">

    Id: <input type="number" name="id" value="${student.id}" disabled="disabled"/>
    <input type="hidden" name="id" value="${student.id}"/>

    Name: <input type="text" name="name" value="${student.name}"/>

    Email: <input type="text" name="email" value="${student.email}"/>

    Course: <input type="text" name="course" value="${student.course}"/>

    <input type="submit" value="Update"/>
</c:forEach>
</pre>
</form>
${msg}
</body>
</html>