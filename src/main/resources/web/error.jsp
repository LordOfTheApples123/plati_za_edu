<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 26.12.2022
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Something went wrong</title>
    <link rel="stylesheet" href="error.css">
</head>
<body>
<body>
<section class="notFound">
    <div class="img">
        <img src="https://assets.codepen.io/5647096/backToTheHomepage.png" alt="Back to the Homepage"/>
        <img src="https://assets.codepen.io/5647096/Delorean.png" alt="El Delorean, El Doc y Marti McFly"/>
    </div>
    <div class="text">
        <h1>SOMETHING WENT WRONG</h1>
        <h2><%= request.getAttribute("error_message")%></h2>
        <h3>BACK TO HOME?</h3>
        <a href="/plati_za_edu/" class="yes">YES</a>
    </div>
</section>
</body>
</body>
</html>
