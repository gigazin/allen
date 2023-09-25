package com.github.gigazin.allen.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static Connection connection;

    public static void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(User.URL, User.NAME, User.PASSWORD);
            System.out.println("Database connection successful.");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Database connection failed: " + e.getMessage());
        }
    }

    public static void shutdown(){
        try {
            connection.close();
            System.out.println("Database closed the connection.");
        } catch (SQLException e) {
            System.out.println("Database disconnection failed: " + e.getMessage());
        }
    }

    protected static Connection getConnection() {
        return connection;
    }

}
