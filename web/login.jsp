<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <%@ page contentType="text/html" %>
    <title>Title</title>
</head>
<body>
<h2>Login</h2>
<form method="post" action="login">
    Email: <input name="email"><br>
    Password: <input type="password" name="password"><br>
    <input type="submit" value="Login">
</form>
<p style="color:red;"><%= request.getAttribute("message") != null ? request.getAttribute("message") : "" %></p>

</body>
</html>