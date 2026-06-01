package Modelo;

public class Candidato {

    private String nombre;
    private String apellido;
    private int grado;
    private String grupo;
    private String lema;
    private int numeroTarjeton;
    private int votos;

    public Candidato() {
    }

    public Candidato(String nombre, String apellido, int grado,
            String grupo, String lema, int numeroTarjeton) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.grado = grado;
        this.grupo = grupo;
        this.lema = lema;
        this.numeroTarjeton = numeroTarjeton;
        this.votos = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getGrado() {
        return grado;
    }

    public void setGrado(int grado) {
        this.grado = grado;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getLema() {
        return lema;
    }

    public void setLema(String lema) {
        this.lema = lema;
    }

    public int getNumeroTarjeton() {
        return numeroTarjeton;
    }

    public void setNumeroTarjeton(int numeroTarjeton) {
        this.numeroTarjeton = numeroTarjeton;
    }

    public int getVotos() {
        return votos;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }

    public void recibirVoto() {
        this.votos++;
    }

    public int obtenerVotos() {
        return this.votos;
    }
}
