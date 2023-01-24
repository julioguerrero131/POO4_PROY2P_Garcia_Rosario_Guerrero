/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Cliente Intel
 */
public class Menu {
    private String descripcion;
    private double precio;
    private Tipo tipo;

    public Menu(String descripcion, double precio, Tipo tipo) {
        this.descripcion = descripcion;
        this.precio = precio;
        this.tipo = tipo;
    }
    

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
    public String toString() {
        return "Menu{" + "descripcion=" + descripcion + ", precio=" + precio + ", tipo=" + tipo + '}';
    }

}
