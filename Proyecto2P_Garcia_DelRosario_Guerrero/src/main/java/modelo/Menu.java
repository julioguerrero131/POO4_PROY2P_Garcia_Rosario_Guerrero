/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Cliente Intel
 */
public class Menu implements Serializable{

    public SimpleStringProperty descripcion = new SimpleStringProperty();
    private double precio;
    private Tipo tipo;
    public SimpleIntegerProperty cantidad = new SimpleIntegerProperty();
    public SimpleDoubleProperty preciototal = new SimpleDoubleProperty();

    public Menu(String descripcion, double precio, Tipo tipo) {
        this.descripcion = new SimpleStringProperty(descripcion);
        this.precio = precio;
        this.tipo = tipo;
        cantidad = new SimpleIntegerProperty(0);
        preciototal = new SimpleDoubleProperty(0);
    }

//    @Override
//    public int compareTo(Menu m) {
//        int resultado = 0;
//        if (this.edad < o.edad) {
//            resultado = -1;
//        } else if (this.edad > o.edad) {
//            resultado = 1;
//        } else {
//            if (this.dni < o.dni) {
//                resultado = -1;
//            } else if (this.dni > o.dni) {
//                resultado = 1;
//            } else {
//                resultado = 0;
//            }
//        }
//        return resultado;
//    }

    public int getCantidad() {
        return cantidad.get();
    }

    public void setCantidad(int cantidad) {
        this.cantidad = new SimpleIntegerProperty(cantidad);
    }

    public double getPreciototal() {
        return preciototal.get();
    }

    public void setPreciototal(double preciototal) {
        this.preciototal = new SimpleDoubleProperty(preciototal);
    }

    public String getDescripcion() {
        return descripcion.get();
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = new SimpleStringProperty(descripcion);
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object o) {

        try {
            Menu menu = (Menu) o;
            if (o == null) {
                return false;
            } else if (this == o) {
                return true;
            } else if (this.getDescripcion().equals(menu.getDescripcion())) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }

        return false;

    }

    @Override
    public String toString() {
        return "Menu{" + "descripcion=" + descripcion + ", precio=" + precio + ", tipo=" + tipo + '}';
    }

}
