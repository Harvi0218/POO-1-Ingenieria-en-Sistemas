package Modelo;

public class Personaje {

    // Atributos protegidos 
    protected String nombre;
    protected int edad;
    protected String personalidad;
    protected String rol;

    public Personaje() {
    }

    // Constructor 
    public Personaje(String nombre, int edad, String personalidad, String rol) {
        this.nombre = nombre;
        this.edad = edad;
        this.personalidad = personalidad;
        this.rol = rol;
    }

    // Método para movilizarse
    public String movilizarse() {
        return nombre + " se está moviendo por la vecindad.";
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getPersonalidad() {
        return personalidad;
    }

    public void setPersonalidad(String personalidad) {
        this.personalidad = personalidad;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    // Método toString para mostrar info del personaje
    @Override
    public String toString() {
        return "Personaje: " + nombre + " | Edad: " + edad + " | Rol: " + rol;
    }
}
