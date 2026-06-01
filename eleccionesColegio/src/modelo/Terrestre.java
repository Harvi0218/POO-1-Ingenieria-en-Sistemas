package Modelo;

public class Terrestre extends Animal {
    
    public Terrestre() {}
    
    public Terrestre(int identificacion, String nombre, String genero,
                 int edad, String cualidades) {
        super(identificacion, nombre, genero, edad, cualidades);
    }
    
    @Override
    public void mostrarInformacion() {
        System.out.println("Animal Terrestre: " + getNombre() + 
                           " | Género: " + getGenero() +
                           " | Edad: " + getEdad() +
                           " | Cualidades: " + getCualidades());
    }
}