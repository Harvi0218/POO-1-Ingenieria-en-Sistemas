package Modelo;
public class Casa extends ObjetosInteractivos {

    private String propietario;
    private double tamanio;

    public Casa() {
        super("Casa", "Beige", "Rectangular");
    }

    // Constructor con parámetros
    public Casa(String propietario, double tamanio, String color) {
        super("Casa de " + propietario, color, "Rectangular");
        this.propietario = propietario;
        this.tamanio = tamanio;
    }

    public String enojarse() {
        return "¡El dueño de la " + nombre + " está muy enojado con los vecinos!";
    }

    public String salir() {
        return propietario + " sale de su casa apresuradamente.";
    }

    // Getters y Setters
    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
        this.nombre = "Casa de " + propietario;
    }

    public double getTamanio() {
        return tamanio;
    }

    public void setTamanio(double tamanio) {
        this.tamanio = tamanio;
    }

    @Override
    public String toString() {
        return super.toString() + " | Propietario: " + propietario + " | Tamaño: " + tamanio + " m2";
    }
}
