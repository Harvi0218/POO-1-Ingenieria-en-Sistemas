package Modelo;
import Modelo.Personaje;
import java.util.ArrayList;
import java.util.List;


public class Vecindad {

    // Listas de elementos de la vecindad
    private List<Personaje> personajes;
    private List<ObjetosInteractivos> objetos;

    // Constructor
    public Vecindad() {
        this.personajes = new ArrayList<>();
        this.objetos = new ArrayList<>();
    }

    /**
     * Muestra todos los personajes de la vecindad
     * @return String con la lista de personajes
     */
    public String mostrarPersonajes() {
        if (personajes.isEmpty()) {
            return "No hay personajes en la vecindad.";
        }

        StringBuilder lista = new StringBuilder("=== PERSONAJES DE LA VECINDAD ===\n");
        for (Personaje p : personajes) {
            lista.append("- ").append(p.toString()).append("\n");
        }
        return lista.toString();
    }

    /**
     * Agrega un personaje a la vecindad
     * @param p Personaje a agregar
     */
    public void agregarPersonaje(Personaje p) {
        personajes.add(p);
    }

    /**
     * Agrega un objeto interactivo a la vecindad
     * @param obj Objeto a agregar
     */
    public void agregarObjeto(ObjetosInteractivos obj) {
        objetos.add(obj);
    }

    /**
     * Busca un personaje por nombre
     * @param nombre Nombre del personaje
     * @return El personaje encontrado o null
     */
    public Personaje buscarPersonaje(String nombre) {
        for (Personaje p : personajes) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                return p;
            }
        }
        return null;
    }

    // Getters
    public List<Personaje> getPersonajes() {
        return personajes;
    }

    public List<ObjetosInteractivos> getObjetos() {
        return objetos;
    }
}
