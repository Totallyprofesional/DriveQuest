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
public abstract class Carga extends Vehiculos{
    private int arriendo; 
    private int numCarga;
    private int carga = 50000;
    private double iva = 0.19;  

    public Carga(int arriendo, int dias, int total) {
        super(dias, total);
        this.arriendo = arriendo;
    }
 
    @Override 
    public void Arriendo(){
        if (numCarga > 400){
        carga = (int)(carga * 0.12);
        }
        
        arriendo = carga * dias;
        total = (int)(arriendo * iva);
        System.out.println("Valor de arriendo: " + total);
    }
  
}
