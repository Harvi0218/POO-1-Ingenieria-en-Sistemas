package Modelo;
import Modelo.Personaje;


/**
 * Clase Usuario que representa al usuario que interactúa con los personajes.
 * Se relaciona con Personaje mediante asociación.
 * 
 * @author Estudiante POO - 2do Semestre
 */
public class Usuario {

    private String nombreUsuario;

    // Constructor
    public Usuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    /**
     * El usuario interactúa con un personaje
     * @param p El personaje con quien interactuar
     * @return String describiendo la interacción
     */
    public String interaccion(Personaje p) {
        return nombreUsuario + " interactúa con " + p.getNombre()
                + " [" + p.getRol() + "]";
    }

    // Getter y Setter
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    @Override
    public String toString() {
        return "Usuario: " + nombreUsuario;
    }
}
