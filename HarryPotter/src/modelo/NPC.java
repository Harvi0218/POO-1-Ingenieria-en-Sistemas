package modelo;

public class NPC extends Personaje {

    private String rol;
    public NPC() {
    }
    public NPC(
            String nombre,
            Casa casa,
            int nivelMagia,
            String rol
    ) {

        super(nombre, casa, nivelMagia);
        this.rol = rol;
    }

    public void hablar() {
        System.out.println(
                nombre + " está hablando"
        );
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

}