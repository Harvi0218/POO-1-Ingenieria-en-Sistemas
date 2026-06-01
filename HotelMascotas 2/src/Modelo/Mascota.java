
package Modelo;

public class Mascota {
    private String nombreMascota;
    private String raza;
    private String edadPerruna;
    private String necesidadesEspeciales;

    public Mascota() {
    }

    public Mascota(String nombreMascota, String raza, String edadPerruna, String necesidadesEspeciales) {
        this.nombreMascota = nombreMascota;
        this.raza = raza;
        this.edadPerruna = edadPerruna;
        this.necesidadesEspeciales = necesidadesEspeciales;
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getEdadPerruna() {
        return edadPerruna;
    }

    public void setEdadPerruna(String edadPerruna) {
        this.edadPerruna = edadPerruna;
    }

    public String getNecesidadesEspeciales() {
        return necesidadesEspeciales;
    }

    public void setNecesidadesEspeciales(String necesidadesEspeciales) {
        this.necesidadesEspeciales = necesidadesEspeciales;
    }
    
    public void mostrarInfo() {
        System.out.println("Mascota: " + nombreMascota + " | Raza: " + raza + " | Edad: " + edadPerruna);
    }
 
    public void actualizarNecesidades(String nuevasNecesidades) {
        this.necesidadesEspeciales = nuevasNecesidades;
        System.out.println("Necesidades actualizadas: " + necesidadesEspeciales);
    }
}