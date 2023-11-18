<%@ page import="com.example.employe.Employee" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Employee List</title>
    <link rel="stylesheet" type="text/css" href="cssFiles/EmployeeList.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"
          crossorigin="anonymous" referrerpolicy="no-referrer"/>


</head>
<body>
<h2>Employee List</h2>
<table id="employeeTable" border="1">
    <thead>
    <tr style="background-color: #36304a; color: white;" id="header_tables">

    <th>ID</th>
        <th>Name</th>
        <th>Designation</th>
        <th>Salary</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    </thead>
    <tbody>
    <% Object employeesObj = request.getAttribute("employees");
        if (employeesObj instanceof List) {
            List<Employee> employees;
            employees = (List<Employee>) employeesObj;
            for (Employee employee : employees) { %>
    <tr>
        <td><%= employee.getId() %>
        </td>
        <td><%= employee.getName() %>
        </td>
        <td><%= employee.getDesignation() %>
        </td>
        <td><%= employee.getSalary() %>
        </td>
        <td><a href='editEmployee?id=<%= employee.getId() %>'><i class="fas fa-edit"></i> </a></td>
        <td><a href='deleteEmployee.jsp?id=<%= employee.getId() %>'><i class="fas fa-trash-alt"></i> </a></td>

    </tr>
    <% }
    } %>
    </tbody>
</table>
<a id="links" class="view-link" href="<%= request.getContextPath() %>">Add new employee</a>
</body>
</html>
