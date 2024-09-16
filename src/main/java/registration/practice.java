package registration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDao {
    private String dburl = "jdbc:mysql://lcalhost:3306/";
    private String dbuname = "root";
    private String dbpassword = "12345";
    private String dbdriver = "com.mysql.cj.jdbc.Driver"; // Correct package name

    public void loadDriver(String dbDriver) {
        try {
            Class.forName(dbDriver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(dburl, dbuname, dbpassword); // Assign connection to conn
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public String insert(Member member) {
        loadDriver(dbdriver);
        Connection conn = getConnection();
        String result = "Data entered successfully";
        String sql = "INSERT INTO userdb.member VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, member.getUname());
            ps.setString(2, member.getpassword());
            ps.setString(3, member.getEmail());
            ps.setString(4, member.getphone()); // Ensure correct method name
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            result = "Data not entered";
        }

        return result; // Correctly return the result string
    }
}