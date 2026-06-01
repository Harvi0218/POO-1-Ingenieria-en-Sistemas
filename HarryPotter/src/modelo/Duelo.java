package modelo;

public class Duelo {

    private Usuario jugador;

    private NPC enemigo;

    public Duelo() {
    }

    public Duelo(
            Usuario jugador,
            NPC enemigo
    ) {

        this.jugador = jugador;
        this.enemigo = enemigo;
    }

    public void iniciarDuelo() {

        System.out.println(
                jugador.getNombre()
                + " VS "
                + enemigo.getNombre()
        );
    }


    public Usuario getJugador() {
        return jugador;
    }

    public void setJugador(
            Usuario jugador
    ) {

        this.jugador = jugador;
    }

    public NPC getEnemigo() {
        return enemigo;
    }

    public void setEnemigo(
            NPC enemigo
    ) {

        this.enemigo = enemigo;
    }

}