package Modelo;

/**
 * Clase que representa a Quico.
 * Hereda de Personaje.
 * 
 * @author Estudiante POO - 2do Semestre
 */
public class Quico extends Personaje {

    // Constructor
    public Quico() {
        super("Quico", 9, "Presumido y llorón", "Amigo/Rival del Chavo");
    }

    // Constructor personalizado
    public Quico(String nombre, int edad, String personalidad, String rol) {
        super(nombre, edad, personalidad, rol);
    }

    /**
     * Método propio de Quico: jugar pelota
     * @return String con el resultado de la acción
     */
    public String jugarPelota() {
        return nombre + " dice: '¡Es mi pelota y no te la presto >:C' Procede a jugar.";
    }


    @Override
    public String movilizarse() {
        return nombre + " corre presumiendo sus juguetes nuevos por la vecindad.";
    }

    @Override
    public String toString() {
        return super.toString() + "\nAcción especial: Juega con la Pelota";
    }
}
