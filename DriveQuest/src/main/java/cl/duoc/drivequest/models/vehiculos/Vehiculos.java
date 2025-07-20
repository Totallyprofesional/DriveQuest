/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cl.duoc.drivequest.models.vehiculos;

import java.time.LocalDate;

/**
 *
 * @author Home
 */ 
public abstract class Vehiculos {     
    private LocalDate fechaCreacion;    
    private int dias; 
    private int carga; 
    private int numPasajeros;

    public Vehiculos(LocalDate fechaCreacion, int dias, int carga, int numPasajeros) {
        this.fechaCreacion = fechaCreacion;
        this.dias = dias;
        this.carga = carga;
        this.numPasajeros = numPasajeros;
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
    
    public abstract void Arriendo();  
   

} 
