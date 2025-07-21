/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cl.duoc.drivequest;

import cl.duoc.drivequest.models.datos.GestionVehiculos;
import cl.duoc.drivequest.models.vehiculos.Vehiculos;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 
 * @author Home
 */
public class Menu {
    private Scanner sc = new Scanner(System.in);
    private String patente;
    private List<GestionVehiculos> lista = new ArrayList<>();
    private int contador; 

    public Menu(String patente, int contador) {
        this.patente = patente;
        this.contador = contador;
    }

    public Menu(String patente) {  
        this.patente = patente;
    }
    
    public void mostrarMenu() throws InterruptedException {
        int option = 0;
 
        do { 
            System.out.println("\n Bienvenido al Menu DriveQuest Rentals");
            System.out.println("1. Arrendar Vehiculos");
            System.out.println("2. Agregar Vehiculos");
            System.out.println("3. Mostrar lista de vehiculos"); 
            System.out.println("4. Cantidad de arriendos");
            System.out.println("5. Total fiscal");
            System.out.println("6. Descuentos");
            System.out.println("7. Guardar Cambios");
            System.out.println("8. Exportar Reporte");
            System.out.println("9. Salir");
            System.out.print("Seleccione una opcion: "); 
             
            option = sc.nextInt(); 
   
            switch (option) {   
                case 1:
                    ArrendarVehiculos(sc);
                    break;
                case 2: 
                    AgregarVehiculos(sc);
                    break;
                case 3:  
                    ListarVehiculos(sc); 
                    break; 
                case 4: 
                    CantidadArriendos();
                    break;
                case 5:
                    TotalFiscal(); 
                    break;
                case 6:
                    VerDescuentos();      
                    break;
                case 7:
                    GuardarCambios(); 
                    break;
                case 8:
                    ExportarReporte(); 
                    break;
                case 9:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Por favor ingrese una opcion valida.");
                    break;
            } 
        } while (option != 9);  
    }   
     
    public void VerificarDatos(String patente) {     
        System.out.println("Ingrese patente");
        patente = sc.nextLine(); 
        GestionVehiculos.VerificarPatente(patente); 
    }
    
    public void ArrendarVehiculos(Scanner sc) {   
        System.out.println("Ingrese patente");
        VerificarDatos(patente);
        
        
        System.out.println(this.contador);
    }
     
    public void AgregarVehiculos(Scanner sc) {
        VerificarDatos(patente);
        
        List<GestionVehiculos> lista = GestionVehiculos.cargarDesdeCSV();

        System.out.print("Ingrese patente nueva: ");
        String patente = sc.nextLine();
        
        GestionVehiculos nuevoVehiculo = new GestionVehiculos(indice, patente);

        lista.add(nuevoVehiculo);
        GestionVehiculos.guardarEnCSV(lista);

        System.out.println("Vehículo agregado correctamente.");
         
    }
    
    public void ListarVehiculos(Scanner sc) {   
        List<GestionVehiculos> lista = GestionVehiculos.cargarDesdeCSV(); 
        System.out.println(""); 
        System.out.println("Lista leída desde CSV:");
         
        for (GestionVehiculos lista2 : lista) {
        System.out.println(lista2.getIndice() + ": " + lista2.getPatente());
        }
    }
    
    public void CantidadArriendos() { 
        System.out.println("Numero de arriendos"); 
        contador += 1; 
    }
          
    public void Boleta() {
         
    } 
    
    public void TotalFiscal() {
         
    } 
    
    public void VerDescuentos() {
        System.out.println("Mostrando descuentos");
        Vehiculos.Descuentos();
    }
        
    public void GuardarCambios() {
        try {
           GestionVehiculos.guardarEnCSV(lista);
            System.out.println("Cambios guardados satisfactoriamente.");
        } catch (Exception e) {
            System.out.println("Error al guardar los cambios: " + e.getMessage());
        }           
    }
     
    public void ExportarReporte() {
        String fecha = java.time.LocalDate.now().toString();
        String rutaArchivo = "reporte_codigos_" + fecha + ".txt";
        try (BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(rutaArchivo))) {
            writer.write("Lista de codigos.");
            writer.newLine();
        if (lista.isEmpty()) { 
            writer.write("No hay codigos registrados.");
            writer.newLine();
        } else { 
            for (GestionVehiculos lista2 : lista) {
            writer.write(lista2.getIndice() + " - " + lista2.getPatente());
            writer.newLine();
           }   
        writer.write("Total de codigos: " + lista.size());
        writer.newLine();
        writer.write("Fecha de generación del reporte: " + fecha);
        }
            System.out.println("Reporte exportado exitosamente a: " + rutaArchivo);
        } catch (Exception e) {
           System.err.println("Error al exportar el reporte: " + e.getMessage());
        }     
    }
    
}
    

