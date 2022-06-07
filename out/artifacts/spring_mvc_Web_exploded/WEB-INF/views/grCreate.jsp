<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 6/6/2022
  Time: 3:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Group Add</title>
</head>
<body>
<h2>Spring MVC Create, Read, Update and Delete (CRUD) Example</h2>
<form action="add" method="post" >
<pre>
    <strong>Create a Group Here | <a href="/group/all">Click for Read Groups</a></strong>

	Name: <input type="text" name="name"/>

	Sinf Id: <input type="number" name="sinfId"/>

	<input type="submit" value="Saqlash"/>
</pre>
</form>
${ketmon}
</body>
</html>
