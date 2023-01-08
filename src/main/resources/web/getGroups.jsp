<%@ page import="com.example.edu_com_plati_za_edu.entity.Teacher" %>
<%@ page import="com.example.edu_com_plati_za_edu.entity.Course" %>
<%@ page import="com.example.edu_com_plati_za_edu.DBRepo" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.edu_com_plati_za_edu.entity.GroupStud" %>
<%@ page import="com.example.edu_com_plati_za_edu.entity.Student" %><%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 30.12.2022
  Time: 08:54
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
        <td>group_number</td>
        <td>course_subj</td>
        <td>students</td>
    </tr>
    </thead>
    <tbody>
    <% List<GroupStud> students = (List<GroupStud>) request.getAttribute("list"); %>

    <%DBRepo dbRepo = (DBRepo) request.getAttribute("dbrepo");%>

    <% for (GroupStud student : students) {%>
    <tr>
        <td><%= student.getGroupNumber() %></td>
        <td><%= ((Course) dbRepo.findById(student.getCourseId(), Course.class)).getSubject() %></td>
        <td><% for(Student student1: dbRepo.getGroupList(student.getId())){ %>
            <%=student1.getFio()%>
        <%}%></td>
    </tr>
    <% } %>
    </tbody>
</table>
</body>
</html>
