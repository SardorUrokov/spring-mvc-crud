<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>Group Update</title>
</head>
<body>
<h2>Spring MVC Create, Read, Update and Delete (CRUD) Example</h2>
<p><strong>Update Group Here | <a href="/group/all">Click for Read Groups</a></strong></p>
<form action="/group/update" method="post">
<pre>
<c:forEach var="group" items="${ketmon}">

    Id: <input type="number" name="id" value="${group.id}" disabled="disabled"/>
    <input type="hidden" name="id" value="${group.id}"/>

    Name: <input type="text" name="name" value="${group.name}"/>

    SinfId: <input type="number" name="sinfId" value="${group.sinfId}"/>

    <input type="submit" value="Update"/>
</c:forEach>
</pre>
</form>
${msg}
</body>
</html>
