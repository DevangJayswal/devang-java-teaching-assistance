package com.example;

import java.sql.*;

public class MainApp {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
    static final String DB_URL = "jdbc:oracle:thin:@//localhost:1521/xe";

    //  Database credentials
    static final String USER = "hr";
    static final String PASS = "oracle";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //STEP 2: Register JDBC driver
        Class.forName(JDBC_DRIVER);

        //STEP 3: Open a connection
        System.out.println("Connecting to database...");
        Connection conn
                = DriverManager.getConnection(DB_URL, USER, PASS);

        conn.setAutoCommit(false);

        //STEP 4: Execute a query
        System.out.println("Creating statement...");
        Statement stmt = conn.createStatement();
        String query = "select employee_id,first_name,last_name,salary " + "from employees";
        // System.out.println("query:"+ query);
        ResultSet rs
                = stmt.executeQuery(query);

        //STEP 5: Extract data from result set
        while (rs.next()) {
            System.out.println(rs.getInt("employee_id") + " " + rs.getString("first_name") + " " + rs.getString("last_name") + " " + rs.getDouble("salary"));
        }

        rs.close();
        stmt.close();
        conn.close();

        System.out.println(
                "ok");
    }
}
