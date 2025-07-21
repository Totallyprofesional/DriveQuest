/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package cl.duoc.drivequest;

/**
 *
 * @author Home 
 */ 
public class DriveQuest { 
    public static String patente;
 
    public static void main(String[] args) throws InterruptedException {
        
        Menu menu = new Menu (patente);
        menu.mostrarMenu(); 
    }
} 
 