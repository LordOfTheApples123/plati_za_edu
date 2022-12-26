package com.example.edu_com_plati_za_edu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMgr {
    public static Connection getNewConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/educational company plati-za-edu";
        String user = "postgres";
        String passwd = "root";
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("боль");
            throw new RuntimeException(e);
        }
        return DriverManager.getConnection(url, user, passwd);
    }

}
