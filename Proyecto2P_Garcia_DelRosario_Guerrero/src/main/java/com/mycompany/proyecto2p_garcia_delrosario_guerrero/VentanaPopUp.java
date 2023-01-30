/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto2p_garcia_delrosario_guerrero;

//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.stage.Modality;
//import javafx.scene.layout.Background;
//import javafx.scene.layout.BackgroundFill;
//import javafx.scene.layout.CornerRadii;

public class VentanaPopUp {

    public static void main(String[] args) {
//        JFrame jFrame = new JFrame();
//
//        JDialog jd = new JDialog(jFrame);
//        jd.setStyle("-fx-background-color: red;");
//        jd.setLayout(new FlowLayout());
//
//        jd.setBounds(500, 300, 400, 300);
//
//        JLabel jLabel = new JLabel("Press close button to close the dialog.");
//        
//        JButton jButton = new JButton("Close");
//        jButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                jd.setVisible(false);
//            }
//        });
//
//        jd.add(jLabel);
//        jd.add(jButton);
//        jd.setVisible(true);

        
    Alert alert = new Alert(AlertType.CONFIRMATION);
alert.setTitle("Confirmación");
alert.setHeaderText("¿Estás seguro de que deseas continuar?");
DialogPane dialogPane = alert.getDialogPane();
dialogPane.setStyle("-fx-background-color: #F8D1CC;");
ButtonType buttonTypeAceptar = new ButtonType("Aceptar", ButtonData.OK_DONE);
ButtonType buttonTypeCancel = new ButtonType("Cancelar", ButtonData.CANCEL_CLOSE);
alert.getButtonTypes().setAll(buttonTypeAceptar, buttonTypeCancel);
alert.initModality(Modality.APPLICATION_MODAL);
Optional<ButtonType> result = alert.showAndWait();
if (result.get() == buttonTypeAceptar){
    // Acción a realizar si el usuario presiona el botón Aceptar
} else if (result.get() == buttonTypeCancel) {
    // Acción a realizar si el usuario presiona el botón Cancelar
}

}
}
