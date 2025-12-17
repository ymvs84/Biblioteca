package com.ymvs84.biblioteca;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // Cargar el FXML nuevo
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("biblioteca-view.fxml"));

        // Crear la escena (ventana) de 800x600 píxeles
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);

        stage.setTitle("Gestión de Biblioteca - Yago Menéndez");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}