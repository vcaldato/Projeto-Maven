package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class App {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/testdb";
        String username = "localhost";
        String password = "9973";

        Connection connection = null;
        Statement statement = null;

        try {
            // Conexão com o banco de dados
            connection = DriverManager.getConnection(jdbcUrl, username, password);

            // Criação do statement
            statement = connection.createStatement();

            // SQL para criar uma tabela
            String createTableSQL = "CREATE TABLE IF NOT EXISTS users ("
                                    + "id INT PRIMARY KEY AUTO_INCREMENT, "
                                    + "name VARCHAR(50), "
                                    + "email VARCHAR(50))";

            // Executando o SQL
            statement.executeUpdate(createTableSQL);

            System.out.println("Tabela criada com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Fechando recursos
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
