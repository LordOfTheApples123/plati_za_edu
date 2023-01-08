<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 30.12.2022
  Time: 08:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<form action="${pageContext.request.contextPath}/studentCR">
    <input type="submit" value="student" />
</form>

<form action="${pageContext.request.contextPath}/courseForm">
    <input type="submit" value="course" />
</form>

<form action="${pageContext.request.contextPath}/groupForm">
    <input type="submit" value="groups" />
</form>

<form action="${pageContext.request.contextPath}/teacherForm">
    <input type="submit" value="teacher" />
</form>
</body>
</html>
