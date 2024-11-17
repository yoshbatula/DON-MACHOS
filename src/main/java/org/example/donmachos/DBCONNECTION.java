package org.example.donmachos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBCONNECTION {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/donmachos";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public Connection getConnection() {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Connection successful!");
            return conn;
        } catch (SQLException e) {
            System.err.println("Failed to connect to the database: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
