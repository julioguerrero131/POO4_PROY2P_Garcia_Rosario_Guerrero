/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;

/**
 *
 * @author Cliente Intel
 */
public class Usuario implements Serializable {
    private String usuario;
    private String contrasenia;
    private String nombre;
    private String numero_tarjeta;
    private String caducidad;
    private String cvv;

    public Usuario(String usuario, String contrasenia, String nombre, String numero_tarjeta, String caducidad, String cvv) {
        this.usuario = usuario;
        this.contrasenia = contrasenia;
       
        this.nombre = nombre;
        this.numero_tarjeta = numero_tarjeta;
        this.caducidad = caducidad;
        this.cvv = cvv;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContraseña(String contraseña) {
        this.contrasenia = contraseña;
    }

 

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumero_tarjeta() {
        return numero_tarjeta;
    }

    public void setNumero_tarjeta(String numero_tarjeta) {
        this.numero_tarjeta = numero_tarjeta;
    }

    public String getCaducidad() {
        return caducidad;
    }

    public void setCaducidad(String caducidad) {
        this.caducidad = caducidad;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    @Override
    public String toString() {
        return "Usuario{" + "usuario=" + usuario + ", contrase\u00f1a=" + contrasenia + ", nombre=" + nombre + ", numero_tarjeta=" + numero_tarjeta + ", caducidad=" + caducidad + ", cvv=" + cvv + '}';
    }
    
}
