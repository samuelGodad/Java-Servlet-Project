<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.calculatore.calculatore_project.OperationServlet" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Simple Calculator</title>
    <link rel="stylesheet" type="text/css" href="./css/calculator.css">

</head>
<body>
<h2 class="header_2">Simple Calculator</h2>
<form class="form_container" action="operation" method="POST">
    <label>
        <span class="label_text">Enter 1st Number:</span>
        <input type="text" name="num1" class="input_field" value="${param.num1}">
    </label>
    <label>
        <span class="label_text">Enter 2nd Number:</span>
        <input type="text" name="num2" class="input_field" value="${param.num2}">
    </label>
    <label>
        <span class="label_text">Select Operation:</span>
        <select class="operations_list" name="operation" onchange="updateButtonText(this)">
            <option value="add" ${param.operation == 'add' ? 'selected' : ''}>Addition (+)</option>
            <option value="subtract" ${param.operation == 'subtract' ? 'selected' : ''}>Subtraction (-)</option>
            <option value="multiply" ${param.operation == 'multiply' ? 'selected' : ''}>Multiplication (*)</option>
            <option value="divide" ${param.operation == 'divide' ? 'selected' : ''}>Division (/)</option>
        </select>
    </label>
    <input type="hidden" name="selectedOperation" value="${param.operation}">
    <input type="submit" value="Calculate" class="calculate_button" id="calculate_button">
    <% String result = (String) request.getAttribute("result");
        if (result != null) {
    %>
    <div class="result_container show">
        <p><%= result %></p>
    </div>
    <% } %>
</form>
<script src="./js/calculator.js"></script>
</body>
</html>