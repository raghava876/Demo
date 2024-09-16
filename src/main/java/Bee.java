package servelet;
import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/FirstServlet")
public class Bee extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uid = request.getParameter("uid");
        String password = request.getParameter("password");

        // Check if the password is "1234"
        if (uid != null && !uid.isEmpty() && "1234".equals(password)) {
            request.setAttribute("uid", uid);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/SecondServlet");
            dispatcher.forward(request, response);
        } else {
            response.getWriter().println("Invalid login credentials");
        }
    }
}