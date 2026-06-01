package Modelo;
public class ObjetosInteractivos {

    protected String nombre;
    protected String color;
    protected String forma;

    // Constructor vacío
    public ObjetosInteractivos() {
    }

    // Constructor 
    public ObjetosInteractivos(String nombre, String color, String forma) {
        this.nombre = nombre;
        this.color = color;
        this.forma = forma;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getForma() {
        return forma;
    }

    public void setForma(String forma) {
        this.forma = forma;
    }

    @Override
    public String toString() {
        return "Objeto: " + nombre + " | Color: " + color + " | Forma: " + forma;
    }
}
