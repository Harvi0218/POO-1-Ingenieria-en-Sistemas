package modelo;

public class Personaje {

    protected String nombre;
    protected Casa casa;
    protected int nivelMagia;

    public Personaje() {
    }

    public Personaje(
            String nombre,
            Casa casa,
            int nivelMagia
    ) {

        this.nombre = nombre;
        this.casa = casa;
        this.nivelMagia = nivelMagia;
    }

    public void explorar() {

        System.out.println(
                nombre + " está explorando Hogwarts"
        );
    }

    public void aprenderHechizo() {

        System.out.println(
                nombre + " aprendió un nuevo hechizo"
        );
    }

    // GETTERS Y SETTERS

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Casa getCasa() {
        return casa;
    }

    public void setCasa(Casa casa) {
        this.casa = casa;
    }

    public int getNivelMagia() {
        return nivelMagia;
    }

    public void setNivelMagia(int nivelMagia) {
        this.nivelMagia = nivelMagia;
    }

}