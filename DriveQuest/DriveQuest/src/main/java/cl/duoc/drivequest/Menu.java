package cl.duoc.drivequest;

import cl.duoc.drivequest.models.datos.GestionVehiculos;
import cl.duoc.drivequest.models.vehiculos.Vehiculos;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
            sc.nextLine(); 

            switch (option) {
                case 1:
                    ArrendarVehiculos();
                    break;
                case 2:
                    AgregarVehiculos();
                    break;
                case 3:
                    ListarVehiculos();
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

    public void ArrendarVehiculos() {
        System.out.print("Ingrese patente a arrendar: ");
        String patenteIngresada = sc.nextLine();

        boolean existe = GestionVehiculos.VerificarPatente(patenteIngresada);
        if (existe) {
            contador += 1;
            System.out.println("Vehículo arrendado correctamente.");
        } else {
            System.out.println("Patente no encontrada. No se puede arrendar.");
        }

        System.out.println("Total de arriendos: " + contador);
    }

    public void AgregarVehiculos() {
        // Cargar lista actual
        lista = GestionVehiculos.cargarDesdeCSV();

        System.out.print("Ingrese patente nueva: ");
        String patenteNueva = sc.nextLine();

        int nuevoIndice = lista.size() + 1;

        GestionVehiculos nuevoVehiculo = new GestionVehiculos(indice, patenteNueva);
        lista.add(nuevoVehiculo);

        System.out.println("Vehículo agregado correctamente a la lista.");
    }

    public void ListarVehiculos() {
        lista = GestionVehiculos.cargarDesdeCSV();

        System.out.println("\nLista de vehículos leída desde CSV:");
        for (GestionVehiculos vehiculo : lista) {
            System.out.println(vehiculo.getIndice() + ": " + vehiculo.getPatente());
        }
    }

    public void CantidadArriendos() {
        System.out.println("Cantidad de arriendos realizados: " + contador);
    }

    public void TotalFiscal() {
        // Aquí podrías sumar precios de arriendos si los tienes
        System.out.println("Total fiscal no implementado todavía.");
    }

    public void VerDescuentos() {
        System.out.println("Mostrando descuentos:");
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

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
            writer.write("Lista de vehículos:");
            writer.newLine();

            if (lista.isEmpty()) {
                writer.write("No hay vehículos registrados.");
                writer.newLine();
            } else {
                for (GestionVehiculos vehiculo : lista) {
                    writer.write(vehiculo.getIndice() + " - " + vehiculo.getPatente());
                    writer.newLine();
                }
            }

            writer.write("Total de vehículos: " + lista.size());
            writer.newLine();
            writer.write("Fecha de generación del reporte: " + fecha);

            System.out.println("Reporte exportado exitosamente a: " + rutaArchivo);
        } catch (Exception e) {
            System.err.println("Error al exportar el reporte: " + e.getMessage());
        }
    }
}
    

