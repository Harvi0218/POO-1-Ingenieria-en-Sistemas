
package Modelo;

public class Cuidador extends Personal{
    
    private int añosExp;
    private String disponibilidad;
    private String especialidad;

    public Cuidador(int añosExp, String disponibilidad, String especialidad, String nombre, String cedula, String edad) {
        super(nombre, cedula, edad);
        this.añosExp = añosExp;
        this.disponibilidad = disponibilidad;
        this.especialidad = especialidad;
    }
    

    public int getAñosExp() {
        return añosExp;
    }

    public void setAñosExp(int añosExp) {
        this.añosExp = añosExp;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
    public void AtenderMascota(){
        System.out.println("Cuidador " + getNombre() + " esta atendiendo una mascota.");
    }
    public void VerificarDisponibilidad(){
        System.out.println("Disponibilidad de " + getNombre() + ": " + disponibilidad);
    }
    
}
