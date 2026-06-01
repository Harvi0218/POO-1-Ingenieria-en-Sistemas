import controlador.Controlador;
import modelo.SistemaRecomendacion;
import vista.VentanaPrincipal;

public class Main {
    public static void main(String[] args) {
        SistemaRecomendacion modelo = new SistemaRecomendacion();
        VentanaPrincipal vista = new VentanaPrincipal();
        Controlador controlador = new Controlador(modelo, vista);
        vista.setControlador(controlador);
        vista.setVisible(true);
    }
}
