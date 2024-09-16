package java.servelet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/result")
public class ss extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve parameters num1 and num2 from the form submission
        String num1Str = request.getParameter("num1");
        String num2Str = request.getParameter("num2");

        try {
            // Parse the input values as integers
            int num1 = Integer.parseInt(num1Str);
            int num2 = Integer.parseInt(num2Str);

            // Perform the addition
            int result = num1 + num2;

            // Prepare response HTML
            response.setContentType("text/html");
            response.getWriter().println("<html><head><title>Result</title></head><body>");
            response.getWriter().println("<h2>Result of Addition</h2>");
            response.getWriter().println("<p>" + num1 + " + " + num2 + " = " + result + "</p>");
            response.getWriter().println("</body></html>");
        } catch (NumberFormatException e) {
            // Handle case where input is not a valid integer
            response.getWriter().println("<html><head><title>Error</title></head><body>");
            response.getWriter().println("<h2>Error</h2>");
            response.getWriter().println("<p>Invalid input. Please enter valid integers.</p>");
            response.getWriter().println("</body></html>");
        }
    }
}
