package com.ymvs84.biblioteca.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    // Configuración (En un proyecto real esto iría en un fichero .properties, pero para empezar vale)
    private static final String URL = "jdbc:mysql://localhost:3306/biblioteca_db";
    private static final String USER = "root";
    private static final String PASSWORD = ""; // Pon aquí tu contraseña de MySQL si tienes

    private static Connection instance;

    private DatabaseConnection() {
        // Constructor privado para evitar instancias
    }

    public static Connection getInstance() throws SQLException {
        if (instance == null || instance.isClosed()) {
            try {
                instance = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (SQLException e) {
                System.err.println("❌ Error conectando a la base de datos: " + e.getMessage());
                throw e;
            }
        }
        return instance;
    }
}