package Modelo;

public class Aereo extends Animal {
    
    public Aereo() {}
    
    public Aereo(int identificacion, String nombre, String genero,
                 int edad, String cualidades) {
        super(identificacion, nombre, genero, edad, cualidades);
    }
    
    @Override
    public void mostrarInformacion() {
        System.out.println("Animal Aéreo: " + getNombre() + 
                           " | Género: " + getGenero() +
                           " | Edad: " + getEdad() +
                           " | Cualidades: " + getCualidades());
    }
}