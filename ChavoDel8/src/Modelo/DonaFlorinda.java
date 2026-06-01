package Modelo;
import Modelo.Personaje;


public class DonaFlorinda extends Personaje {

    public DonaFlorinda() {
        super("Doña Florinda", 35, "Soberbia y protectora", "Madre de Quico");
    }

    public DonaFlorinda(String nombre, int edad, String personalidad, String rol) {
        super(nombre, edad, personalidad, rol);
    }

    public String darTorta() {
        return nombre + " le da una torta al Chavo: '¡niño Metiche!'";
    }

    public String golpearDonRamon(DonRamon donRamon) {
        return nombre + " golpea a " + donRamon.getNombre() + " Vamonos tesoro, no te juntes con esta chusma";
    }

    @Override
    public String movilizarse() {
        return nombre + " camina elegante por la vecindad buscando a Quico.";
    }

    @Override
    public String toString() {
        return super.toString() + "\nAcciones especiales: Dar Torta o Golpear Don Ramón";
    }
}
