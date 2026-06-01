package Modelo;

public class CandidatoRepresentante extends Candidato {
    
    private Estudiante formula;
    
    public CandidatoRepresentante() {}
    
    public CandidatoRepresentante(String nombre, String apellido, int grado,
                                   String grupo, String lema, int numeroTarjeton,
                                   Estudiante formula) {
        super(nombre, apellido, grado, grupo, lema, numeroTarjeton);
        this.formula = formula;
    }
    
    public Estudiante getFormula() {
        return formula;
    }
    
    public void setFormula(Estudiante formula) {
        this.formula = formula;
    }
}