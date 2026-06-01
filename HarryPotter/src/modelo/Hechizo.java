package modelo;

public class Hechizo {

    private String nombre;
    private int poder;
    private Elemento elemento;
    private int nivelNecesario;
    public Hechizo() {
    }

    public Hechizo(
            String nombre,
            int poder,
            Elemento elemento,
            int nivelNecesario
    ) {

        this.nombre = nombre;
        this.poder = poder;
        this.elemento = elemento;
        this.nivelNecesario = nivelNecesario;
    }

    public void lanzarHechizo() {
        System.out.println(
                "Lanzando hechizo: "
                + nombre
        );
    }


    public String getNombre() {
        return nombre;
    }

    public int getPoder() {
        return poder;
    }

    public Elemento getElemento() {
        return elemento;
    }

    public int getNivelNecesario() {
        return nivelNecesario;
    }

}