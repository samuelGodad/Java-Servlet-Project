<%@ page import="com.example.employe.Employee" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Employee</title>
    <link rel="stylesheet" type="text/css" href="cssFiles/EditEmployee.css">
</head>
<body>
<h2>Edit Employee</h2>
<form class="container" action="editEmployee" method="post">
    <input type="hidden" name="id" value="<%= ((Employee) request.getAttribute("employee")).getId() %>">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" value="<%= ((Employee) request.getAttribute("employee")).getName() %>" required><br>

    <label for="designation">Designation:</label>
    <input type="text" id="designation" name="designation" value="<%= ((Employee) request.getAttribute("employee")).getDesignation() %>"
           required><br>

    <label for="salary">Salary:</label>
    <input type="number" id="salary" name="salary" value="<%= ((Employee) request.getAttribute("employee")).getSalary() %>" required><br>

    <input type="submit" value="Update Employee">
</form>
<br>
<a href="employeeList">View Employee List</a>
</body>
</html>
