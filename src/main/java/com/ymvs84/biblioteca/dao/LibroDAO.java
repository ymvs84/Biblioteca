package com.ymvs84.biblioteca.dao;

import com.ymvs84.biblioteca.model.Libro;
import com.ymvs84.biblioteca.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LibroDAO {

    // CREATE
    public void insertar(Libro libro) throws SQLException {
        String sql = "INSERT INTO libros (isbn, titulo, autor, disponible) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getInstance();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, libro.getIsbn());
            pstmt.setString(2, libro.getTitulo());
            pstmt.setString(3, libro.getAutor());
            pstmt.setBoolean(4, libro.isDisponible());

            pstmt.executeUpdate();
        }
    }

    // READ (Todos)
    public List<Libro> obtenerTodos() throws SQLException {
        List<Libro> libros = new ArrayList<>();
        String sql = "SELECT * FROM libros";

        try (Connection conn = DatabaseConnection.getInstance();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Libro libro = new Libro(
                        rs.getInt("id"),
                        rs.getString("isbn"),
                        rs.getString("titulo"),
                        rs.getString("autor"),
                        rs.getBoolean("disponible")
                );
                libros.add(libro);
            }
        }
        return libros;
    }

    // UPDATE (Prestar/Devolver)
    public void actualizarDisponibilidad(String isbn, boolean disponible) throws SQLException {
        String sql = "UPDATE libros SET disponible = ? WHERE isbn = ?";

        try (Connection conn = DatabaseConnection.getInstance();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setBoolean(1, disponible);
            pstmt.setString(2, isbn);
            pstmt.executeUpdate();
        }
    }

    // DELETE
    public void eliminar(String isbn) throws SQLException {
        String sql = "DELETE FROM libros WHERE isbn = ?";

        try (Connection conn = DatabaseConnection.getInstance();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, isbn);
            pstmt.executeUpdate();
        }
    }
}