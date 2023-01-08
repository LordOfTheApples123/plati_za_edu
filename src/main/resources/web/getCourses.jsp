<%@ page import="com.example.edu_com_plati_za_edu.entity.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.edu_com_plati_za_edu.entity.Course" %>
<%@ page import="com.example.edu_com_plati_za_edu.entity.Teacher" %>
<%@ page import="com.example.edu_com_plati_za_edu.DBRepo" %><%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 30.12.2022
  Time: 08:49
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
    <td>subject</td>
    <td>price</td>
    <td>teacher</td>
  </tr>
  </thead>
  <tbody>
  <% List<Course> students = (List<Course>) request.getAttribute("list"); %>
  <%DBRepo dbRepo = (DBRepo) request.getAttribute("dbrepo");%>

  <% for (Course student : students) {%>
  <tr>
    <td><%= student.getId() %></td>
    <td><%= student.getSubject() %></td>
    <td><%=student.getPrice()%></td>
    <td><%=((Teacher) dbRepo.findById(student.getTeacherID(), Teacher.class)).getFio()%></td>
  </tr>
  <% } %>
  </tbody>
</table>
</body>
</html>
