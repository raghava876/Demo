package sXd;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;                                       
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Databaseservlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
	private static final Statement DatabaseConnector = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = DatabaseConnector.getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT * FROM mytable";
            ResultSet rs = stmt.executeQuery(sql);

            // Process the result set, e.g., output data to the servlet response
            PrintWriter out = response.getWriter();
            while (rs.next()) {
                out.println("Name: " + rs.getString("name"));
                out.println("Age: " + rs.getInt("age"));
                // Add more fields as needed
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
