package br.com.bacana.store.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection connection = null;

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        final String USER = "root";
        final String PASSWORD = "";

        if(connection != null) {
            return connection;
        } else {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projeto_bacanas", USER, PASSWORD);
        }

        return connection;
    }
}
