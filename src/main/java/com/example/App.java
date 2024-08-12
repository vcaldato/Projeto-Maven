package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class App {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String user = "vini";
        String password = "9973";

        Connection connection = null;
        Statement statement = null;

        try {
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
            String createTableSQL = "CREATE TABLE IF NOT EXISTS users ("
                                    + "id INT PRIMARY KEY AUTO_INCREMENT, "
                                    + "name VARCHAR(50), "
                                    + "email VARCHAR(50))";
            statement.executeUpdate(createTableSQL);

            String insertSQL = "INSERT INTO users (name, email) VALUES ('Vinicius Caldato', 'vinicaldato@gmail.com')";
            statement.executeUpdate(insertSQL);
            
            System.out.println("Tabela criada com sucesso e registro inseridos com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
