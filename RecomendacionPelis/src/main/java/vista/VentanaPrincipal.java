package vista;

import controlador.Controlador;
import modelo.Pelicula;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class VentanaPrincipal extends JFrame {

    private Controlador controlador;

    // --- COMPONENTES ---
    // Login
    private JLabel lblNombre;
    private JTextField txtNombre;
    private JButton btnLogin;
    private JButton btnRegistrar;

    // Registro
    private JLabel lblEmail;
    private JTextField txtEmail;
    private JLabel lblGenero;
    private JComboBox<String> cboGenero;

    // Buscar
    private JLabel lblBuscar;
    private JTextField txtBuscar;
    private JComboBox<String> cboCriterioBusqueda;
    private JButton btnBuscar;

    // Catálogo y resultados
    private JLabel lblCatalogo;
    private JList<String> listaPeliculas;
    private DefaultListModel<String> modeloLista;

    // Calificar
    private JLabel lblCalificacion;
    private JSpinner spinnerCal;
    private JLabel lblComentario;
    private JTextField txtComentario;
    private JButton btnCalificar;

    // Recomendaciones e Historial
    private JButton btnRecomendaciones;
    private JButton btnHistorial;
    private JButton btnVerCatalogo;

    // Área de texto para mostrar info
    private JTextArea areaInfo;

    public VentanaPrincipal() {
        setTitle("Sistema de Recomendacion de Peliculas");
        setSize(700, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(5, 5));

        // Panel superior: Login y Registro
        JPanel panelTop = new JPanel(new GridLayout(2, 1, 3, 3));
        panelTop.setBorder(BorderFactory.createTitledBorder("Usuario"));

        // Fila 1: Login
        JPanel filaLogin = new JPanel(new FlowLayout(FlowLayout.LEFT));
        lblNombre = new JLabel("Nombre:");
        txtNombre = new JTextField(15);
        btnLogin = new JButton("Iniciar Sesion");
        filaLogin.add(lblNombre);
        filaLogin.add(txtNombre);
        filaLogin.add(btnLogin);

        // Fila 2: Registro
        JPanel filaRegistro = new JPanel(new FlowLayout(FlowLayout.LEFT));
        lblEmail = new JLabel("Email:");
        txtEmail = new JTextField(12);
        lblGenero = new JLabel("Genero favorito:");
        String[] generos = {"Ciencia Ficcion", "Romance", "Animacion", "Drama", "Accion", "Fantasia"};
        cboGenero = new JComboBox<>(generos);
        btnRegistrar = new JButton("Registrarse");
        filaRegistro.add(lblEmail);
        filaRegistro.add(txtEmail);
        filaRegistro.add(lblGenero);
        filaRegistro.add(cboGenero);
        filaRegistro.add(btnRegistrar);

        panelTop.add(filaLogin);
        panelTop.add(filaRegistro);

        // Panel centro izquierda: Lista de películas
        modeloLista = new DefaultListModel<>();
        listaPeliculas = new JList<>(modeloLista);
        JScrollPane scrollLista = new JScrollPane(listaPeliculas);
        scrollLista.setPreferredSize(new Dimension(320, 200));

        JPanel panelLista = new JPanel(new BorderLayout());
        panelLista.setBorder(BorderFactory.createTitledBorder("Peliculas"));

        // Barra de búsqueda dentro del panel lista
        JPanel filaBuscar = new JPanel(new FlowLayout(FlowLayout.LEFT));
        lblBuscar = new JLabel("Buscar:");
        txtBuscar = new JTextField(10);
        String[] criterios = {"Titulo", "Genero", "Director"};
        cboCriterioBusqueda = new JComboBox<>(criterios);
        btnBuscar = new JButton("Buscar");
        btnVerCatalogo = new JButton("Ver Todo");
        filaBuscar.add(lblBuscar);
        filaBuscar.add(txtBuscar);
        filaBuscar.add(cboCriterioBusqueda);
        filaBuscar.add(btnBuscar);
        filaBuscar.add(btnVerCatalogo);

        panelLista.add(filaBuscar, BorderLayout.NORTH);
        panelLista.add(scrollLista, BorderLayout.CENTER);

        // Panel centro derecha: Acciones
        JPanel panelAcciones = new JPanel(new GridLayout(6, 1, 4, 4));
        panelAcciones.setBorder(BorderFactory.createTitledBorder("Acciones"));
        panelAcciones.setPreferredSize(new Dimension(350,200));

        lblCalificacion = new JLabel("Calificacion (1-5):");
        spinnerCal = new JSpinner(new SpinnerNumberModel(5, 1, 5, 1));
        lblComentario = new JLabel("Comentario:");
        txtComentario = new JTextField();
        btnCalificar = new JButton("Calificar Pelicula");
        btnRecomendaciones = new JButton("Mis Recomendaciones");
        btnHistorial = new JButton("Mi Historial");

        panelAcciones.add(lblCalificacion);
        panelAcciones.add(spinnerCal);
        panelAcciones.add(lblComentario);
        panelAcciones.add(txtComentario);
        panelAcciones.add(btnCalificar);
        panelAcciones.add(btnRecomendaciones);
        panelAcciones.add(btnHistorial);

        // Panel centro: lista + acciones juntos
        JPanel panelCentro = new JPanel(new BorderLayout(5, 5));
        panelCentro.add(panelLista, BorderLayout.CENTER);
        panelCentro.add(panelAcciones, BorderLayout.EAST);

        // Panel inferior: área de mensajes/info
        areaInfo = new JTextArea(6, 50);
        areaInfo.setEditable(false);
        areaInfo.setText("Bienvenido. Inicia sesion para comenzar.");
        JScrollPane scrollInfo = new JScrollPane(areaInfo);
        scrollInfo.setBorder(BorderFactory.createTitledBorder("Informacion"));

        // Agregar todo al JFrame
        add(panelTop, BorderLayout.NORTH);
        add(panelCentro, BorderLayout.CENTER);
        add(scrollInfo, BorderLayout.SOUTH);
    }

    // El controlador asigna los eventos
    public void setControlador(Controlador controlador) {
        this.controlador = controlador;

        // Cargar catálogo al inicio
        cargarListaPeliculas(controlador.obtenerCatalogo());

        // Iniciar sesión
        btnLogin.addActionListener(e -> {
            String nombre = txtNombre.getText().trim();
            controlador.iniciarSesion(nombre);
        });

        // Registrar usuario
        btnRegistrar.addActionListener(e -> {
            String nombre = txtNombre.getText().trim();
            String email = txtEmail.getText().trim();
            String genero = (String) cboGenero.getSelectedItem();
            controlador.registrarUsuario(nombre, email, genero);
        });

        // Buscar películas
        btnBuscar.addActionListener(e -> {
            String criterio = (String) cboCriterioBusqueda.getSelectedItem();
            String texto = txtBuscar.getText().trim();
            ArrayList<Pelicula> resultados = controlador.buscar(criterio, texto);
            cargarListaPeliculas(resultados);
        });

        // Ver todo el catálogo
        btnVerCatalogo.addActionListener(e -> {
            cargarListaPeliculas(controlador.obtenerCatalogo());
            mostrarInfo("Mostrando catalogo completo: " + controlador.obtenerCatalogo().size() + " peliculas.");
        });

        // Calificar película seleccionada
        btnCalificar.addActionListener(e -> {
            int indice = listaPeliculas.getSelectedIndex();
            if (indice < 0) {
                mostrarInfo("Selecciona una pelicula de la lista primero.");
                return;
            }
            Pelicula pelicula = controlador.obtenerCatalogo().get(indice);
            int cal = (int) spinnerCal.getValue();
            String comentario = txtComentario.getText().trim();
            controlador.calificarPelicula(pelicula, cal, comentario);
            txtComentario.setText("");
        });

        // Ver recomendaciones
        btnRecomendaciones.addActionListener(e -> {
            ArrayList<Pelicula> recomendaciones = controlador.obtenerRecomendaciones();
            if (recomendaciones.isEmpty()) {
                mostrarInfo("No hay recomendaciones. Inicia sesion primero o califica algunas peliculas.");
            } else {
                StringBuilder sb = new StringBuilder("=== Recomendaciones para ti ===\n");
                for (Pelicula p : recomendaciones) {
                    sb.append("- ").append(p.getTitulo())
                      .append(" (").append(p.getGenero()).append(", ").append(p.getAnio()).append(")")
                      .append(" - Director: ").append(p.getDirector())
                      .append(" - Calificacion: ").append(p.getCalificacionPromedio()).append("\n");
                }
                mostrarInfo(sb.toString());
            }
        });

        // Ver historial
        btnHistorial.addActionListener(e -> {
            mostrarInfo(controlador.obtenerHistorial());
        });
    }

    // Carga una lista de películas en el JList
    public void cargarListaPeliculas(ArrayList<Pelicula> peliculas) {
        modeloLista.clear();
        for (Pelicula p : peliculas) {
            modeloLista.addElement(p.getTitulo() + " | " + p.getGenero() + " | " + p.getAnio() + " | Cal: " + p.getCalificacionPromedio());
        }
    }

    // Muestra texto en el área de información
    public void mostrarInfo(String texto) {
        areaInfo.setText(texto);
    }

    // Muestra un popup de mensaje
    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
        areaInfo.setText(mensaje);
    }
}
