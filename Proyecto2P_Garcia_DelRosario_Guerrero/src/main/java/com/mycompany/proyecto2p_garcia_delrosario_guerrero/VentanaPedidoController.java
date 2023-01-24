/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyecto2p_garcia_delrosario_guerrero;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import modelo.Usuario;

/**
 * FXML Controller class
 *
 * @author Cliente Intel
 */
public class VentanaPedidoController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }  
    
    
    
    public static ArrayList<Usuario> lista_menu = new ArrayList<>();
    public void cargarmenu(String nombreArchivo){
        ArrayList<String> lineaMenu= ManejoArchivos.LeeFichero(nombreArchivo);
 
        for (int i = 1; i < lineaMenu.size(); i++) {
            String[] datos = lineaMenu.get(i).split(";");
            Usuario usu = new Usuario(datos[0], datos[1], datos[2], datos[3], datos[4], datos[5]);
            lista_menu.add(usu);
        }
        
        
    }
    
//    public static ArrayList<Usuario> lista_usuarios = new ArrayList<>();
//
//    public static void cargarUsuarios(String nombreArchivo) {
//        ArrayList<String> lineaUsuarios = ManejoArchivos.LeeFichero(nombreArchivo);
//
//        for (int i = 0; i < lineaUsuarios.size(); i++) {
//            String[] datos = lineaUsuarios.get(i).split(";");
//            Usuario usu = new Usuario(datos[0], datos[1], datos[2], datos[3], datos[4], datos[5]);
//            lista_usuarios.add(usu);
//        }
    }    
    
    
    
    
    
    
    
    
    
    

