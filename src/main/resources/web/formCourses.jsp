<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 30.12.2022
  Time: 08:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<form action="${pageContext.request.contextPath}/course" method="get">
    <div>
        <input type = "Submit" value = "getAll">
    </div>
</form>

<form action="${pageContext.request.contextPath}/group" method="post">
    <div class="form-example">
        <label for="subject">group id: </label>
        <input type="number" name="subject" id="subject" required>
    </div>
    <div class="form-example">
        <label for="price">course_name: </label>
        <input type="number" name="price" id="price" required>
        <label for="teacher_id">teacher_id: </label>
        <input type="number" name="teacher_id" id="teacher_id" required>
    </div>
    <div class="form-example">
        <input type="submit" value="Submit!">
    </div>
</form>

<h1>update</h1>
<form action="${pageContext.request.contextPath}/group" method="post">
    <div class="form-example">

        <label for="subject">id: </label>
        <input type="number" name="subject" id="uid" required>
        <label for="subject">group id: </label>
        <input type="number" name="subject" id="usubject" required>
    </div>
    <div class="form-example">
        <label for="price">course_name: </label>
        <input type="number" name="price" id="uprice" required>
        <label for="teacher_id">teacher_id: </label>
        <input type="number" name="teacher_id" id="uteacher_id" required>
    </div>
    <div class="form-example">
        <input type="submit" value="Submit!">
    </div>
</form>

<form action="${pageContext.request.contextPath}/group" method="get">

    <div>
        <label for="find_id">find by id: </label>
        <input type="hidden" name="action" value="find">
        <input type="text" name="find_id" id="find_id" required>

    </div>
    <input type="submit" value="findById">
</form>

<form action="${pageContext.request.contextPath}/group" method="get">

    <div>
        <label for="delete_id">delete by id: </label>
        <input type="hidden" name="deleteById" value="true">
        <input type="text" name="delete_id" id="delete_id" required>

    </div>
    <input type="submit" value="deleteById">
</form>
</body>
</html>
