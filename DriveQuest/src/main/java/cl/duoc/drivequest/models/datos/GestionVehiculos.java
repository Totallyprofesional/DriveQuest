/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cl.duoc.drivequest.models.datos;

import java.time.LocalDate;

/**
 *
 * @author Home
 */ 
public class GestionVehiculos implements Interfaz {
    private int patente;
    private int cantidad;
    private String tipo;
    private String arriendo;
    
    public GestionVehiculos(int patente, String tipo, String arriendo) {
        this.patente = patente;
        this.tipo = tipo;
        this.arriendo = arriendo;
    }
 
    @Override  
    public void Descuentos() {
        // iva  
        // descuentos
    } 

    //Hashmap ?
    //Validar patente
    //Duracion arriendo
    //metodos csv
    
}
 