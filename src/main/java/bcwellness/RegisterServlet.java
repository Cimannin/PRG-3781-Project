package bcwellness;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        String student_number = request.getParameter("student_number");
        String student_name = request.getParameter("student_name");
        String surname = request.getParameter("surname");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String rawPassword = request.getParameter("user_password");
        String user_password = PasswordHash.hashPassword(rawPassword);

        try(Connection conn = DBConnection.getConnection()) {
            PreparedStatement check = conn.prepareStatement("SELECT * FROM users WHERE email=?");
            check.setString(1, email);
            ResultSet rs = check.executeQuery();

            if (rs.next()){
                request.setAttribute("message", "Email is already in use.");
                request.getRequestDispatcher("register.jsp").forward(request, response);
                return;
            }

            PreparedStatement ps = conn.prepareStatement(
                    "INSERT INTO users (student_number, student_name, surname, email, phone, user_password) VALUES (?, ?, ?, ?, ?, ?)"
            );
            ps.setString(1, student_number);
            ps.setString(2, student_name);
            ps.setString(3, surname);
            ps.setString(4, email);
            ps.setString(5, phone);
            ps.setString(6, user_password);
            ps.executeUpdate();

            HttpSession session = request.getSession();
            session.setAttribute("registerSuccess", "Registration successful! Please log in.");
            response.sendRedirect("login.jsp");

        }catch (Exception e){
            e.printStackTrace();
            response.sendRedirect("register.jsp");
        }
    }
}
