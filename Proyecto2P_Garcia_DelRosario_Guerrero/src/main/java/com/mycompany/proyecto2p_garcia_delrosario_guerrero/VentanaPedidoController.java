/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyecto2p_garcia_delrosario_guerrero;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modelo.Menu;
import modelo.Orden;
import modelo.Pedido;
import modelo.Tipo;
import modelo.Usuario;
import modelo.ValorInsuficienteException;

/**
 * FXML Controller class
 *
 * @author Cliente Intel
 */
public class VentanaPedidoController implements Initializable {

    public static ArrayList<Menu> lista_menu = new ArrayList<>();
    private Tipo tipoSelec;
    private ObservableList<Menu> listaPedido;
    private Orden ordenSelec;
    private ArrayList<Menu> menuFilt = new ArrayList();
    public static Pedido totalPedido;

    @FXML
    private ComboBox<String> cb_tipo;
    @FXML
    private ComboBox<String> cb_ordenar;
    @FXML
    private TableView<Menu> tabla_pedidos;
    @FXML
    private VBox vbdesc;
    @FXML
    private VBox vbprecio;
    @FXML
    private VBox vbcant;
    @FXML
    private VBox vbbtnagregar;
    @FXML
    private TableColumn tcdesc;
    @FXML
    private TableColumn tcant;
    @FXML
    private TableColumn tcvalor;
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

        cargarMenu(App.pathFiles + "menu.txt");
        cargarCombos();
        inicializarTabla();
        cb_tipo.setOnAction(e -> selecTipo());
        cb_ordenar.setOnAction(e -> selecOrden());
        btn_limpiar.setOnAction(e -> limpiar());
        btn_continuar.setOnAction(e -> continuar());
        

    }

    public void cargarMenu(String nombreArchivo) {

        ArrayList<String> lineaMenu = ManejoArchivos.LeeFichero(nombreArchivo);

        for (int i = 1; i < lineaMenu.size(); i++) {
            String[] datos = lineaMenu.get(i).split(",");
            Menu menu = new Menu(datos[0], Double.parseDouble(datos[1]), Tipo.valueOf(datos[2]));
            lista_menu.add(menu);
        }

    }

    public void cargarCombos() {

        ObservableList<String> items1 = FXCollections.observableArrayList();
        items1.addAll("Plato Fuerte", "Postre", "Bebida", "Piqueo");
        cb_tipo.setItems(items1);

        ObservableList<String> items2 = FXCollections.observableArrayList();
        items2.addAll("Precio", "Nombre");
        cb_ordenar.setItems(items2);

    }

    public void selecTipo() {
        String tipoS = cb_tipo.getValue();
        if (tipoS.equals("Plato Fuerte")) {
            tipoSelec = Tipo.F;
        } else if (tipoS.equals("Postre")) {
            tipoSelec = Tipo.P;
        } else if (tipoS.equals("Bebida")) {
            tipoSelec = Tipo.B;
        } else if (tipoS.equals("Piqueo")) {
            tipoSelec = Tipo.Q;
        }
        ArrayList<Menu> menuf = filtroTipo();
        try {
            llenarOpciones(menuf);
            menuFilt = menuf;
        } catch (ValorInsuficienteException ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<Menu> filtroTipo() {

        ArrayList<Menu> menuFilt = new ArrayList();
        for (Menu m : lista_menu) {
            if (m.getTipo() == tipoSelec) {
                menuFilt.add(m);
            }
        }
        return menuFilt;
    }

    public void selecOrden() {

        String ordenS = cb_ordenar.getValue();
        if (ordenS.equals("Precio")) {
            ordenSelec = Orden.P;

        } else if (ordenS.equals("Nombre")) {
            ordenSelec = Orden.N;
        }
        if (tipoSelec != null) {
            filtroOrden();
            try {
                llenarOpciones(menuFilt);
            } catch (ValorInsuficienteException vie) {
                vie.printStackTrace();
            } 
        }

    }

    public void filtroOrden() {
        ArrayList<Menu> menuOrd = new ArrayList();
        if (ordenSelec == Orden.N) {
            Collections.sort(menuFilt, new Comparator<Menu>() {
                public int compare(Menu m1, Menu m2) {
                    return m1.getDescripcion().compareTo(m2.getDescripcion());
                }
            });
        } else if (ordenSelec == Orden.P) {
            Collections.sort(menuFilt, new Comparator<Menu>() {
                public int compare(Menu m1, Menu m2) {
                    return Double.compare(m1.getPrecio(), m2.getPrecio());
                }
            });
        }

    }

    public void llenarOpciones(ArrayList<Menu> listaM) throws ValorInsuficienteException {

        //limpiar
        vbdesc.getChildren().clear();
        vbprecio.getChildren().clear();
        vbcant.getChildren().clear();
        vbbtnagregar.getChildren().clear();

        for (Menu m : listaM) {

            Label lbldes = new Label(m.getDescripcion());
            Label lblprecio = new Label(String.format("%.2f", m.getPrecio()));
            TextField txtcant = new TextField();
            Button btagregar = new Button("Agregar");

            vbdesc.getChildren().add(lbldes);
            vbdesc.setSpacing(15);
            vbprecio.getChildren().add(lblprecio);
            vbprecio.setSpacing(15);
            vbcant.getChildren().add(txtcant);
            vbcant.setSpacing(5);
            vbbtnagregar.getChildren().add(btagregar);
            vbbtnagregar.setSpacing(5);

            btagregar.setOnAction(e -> {

                String cantS = txtcant.getText();
                try {
                    validarCantidad(cantS);
                    int cant = Integer.valueOf(cantS);
                    m.setCantidad(cant + m.getCantidad());
                    m.setPreciototal((m.getCantidad() * m.getPrecio()));
                    if (listaPedido.contains(m)) {
                        tabla_pedidos.refresh();
                        actualizarTotal();
                    } else {
                        listaPedido.add(m);
                        actualizarTotal();
                    }

                } catch (ValorInsuficienteException ex) {
                    ex.printStackTrace();
                }

            });

        }

    }

    public void validarCantidad(String cant) throws ValorInsuficienteException {

        try {
            int c = Integer.valueOf(cant);
            if (c == 0) {
                throw new ValorInsuficienteException("Ingresar una cantidad válida");
            }
        } catch (Exception e) {
            throw new ValorInsuficienteException("Ingresar una cantidad válida");
        }

    }

    public void inicializarTabla() {

        tcdesc.setCellValueFactory(new PropertyValueFactory<Menu, String>("descripcion"));
        tcant.setCellValueFactory(new PropertyValueFactory<Menu, Integer>("cantidad"));
        tcvalor.setCellValueFactory(new PropertyValueFactory<Menu, Double>("preciototal"));

        listaPedido = FXCollections.observableArrayList();
        tabla_pedidos.setItems(listaPedido);

    }

    public void actualizarTotal() {

        double subt = 0;
        for (Menu m : listaPedido) {
            subt = subt + m.getPreciototal();
        }
        double iv = subt * 0.12;
        subtotal.setText(String.format("%.2f", subt));
        iva.setText(String.format("%.2f", iv));
        total.setText(String.format("%.2f", subt + iv));

    }
    
    public void limpiar() {       
        subtotal.setText("0.00");
        iva.setText("0.00");
        total.setText("0.00");
        
        for (Menu m:listaPedido) {
            m.setCantidad(0);
            m.setPreciototal(0);
        }
        listaPedido.clear();
        tabla_pedidos.refresh();
        
    }
    
    @FXML
    public void continuar() {
        Usuario usuario = VentanaSistemaController.userSesion;
        String s = subtotal.getText();
        String i = iva.getText();
        String t = total.getText(); 
        ArrayList<Menu> listaP = new ArrayList(listaPedido);
        Pedido pedido = new Pedido(usuario,listaP,s,i,t);
        totalPedido = pedido;
        ingresarDireccion();
    }
    
    public void ingresarDireccion(){
         try {
            FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("VentanaDireccion.fxml"));
            Parent origen = fxmlloader.load();
            Scene menu = new Scene(origen);
            Stage stage = (Stage) btn_continuar.getScene().getWindow();
            stage.setScene(menu);
            stage.show();

        } catch (IOException ex) {
            System.out.println("Error acceso Menu");
            ex.printStackTrace();
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
