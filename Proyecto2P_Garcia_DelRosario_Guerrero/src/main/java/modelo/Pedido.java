/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import com.mycompany.proyecto2p_garcia_delrosario_guerrero.App;
import com.mycompany.proyecto2p_garcia_delrosario_guerrero.ManejoArchivos;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author julio
 */
public class Pedido implements Serializable {

    private String id;
    private Usuario usuario;
    private ArrayList<Menu> menuSelec;
    private String subtotal;
    private String iva;
    private String total;
    private static final long serialVersionUID = 1234L;

    public Pedido(Usuario usuario, ArrayList<Menu> menuSelec, String subtotal, String iva, String total) {
        this.id = generarIdPed();
        this.usuario = usuario;
        this.menuSelec = menuSelec;
        this.subtotal = subtotal;
        this.iva = iva;
        this.total = total;
        crearArchivosPed(this);
    }

    public void crearArchivosPed(Pedido p) {
        
        //archivo pedidos.txt
        String id = p.id;
        String nomU = p.usuario.getNombre();
        String total = p.total;
        String linea = id + "," + nomU + "," + total;
        ManejoArchivos.EscribirArchivo(App.pathFiles+"pedidos.txt", linea);
        
        //string archivo serializado
        try (ObjectOutputStream obj=new ObjectOutputStream(new FileOutputStream(App.pathPed+"pedido"+id+"Pedido.bin"))) {
            obj.writeObject(p);
        } catch (FileNotFoundException ex) {
            
        } catch (IOException ex) {

        }
        
    }
    
    public String generarIdPed() {
        
        String banco = "0123456789";
        String id= "";
        int ind = 0;
        for (int i = 1; i <= 4; i++) {
            ind = (int) (Math.random() * 9 + 1);
            id=id+banco.substring(ind, ind+1);
        }
        return id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public ArrayList<Menu> getMenuSelec() {
        return menuSelec;
    }

    public void setMenuSelec(ArrayList<Menu> menuSelec) {
        this.menuSelec = menuSelec;
    }

    public String getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(String subtotal) {
        this.subtotal = subtotal;
    }

    public String getIva() {
        return iva;
    }

    public void setIva(String iva) {
        this.iva = iva;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
