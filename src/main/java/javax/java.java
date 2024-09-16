import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class AddNumbersServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Get parameters from the form
        String num1Str = request.getParameter("num1");
        String num2Str = request.getParameter("num2");

        // Convert parameters to integers
        int num1 = Integer.parseInt(num1Str);
        int num2 = Integer.parseInt(num2Str);

        // Perform addition
        int sum = num1 + num2;

        // Set response content type
        response.setContentType("text/html");

        // Write the result HTML response
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Result</title></head><body>");
        out.println("<h2>Result of Add
