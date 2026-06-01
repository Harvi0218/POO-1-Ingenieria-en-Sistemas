package modelo;

public class Mision {

    private String nombre;
    private boolean completada;

    public Mision() {
    }

    public Mision(String nombre) {

        this.nombre = nombre;
        this.completada = false;
    }

    public void completarMision() {

        completada = true;

        System.out.println(
                "Misión completada: "
                + nombre
        );
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isCompletada() {
        return completada;
    }
}