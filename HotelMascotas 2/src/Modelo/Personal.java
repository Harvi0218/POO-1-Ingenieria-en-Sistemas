
package Modelo;

public class Personal extends Usuario{
    
    public Personal(String nombre, String cedula,String edad) {
    super(nombre, cedula,edad);
}
    public void mostrarPerfil() {
        System.out.println("Nombre: " + getNombre() + " Cedula: " + getCedula());
    }
    
}
