
package Modelo;

import Modelo.Personal;

public class Administrador extends Personal{
    
    public Administrador(String nombre, String cedula,String edad) {
    super(nombre, cedula,edad);
}
    public void gestionarReservas() {
        System.out.println("Administrador " + getNombre() + " gestionando reservas.");
    }
 
    public void asignarCuidador() {
        System.out.println("Administrador " + getNombre() + " asignando cuidador.");
    }
    
}
