package modelo;

public class ObjetoMagico {
    private String nombre;
    private String descripcion;
    private int bono; 

    public ObjetoMagico(String nombre, String descripcion, int bono) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.bono = bono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getBono() {
        return bono;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setBono(int bono) {
        this.bono = bono;
    }
}