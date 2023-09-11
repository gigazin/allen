package com.github.gigazin.allen.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    public static void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(User.URL, User.NAME, User.PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Database connection failed:" + e.getMessage());
        }
    }

    public static void shutdown() {

    }

}
