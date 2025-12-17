package com.ymvs84.biblioteca.controller;

import com.ymvs84.biblioteca.dao.LibroDAO;
import com.ymvs84.biblioteca.model.Libro;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;
import java.util.List;

public class BibliotecaController {

    // Elementos visuales (tabla y columnas)
    @FXML private TableView<Libro> tablaLibros;
    @FXML private TableColumn<Libro, Integer> colId;
    @FXML private TableColumn<Libro, String> colIsbn;
    @FXML private TableColumn<Libro, String> colTitulo;
    @FXML private TableColumn<Libro, String> colAutor;
    @FXML private TableColumn<Libro, Boolean> colDisponible;

    // Campos de texto para añadir libros
    @FXML private TextField txtIsbn;
    @FXML private TextField txtTitulo;
    @FXML private TextField txtAutor;

    // Lógica de datos
    private final LibroDAO libroDAO = new LibroDAO();
    private final ObservableList<Libro> listaLibros = FXCollections.observableArrayList();

    // Este método se ejecuta automáticamente al abrir la ventana
    @FXML
    public void initialize() {
        configurarColumnas();
        cargarDatos();
    }

    private void configurarColumnas() {
        // Enlaza las columnas con los atributos de la clase Libro (usando los Getters de Lombok)
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colIsbn.setCellValueFactory(new PropertyValueFactory<>("isbn"));
        colTitulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        colAutor.setCellValueFactory(new PropertyValueFactory<>("autor"));
        colDisponible.setCellValueFactory(new PropertyValueFactory<>("disponible"));
    }

    private void cargarDatos() {
        try {
            listaLibros.clear();
            List<Libro> librosBBDD = libroDAO.obtenerTodos();
            listaLibros.addAll(librosBBDD);
            tablaLibros.setItems(listaLibros);
        } catch (SQLException e) {
            mostrarAlerta("Error SQL", "No se pudieron cargar los libros: " + e.getMessage());
        }
    }

    @FXML
    protected void onBotonGuardarClick() {
        String isbn = txtIsbn.getText();
        String titulo = txtTitulo.getText();
        String autor = txtAutor.getText();

        if (isbn.isEmpty() || titulo.isEmpty() || autor.isEmpty()) {
            mostrarAlerta("Datos incompletos", "Por favor, rellena todos los campos.");
            return;
        }

        try {
            Libro nuevoLibro = new Libro(isbn, titulo, autor);
            libroDAO.insertar(nuevoLibro); // Guardar en MySQL
            cargarDatos(); // Refrescar la tabla
            limpiarCampos();
        } catch (SQLException e) {
            mostrarAlerta("Error al guardar", "Probablemente el ISBN ya existe.\n" + e.getMessage());
        }
    }

    @FXML
    protected void onBotonEliminarClick() {
        Libro seleccionado = tablaLibros.getSelectionModel().getSelectedItem();
        if (seleccionado == null) {
            mostrarAlerta("Sin selección", "Selecciona un libro de la tabla para eliminarlo.");
            return;
        }

        try {
            libroDAO.eliminar(seleccionado.getIsbn());
            cargarDatos();
        } catch (SQLException e) {
            mostrarAlerta("Error al eliminar", e.getMessage());
        }
    }

    @FXML
    protected void onBotonPrestarClick() {
        cambiarEstado(false);
    }

    @FXML
    protected void onBotonDevolverClick() {
        cambiarEstado(true);
    }

    private void cambiarEstado(boolean disponible) {
        Libro seleccionado = tablaLibros.getSelectionModel().getSelectedItem();
        if (seleccionado == null) return;

        try {
            libroDAO.actualizarDisponibilidad(seleccionado.getIsbn(), disponible);
            cargarDatos();
        } catch (SQLException e) {
            mostrarAlerta("Error", e.getMessage());
        }
    }

    private void limpiarCampos() {
        txtIsbn.clear();
        txtTitulo.clear();
        txtAutor.clear();
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}