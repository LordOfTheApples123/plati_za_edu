<%@ page import="com.example.edu_com_plati_za_edu.entity.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.edu_com_plati_za_edu.entity.GroupStud" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.HashSet" %><%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 30.12.2022
  Time: 08:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<form action="${pageContext.request.contextPath}/studentCR" method="get">
    <div>

        <input type = "Submit" value = "getAll">
    </div>
</form>



<h1>update</h1>
<form action="${pageContext.request.contextPath}/update_delete" method="post">
    <% Student student = (Student) request.getAttribute("student"); %>


        <input type="hidden" name="id" id="id" value = <%=student.getId()%>>
        <div class="form-example">
            <label for="name">name: </label>
            <input type="text" name="name" id="name" value = <%=student.getFio()%> required>
        </div>
        <div class="form-example">
            <label for="email">email: </label>
            <input type="text" name="email" id="email" value = <%= student.getEmail()%> required>
        </div>
        <div class="form-example">
            <p><select name="group_number">
                <option disabled> Выберите номер группы</option>
                <% List<GroupStud> list = (List<GroupStud>) request.getAttribute("groupsList"); %>
                <% Set<Integer> groups = new HashSet<>();%>
                <% for(GroupStud groupStud: list){
                    groups.add(groupStud.getGroupNumber());
                }%>
                <%for(Integer groupStud: groups){%>
                <option value= <%=groupStud%>><%=groupStud%></option>
                <%}%>
            </select></p>
        </div>
        <div class="form-example">
            <input type="submit" value="Submit!">
        </div>
</form>

</body>
</html>
