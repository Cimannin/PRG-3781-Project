<!DOCTYPE html>
<html lang="en">
<head>
 <%@ page contentType="text/html" %>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h2>Register</h2>
<form method="post" action="register">
    Student Number: <input name="student_number"><br>
    Name: <input name="name"><br>
    Surname: <input name="surname"><br>
    Email: <input name="email"><br>
    Phone: <input name="phone"><br>
    Password: <input type="password" name="password"><br>
    <input type="submit" value="Register">
</form>
<p style="color:red;"><%= request.getAttribute("message") != null ? request.getAttribute("message") : "" %></p>

</body>
</html>