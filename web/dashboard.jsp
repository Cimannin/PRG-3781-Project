<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <%@ page session="true" %>
    <%
    String student = (String) session.getAttribute("studentName");
    if (student == null) {
        response.sendRedirect("login.jsp");
    }
    %>
    <title>Title</title>
</head>
<body>
<h2>Welcome, <%= student %>!</h2>
<a href="login.jsp" onclick="<% session.invalidate(); %>">Logout</a>
</body>
</html>