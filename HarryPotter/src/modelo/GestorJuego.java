package modelo;

public class GestorJuego {
    private Usuario jugador;
    private Escenario escenarioActual;
    public GestorJuego(Usuario jugador) {
        this.jugador = jugador;
        this.escenarioActual = new Escenario("Gran Comedor");
    }

    public boolean intentarDuelo() {
        int bonoTotal = 0;
        for (ObjetoMagico obj : jugador.getInventario()) {
            bonoTotal += obj.getBono(); 
        }
        
        double probabilidadVictoria = 0.60 + (bonoTotal * 0.05); 
        boolean victoria = Math.random() <= probabilidadVictoria;
        if (victoria) {
            jugador.setNivelMagia(jugador.getNivelMagia() + 2);
        }
        return victoria;
    }

    public void moverA(String nombre) {
        this.escenarioActual = new Escenario(nombre);
    }

    public Usuario getJugador() {
        return jugador;
    }

    public Escenario getEscenarioActual() {
        return escenarioActual;
    }
    
    public int getNivelNecesario(String hechizo) {
        switch (hechizo) {
            case "Expecto Patronum": return 15;
            case "Avada Kedavra": return 50;
            default: return 10;
        }
    }
}