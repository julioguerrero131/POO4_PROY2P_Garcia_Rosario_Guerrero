/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyecto2p_garcia_delrosario_guerrero;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import modelo.Menu;
import modelo.Tipo;
import modelo.Usuario;

/**
 * FXML Controller class
 *
 * @author Cliente Intel
 */
public class VentanaPedidoController implements Initializable {
    
    public static ArrayList<Menu> lista_menu = new ArrayList<>();
    
    @FXML
    private ComboBox<?> cb_tipo;
    @FXML
    private ComboBox<?> cb_ordenar;
    @FXML
    private VBox tabla_opciones;
    @FXML
    private TableView<?> tabla_pedidos;
    @FXML
    private Label subtotal;
    @FXML
    private Label iva;
    @FXML
    private Label total;
    @FXML
    private Button btn_continuar;
    @FXML
    private Button btn_limpiar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        cargarmenu(App.pathFiles+"menu.txt");
        
    }  
    
    public void cargarmenu(String nombreArchivo){
        ArrayList<String> lineaMenu= ManejoArchivos.LeeFichero(nombreArchivo);
 
        for (int i = 1; i < lineaMenu.size(); i++) {
            String[] datos = lineaMenu.get(i).split(",");
            Menu menu = new Menu(datos[0], Double.parseDouble(datos[1]), Tipo.valueOf(datos[2]));
            lista_menu.add(menu);
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
    
    
    
    
    
    
    
    
    
    

