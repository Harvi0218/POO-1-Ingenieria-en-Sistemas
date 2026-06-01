package modelo;

import java.util.ArrayList;

public class Usuario extends Personaje {
    private String habilidadEspecial;
    private ArrayList<Hechizo> hechizos;
    private ArrayList<ObjetoMagico> inventario;
    public Usuario() {

        hechizos = new ArrayList<>();
        inventario = new ArrayList<>();
    }

    public Usuario(
            String nombre,
            Casa casa,
            int nivelMagia,
            String habilidadEspecial
    ) {

        super(nombre, casa, nivelMagia);

        this.habilidadEspecial = habilidadEspecial;

        hechizos = new ArrayList<>();
        inventario = new ArrayList<>();
    }

    public void aprenderHechizo(
            Hechizo hechizo
    ) {

        hechizos.add(hechizo);

        System.out.println(
                nombre + " aprendió "
                + hechizo.getNombre()
        );
    }

    public boolean usarHechizo(
            Hechizo hechizo
    ) {

        if (nivelMagia >= hechizo.getNivelNecesario()) {

            System.out.println(
                    nombre + " usó "
                    + hechizo.getNombre()
            );

            return true;

        } else {

            return false;
        }
    }

    public void agregarObjeto(
            ObjetoMagico objeto
    ) {

        inventario.add(objeto);
    }

    public String getHabilidadEspecial() {
        return habilidadEspecial;
    }

    public void setHabilidadEspecial(
            String habilidadEspecial
    ) {

        this.habilidadEspecial = habilidadEspecial;
    }

    public ArrayList<Hechizo> getHechizos() {
        return hechizos;
    }

    public ArrayList<ObjetoMagico> getInventario() {
        return inventario;
    }

}