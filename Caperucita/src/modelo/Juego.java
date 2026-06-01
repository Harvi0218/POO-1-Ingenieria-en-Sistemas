package modelo;

import vista.VistaPrincipal;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Juego
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() ->
        {
            try
            {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            }
            catch (Exception e)
            {
            }
            VistaPrincipal ventana = new VistaPrincipal();
            ventana.setVisible(true);
        });
    }
}
