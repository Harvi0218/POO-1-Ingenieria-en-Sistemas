package Modelo;

public abstract class Animal {
    
    private int identificacion;
    private String nombre;
    private String genero;
    private int edad;
    private String cualidades;
    
    public Animal() {}
    
    public Animal(int identificacion, String nombre, String genero, 
                  int edad, String cualidades) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.genero = genero;
        this.edad = edad;
        this.cualidades = cualidades;
    }
    
    public abstract void mostrarInformacion();

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCualidades() {
        return cualidades;
    }

    public void setCualidades(String cualidades) {
        this.cualidades = cualidades;
    }
    
 
}