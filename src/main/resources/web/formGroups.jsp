<%@ page import="com.example.edu_com_plati_za_edu.entity.GroupStud" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.edu_com_plati_za_edu.entity.Course" %><%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 30.12.2022
  Time: 08:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<form action="${pageContext.request.contextPath}/group" method="get">
  <div>
    <input type = "Submit" value = "getAll">
  </div>
</form>

<form action="${pageContext.request.contextPath}/group" method="post">
  <div class="form-example">
    <label for="group_number">group number: </label>
    <input type="number" name="group_number" id="group_number" required>
  </div>
  <div class="form-example">
    <p><select name="group_number">
      <option disabled> Выберите номер группы</option>
    <% List<Course> list = (List<Course>) request.getAttribute("list"); %>
      <%for(Course groupStud: list){%>
      <option value= <%=groupStud.getId()%>><%=groupStud.getSubject()%></option>
      <%}%>
    </select></p>
  </div>
  <div class="form-example">
    <input type="submit" value="Submit!">
  </div>
</form>

<h1>update</h1>
<form action="${pageContext.request.contextPath}/group" method="post">


    <label for="uid">id: </label>
    <input type="number" name="subject" id="uid" required>
    <div class="form-example">
      <label for="group_number">group number: </label>
      <input type="number" name="group_number" id="ugroup_number" required>
    </div>
    <div class="form-example">
      <p><select name="group_number">
        <option> disabledВыберите номер группы</option>
<%--        <% List<Course> list = (List<Course>) request.getAttribute("list"); %>--%>
        <%for(Course groupStud: list){%>
        <option value= <%=groupStud.getId()%>><%=groupStud.getSubject()%></option>
        <%}%>
      </select></p>
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
