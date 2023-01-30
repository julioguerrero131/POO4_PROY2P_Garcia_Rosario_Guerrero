/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyecto2p_garcia_delrosario_guerrero;

import static com.mycompany.proyecto2p_garcia_delrosario_guerrero.VentanaSistemaController.lista_usuarios;
import static com.mycompany.proyecto2p_garcia_delrosario_guerrero.VentanaSistemaController.nombre_ingresado;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Cliente Intel
 */
public class VentanaMenuController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Label nombre= new Label("Bienvenid@" + " " +nombre_ingresado);
        nombre.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        nombre.setStyle("-fx-text-fill:#ff9706");
        hb_bienvenido.getChildren().add(nombre);
        
        try ( FileInputStream input = new FileInputStream(App.pathImg + "imagenMenu.png")) {
            Image image = new Image(input, 400, 400, false, false);
            viewMenu.setImage(image);
            Rectangle2D viewreport= new Rectangle2D(-1200,-1000, viewMenu.getImage().getWidth()+800, viewMenu.getImage().getHeight()+800);

        } catch (IOException ex) {

        }
    }

    @FXML
    private ImageView viewMenu;
    @FXML
    private HBox hb_bienvenido;
    @FXML
    private Button btn_cercano;
    @FXML
    private Button btn_pedido;
    
    @FXML
    void pedido(ActionEvent event){
        
        ingresar_pedido();
    }
    
    @FXML
    void cercano(ActionEvent event){
        
        accesoMapa();
    }
 
    public void ingresar_pedido() {
        try {
            FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("VentanaPedido.fxml"));
            Parent root = fxmlloader.load();
            Scene menu = new Scene(root);
            Stage stage = (Stage) btn_pedido.getScene().getWindow();
            stage.setScene(menu);
            stage.show();

        } catch (IOException ex) {
            System.out.println("Error ingresar pedido");
        }

    }
    
    public void accesoMapa() {
        try {
            FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("Mapa.fxml"));
            Parent origen = fxmlloader.load();
            Scene menu = new Scene(origen);
            Stage stage = (Stage) btn_cercano.getScene().getWindow();
            stage.setScene(menu);
            stage.show();

        } catch (IOException ex) {
            System.out.println("Error acceso Menu");
            ex.printStackTrace();
        }
    }
    
    

}
