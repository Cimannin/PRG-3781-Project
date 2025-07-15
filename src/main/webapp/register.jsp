<%@ page contentType="text/html" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Register</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
<div class="container">
    <h2>Register</h2>
    <form method="post" action="register">
        <input type="text" name="student_number" placeholder="Student Number" required>
        <input type="text" name="student_name" placeholder="Name" required>
        <input type="text" name="surname" placeholder="Surname" required>
        <input type="email" name="email" placeholder="Email" required>
        <input type="text" name="phone" placeholder="Phone" required>
        <input type="password" name="user_password" placeholder="Password" required>
        <input type="submit" value="Register">
    </form>
    <a href="index.jsp">← Back to Home</a>
</div>
</body>
</html>