<%@ page import="com.example.edu_com_plati_za_edu.entity.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.edu_com_plati_za_edu.entity.Teacher" %><%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 30.12.2022
  Time: 09:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
  <link rel="stylesheet" href="style.css">
</head>
<body>
<table>
  <thead>
  <tr>
    <td>id</td>
    <td>fio</td>
    <td>email</td>
    <td>phone_numver</td>
  </tr>
  </thead>
  <tbody>
  <% List<Teacher> students = (List<Teacher>) request.getAttribute("list"); %>
  <% for (Teacher student : students) {%>
  <tr>
    <td><%= student.getId() %></td>
    <td><%= student.getFio() %></td>
    <td><%=student.getEmail()%></td>
    <td><%=student.getPhoneNumber()%></td>
  </tr>
  <% } %>
  </tbody>
</table>
</body>
</html>
