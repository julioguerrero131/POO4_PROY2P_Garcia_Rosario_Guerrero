/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package modelo;

/**
 *
 * @author julio
 */
public class ValorInsuficienteException extends Exception {

    /**
     * Creates a new instance of <code>ValorInsuficienteException</code> without
     * detail message.
     */
    public ValorInsuficienteException() {
    }

    /**
     * Constructs an instance of <code>ValorInsuficienteException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public ValorInsuficienteException(String msg) {
        super(msg);
    }
}
