/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cl.duoc.drivequest.models.datos;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Home  
 */ 
public class GestionVehiculos {
    private String indice;
    private String patente;

    public GestionVehiculos(String indice, String patente) {
        this.indice = indice; 
        this.patente = patente;
    }

    public String getIndice() {
        return indice;
    }

    public String getPatente() {
        return patente; 
    }
 
    public static boolean VerificarPatente() {  
        try {
            // revisar input en lista de GestionVehiculos
            cargarDesdeCSV(); 
                     
        } catch (Exception e) {
            System.out.println("Error de verificacion: " + e.getMessage());
            return false; 
        }  
        return true;   
    } 
     
    //Duracion arriendo = o mas de 7 dias 
     
     public static List<GestionVehiculos> cargarDesdeCSV() {  
        List<GestionVehiculos> lista = new ArrayList<>();
        try (
            FileReader reader = new FileReader("patentes.csv"); 
            CSVReader csvReader = new CSVReader(reader); 
        ) {
            System.out.println(new java.io.File(".").getAbsolutePath());
            
            String[] nextLine;
            csvReader.readNext();  
             
            while ((nextLine = csvReader.readNext()) != null) { 
                String indice = nextLine[0];
                String patente = nextLine[1];

                GestionVehiculos listaNueva = new GestionVehiculos(indice, patente); 
                lista.add(listaNueva); 
            }
        } catch (Exception e) {
            System.out.println("Error de lectura: " + e.getMessage());
        }
        return lista;
    } 

    public static void guardarEnCSV(List<GestionVehiculos> lista) {
        try (
            FileWriter writer = new FileWriter("patentes.csv");
            CSVWriter csvWriter = new CSVWriter(writer);
        ) {
            String[] header = {"Indice", "Patente"};
            csvWriter.writeNext(header);

            for (GestionVehiculos lista2 : lista) {
            String[] data = {
                lista2.getIndice(),
                lista2.getPatente(),
            };
            csvWriter.writeNext(data);
            }
        } catch (IOException e) {
        System.out.println("Error de guardado: " + e.getMessage());
        }
    }   
    
}
 