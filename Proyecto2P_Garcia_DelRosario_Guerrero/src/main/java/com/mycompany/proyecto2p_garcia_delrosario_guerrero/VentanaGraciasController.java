/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyecto2p_garcia_delrosario_guerrero;

import static com.mycompany.proyecto2p_garcia_delrosario_guerrero.VentanaPedidoController.totalPedido;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Cliente Intel
 */
public class VentanaGraciasController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Label lbl_id;

    @FXML
    private ImageView imgv_imagen;
    
    @FXML
    private VBox vb_cerrando;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String texto = "Su pedido Nro. " + totalPedido.getId() + " ha sido pagado y ahora empezaremos a prepararlo.";
        lbl_id.setText(texto);
        try ( FileInputStream input = new FileInputStream(App.pathImg + "imagen_gracias.png")) {
            Image img = new Image(input, 200, 200, false, false);
            imgv_imagen.setImage(img);

        } catch (IOException ex) {
        }
        cerrar();
    }
    
    int i;
    int contador;
    void cerrar(){
        Label lbl_cerrando = new Label(" ");
        vb_cerrando.getChildren().add(lbl_cerrando);
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
                                lbl_cerrando.setText("Cerrando en... " + i + " segundos");
                                if (contador == 0) {
                                    Platform.exit();
                                }
                            }
                        });
                    }
                }
            });
            t2.start();
    }
}
