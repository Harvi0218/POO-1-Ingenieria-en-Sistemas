package Modelo;

public class CandidatoPersonero extends Candidato {
    
    private Animal mascota;
    
    public CandidatoPersonero() {}
    
    public CandidatoPersonero(String nombre, String apellido, int grado,
                               String grupo, String lema, int numeroTarjeton,
                               Animal mascota) {
        super(nombre, apellido, grado, grupo, lema, numeroTarjeton);
        this.mascota = mascota;
    }
    
    public Animal getMascota() {
        return mascota;
    }
    
    public void setMascota(Animal mascota) {
        this.mascota = mascota;
    }
}