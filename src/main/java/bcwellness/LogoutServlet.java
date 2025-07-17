package bcwellness;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
//the logout servlet allows the user to logout.
public class LogoutServlet extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//checks the session, if exists, and then ends it
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
//redirects to login page
        response.sendRedirect("login.jsp");
    }
}
