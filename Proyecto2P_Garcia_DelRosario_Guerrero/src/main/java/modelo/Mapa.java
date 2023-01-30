/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

public class Mapa {
    private String nombre;
    private String direccion;
    private String horario;
    private float coordenadaX;
    private float coordenadaY;
    
    
    public Mapa(String nombre, String direccion,String horario, float coordenadaX, float coordenadaY){
        this.nombre = nombre;
        this.direccion = direccion;
        this.horario = horario;
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public float getCoordenadaX() {
        return coordenadaX;
    }

    public void setCoordenadaX(int coordenadaX) {
        this.coordenadaX = coordenadaX;
    }

    public float getCoordenadaY() {
        return coordenadaY;
    }

    public void setCoordenadaY(int coordenadaY) {
        this.coordenadaY = coordenadaY;
    }

    @Override
    public String toString() {
        return "Mapa{" + "nombre=" + nombre + ", direccion=" + direccion + ", horario=" + horario + ", coordenadaX=" + coordenadaX + ", coordenadaY=" + coordenadaY + '}';
    }
    
    

    
    
    
}
