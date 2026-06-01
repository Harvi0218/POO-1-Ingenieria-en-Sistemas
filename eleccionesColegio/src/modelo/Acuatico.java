package Modelo;

public class Acuatico extends Animal {
    
    public Acuatico() {}
    
    public Acuatico(int identificacion, String nombre, String genero,
                 int edad, String cualidades) {
        super(identificacion, nombre, genero, edad, cualidades);
    }
    
    @Override
    public void mostrarInformacion() {
        System.out.println("Animal Acuático: " + getNombre() + 
                           " | Género: " + getGenero() +
                           " | Edad: " + getEdad() +
                           " | Cualidades: " + getCualidades());
    }
}