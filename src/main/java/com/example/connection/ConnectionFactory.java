package com.example.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private  static Connection connection = null;

    public static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
    public static final String USER = "hr";
    public static final String PASS = "oracle";

    public static Connection getConnection() throws ClassNotFoundException {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection= DriverManager.getConnection(URL, USER, PASS);
            return connection;
        } catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }
    }

    public void closeConnection() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

}
