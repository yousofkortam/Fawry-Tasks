package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = DatabaseConnection.getInstance().getConnection();
            connection.setAutoCommit(false);

            // Correct
            String query1 = "INSERT INTO `group` (`name`, `description`) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query1);
            preparedStatement.setString(1, "group 123465 task name");
            preparedStatement.setString(2, "group 123465 task description");
            preparedStatement.executeUpdate();

            // ------------------------------------------------

            // Wrong
            String query2 = "INSERT INTO contest (`nema`, `description`) VALUES (?, ?)";
            preparedStatement = connection.prepareStatement(query2);
            preparedStatement.setString(1, "contest 123465 task name");
            preparedStatement.setString(2, "contest 123465 task description");
            preparedStatement.executeUpdate();

            connection.commit();
            System.out.println("Transactions commited :)");

        } catch (Exception e) {
            System.out.println("Ops..!");
            if (connection != null) {
                try {
                    System.out.println("Rolling back transactions :(");
                    connection.rollback();
                } catch (SQLException e1) {
                    throw new RuntimeException(e1);
                }
            }
        }
    }
}