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

    ArrayList<Mapa> p = new ArrayList<>();
    private ImageView imgv;
    private double x;
    private double y;
    public static Mapa local;

    @FXML
    Pane root;

    @FXML
    ImageView mapa;

    /**
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        p = seleccionarLocal();
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
     *
     */
    public void agregarLocal() {
        root.getChildren().clear();
        imgv = null;
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (Mapa m : p) {
                    int n = (int) (Math.random() * 10 + 1);
                    try {
                        Thread.sleep(1 * 1000);
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            try ( FileInputStream input = new FileInputStream(App.pathImg + "imagenUbi.png")) {
                                Image img = new Image(input, 61, 63, false, false);
                                imgv = new ImageView(img);
                                imgv.setLayoutX(m.getCoordenadaX());
                                imgv.setLayoutY(m.getCoordenadaY());
                            } catch (IOException ex) {
                            }
                            root.getChildren().add(imgv);
                            imgv.setFocusTraversable(true);
                            imgv.setOnMouseClicked(new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent t) {
                                    local = m;
                                    x = imgv.getLayoutX();
                                    y = imgv.getLayoutY();
                                    ventanaPopUp(local, imgv, x, y);
                                }
                            });
                        }
                    });
                }
            }

        });
        t.start();
    }

    //Cambiar el event hablder a otro lado y hacer listas con los image view
//    @FXML
//    void mostrarPopUP(MouseEvent event) {
//       ventanaPopUp();
//        
//    }
//    public static int Segundos() {
//        new Thread(()->{
//            for(int= 5; i>=0;i--){
//            final int seg = i;
//            Platform.runLater(()-> label.setText("Mostrando" + seg + "segundos..."));
//            
//        }
//        }
//    }
//    public static int numeroAleatorioEnRango(int minimo, int maximo) {
//        minimo = 0;
//        maximo = 13;
//        return ThreadLocalRandom.current().nextInt(minimo, maximo + 1);
//    }
    /**
     *
     * @return
     */
    public static ArrayList<Mapa> seleccionarLocal() {
        ArrayList<Mapa> listaObjetos = new ArrayList<>();
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
     *
     * @param local
     * @param imgv
     * @param x
     * @param y
     */
    int i;
    int contador;
    String finish;
    public void ventanaPopUp(Mapa local, ImageView imgv, double x, double y) {
        if (local.getCoordenadaX() == x && local.getCoordenadaY() == y) {
            System.out.println(local.getCoordenadaX());
            System.out.println(x);
            Alert alert = new Alert(AlertType.NONE);
            alert.setGraphic(null);
            alert.setContentText("TBG" + " " + local.getNombre() + "\n" + "Local principal" + "\n" + local.getDireccion());
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.setStyle("-fx-background-color: #f6b347;");
            ButtonType buttonTypeAceptar = new ButtonType("Aceptar", ButtonBar.ButtonData.OK_DONE);
            alert.getButtonTypes().setAll(buttonTypeAceptar);
            alert.initModality(Modality.APPLICATION_MODAL);
            Optional<ButtonType> result = alert.showAndWait();
            Thread t2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (i = 5; i >= 0; i--) {
                        contador = i;
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                        }
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                finish = "La ventana se cerrara en " + i + " segundos";
                                alert.setContentText(finish);
                                if (contador == 0) {
                                    alert.close();
                                }
                            }
                        });
                    }
                }
            });
            t2.start();
        }
    }
}



//    static ImageView im = null;
//    public static void agregarLocal() {
//        root.getChildren().clear();
//        System.out.println("a");
//        ArrayList<Mapa> listaLocales = seleccionarLocal();
//        Thread t = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (Mapa m : listaLocales) {
//                    int n = (int) (Math.random() * 10 + 1);
//                    try {
//                            Thread.sleep(n*1000);
//                        } catch (InterruptedException e) {
//                            System.out.println(e.getMessage());
//                        }
//                    Platform.runLater(new Runnable() {
//
//                        @Override
//                        public void run() {
//                            try ( FileInputStream input = new FileInputStream(App.pathImg + "imagenUbi.png")) {
//                                Image image = new Image(input);
//                                im = new ImageView(image);
//                                im.setLayoutX(m.getCoordenadaX());
//                                im.setLayoutY(m.getCoordenadaY());
//                            } catch (IOException e) {
//                                System.out.println("error1"); 
//                            }
//                            root.getChildren().add(im);
//                        }
//                    });
//                }
//            }
//        });        
//        t.start ();
//        }
//    }
//    public static void ventanaPopUp() {
//        Mapa localSeleccionado = seleccionarLocal();
//
//        Alert alert = new Alert(AlertType.NONE);
//
//        alert.setGraphic(null);
//        alert.setContentText("TBG" + localSeleccionado.getNombre());
//        alert.setContentText("Local Principal");
//        alert.setContentText(localSeleccionado.getDireccion());
//        DialogPane dialogPane = alert.getDialogPane();
//
//        dialogPane.setStyle("-fx-background-color: #f6b347;");
//        ButtonType buttonTypeAceptar = new ButtonType("Aceptar", ButtonBar.ButtonData.OK_DONE);
//
//        alert.getButtonTypes()
//                .setAll(buttonTypeAceptar);
//        alert.initModality(Modality.APPLICATION_MODAL);
//        Optional<ButtonType> result = alert.showAndWait();
//
//        if (result.get()
//                == buttonTypeAceptar) {
//            // Acción a realizar si el usuario presiona el botón Aceptar
//        }
//}
//
//    }
//    void mostarPopUp(MouseEvent event) {
//        ImageView imagenSeleccionada = agregarLocal();
//        imagenSeleccionada.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent t) {
//                throw new UnsupportedOperationException("Not supported yet.");
//            }
//
//        });
//        Label l2 = new Label("Mas informacion");
//        root.getChildren().addAll(l2);
//
//    }

