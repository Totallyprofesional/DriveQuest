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
public class Pasajeros extends Vehiculos{

    public Pasajeros(LocalDate fechaCreacion, int dias, int carga, int numPasajeros) {
        super(fechaCreacion, dias, carga, numPasajeros);
    } 
    
    @Override
    public void Arriendo(){
    //IVA
    }
    
}
