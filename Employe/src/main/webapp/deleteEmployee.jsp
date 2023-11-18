<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Delete Employee</title>
    <link rel="stylesheet" type="text/css" href="cssFiles/DeleteEmployee.css">
</head>
<body>
<div class="container">
    <h2>Delete Employee</h2>
    <p>Are you sure you want to delete this employee?</p>
    <div class="button-container">
        <form action="deleteEmployee" method="post">
            <input type="hidden" name="id" value="<%= request.getParameter("id") %>">
            <input type="submit" value="Delete">
        </form>
        <a href="employeeList">Back to Employee List</a>
    </div>
</div>
</body>
</html>