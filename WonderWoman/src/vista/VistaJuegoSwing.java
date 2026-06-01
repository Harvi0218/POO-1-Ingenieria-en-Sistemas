package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JProgressBar;
import javax.swing.BorderFactory;
import javax.swing.SwingUtilities;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;

public class VistaJuegoSwing extends JFrame
{
    // =========================================================
    // COLORES NUEVOS
    // =========================================================

    private static final Color COLOR_FONDO       = new Color(8, 12, 25);
    private static final Color COLOR_PANEL       = new Color(18, 28, 45);

    private static final Color COLOR_CYAN        = new Color(0, 220, 255);
    private static final Color COLOR_MORADO      = new Color(160, 90, 255);

    private static final Color COLOR_ROJO        = new Color(255, 70, 70);
    private static final Color COLOR_VERDE       = new Color(80, 255, 170);

    private static final Color COLOR_TEXTO       = new Color(230, 240, 255);

    private static final Color COLOR_LOG         = new Color(10, 18, 30);

    // =========================================================
    // FUENTES
    // =========================================================

    private static final Font FUENTE_TITULO =
            new Font("Arial", Font.BOLD, 24);

    private static final Font FUENTE_LABEL =
            new Font("Arial", Font.BOLD, 14);

    private static final Font FUENTE_NORMAL =
            new Font("Arial", Font.PLAIN, 13);

    private static final Font FUENTE_LOG =
            new Font("Consolas", Font.PLAIN, 12);

    private static final Font FUENTE_BOTON =
            new Font("Arial", Font.BOLD, 12);

    // =========================================================
    // COMPONENTES
    // =========================================================

    private JLabel lblEscenario;

    private JLabel lblSaludDianaNum;
    private JLabel lblSaludAresNum;

    private JProgressBar barSaludDiana;
    private JProgressBar barSaludAres;

    private JLabel lblModoFuria;
    private JLabel lblTurno;

    private JTextArea areaLog;

    private JLabel lblNombreHablante;
    private JLabel lblDialogo;

    // =========================================================
    // BOTONES PUBLICOS
    // =========================================================

    public JButton btnAtacar;
    public JButton btnFuria;
    public JButton btnLazo;
    public JButton btnEscudo;
    public JButton btnDialogo;
    public JButton btnNuevoJuego;

    // =========================================================
    // CONSTRUCTOR
    // =========================================================

    public VistaJuegoSwing()
    {
        configurarVentana();
        construirUI();
    }

    // =========================================================
    // CONFIGURAR VENTANA
    // =========================================================

    private void configurarVentana()
    {
        setTitle("Wonder Woman - Ultimate Edition");

        setSize(850, 640);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        setResizable(false);

        getContentPane().setBackground(COLOR_FONDO);

        setLayout(new BorderLayout(8, 8));
    }

    // =========================================================
    // CONSTRUIR INTERFAZ
    // =========================================================

    private void construirUI()
    {
        add(crearPanelTitulo(), BorderLayout.NORTH);

        add(crearPanelCentral(), BorderLayout.CENTER);

        add(crearPanelBotones(), BorderLayout.SOUTH);
    }

    // =========================================================
    // PANEL TITULO
    // =========================================================

    private JPanel crearPanelTitulo()
    {
        JPanel panel = new JPanel(new BorderLayout());

        panel.setBackground(COLOR_PANEL);

        panel.setBorder(
                BorderFactory.createEmptyBorder(
                        12,
                        18,
                        12,
                        18
                )
        );

        JLabel lblTitulo =
                new JLabel("⚡ WONDER WOMAN");

        lblTitulo.setForeground(COLOR_CYAN);

        lblTitulo.setFont(FUENTE_TITULO);

        lblEscenario =
                new JLabel("Escenario: Themyscira");

        lblEscenario.setForeground(COLOR_TEXTO);

        lblEscenario.setFont(FUENTE_LABEL);

        panel.add(lblTitulo, BorderLayout.WEST);

        panel.add(lblEscenario, BorderLayout.EAST);

        return panel;
    }

    // =========================================================
    // PANEL CENTRAL
    // =========================================================

    private JPanel crearPanelCentral()
    {
        JPanel panel = new JPanel(new BorderLayout(8, 8));

        panel.setBackground(COLOR_FONDO);

        panel.setBorder(
                BorderFactory.createEmptyBorder(
                        10,
                        10,
                        10,
                        10
                )
        );

        panel.add(crearPanelVidas(), BorderLayout.NORTH);

        panel.add(crearPanelLog(), BorderLayout.CENTER);

        panel.add(crearPanelDialogo(), BorderLayout.SOUTH);

        return panel;
    }

    // =========================================================
    // PANEL VIDAS
    // =========================================================

    private JPanel crearPanelVidas()
    {
        JPanel panel = new JPanel(new GridLayout(1, 2, 20, 0));

        panel.setBackground(COLOR_FONDO);

        // =====================================================
        // PANEL DIANA
        // =====================================================

        JPanel panelDiana = new JPanel(new BorderLayout(5, 5));

        panelDiana.setBackground(COLOR_PANEL);

        panelDiana.setBorder(
                BorderFactory.createTitledBorder(
                        BorderFactory.createLineBorder(
                                COLOR_CYAN,
                                2
                        ),
                        "Wonder Woman",
                        0,
                        0,
                        FUENTE_LABEL,
                        COLOR_CYAN
                )
        );

        lblSaludDianaNum =
                new JLabel("100 / 100");

        lblSaludDianaNum.setForeground(COLOR_TEXTO);

        lblSaludDianaNum.setFont(FUENTE_NORMAL);

        barSaludDiana =
                new JProgressBar(0, 100);

        barSaludDiana.setValue(100);

        barSaludDiana.setForeground(COLOR_VERDE);

        barSaludDiana.setBackground(new Color(30, 30, 40));

        barSaludDiana.setBorderPainted(false);

        lblModoFuria =
                new JLabel("Modo furia: OFF");

        lblModoFuria.setForeground(COLOR_TEXTO);

        lblModoFuria.setFont(FUENTE_NORMAL);

        panelDiana.add(barSaludDiana, BorderLayout.CENTER);

        panelDiana.add(lblSaludDianaNum, BorderLayout.NORTH);

        panelDiana.add(lblModoFuria, BorderLayout.SOUTH);

        // =====================================================
        // PANEL ARES
        // =====================================================

        JPanel panelAres = new JPanel(new BorderLayout(5, 5));

        panelAres.setBackground(COLOR_PANEL);

        panelAres.setBorder(
                BorderFactory.createTitledBorder(
                        BorderFactory.createLineBorder(
                                COLOR_ROJO,
                                2
                        ),
                        "Ares",
                        0,
                        0,
                        FUENTE_LABEL,
                        COLOR_ROJO
                )
        );

        lblSaludAresNum =
                new JLabel("200 / 200");

        lblSaludAresNum.setForeground(COLOR_TEXTO);

        lblSaludAresNum.setFont(FUENTE_NORMAL);

        barSaludAres =
                new JProgressBar(0, 200);

        barSaludAres.setValue(200);

        barSaludAres.setForeground(COLOR_ROJO);

        barSaludAres.setBackground(new Color(30, 30, 40));

        barSaludAres.setBorderPainted(false);

        lblTurno =
                new JLabel("Turno: 0");

        lblTurno.setForeground(COLOR_TEXTO);

        lblTurno.setFont(FUENTE_NORMAL);

        panelAres.add(barSaludAres, BorderLayout.CENTER);

        panelAres.add(lblSaludAresNum, BorderLayout.NORTH);

        panelAres.add(lblTurno, BorderLayout.SOUTH);

        // =====================================================
        // AGREGAR PANELES
        // =====================================================

        panel.add(panelDiana);

        panel.add(panelAres);

        return panel;
    }

    // =========================================================
    // PANEL LOG
    // =========================================================

    private JPanel crearPanelLog()
    {
        JPanel panel = new JPanel(new BorderLayout());

        panel.setBackground(COLOR_FONDO);

        JLabel lblTituloLog =
                new JLabel("REGISTRO DE BATALLA");

        lblTituloLog.setForeground(COLOR_MORADO);

        lblTituloLog.setFont(FUENTE_LABEL);

        areaLog = new JTextArea();

        areaLog.setEditable(false);

        areaLog.setBackground(COLOR_LOG);

        areaLog.setForeground(COLOR_TEXTO);

        areaLog.setFont(FUENTE_LOG);

        areaLog.setLineWrap(true);

        areaLog.setWrapStyleWord(true);

        JScrollPane scroll =
                new JScrollPane(areaLog);

        scroll.setBorder(
                BorderFactory.createLineBorder(
                        COLOR_MORADO,
                        1
                )
        );

        panel.add(lblTituloLog, BorderLayout.NORTH);

        panel.add(scroll, BorderLayout.CENTER);

        return panel;
    }

    // =========================================================
    // PANEL DIALOGO
    // =========================================================

    private JPanel crearPanelDialogo()
    {
        JPanel panel = new JPanel(new BorderLayout());

        panel.setBackground(COLOR_PANEL);

        panel.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                COLOR_MORADO,
                                1
                        ),
                        BorderFactory.createEmptyBorder(
                                8,
                                10,
                                8,
                                10
                        )
                )
        );

        lblNombreHablante =
                new JLabel("...");

        lblNombreHablante.setForeground(COLOR_CYAN);

        lblNombreHablante.setFont(FUENTE_LABEL);

        lblDialogo =
                new JLabel("...");

        lblDialogo.setForeground(COLOR_TEXTO);

        lblDialogo.setFont(FUENTE_NORMAL);

        panel.add(lblNombreHablante, BorderLayout.WEST);

        panel.add(lblDialogo, BorderLayout.CENTER);

        return panel;
    }

    // =========================================================
    // PANEL BOTONES
    // =========================================================

    private JPanel crearPanelBotones()
    {
        JPanel panel =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.CENTER,
                                12,
                                10
                        )
                );

        panel.setBackground(COLOR_PANEL);

        btnAtacar =
                crearBoton("⚔ Atacar", COLOR_CYAN);

        btnFuria =
                crearBoton("🔥 Furia", COLOR_ROJO);

        btnLazo =
                crearBoton("🌀 Lazo", COLOR_MORADO);

        btnEscudo =
                crearBoton("🛡 Escudo", COLOR_VERDE);

        btnDialogo =
                crearBoton("💬 Hablar", COLOR_CYAN);

        btnNuevoJuego =
                crearBoton("↺ Reiniciar", COLOR_MORADO);

        panel.add(btnAtacar);
        panel.add(btnFuria);
        panel.add(btnLazo);
        panel.add(btnEscudo);
        panel.add(btnDialogo);
        panel.add(btnNuevoJuego);

        return panel;
    }

    // =========================================================
    // CREAR BOTON
    // =========================================================

    private JButton crearBoton(
            String texto,
            Color color
    )
    {
        JButton boton = new JButton(texto);

        boton.setFont(FUENTE_BOTON);

        boton.setBackground(color);

        boton.setForeground(Color.BLACK);

        boton.setFocusPainted(false);

        boton.setPreferredSize(
                new Dimension(125, 38)
        );

        return boton;
    }

    // =========================================================
    // METODOS PARA EL CONTROLADOR
    // =========================================================

    public void actualizarSaludDiana(
            int salud,
            int maxSalud
    )
    {
        barSaludDiana.setMaximum(maxSalud);

        barSaludDiana.setValue(
                Math.max(salud, 0)
        );

        lblSaludDianaNum.setText(
                salud + " / " + maxSalud
        );
    }

    public void actualizarSaludAres(
            int salud,
            int maxSalud
    )
    {
        barSaludAres.setMaximum(maxSalud);

        barSaludAres.setValue(
                Math.max(salud, 0)
        );

        lblSaludAresNum.setText(
                salud + " / " + maxSalud
        );
    }

    public void actualizarEscenario(
            String nombre,
            String ubicacion
    )
    {
        lblEscenario.setText(
                "Escenario: "
                        + nombre
                        + " - "
                        + ubicacion
        );
    }

    public void actualizarModoFuria(boolean activo)
    {
        if (activo)
        {
            lblModoFuria.setText(
                    "🔥 FURIA ACTIVADA"
            );

            lblModoFuria.setForeground(COLOR_ROJO);
        }
        else
        {
            lblModoFuria.setText(
                    "Modo furia: OFF"
            );

            lblModoFuria.setForeground(COLOR_TEXTO);
        }
    }

    public void actualizarTurno(int turno)
    {
        lblTurno.setText(
                "Turno: " + turno
        );
    }

    public void escribirLog(String mensaje)
    {
        areaLog.append(mensaje + "\n");

        areaLog.setCaretPosition(
                areaLog.getDocument().getLength()
        );
    }

    public void escribirLogDestacado(String mensaje)
    {
        areaLog.append(
                "\n>>> "
                        + mensaje
                        + " <<<\n\n"
        );

        areaLog.setCaretPosition(
                areaLog.getDocument().getLength()
        );
    }

    public void limpiarLog()
    {
        areaLog.setText("");
    }

    public void mostrarDialogo(
            String personaje,
            String texto
    )
    {
        lblNombreHablante.setText(
                personaje + ": "
        );

        lblDialogo.setText(texto);
    }

    public void habilitarBotones(boolean estado)
    {
        btnAtacar.setEnabled(estado);

        btnFuria.setEnabled(estado);

        btnLazo.setEnabled(estado);

        btnEscudo.setEnabled(estado);

        btnDialogo.setEnabled(estado);
    }

    public void deshabilitarBoton(
            JButton boton
    )
    {
        boton.setEnabled(false);

        boton.setBackground(
                new Color(80, 80, 80)
        );
    }

    public void mostrar()
    {
        SwingUtilities.invokeLater(
                () -> setVisible(true)
        );
    }
}