package bcwellness;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String email = request.getParameter("email");
        String rawPassword = request.getParameter("user_password");

        // Hash the incoming password, which, if checked inside postgre, it will be hashed
        String hashedPassword = PasswordHash.hashPassword(rawPassword);

        try(Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE email=? AND user_password=?");
            ps.setString(1, email);
            ps.setString(2, hashedPassword);

            ResultSet rs = ps.executeQuery();

            //the session is active, when their password and emails match with what is in the database
            if (rs.next()){
                HttpSession session = request.getSession();
                System.out.println("User found:" + rs.getString("student_name") );

                session.setAttribute("student_name", rs.getString("student_name"));
                session.setAttribute("email", rs.getString("email"));
                session.setAttribute("successMessage", "Login successful! Welcome " + rs.getString("student_name") + ".");
                response.sendRedirect("dashboard.jsp");
            }else{
                System.out.println("User not found:" + rs.getString("student_name") );

                //if this user types in the wrong information, this message will show.
                request.setAttribute("Message", "Invalid credentials.");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        }catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("login.jsp");
        }
    }
}
