package com.mycompany.proyecto2p_garcia_delrosario_guerrero;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import modelo.Usuario;

/**
 * JavaFX App
 */
public class App extends Application {

    public static Scene scene;
    public static String pathFiles = "src/main/resources/files/";
    public static String pathImg = "src/main/resources/images/";
    public static String pathPed = "src/main/resources/pedidos/";

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmLoader = new FXMLLoader(App.class.getResource("VentanaSistema.fxml"));
        Parent root = fxmLoader.load();
        scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.show();

    }



    public static void main(String[] args) {
        launch();
    }
}
