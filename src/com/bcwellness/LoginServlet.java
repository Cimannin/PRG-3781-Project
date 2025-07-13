package com.bcwellness;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String email = request.getParameter("email");
        String üser_password =request.getParameter("user_password");

        try(Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.preparedStatement("SELECT * FROM users WHERE email=? AND password=?");
            ps.setString(1, email);
            ps.setString(2, üser_password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()){
                HttpSession session = request.getSession();
                session.setAttribute("student_name", rs.getString("student_name"));
                response.sendRedirect("dashboard.jsp");
            }else{
                request.setAttribute("Message", "Invalid credentials.");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        }catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("login.jsp");
        }
    }
}
