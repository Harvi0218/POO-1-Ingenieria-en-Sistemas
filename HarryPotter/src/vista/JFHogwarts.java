package vista;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import java.util.logging.Logger;
import javax.swing.JLabel;

public class JFHogwarts extends javax.swing.JFrame {
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(JFHogwarts.class.getName());
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel panelJugador;
    private javax.swing.JPanel panelAcciones;
    private javax.swing.JPanel panelMisiones;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblNombreJugador;
    private javax.swing.JLabel lblCasa;
    private javax.swing.JLabel lblNivelMagia;
    private javax.swing.JLabel lblUbicacion;
    private javax.swing.JLabel lblObjetivos;
    private javax.swing.JLabel lblHechizos;
    private javax.swing.JButton btnExplorar;
    private javax.swing.JButton btnHablar;
    private javax.swing.JButton btnAprender;
    private javax.swing.JButton btnUsarHechizo;
    private javax.swing.JButton btnInventario;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> comboHechizos;
    private javax.swing.JList<String> listaMisiones;
    private javax.swing.JScrollPane scrollMisiones;



    public JFHogwarts() {
        initComponents();
        iniciarVista();
    }
    private void iniciarVista() {

        setTitle("Hogwarts Legacy");
        setSize(1000, 700);
        setLocationRelativeTo(null);

        panelPrincipal = new javax.swing.JPanel();
        panelPrincipal.setLayout(null);
        panelPrincipal.setBackground(new java.awt.Color(25, 25, 25));

        lblTitulo = new javax.swing.JLabel();
        lblTitulo.setText("HOGWARTS LEGACY");
        lblTitulo.setForeground(java.awt.Color.WHITE);
        lblTitulo.setFont(new java.awt.Font("Serif", 1, 32));
        lblTitulo.setBounds(300, 20, 500, 40);
        panelPrincipal.add(lblTitulo);

        panelJugador = new javax.swing.JPanel();
        panelJugador.setLayout(null);
        panelJugador.setBackground(new java.awt.Color(45, 45, 45));
        panelJugador.setBounds(30, 90, 300, 220);
        panelPrincipal.add(panelJugador);

        lblNombreJugador = new javax.swing.JLabel();
        lblNombreJugador.setText("Jugador: Harry Potter");
        lblNombreJugador.setForeground(java.awt.Color.WHITE);
        lblNombreJugador.setBounds(20,20,250,30);
        panelJugador.add(lblNombreJugador);

        lblCasa = new javax.swing.JLabel();
        lblCasa.setText("Casa: Gryffindor");
        lblCasa.setForeground(java.awt.Color.WHITE);
        lblCasa.setBounds(20,60,250,30);
        panelJugador.add(lblCasa);

        lblNivelMagia = new javax.swing.JLabel();
        lblNivelMagia.setText("Nivel de Magia: 10");
        lblNivelMagia.setForeground(java.awt.Color.WHITE);
        lblNivelMagia.setBounds(20,100,250,30);
        panelJugador.add(lblNivelMagia);

        lblUbicacion = new javax.swing.JLabel();
        lblUbicacion.setText("Ubicación: Gran Comedor");
        lblUbicacion.setForeground(java.awt.Color.WHITE);
        lblUbicacion.setBounds(20,140,250,30);
        panelJugador.add(lblUbicacion);

        panelAcciones = new javax.swing.JPanel();
        panelAcciones.setLayout(null);
        panelAcciones.setBackground(new java.awt.Color(55,55,55));
        panelAcciones.setBounds(360,90,580,220);
        panelPrincipal.add(panelAcciones);

        btnExplorar = new JButton("Explorar Hogwarts");
        btnExplorar.setBounds(30,30,220,40);
        panelAcciones.add(btnExplorar);

        btnHablar = new JButton("Hablar con Personaje");
        btnHablar.setBounds(300,30,220,40);
        panelAcciones.add(btnHablar);

        btnAprender = new JButton("Aprender Hechizo");
        btnAprender.setBounds(30,100,220,40);
        panelAcciones.add(btnAprender);

        btnUsarHechizo = new JButton("Usar Hechizo");
        btnUsarHechizo.setBounds(300,100,220,40);
        panelAcciones.add(btnUsarHechizo);

        btnInventario = new JButton("Inventario");
        btnInventario.setBounds(30,160,220,40);
        panelAcciones.add(btnInventario);

        btnSalir = new JButton("Salir");
        btnSalir.setBounds(300,160,220,40);
        panelAcciones.add(btnSalir);

        lblHechizos = new javax.swing.JLabel();
        lblHechizos.setText("Hechizos Disponibles");
        lblHechizos.setForeground(java.awt.Color.WHITE);
        lblHechizos.setBounds(30,330,200,30);
        panelPrincipal.add(lblHechizos);

        comboHechizos = new JComboBox<>();
        comboHechizos.setModel(
                new DefaultComboBoxModel<>(
                        new String[]{"Lumos","Expelliarmus","Expecto Patronum"}
                )
        );
        comboHechizos.setBounds(30,370,250,40);
        panelPrincipal.add(comboHechizos);

        panelMisiones = new javax.swing.JPanel();
        panelMisiones.setLayout(null);
        panelMisiones.setBackground(new java.awt.Color(45,45,45));
        panelMisiones.setBounds(360,330,580,250);
        panelPrincipal.add(panelMisiones);

        lblObjetivos = new javax.swing.JLabel();
        lblObjetivos.setText("Misiones Actuales");
        lblObjetivos.setForeground(java.awt.Color.WHITE);
        lblObjetivos.setBounds(20,10,200,30);
        panelMisiones.add(lblObjetivos);

        listaMisiones = new JList<>();

        DefaultListModel<String> modelo = new DefaultListModel<>();
        modelo.addElement("Aprender Lumos");
        modelo.addElement("Hablar con Dumbledore");
        modelo.addElement("Explorar el Bosque Prohibido");

        listaMisiones.setModel(modelo);

        scrollMisiones = new javax.swing.JScrollPane(listaMisiones);
        scrollMisiones.setBounds(20,50,530,170);
        panelMisiones.add(scrollMisiones);

        setContentPane(panelPrincipal);

        revalidate();
        repaint();
    }

    public JButton getBtnExplorar() { return btnExplorar; }
    public JButton getBtnHablar() { return btnHablar; }
    public JButton getBtnAprender() { return btnAprender; }
    public JButton getBtnUsarHechizo() { return btnUsarHechizo; }
    public JButton getBtnInventario() { return btnInventario; }
    public JButton getBtnSalir() { return btnSalir; }

    public JComboBox<String> getComboHechizos() { return comboHechizos; }
    public JList<String> getListaMisiones() { return listaMisiones; }
    
    public JLabel getLblUbicacion() { return lblUbicacion; }
    public JLabel getLblNivelMagia() { return lblNivelMagia; }
    public JLabel getLblNombreJugador() { return lblNombreJugador; }
    public JLabel getLblCasa() { return lblCasa; }

    
    @SuppressWarnings("unchecked")
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
        
        java.awt.EventQueue.invokeLater(() -> new JFHogwarts().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
