package harrypotter;

import controlador.ControladorHogwarts;
import vista.JFHogwarts;

public class HarryPotter {

    public static void main(String[] args) {

        JFHogwarts vista = new JFHogwarts();

        ControladorHogwarts controlador =
                new ControladorHogwarts(vista);

        vista.setVisible(true);
    }
}