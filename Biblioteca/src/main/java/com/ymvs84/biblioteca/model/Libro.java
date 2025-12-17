package com.ymvs84.biblioteca.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Genera getters, setters, toString, equals y hashcode automáticamente
@AllArgsConstructor // Genera constructor con todos los argumentos
@NoArgsConstructor  // Genera constructor vacío
public class Libro {
    private int id;
    private String isbn;
    private String titulo;
    private String autor;
    private boolean disponible;

    // Constructor personalizado sin ID (para cuando creamos un libro nuevo que aún no está en BBDD)
    public Libro(String isbn, String titulo, String autor) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.disponible = true; // Por defecto siempre está disponible al crearse
    }
}