package Modelo;
import Modelo.Personaje;



public class DonRamon extends Personaje {

    public DonRamon() {
        super("Don Ramón", 40, "Flojo y buen corazón", "Vecino / Padre de la Chilindrina");
    }

    public DonRamon(String nombre, int edad, String personalidad, String rol) {
        super(nombre, edad, personalidad, rol);
    }

    public String huir() {
        return nombre + " sale corriendo: '¡Yo mejor me retiro antes de que me peguen!'";
    }


    public String enojarse() {
        return nombre + " se enoja: '¡No me voy a enojar >:C!'";
    }


    @Override
    public String movilizarse() {
        return nombre + " camina lentamente, sin ganas de trabajar.";
    }

    @Override
    public String toString() {
        return super.toString() + "\nAcciones especiales: Huir | Enojarse";
    }
}
