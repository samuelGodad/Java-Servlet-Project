<%--
  Created by IntelliJ IDEA.
  User: Sami
  Date: 12/1/2023
  Time: 9:57 AM
  To change this template use File | Settings | File Templates.
--%>
<!-- welcome.jsp -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome Page</title>
    <link type="text/css" rel="stylesheet" href="css/welcome.css"/>
</head>
<body>
<% String userName = (String) session.getAttribute("userName"); %>
<% Boolean signup = (Boolean) session.getAttribute("signup"); %>
<div class="card">
    <% if (signup) { %>
    <h1>Welcome <%= userName %>!</h1>
    <p>You have successfully signed up.</p>
    <p>Click <a href="back?showLogin=true">here</a> to login.</p>
    <% } else { %>
    <h1>Welcome back <%= userName %> we are happy to see you again!</h1>

    <p>Click <a href="back?showLogin=true">here</a> to login.</p>
    <% } %>
    <form action="logout" method="POST">
        <button type="submit">Logout</button>
    </form>
</div>
</body>
</html>
