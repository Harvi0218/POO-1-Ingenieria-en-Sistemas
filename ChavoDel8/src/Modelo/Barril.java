package Modelo;
public class Barril extends ObjetosInteractivos {

    private String propietario;

    public Barril() {
        super("Barril del Chavo", "Café", "Cilíndrica");
        this.propietario = "El Chavo";
    }

    public Barril(String propietario, String color) {
        super("Barril de " + propietario, color, "Cilíndrica");
        this.propietario = propietario;
    }

 
    public String mostrarPropietario() {
        return "Este barril pertenece a: " + propietario;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
        this.nombre = "Barril de " + propietario;
    }

    @Override
    public String toString() {
        return super.toString() + " | Propietario: " + propietario;
    }
}
