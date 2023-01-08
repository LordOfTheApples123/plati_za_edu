<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="style.css">
</head>
<body>

<h1>My First Heading</h1>

<form action="${pageContext.request.contextPath}/studentCR" method="get">
    <div>
        <input type = "Submit" value = "getAll">
    </div>
</form>

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
        <label for="phone_number">phone_number: </label>
        <input type="number" name="phone_number" id="phone_number" required>
    </div>
    <div class="form-example">
        <input type="submit" value="Submit!">
    </div>
</form>

<form action="${pageContext.request.contextPath}/studentCR" method="get">

    <div>
        <label for="find_id">find by id: </label>
        <input type="hidden" name="getById" value="true">
        <input type="text" name="find_id" id="find_id" required>

    </div>
        <input type="submit" value="findById">
</form>

<form action="${pageContext.request.contextPath}/deleteStudentById" method="get">

    <div>
        <label for="delete_id">find by id: </label>
        <input type="hidden" name="action" value="find">
        <input type="text" name="delete_id" id="delete_id" required>

    </div>
    <input type="submit" value="deleteById">
</form>

</body>
</html>