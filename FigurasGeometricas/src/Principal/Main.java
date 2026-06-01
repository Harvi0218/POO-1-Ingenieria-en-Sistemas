package Principal;

import controlador.ControladorFiguras;
import vista.JFFiguras;

public class Main {

    public static void main(String[] args) {

        JFFiguras vista = new JFFiguras();

        ControladorFiguras controlador = new ControladorFiguras(vista);

        vista.setVisible(true);
    }
}