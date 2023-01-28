/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyecto2p_garcia_delrosario_guerrero;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Cliente Intel
 */
public class VentanaDireccionController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private TextField tf_direccion;
    @FXML
    private RadioButton rb_efectivo;
    @FXML
    private RadioButton rb_tarjeta;
    @FXML
    private VBox datos;
    @FXML
    private Button btn_continuar;
    @FXML
    private Button btn_limpiar;
    @FXML
    private ToggleGroup detalles;

    @FXML
    void efectivo(ActionEvent event) {
        datos.getChildren().clear();
        Label mensaje = new Label("Tendrá que pagar un total de" + "");
        Label mensaje2 = new Label("Asegurese de tener el dinero completo por si el repartidor no tiene cambio");
        datos.getChildren().addAll(mensaje, mensaje2);
    }

    TextField campo_t = new TextField();
    TextField campo_n = new TextField();
    TextField campo_c = new TextField();
    TextField campo_cv = new TextField();

    @FXML
    void tarjeta(ActionEvent event) {

        datos.getChildren().clear();

        Label titular = new Label("Titular: ");
        Label numero = new Label("Número: ");
        Label caducidad = new Label("Caducidad: ");
        Label cvv = new Label("CVV: ");

        campo_t.setPrefWidth(274);
        campo_n.setPrefWidth(274);
        campo_c.setPrefWidth(274);
        campo_cv.setPrefWidth(274);

        HBox seccion1 = new HBox();
        HBox seccion2 = new HBox();
        HBox seccion3 = new HBox();
        HBox seccion4 = new HBox();

        seccion1.setAlignment(Pos.CENTER);
        seccion1.setSpacing(30);
        seccion1.setPrefHeight(40);

        seccion2.setAlignment(Pos.CENTER);
        seccion2.setSpacing(30);
        seccion2.setPrefHeight(40);

        seccion3.setAlignment(Pos.CENTER);
        seccion3.setSpacing(17);
        seccion3.setPrefHeight(40);

        seccion4.setAlignment(Pos.CENTER);
        seccion4.setSpacing(47);
        seccion4.setPrefHeight(40);

        seccion1.getChildren().addAll(titular, campo_t);
        seccion2.getChildren().addAll(numero, campo_n);
        seccion3.getChildren().addAll(caducidad, campo_c);
        seccion4.getChildren().addAll(cvv, campo_cv);

        datos.getChildren().addAll(seccion1, seccion2, seccion3, seccion4);
    }

    @FXML
    void ingresarGracias(ActionEvent event) { 
        datos.getChildren().clear();
        if(tf_direccion.getText().equals(" ")){
            datos.getChildren().clear();
            Label advertencia= new Label("Llene todos los datos solicitados. Vuelva a intentar");
            datos.getChildren().add(advertencia);
        }else if(campo_t.getText().equals("") && campo_n.getText().equals("") && campo_c.getText().equals("") && campo_cv.getText().equals("")){
            Label advertencia= new Label("Llene todos los datos solicitados. Vuelva a intentar");
            datos.getChildren().add(advertencia);
        }else{
            accesoGracias();
        }
    }

    @FXML
    void limpiar(ActionEvent event) {

        RadioButton elegido = (RadioButton) detalles.getSelectedToggle();

        if (elegido.getText().equals("Efectivo")) {
            tf_direccion.clear();
            rb_efectivo.setSelected(false);
        } else {
            rb_tarjeta.setSelected(false);
            tf_direccion.clear();
            campo_t.clear();
            campo_n.clear();
            campo_c.clear();
            campo_cv.clear();
        }
    }

    public void accesoGracias() {
        try {
            FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("VentanaGracias.fxml"));
            Parent root = fxmlloader.load();
            Scene menu = new Scene(root, 600, 400);
            Stage stage = (Stage) btn_continuar.getScene().getWindow();
            stage.setScene(menu);

        } catch (IOException ex) {
            System.out.println("Error acceso Menu");
        }
    }

}
