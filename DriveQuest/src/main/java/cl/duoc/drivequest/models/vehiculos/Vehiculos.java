/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cl.duoc.drivequest.models.vehiculos;

import java.util.ArrayList;

/**
 * 
 * @author Home   
 */  
public abstract class Vehiculos implements Interfaz {     
    protected int dias;   
    protected int total;    

    public Vehiculos(int dias, int total) { 
        this.dias = dias;  
        this.total = total;
    }     

    public abstract void Arriendo();  
    
    @Override
    public void Descuentos(){   
        System.out.println("Descuento pasajeros: " + 20000 * 0.7);
        System.out.println("Descuento carga: " + 50000 * 0.12);   
    }

} 
 