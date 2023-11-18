

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Sample JSP</title>
</head>
<body>
<h1>this is the new jsp file</h1>
<div>
    converting a string to uppercase :<%=new String("this was a small letter").toUpperCase()%>
    maths :<%=34*5%>
    <h1>let us do some scripts</h1>
    <%
        for (int i =1;i<5;i++){
            out.println("<br/>i love coding :"+i);
        }
    %>
</div>
</body>
</html>