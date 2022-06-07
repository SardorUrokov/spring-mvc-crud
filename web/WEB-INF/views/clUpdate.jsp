<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>Class Update</title>
</head>
<body>
<h2>Spring MVC Create, Read, Update and Delete (CRUD) Example</h2>
<p><strong>Update Group Here | <a href="/class/all">Click for Read Groups</a></strong></p>
<form action="/class/update" method="post">
<pre>
<c:forEach var="sinf" items="${ketmon}">

    Id: <input type="number" name="id" value="${sinf.id}" disabled="disabled"/>
    <input type="hidden" name="id" value="${sinf.id}"/>

    Name: <input type="text" name="name" value="${sinf.name}"/>

    <input type="submit" value="Update"/>
</c:forEach>
</pre>
</form>
${msg}
</body>
</html>
