/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyecto2p_garcia_delrosario_guerrero;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modelo.Usuario;

/**
 * FXML Controller class
 *
 * @author Cliente Intel
 */
public class VentanaSistemaController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try ( FileInputStream input = new FileInputStream(App.pathImg + "imagenSistema1.png")) {
            Image image = new Image(input, 200, 200, false, false);
            imagen1.setImage(image);
        } catch (IOException ex) {

        }

        try ( FileInputStream input = new FileInputStream(App.pathImg + "imagenSistema2.png")) {
            Image image = new Image(input, 200, 200, true, false);

            imagen2.setImage(image);

        } catch (IOException ex) {

        }

    }

    @FXML
    private TextField tf_usuario;
    @FXML
    private PasswordField tf_contrasenia;
    @FXML
    private Button btn_ingresar;
    @FXML
    private ImageView imagen1;
    @FXML
    private ImageView imagen2;
    @FXML
    private HBox hbox_advertencia;
    
    
    public static String nombre_ingresado;
    
    
    @FXML
    void ingresar(ActionEvent event) {
        cargarUsuarios(App.pathFiles+"usuarios.txt");
        
        Label advertencia = new Label("Usuario o Contraseña incorrectos. Volver a intentar");
        String usuario_ingresado = tf_usuario.getText();
        String contrasenia_ingresada = tf_contrasenia.getText();

        for (Usuario u : lista_usuarios) {
            if (u.getUsuario().equals(usuario_ingresado) && u.getContrasenia().equals(contrasenia_ingresada)) {
                nombre_ingresado= u.getNombre();
                accesoMenu();

            } else {
                hbox_advertencia.getChildren().clear();
                hbox_advertencia.getChildren().add(advertencia);
                tf_usuario.clear();
                tf_contrasenia.clear();
            }
        }

    }

    public void accesoMenu() {
        try {
            FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("VentanaMenu.fxml"));
            Parent root = fxmlloader.load();
            Scene menu = new Scene(root, 600, 400);
            Stage stage = (Stage) btn_ingresar.getScene().getWindow();
            stage.setScene(menu);

        } catch (IOException ex) {
            System.out.println("Error acceso Menu");
        }
    }

    public static ArrayList<Usuario> lista_usuarios = new ArrayList<>();

    public static void cargarUsuarios(String nombreArchivo) {
        ArrayList<String> lineaUsuarios = ManejoArchivos.LeeFichero(nombreArchivo);

        for (int i = 0; i < lineaUsuarios.size(); i++) {
            String[] datos = lineaUsuarios.get(i).split(";");
            Usuario usu = new Usuario(datos[0], datos[1], datos[2], datos[3], datos[4], datos[5]);
            lista_usuarios.add(usu);
        }
    }

}
