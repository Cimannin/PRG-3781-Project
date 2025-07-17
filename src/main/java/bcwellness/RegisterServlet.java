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
            //Created this variable to check the email
            PreparedStatement checkEmail = conn.prepareStatement("SELECT * FROM users WHERE email = ?");
            checkEmail.setString(1, email);
            ResultSet rsEmail = checkEmail.executeQuery();

            //when the user registers, it'll check if that email they entered already exists.
            if (rsEmail.next()){
                request.setAttribute("message", "Email is already in use.");
                request.getRequestDispatcher("register.jsp").forward(request, response);
                return;
            }

            //created this variable to check the student number, because no user can have the same student number.
            PreparedStatement checkStudent = conn.prepareStatement("SELECT * FROM users WHERE student_number = ?");
            checkStudent.setString(1, student_number);
            ResultSet rsStudent = checkStudent.executeQuery();

            //This message will display if the student number already exists
            if(rsStudent.next()){
                request.setAttribute("studentCodeMessage", "This student number already exists.");
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
        //this inserts all the registered information inside the table.
        }catch (Exception e){
            e.printStackTrace();
            response.sendRedirect("register.jsp");
        }
    }
}
