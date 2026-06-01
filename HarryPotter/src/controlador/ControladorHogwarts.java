package controlador;

import modelo.*;
import vista.JFHogwarts;
import javax.swing.*;
import java.awt.event.*;
import java.util.List;

public class ControladorHogwarts implements ActionListener {

    private JFHogwarts vista;
    private GestorJuego gestor;

    public ControladorHogwarts(JFHogwarts vista) {
        this.vista = vista;
        this.gestor = new GestorJuego(new Usuario("Harry Potter", Casa.GRYFFINDOR, 10, "Varita de Fénix"));
        iniciarEventos();
    }

    private void iniciarEventos() {
        vista.getBtnExplorar().addActionListener(this);
        vista.getBtnHablar().addActionListener(this);
        vista.getBtnAprender().addActionListener(this);
        vista.getBtnUsarHechizo().addActionListener(this);
        vista.getBtnInventario().addActionListener(this);
        vista.getBtnSalir().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.getBtnExplorar()) {
            ejecutarExplorar();
        } else if (e.getSource() == vista.getBtnHablar()) {
            ejecutarHablar();
        } else if (e.getSource() == vista.getBtnAprender()) {
            ejecutarAprenderHechizo();
        } else if (e.getSource() == vista.getBtnUsarHechizo()) {
            ejecutarUsarHechizo();
        } else if (e.getSource() == vista.getBtnInventario()) {
            ejecutarInventario();
        } else if (e.getSource() == vista.getBtnSalir()) {
            ejecutarSalir();
        }
    }

    private void ejecutarExplorar() {
        String[] lugares = {"Gran Comedor", "Bosque Prohibido", "Cabaña de Hagrid", "Biblioteca", "Campo de Quidditch"};
        String destinoSeleccionado = (String) JOptionPane.showInputDialog(vista, "Selecciona lugar:", "Explorar", JOptionPane.QUESTION_MESSAGE, null, lugares, lugares[0]);

        if (destinoSeleccionado != null) {
            gestor.moverA(destinoSeleccionado);
            vista.getLblUbicacion().setText("Ubicación: " + gestor.getEscenarioActual().getNombre());
            
            if (destinoSeleccionado.equals("Bosque Prohibido")) {
                borrarMision("bosque prohibido");
            }
            
            if (Math.random() <= 0.40) {
                List<Hechizo> hechizosConocidos = gestor.getJugador().getHechizos();
                
                if (hechizosConocidos.isEmpty()) {
                    JOptionPane.showMessageDialog(vista, "¡Te ha emboscado un enemigo!\nComo no has asistido a clases y no sabes hechizos, tuviste que huir.", "Duelo Inesperado", JOptionPane.WARNING_MESSAGE);
                } else {
                    String[] nombresHechizos = hechizosConocidos.stream().map(Hechizo::getNombre).toArray(String[]::new);
                    String hechizoElegido = (String) JOptionPane.showInputDialog(vista, 
                            "¡Alerta! Te ha emboscado un enemigo.\nSelecciona el hechizo para defenderte:", 
                            "Duelo Inesperado", JOptionPane.WARNING_MESSAGE, null, nombresHechizos, nombresHechizos[0]);
                    
                    if (hechizoElegido != null) {
                        JOptionPane.showMessageDialog(vista, "¡Lanzaste " + hechizoElegido + "!");
                        
                        // Lógica de combate (que internamente suma los bonos del RF5)
                        if (gestor.intentarDuelo()) {
                            JOptionPane.showMessageDialog(vista, "¡Victoria! Subes 2 niveles.");
                            vista.getLblNivelMagia().setText("Nivel de Magia: " + gestor.getJugador().getNivelMagia());
                        } else {
                            JOptionPane.showMessageDialog(vista, "Has sido derrotado.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(vista, "Dudaste demasiado y has sido derrotado.");
                    }
                }
            } else {
                if (Math.random() <= 0.50) {
                    String nombreObjeto = obtenerObjetoPorLugar(destinoSeleccionado);
                    int bonoPoder = obtenerBonoPorObjeto(nombreObjeto);
                    gestor.getJugador().getInventario().add(new ObjetoMagico(nombreObjeto, "Encontrado en " + destinoSeleccionado, bonoPoder));
                    JOptionPane.showMessageDialog(vista, "¡Has encontrado: " + nombreObjeto + "!\nEste objeto te dará ventaja en los duelos.");
                } else {
                    JOptionPane.showMessageDialog(vista, "Has llegado a " + destinoSeleccionado + ". Todo está tranquilo.");
                }
            }
        }
    }

    private void ejecutarHablar() {
        String ubicacionActual = gestor.getEscenarioActual().getNombre();
        String[] personajes;

        switch (ubicacionActual) {
            case "Gran Comedor": personajes = new String[]{"Dumbledore", "McGonagall"}; break;
            case "Bosque Prohibido": personajes = new String[]{"Centauro Firenze", "Aragog"}; break;
            case "Cabaña de Hagrid": personajes = new String[]{"Hagrid", "Fang"}; break;
            case "Biblioteca": personajes = new String[]{"Madam Pince", "Hermione"}; break;
            case "Campo de Quidditch": personajes = new String[]{"Madam Hooch", "Oliver Wood"}; break;
            default: personajes = new String[]{"Estudiante anónimo"}; break;
        }

        String npc = (String) JOptionPane.showInputDialog(vista, "Elige personaje:", "Personajes", JOptionPane.QUESTION_MESSAGE, null, personajes, personajes[0]);

        if (npc != null) {
            String respuesta;
            switch(npc) {
                case "Dumbledore": respuesta = "La felicidad se puede hallar hasta en los momentos más oscuros."; break;
                case "McGonagall": respuesta = "Por favor, compórtese."; break;
                case "Centauro Firenze": respuesta = "Marte brilla mucho esta noche."; break;
                case "Aragog": respuesta = "¡Mis hijos tienen hambre!"; break;
                case "Hagrid": respuesta = "¡No debí decir eso!"; break;
                case "Fang": respuesta = "*Guau guau*"; break;
                case "Madam Pince": respuesta = "¡Silencio absoluto!"; break;
                case "Hermione": respuesta = "Es LeviOsa, no LeviosÁ."; break;
                case "Madam Hooch": respuesta = "¡Juego limpio!"; break;
                case "Oliver Wood": respuesta = "¡Concéntrate en la Snitch!"; break;
                default: respuesta = "Hola."; break;
            }
            JOptionPane.showMessageDialog(vista, npc + ":\n\"" + respuesta + "\"");
            if (npc.equals("Dumbledore")) {
                borrarMision("dumbledore");
            }
        }
    }

    private void ejecutarAprenderHechizo() {
        String hechizoSeleccionado = (String) vista.getComboHechizos().getSelectedItem();
        int nivelRequerido = gestor.getNivelNecesario(hechizoSeleccionado);
        Usuario jugador = gestor.getJugador();

        if (jugador.getHechizos().stream().anyMatch(h -> h.getNombre().equals(hechizoSeleccionado))) {
            JOptionPane.showMessageDialog(vista, "Ya conoces este hechizo.");
            return;
        }

        int confirmarClase = JOptionPane.showConfirmDialog(vista, 
                "¿Deseas asistir a la clase para aprender " + hechizoSeleccionado + "?\nRequiere nivel: " + nivelRequerido, 
                "Asistir a Clase", JOptionPane.YES_NO_OPTION);

        if (confirmarClase == JOptionPane.YES_OPTION) {
            if (jugador.getNivelMagia() >= nivelRequerido) {
                jugador.aprenderHechizo(new Hechizo(hechizoSeleccionado, 20, Elemento.AIRE, nivelRequerido));
                JOptionPane.showMessageDialog(vista, "Has asistido a clase y aprendido: " + hechizoSeleccionado);
            } else {
                JOptionPane.showMessageDialog(vista, "Nivel insuficiente para esta clase. Necesitas: " + nivelRequerido + "\nTu nivel actual es: " + jugador.getNivelMagia());
            }
        }
    }

    private void ejecutarUsarHechizo() {
        String sel = (String) vista.getComboHechizos().getSelectedItem();
        if (gestor.getJugador().getHechizos().stream().anyMatch(h -> h.getNombre().equals(sel))) {
            JOptionPane.showMessageDialog(vista, "¡Lanzaste " + sel + "!");
            borrarMision(sel);
        } else {
            JOptionPane.showMessageDialog(vista, "Primero debes aprender el hechizo en clases.");
        }
    }

    private void ejecutarInventario() {
        Usuario jugador = gestor.getJugador();
        if (jugador.getInventario().isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Tu inventario está vacío.");
        } else {
            StringBuilder objetos = new StringBuilder("Inventario:\n");
            for (ObjetoMagico obj : jugador.getInventario()) {
                objetos.append("- ").append(obj.getNombre()).append("\n");
            }
            JOptionPane.showMessageDialog(vista, objetos.toString());
        }
    }

    private void ejecutarSalir() {
        if (JOptionPane.showConfirmDialog(vista, "¿Salir?", "Salir", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    private void borrarMision(String palabraClave) {
        DefaultListModel<String> model = (DefaultListModel<String>) vista.getListaMisiones().getModel();
        for (int i = 0; i < model.size(); i++) {
            if (model.getElementAt(i).toLowerCase().contains(palabraClave.toLowerCase())) {
                model.removeElementAt(i);
                break;
            }
        }
        
        if (model.isEmpty()) {
            JOptionPane.showMessageDialog(vista, 
                "¡Felicidades! Has completado todas las misiones.\n¡Eres un verdadero mago de Hogwarts!", 
                "¡Victoria!", 
                JOptionPane.INFORMATION_MESSAGE);
            
            if (JOptionPane.showConfirmDialog(vista, "¿Deseas salir del juego?", "Fin del Juego", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }
    }

    private String obtenerObjetoPorLugar(String lugar) {
        switch (lugar) {
            case "Gran Comedor": return "Rana de Chocolate";
            case "Bosque Prohibido": return "Pelo de Unicornio";
            case "Cabaña de Hagrid": return "Pastel de Roca";
            case "Biblioteca": return "Libro de Pociones";
            case "Campo de Quidditch": return "Snitch Dorada";
            default: return "Galeón de Oro";
        }
    }

    private int obtenerBonoPorObjeto(String nombreObjeto) {
        switch (nombreObjeto) {
            case "Pelo de Unicornio": return 3;
            case "Libro de Pociones": return 2;
            case "Rana de Chocolate": return 1;
            case "Snitch Dorada": return 2;
            default: return 0;
        }
    }
}