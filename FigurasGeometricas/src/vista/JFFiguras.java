package vista;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class JFFiguras extends JFrame {

    private static final java.util.logging.Logger logger =
            java.util.logging.Logger.getLogger(JFFiguras.class.getName());

    private JLabel lblTitulo;
    private JLabel lblFigura;
    private JLabel lblCodigo;
    private JLabel lblColor;
    private JLabel lblDato1;
    private JLabel lblDato2;
    private JLabel lblDato3;
    private JTextField txtCodigo;
    private JTextField txtColor;
    private JTextField txtDato1;
    private JTextField txtDato2;
    private JTextField txtDato3;
    private JButton btnCalcularArea;
    private JButton btnCalcularPerimetro;
    private JButton btnLimpiar;
    private JLabel lblResultadoArea;
    private JLabel lblResultadoPerimetro;
    private JComboBox<String> cbFigura;
    public JFFiguras() {
        initComponents();

        setTitle("Sistema de Figuras");
        setSize(700, 500);
        setLocationRelativeTo(null);
        setResizable(false);

        getContentPane().setLayout(null);

        lblTitulo = new JLabel("SISTEMA DE FIGURAS GEOMETRICAS");
        lblTitulo.setBounds(180, 20, 350, 30);
        add(lblTitulo);
        lblFigura = new JLabel("Figura:");
        lblFigura.setBounds(50, 80, 100, 25);
        add(lblFigura);
        cbFigura = new JComboBox<>();
        cbFigura.addItem("Circulo");
        cbFigura.addItem("Cuadrado");
        cbFigura.addItem("Triangulo");
        cbFigura.setBounds(150, 80, 150, 25);
        add(cbFigura);
        lblCodigo = new JLabel("Codigo:");
        lblCodigo.setBounds(50, 130, 100, 25);
        add(lblCodigo);
        txtCodigo = new JTextField();
        txtCodigo.setBounds(150, 130, 150, 25);
        add(txtCodigo);
        lblColor = new JLabel("Color:");
        lblColor.setBounds(50, 180, 100, 25);
        add(lblColor);
        txtColor = new JTextField();
        txtColor.setBounds(150, 180, 150, 25);
        add(txtColor);
        lblDato1 = new JLabel("Dato 1:");
        lblDato1.setBounds(50, 230, 100, 25);
        add(lblDato1);
        txtDato1 = new JTextField();
        txtDato1.setBounds(150, 230, 150, 25);
        add(txtDato1);
        lblDato2 = new JLabel("Dato 2:");
        lblDato2.setBounds(50, 280, 100, 25);
        add(lblDato2);
        txtDato2 = new JTextField();
        txtDato2.setBounds(150, 280, 150, 25);
        add(txtDato2);
        lblDato3 = new JLabel("Dato 3:");
        lblDato3.setBounds(50, 330, 100, 25);
        add(lblDato3);
        txtDato3 = new JTextField();
        txtDato3.setBounds(150, 330, 150, 25);
        add(txtDato3);
        btnCalcularArea = new JButton("Calcular Area");
        btnCalcularArea.setBounds(400, 130, 180, 40);
        add(btnCalcularArea);
        btnCalcularPerimetro = new JButton("Calcular Perimetro");
        btnCalcularPerimetro.setBounds(400, 200, 180, 40);
        add(btnCalcularPerimetro);

        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setBounds(400, 270, 180, 40);
        add(btnLimpiar);
        lblResultadoArea = new JLabel("Area:");
        lblResultadoArea.setBounds(400, 340, 250, 30);
        add(lblResultadoArea);
        lblResultadoPerimetro = new JLabel("Perimetro:");
        lblResultadoPerimetro.setBounds(400, 380, 250, 30);
        add(lblResultadoPerimetro);
        repaint();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public JComboBox<String> getCbFigura() {
        return cbFigura;
    }

    public JTextField getTxtCodigo() {
        return txtCodigo;
    }

    public JTextField getTxtColor() {
        return txtColor;
    }

    public JTextField getTxtDato1() {
        return txtDato1;
    }

    public JTextField getTxtDato2() {
        return txtDato2;
    }

    public JTextField getTxtDato3() {
        return txtDato3;
    }

    public JButton getBtnCalcularArea() {
        return btnCalcularArea;
    }

    public JButton getBtnCalcularPerimetro() {
        return btnCalcularPerimetro;
    }

    public JButton getBtnLimpiar() {
        return btnLimpiar;
    }

    public JLabel getLblResultadoArea() {
        return lblResultadoArea;
    }

    public JLabel getLblResultadoPerimetro() {
        return lblResultadoPerimetro;
    }

    
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(() -> new JFFiguras().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
