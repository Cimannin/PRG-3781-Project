<%@ page contentType="text/html" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
<div class="container">

  <%-- Show successful registration message --%>
    <%
        String regMsg = (String) session.getAttribute("registerSuccess");
        if (regMsg != null) {
    %>
        <p class="success-message"><%= regMsg %></p>
    <%
            session.removeAttribute("registerSuccess");
        }
    %>

    <%-- Show invalid login message --%>
    <%
        String msg = (String) request.getAttribute("Message");
        if (msg != null) {
    %>
        <p class="error-message"><%= msg %></p>
    <%
        }
    %>
    <h2>Login</h2>
<form method="post" action="login">
    <label>Email:</label>
    <input type="email" name="email" required>

    <label>Password:</label>
    <input type="password" name="user_password" required>

    <input type="submit" value="Login">
</form>
    <a href="index.jsp">Back to Home</a>
</div>
</body>
</html>