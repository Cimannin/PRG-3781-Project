
<!DOCTYPE html>
<html lang="en">
<head>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" %>
<%
    String student = (String) session.getAttribute("student_name");
    if (student == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
    <meta charset="UTF-8">
    <title>Dashboard</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
<div class="container">
    <h2>Welcome, <%= student %>!</h2>

    <p class="fade-in">You are successfully logged into your dashboard.</p>

    <form action="logout.jsp" method="post" style="margin-top: 20px;">
        <input type="submit" value="Logout" class="button">
    </form>

    <a href="index.jsp" class="button-outline" style="margin-top: 10px; display:inline-block;">← Back to Home</a>
</div>
</body>
</html>