package sXd;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/Register")
public class dadd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out =response.getWriter();
		
		String name =request.getParameter("name");
		String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        
        try {
Class.forName("com.mysql.cj.jdbc.Driver");
			
Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","Chandu@1234");
       
PreparedStatement ps =con.prepareStatement("insert into register values(?,?,?)");

ps.setString(1, name);
ps.setString(2, email);
ps.setString(3, pass);
int i = ps.executeUpdate();
 
if(i > 0) {
    out.println("You are successfully registered ");
 }
	   }catch(Exception exc) {
			exc.printStackTrace();
		}
	}

}