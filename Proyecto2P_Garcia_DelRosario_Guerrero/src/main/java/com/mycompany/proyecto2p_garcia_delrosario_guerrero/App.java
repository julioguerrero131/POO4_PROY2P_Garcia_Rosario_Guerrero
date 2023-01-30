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

    /**
     * Scene scene; atributo propio
     */
    public static Scene scene;
    /**
     * String pathFiles; atributo que guardará las rutas de acceso de los archivos
     */
    public static String pathFiles = "src/main/resources/files/";
    
    /**
     * String pathImg; atributo que guardará las rutas de acceso de las imagenes
     */
    public static String pathImg = "src/main/resources/images/";
    
    /**
     * String pathPed; atributo que guardará las rutas de acceso de los pedidos
     */
    public static String pathPed = "src/main/resources/pedidos/";
    
    /**
     * Metodo start; Metodo que nos permitirá generar una nueva escena y ventana en el programa
     * @param stage; parametro necesario para poder generar una escena en JAVA FX
     * @throws Exception 
     */
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmLoader = new FXMLLoader(App.class.getResource("VentanaSistema.fxml"));
        Parent root = fxmLoader.load();
        scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.show();

    }


    /**
     * Metodo main; dará inició al lanzamiento de la escena
     * @param args 
     */
    public static void main(String[] args) {
        launch();
    }
    

}
