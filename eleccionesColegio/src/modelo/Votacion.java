package Modelo;

import java.util.ArrayList;

public class Votacion {
    
    private int votosNulos;
    private int votosBlancos;
    private ArrayList<Candidato> candidatos;
    
    public Votacion(){
        this.votosNulos = 0;
        this.votosBlancos = 0;
        this.candidatos = new ArrayList<>();
    }
    
    public void registrarVoto(Candidato c){
        c.recibirVoto();
    }
    
    public void registrarVotoBlanco(){
        this.votosBlancos++;
    }
    
    public Candidato obtenerGanadorPersonero(){
        Candidato ganador = candidatos.get(0);
        for (Candidato c : candidatos) {
            if (c.obtenerVotos() > ganador.obtenerVotos()) {
                ganador = c;
            }
        }
        return ganador;
    }
    public Candidato obtenerMenorVotacionPersonero() {
        Candidato menor = candidatos.get(0);
        for (Candidato c : candidatos) {
            if (c.obtenerVotos() < menor.obtenerVotos()) {
                menor = c;
            }
        }
        return menor;
    }
    public int calcularPoblacionElectoral(){
        int total = 0;
        for (Candidato c : candidatos) {
            total += c.obtenerVotos();
        }
         return total + votosNulos + votosBlancos;
    }

    public int getVotosNulos() {
        return votosNulos;
    }

    public void setVotosNulos(int votosNulos) {
        this.votosNulos = votosNulos;
    }

    public int getVotosBlancos() {
        return votosBlancos;
    }

    public void setVotosBlancos(int votosBlancos) {
        this.votosBlancos = votosBlancos;
    }

    public ArrayList<Candidato> getCandidatos() {
        return candidatos;
    }

    public void setCandidatos(ArrayList<Candidato> candidatos) {
        this.candidatos = candidatos;
    }
    
}
