<%@ page import="com.example.edu_com_plati_za_edu.entity.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.edu_com_plati_za_edu.entity.GroupStud" %>
<%@ page import="java.util.HashSet" %>
<%@ page import="java.util.Set" %><%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 26.12.2022
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>GetStudents</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<form action="${pageContext.request.contextPath}/studentCR" method="post">
    <div class="form-example">
        <label for="name">name: </label>
        <input type="text" name="name" id="name" required>
    </div>
    <div class="form-example">
        <label for="email">email: </label>
        <input type="text" name="email" id="email" required>
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
<form action="${pageContext.request.contextPath}/studentCR" method="get">

    <div>
        <label for="find_id">find by id: </label>
        <input type = "hidden" name = "findById" value = "find">
        <input type="hidden" name="getById" value="true">
        <input type="number" name="find_id" id="find_id" required>

    </div>
    <input type="submit" value="findById">
</form>
<form action="${pageContext.request.contextPath}/studentCR" method="get">

    <div>
        <label for="find_id">find by id: </label>
        <input type = "hidden" name = "findByFio" value = "find">
        <input type="text" name="fio" required>

    </div>
    <input type="submit" value="findByFio">
</form>
<table>
    <thead>
    <tr>
        <td>id</td>
        <td>fio</td>
        <td>email</td>
        <td>group_number</td>
    </tr>
    </thead>
    <tbody>
    <% List<Student> students = (List<Student>) request.getAttribute("list");
    int pageNo = (int) request.getAttribute("page");
    int recordsPerPage = (int) request.getAttribute("recordsPerPage");
    int noOfPages = (int) request.getAttribute("noOfPages");
    int start = (pageNo-1) * recordsPerPage;
    if(start != 0){
        start--;
    }
    %>
    <% for (int i = start; i < (pageNo * recordsPerPage) - 1 && i < students.size(); i++ ) {%>
    <tr>
        <% Student student = students.get(i); %>
        <td><%= student.getId() %></td>
        <td><%= student.getFio() %></td>
        <td><%=student.getEmail()%></td>
        <td><%=1%></td>
        <td><form action="${pageContext.request.contextPath}/update_delete" method="get">
            <input type = "hidden" name = "update" value = <%=student.getId()%>>
            <input type = "hidden" name = "class" value="student">
            <input type = "submit" value="update">
        </form></td>
        <td><form action="${pageContext.request.contextPath}/update_delete" method="get">
            <input type = "hidden" name = "delete" value = <%=student.getId()%>>
            <input type = "hidden" name = "class" value="com.example.edu_com_plati_za_edu.entity.Student">
            <input type = "submit" value="delete">
        </form></td>
    </tr>
    <% } %>
    </tbody>
</table>
<%--For displaying Previous link except for the 1st page --%>


<%--For displaying Page numbers.
The when condition does not display a link for the current page--%>
<table>
    <tr>

        <% if(pageNo!=1){ %>
        <td><a href="${pageContext.request.contextPath}/studentCR?page=<%=pageNo - 1%>">Previous</a></td>
        <%}%>
        <% for(int i = 1; i <= noOfPages; i++){
            if(i == pageNo){ %>
                <td><%=i%></td>
            <% }
            else{ %>
                <td><a href="${pageContext.request.contextPath}/studentCR?page=<%=i%>"><%=i%></a></td>
            <%}
        }%>
        <%--For displaying Next link --%>
        <% if(pageNo!=noOfPages){ %>
        <td><a href="${pageContext.request.contextPath}/studentCR?page=<%=pageNo + 1%>">Next</a></td>
        <%}%>
    </tr>
</table>


</body>
</html>
