///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
// */
//package com.mycompany.proyecto2p_garcia_delrosario_guerrero;
////fx:controller="com.mycompany.proyecto2p_garcia_delrosario_guerrero.VentanaMapaController"
//
//import java.io.BufferedReader;
//import java.io.FileInputStream;
//import java.io.FileReader;
//import java.io.IOException;
//import java.net.URL;
//import java.nio.charset.StandardCharsets;
//import java.util.ArrayList;
//import java.util.Optional;
//import java.util.ResourceBundle;
//import javafx.application.Platform;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.fxml.Initializable;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.Alert;
//import javafx.scene.control.Alert.AlertType;
//import javafx.scene.control.ButtonBar;
//import javafx.scene.control.ButtonType;
//import javafx.scene.control.DialogPane;
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
//import javafx.scene.layout.Pane;
//import javafx.stage.Modality;
//import javafx.stage.Stage;
//import modelo.Mapa;
//
///**
// * FXML Controller class
// *
// * @author Cliente Control
// */
//public class VentanaMapaController implements Initializable {
//
//    /**
//     * ArrayList que guarda todos los locales del archivo locales.txt.
//     */
//    private static ArrayList<Mapa> locales = new ArrayList();
//    /**
//     * objeto Mapa al que el usuario a seleccionado con un click.
//     */
//    public static Mapa localSelec;
//
//    /**
//     * Pane root Es el contenedor padre de la ventanaMapa
//     */
//    @FXML
//    private Pane root;
//    
//    /**
//     * ImageView imgvmapa se carga la imagen del mapa.
//     */
//    @FXML
//    private ImageView imgvmapa;
//
//    /**
//     * Initializes the controller class.
//     * @param url
//     * @param rb
//     */
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//        // TODO
//        cargarMapa();
//        seleccionarLocal();
//        agregarWings();
//    }
//
//    /**
//     * @see mapa Carga el mapa del sector.
//     */
//    public void cargarMapa() {
//        try ( FileInputStream input = new FileInputStream(App.pathImg + "mapa2.png")) {
//            Image img = new Image(input, 700, 473, false, false);
//            imgvmapa.setImage(img);
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//    }
//
//    
//    /**
//     * carga del archivo locales.txt cada local y los convierte en objeto
//     */
//    public static void seleccionarLocal() {
//        ArrayList<Mapa> listaObjetos = new ArrayList<>();
//        try ( BufferedReader bf = new BufferedReader(new FileReader(App.pathFiles + "locales.txt", StandardCharsets.UTF_8))) {
//            String linea;
//            while ((linea = bf.readLine()) != null) {
//                String p[] = linea.split(",");
//                listaObjetos.add(new Mapa(p[0].trim(), p[1].trim(), p[2].trim(), Float.valueOf(p[3].trim()), Float.valueOf(p[4].trim())));
//            }
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
//        locales = listaObjetos;
//    }
//
//    /**
//     * 
//     * @param l recibe el local para ubicarlo dentro del mapa. 
//     */
//    public void crearWing(Mapa l) {
//
//        float cx = l.getCoordenadaX();
//        float cy = l.getCoordenadaY();
//        ImageView imgv = new ImageView();
//        try ( FileInputStream input = new FileInputStream(App.pathImg + "wing.png")) {
//            Image img = new Image(input, 50, 50, false, false);
//            imgv.setImage(img);
//            imgv.setLayoutX(cx);
//            imgv.setLayoutY(cy);
//            root.getChildren().add(imgv);
//            imgv.setFocusTraversable(true);
//            imgv.setOnMouseClicked(e -> {
//                localSelec = l;
//                ventanaPopUp(l, imgv); //alert*******
//                //abrirDetalles(); //ventana********
//            });
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//
//    }
//
//    /**
//     * Thread para que cada local aparezca cada 1 a 10 segundos en el mapa.
//     */
//    public void agregarWings() {
//        for (Mapa l : locales) {
//            Thread t = new Thread(new Runnable() {
//
//                @Override
//                public void run() {
//                    try {
//                        int n = (int) (Math.random() * (10 - 1 + 1) + 1);
//                        Thread.sleep(n * 1000);
//                    } catch (InterruptedException ie) {
//                        ie.printStackTrace();
//                    }
//
//                    Platform.runLater(new Runnable() {
//                        @Override
//                        public void run() {
//                            crearWing(l);
//                        }
//                    });
//
//                }
//            });
//            t.start();
//        }
//    }
//    
//     /**
//     * @see VentanaInfoLocal
//     */
//    public void abrirDetalles() {
//        try {
//            FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("VentanaInfoLocal.fxml"));
//            Parent root = fxmlloader.load();
//            Scene info = new Scene(root);
//            Stage secondStage = new Stage();
//            secondStage.setScene(info);
//            secondStage.show();
//
//        } catch (IOException ex) {
//            System.out.println("Error ingresar_info");
//        }
//    }
//    //metodo popup
//
//    /**
//     *
//     * @param local
//     * @param imgv
//     */
//    public void ventanaPopUp(Mapa local, ImageView imgv) {
//
//        Alert alert = new Alert(AlertType.NONE);
//
//        Thread t2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 5; i >= 0; i--) {
//                    int contador = i;
//                    final String finish = "La ventana se cerrara en " + i + " segundos";
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException ex) {
//                        ex.printStackTrace();
//                    }
//                    Platform.runLater(new Runnable() {
//                        @Override
//                        public void run() {
//
//                            alert.setGraphic(null);
//                            alert.setContentText("TBG" + " " + local.getNombre() + "\n" + "Local principal" + "\n" + local.getDireccion() + "\n" + finish);
//                            DialogPane dialogPane = alert.getDialogPane();
//                            dialogPane.setStyle("-fx-background-color: #f6b347;");
//                            ButtonType buttonTypeAceptar = new ButtonType("Aceptar", ButtonBar.ButtonData.OK_DONE);
//                            alert.getButtonTypes().setAll(buttonTypeAceptar);
//                            alert.initModality(Modality.APPLICATION_MODAL);
//                            Optional<ButtonType> result = alert.showAndWait();
//                        }
//                    });
//                }
//                Platform.runLater(new Runnable(){
//                    @Override
//                    public void run(){
//                        alert.close();
//                    }
//                });
//                
//            }
//        });
//        
//        
//        t2.start();
//        
//    }

//    public void ventanaPopUp(Mapa local, ImageView imgv) {
//            System.out.println(local.getCoordenadaX());
//            Alert alert = new Alert(AlertType.NONE);
//            alert.setGraphic(null);
//            alert.setContentText("TBG" + " " + local.getNombre() + "\n" + "Local principal" + "\n" + local.getDireccion());
//            DialogPane dialogPane = alert.getDialogPane();
//            dialogPane.setStyle("-fx-background-color: #f6b347;");
//            ButtonType buttonTypeAceptar = new ButtonType("Aceptar", ButtonBar.ButtonData.OK_DONE);
//            alert.getButtonTypes().setAll(buttonTypeAceptar);
//            alert.initModality(Modality.APPLICATION_MODAL);
//            Optional<ButtonType> result = alert.showAndWait();
//            Thread t2 = new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    for (int i = 5; i >= 0; i--) {
//                        int contador = i;
//                        String finish = "La ventana se cerrara en " + i + " segundos";
//                        try {
//                            Thread.sleep(1000);
//                        } catch (InterruptedException ex) {
//                        }
//                        Platform.runLater(new Runnable() {
//                            @Override
//                            public void run() {
//                                alert.setContentText(finish);
//                                if (contador == 0) {
//                                    alert.close();
//                                }
//                            }
//                        });
//                    }
//                }
//            });
//            t2.start();
//        }
//}