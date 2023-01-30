/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto2p_garcia_delrosario_guerrero;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 *
 * @author Cliente Intel
 */

    /**
     * Este metodo retorna un ArrayList de elementos tipo String
     * @param nombrearchivo String necesario para generar la lista
     * @return ArrayList de la lectura de los Strings en los archivos
     */

public class ManejoArchivos {
     public static ArrayList<String> LeeFichero(String nombrearchivo) {
        ArrayList<String> lineas = new ArrayList<>();
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            archivo = new File(nombrearchivo);
            fr = new FileReader(archivo,StandardCharsets.UTF_8);
            br = new BufferedReader(fr);

            String linea;
            while ((linea = br.readLine()) != null) {
                lineas.add(linea);

            }

        } catch (Exception e) {
            System.out.println("Error lectura archivo");
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                System.out.println("Error cerrar archivo");
            }
        }
        return lineas;

    }
    /**
     * ESte metodo retorna void 
     * @param nombreArchivo String necesario para crear el fichero
     * @param linea String necesario para escribir en el fichero
     * Retorna un archivo de tipo txt con la informacion generada
     */
    public static void EscribirArchivo(String nombreArchivo, String linea) {

        FileWriter fichero = null;
        BufferedWriter bw = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter(nombreArchivo,true);
            bw = new BufferedWriter(fichero);
            bw.write(linea + "\n");
//            System.out.println("ksdsdlsd");

        } catch (Exception e) {
            System.out.println("Error escritura archivo");
        } finally {
            try {
                // Nuevamente aprovechamos el finally para 
                // asegurarnos que se cierra el fichero.
                if (null != fichero) {
                    //fichero.close();
                    bw.close();
                }
            } catch (Exception e2) {
                System.out.println("Error cerrar archivo");
            }
        }
    }

     
}
