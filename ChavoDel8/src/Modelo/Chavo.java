package Modelo;

public class Chavo extends Personaje {

    public Chavo() {
        super("El Chavo", 8, "Inocente y travieso", "Protagonista");
    }

    public Chavo(String nombre, int edad, String personalidad, String rol) {
        super(nombre, edad, personalidad, rol);
    }

    public String pedirTorta() {
        return nombre + " dice: '¡Una tortita de jamón, por favor...' (fue sin querer queriendo :C)";
    }


    @Override
    public String movilizarse() {
        return nombre + " sale corriendo del barril hacia la vecindad.";
    }

    @Override
    public String toString() {
        return super.toString() + "\nAcción especial: ¿Me regalas una Torta?";
    }
}
