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
  <div class="card">
    <h2>Welcome, <%= session.getAttribute("userName") %>!</h2>
    <form action="logout" method="POST">
      <button type="submit">Logout</button>
    </form>


  </div>

  </body>
</html>

