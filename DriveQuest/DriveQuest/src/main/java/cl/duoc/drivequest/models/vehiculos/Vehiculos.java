/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cl.duoc.drivequest.models.vehiculos;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * 
 * @author Home   
 */ 
public abstract class Vehiculos implements Interfaz {     
    private LocalDate fechaCreacion;      
    private int dias;  
    private int carga; 
    private int numPasajeros; 
    private int total;    
    private double iva = 0.19; 
    private double tipoCarga = 0.7;    
    private double tipoPasajeros = 0.12;    

    public Vehiculos(LocalDate fechaCreacion, int dias, int carga, int numPasajeros, int total) {
        this.fechaCreacion = fechaCreacion;
        this.dias = dias;
        this.carga = carga;
        this.numPasajeros = numPasajeros;
        this.total = total;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion; 
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public int getCarga() {
        return carga;
    } 

    public void setCarga(int carga) {
        this.carga = carga;
    }

    public int getNumPasajeros() {
        return numPasajeros;
    }

    public void setNumPasajeros(int numPasajeros) {
        this.numPasajeros = numPasajeros;
    }
    
    @Override  
    public void Descuentos() { 
        total = (int)(total * iva);  
        tipoCarga = (int)(total * tipoCarga);              
        tipoPasajeros = (int)(total * tipoPasajeros);
    } 
    
    public abstract void Arriendo();  
   

} 
