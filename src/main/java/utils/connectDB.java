package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectDB {
    public static Connection getConnection() {
        Connection connection = null;
        try {
            String dbURL = "jdbc:mysql://localhost:3306/murach";
            String username = "root";
            String password = "123456";
            connection = DriverManager.getConnection(dbURL, username, password);
        } catch (SQLException e) {
            for (Throwable t : e)
                t.printStackTrace();
        }
        return connection;
    }
}
