package java.servelet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/welcome")
public class Log extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("username") != null) {
            String username = (String) session.getAttribute("username");

            PrintWriter out = response.getWriter();
            out.println("<html><head><title>Welcome</title></head><body>");
            out.println("<h2>Welcome, " + username + "!</h2>");
            out.println("<a href='logout'>Logout</a>");
            out.println("</body></html>");
        } else {
            response.sendRedirect("login.html"); // Redirect to login page if not logged in
        }
    }
}
