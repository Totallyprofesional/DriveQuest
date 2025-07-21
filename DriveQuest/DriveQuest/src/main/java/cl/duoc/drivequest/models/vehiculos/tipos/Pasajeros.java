/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cl.duoc.drivequest.models.vehiculos.tipos;

import cl.duoc.drivequest.models.vehiculos.Vehiculos;
import java.time.LocalDate;
 
/**
 *
 * @author Home   
 */
public abstract class Pasajeros extends Vehiculos{
    private int arriendo; 
    private int numPasajeros; 
    private int pasajeros = 20000;
    private double iva = 0.19;  

    public Pasajeros(int arriendo, int dias, int total) {
        super(dias, total);
        this.arriendo = arriendo; 
    }

    @Override
    public void Arriendo(){
        if (numPasajeros > 4){
        pasajeros = (int)(pasajeros * 0.7);
        }
        
        arriendo = pasajeros * dias;
        total = (int)(arriendo * iva);
        System.out.println("Valor de arriendo: " + total);
    } 
  
}
