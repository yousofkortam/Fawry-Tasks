package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static DatabaseConnection instance;
    private Connection connection;
    private final String url = "jdbc:mysql://localhost:3306/xjudge";
    private final String username = "root";
    private final String password = "root";

    private DatabaseConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static DatabaseConnection getInstance() throws SQLException {
        if (instance == null) {
            return new DatabaseConnection();
        } else if (instance.getConnection().isClosed()) {
            return new DatabaseConnection();
        }
        return instance;
    }

}
