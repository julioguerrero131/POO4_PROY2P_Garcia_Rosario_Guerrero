/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyecto2p_garcia_delrosario_guerrero;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.concurrent.ThreadLocalRandom;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import modelo.Mapa;
import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;

public class MapaController implements Initializable {

    /**
     * ArrayList que guarda todos los locales del archivo locales.txt.
     */
    static ArrayList<Mapa> listaObjetos = new ArrayList<>();

    /**
     * objeto Mapa al que el usuario a seleccionado con un click.
     */
    public static Mapa localSeleccionado;

    /**
     * Pane root Es el contenedor padre de la ventanaMapa
     */
    @FXML
    Pane root;

    /**
     * ImageView imgvmapa se carga la imagen del mapa.
     */
    @FXML
    ImageView mapa;

    /**
     * Initializes the controller class
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listaObjetos = seleccionarLocal();
        agregarLocal();
        try ( FileInputStream input = new FileInputStream(App.pathImg + "mapa2.png")) {
            Image img = new Image(input, 828, 597, false, false);
            mapa = new ImageView(img);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        root.getChildren().add(mapa);
    }

    /**
     * Carga del archivo locales.txt cada local y los convierte en objeto
     *
     * @return
     */
    public static ArrayList<Mapa> seleccionarLocal() {
        try ( BufferedReader bf = new BufferedReader(new FileReader(App.pathFiles + "locales.txt"))) {
            String linea;
            while ((linea = bf.readLine()) != null) {
                String p[] = linea.split(",");
                listaObjetos.add(new Mapa(p[0].trim(), p[1].trim(), p[2].trim(), Float.valueOf(p[3].trim()), Float.valueOf(p[4].trim())));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(listaObjetos);
        return listaObjetos;
    }

    /**
     * Thread para que cada local aparezca cada 1 a 10 segundos en el mapa.
     */
    public void agregarLocal() {
        for (Mapa m : listaObjetos) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        int n = (int) (Math.random() * (10 - 1 + 1) + 1);
                        Thread.sleep(n * 1000);
                    } catch (InterruptedException e) {
                        e.getMessage();
                    }
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            float cx = m.getCoordenadaX();
                            float cy = m.getCoordenadaY();
                            ImageView imgv = new ImageView();
                            try ( FileInputStream input = new FileInputStream(App.pathImg + "imagenUbi.png")) {
                                Image img = new Image(input, 61, 63, false, false);
                                imgv.setImage(img);
                                imgv.setLayoutX(cx);
                                imgv.setLayoutY(cy);
                                root.getChildren().add(imgv);
                                imgv.setFocusTraversable(true);
                                imgv.setOnMouseClicked(new EventHandler<MouseEvent>() {
                                    @Override
                                    public void handle(MouseEvent t) {
                                        localSeleccionado = m;
                                        ventanaPopUp(m, imgv);
                                    }
                                });
                            } catch (IOException ex) {
                            }
                        }
                    });
                }
            });
            t.start();
        }
    }

    /**
     *
     * @param local
     * @param imgv
     * @param x
     * @param y
     */
    
    public void ventanaPopUp(Mapa local, ImageView imgv) {
        Alert alert = new Alert(AlertType.NONE);
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 5; i >= 0; i--) {
                    int contador = i;
                    final String terminar = "La ventana se cerrara en " + i + " segundos";
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                    }
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            alert.setGraphic(null);
                            alert.setContentText("TBG" + " " + local.getNombre() + "\n" + "Local principal" + "\n" + local.getDireccion() + "\n" + terminar);
                            DialogPane dialogPane = alert.getDialogPane();
                            dialogPane.setStyle("-fx-background-color: #f6b347;");
                            ButtonType buttonTypeAceptar = new ButtonType("Aceptar", ButtonBar.ButtonData.OK_DONE);
                            alert.getButtonTypes().setAll(buttonTypeAceptar);
                            alert.initModality(Modality.APPLICATION_MODAL);
                            Optional<ButtonType> result = alert.showAndWait();                          
                        }
                    });
                }
                Platform.runLater(new Runnable(){
                    @Override
                    public void run(){
                        alert.close();
                    }
                });
            }
        });
        t2.start();

    }
}



