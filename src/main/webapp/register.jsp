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
 <%-- Show error if email already exists --%>
    <% String regError = (String) request.getAttribute("message"); %>
    <% if (regError != null) { %>
        <p class="error-message"><%= regError %></p>
 <% } %>

 <%-- Show error if student number already exists --%>
     <% String regStuError = (String) request.getAttribute("studentCodeMessage"); %>
     <% if (regStuError != null) { %>
         <p class="error-message"><%= regStuError %></p>
  <% } %>

   <%--student number is forced to be six digits, and new users cant type smaller than that --%>
    <h2>Register</h2>
    <form method="post" action="register">
        <input type="text" name="student_number" placeholder="Student Number" required
                     pattern="\d{6}" maxlength="6" title="Student number must be exactly 6 digits">

        <input type="text" name="student_name" placeholder="Name"  required pattern="[A-Za-z\s]+" title="Only letters and spaces allowed">
        <input type="text" name="surname" placeholder="Surname" required pattern="[A-Za-z\s]+" title="Only letters and spaces allowed">
        <input type="email" name="email" placeholder="Email" required>
        <input type="text" name="phone" placeholder="Phone" required pattern="0[6-8][0-9]{8}" title="Has to be in this format: 0(6-9)...">
        <input type="password" name="user_password" placeholder="Password" required pattern=".{6,}" title="Password must be at least 6 characters long">
        <input type="submit" value="Register">
    </form>
    <a href="index.jsp">Back to Home</a>
</div>
</body>
</html>