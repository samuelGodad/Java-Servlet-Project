
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Employee</title>
    <link rel="stylesheet" type="text/css" href="cssFiles/AddEmployee.css">
    <script>
        function validateForm() {
            var name = document.getElementById("name").value;
            var designation = document.getElementById("designation").value;
            var salary = document.getElementById("salary").value;

            if (name === "" || designation === "" || salary === "") {
                alert("All fields must be filled out");
                return false;
            }

            return true;
        }
    </script>
</head>
<body>
<h2>Add Employee</h2>
<form class="container" action="createEmployee" method="post" onsubmit="return validateForm()">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" required><br>
    <label for="designation">Designation:</label>
    <input type="text" id="designation" name="designation" required><br>
    <label for="salary">Salary:</label>
    <input type="number" id="salary" name="salary" required><br>

    <input type="submit" value="Add Employee">
</form>
<br>
<a class="view-link" href="employeeList">View Employee List</a>
</body>
</html>