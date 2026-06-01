package Controlador;

import Modelo.Chavo;
import Modelo.Quico;
import Modelo.DonaFlorinda;
import Modelo.DonRamon;
import Modelo.Personaje;
import java.util.HashMap;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
interface IControlador {
    public void accionInteractuar();
    public void accionDialogar();
    public void accionMover();
    public void accionFinalizar();
}

public class ControladorInteraccion implements IControlador {

    private JComboBox<String> cmbBoxPersonaje1;
    private JComboBox<String> cmbBoxPersonaje2;
    private JTextArea AreaResults;
    private HashMap<String, Personaje> personajes;
    public ControladorInteraccion(JComboBox<String> cmbBoxPersonaje1,JComboBox<String> cmbBoxPersonaje2,JTextArea AreaResults) {

        this.cmbBoxPersonaje1 = cmbBoxPersonaje1;
        this.cmbBoxPersonaje2 = cmbBoxPersonaje2;
        this.AreaResults = AreaResults;

        personajes = new HashMap<>();
        cargarPersonajes();
    }

    private void cargarPersonajes() {
        personajes.put("El Chavo",new Chavo());
        personajes.put("Quico",new Quico());
        personajes.put("Doña Florinda",new DonaFlorinda());
        personajes.put("Don Ramon",new DonRamon());

        for (String nombre : personajes.keySet()) {
            cmbBoxPersonaje1.addItem(nombre);
            cmbBoxPersonaje2.addItem(nombre);
        }
    }

    @Override
    public void accionInteractuar() {
        try {
            String nombre1 = (String) cmbBoxPersonaje1.getSelectedItem();
            String nombre2 = (String) cmbBoxPersonaje2.getSelectedItem();

            if (nombre1.equals(nombre2)) {
                AreaResults.append("Selecciona personajes diferentes.\n");
                return;
            }

            Personaje p1 = personajes.get(nombre1);
            Personaje p2 = personajes.get(nombre2);

            AreaResults.append("=== INTERACCION ===\n");

            if (p1 instanceof Chavo) {
                Chavo c = (Chavo) p1;
                AreaResults.append(c.pedirTorta() + "\n");

            } else if (p1 instanceof Quico) {
                Quico q = (Quico) p1;
                AreaResults.append(q.jugarPelota() + "\n");

            } else if (p1 instanceof DonaFlorinda) {
                DonaFlorinda f = (DonaFlorinda) p1;
                if (p2 instanceof DonRamon) {
                    DonRamon dr = (DonRamon) p2;
                    AreaResults.append(f.golpearDonRamon(dr) + "\n");
                } else {
                    AreaResults.append(f.darTorta() + "\n");
                }

            } else if (p1 instanceof DonRamon) {
                DonRamon dr = (DonRamon) p1;
                AreaResults.append(dr.enojarse() + "\n");
            }

        } catch (Exception e) {
            AreaResults.append("Error en interaccion: " + e.getMessage() + "\n");
        }
    }

    @Override
    public void accionDialogar() {
        try {
            String nombre1 = (String) cmbBoxPersonaje1.getSelectedItem();
            String nombre2 = (String) cmbBoxPersonaje2.getSelectedItem();

            if (nombre1.equals(nombre2)) {
                AreaResults.append("Selecciona personajes diferentes.\n");
                return;
            }

            Personaje p1 = personajes.get(nombre1);
            Personaje p2 = personajes.get(nombre2);

            AreaResults.append("=== DIALOGO ===\n");
            AreaResults.append(p1.getNombre() + ": " + obtenerFrase(nombre1, nombre2) + "\n");
            AreaResults.append(p2.getNombre() + ": " + obtenerFrase(nombre2, nombre1) + "\n");

        } catch (Exception e) {
            AreaResults.append("Error en dialogo: " + e.getMessage() + "\n");
        }
    }

    @Override
    public void accionMover() {
        try {
            String nombre1 = (String) cmbBoxPersonaje1.getSelectedItem();
            Personaje p1   = personajes.get(nombre1);

            AreaResults.append("=== MOVIMIENTO ===\n");
            AreaResults.append(p1.movilizarse() + "\n");

        } catch (Exception e) {
            AreaResults.append("Error al mover: " + e.getMessage() + "\n");
        }
    }

    @Override
    public void accionFinalizar() {
        try {
            AreaResults.append("=== FIN DEL PROCESO ===\n");
            AreaResults.append("Hasta la proxima en la vecindad!\n");
            AreaResults.append("-------------------------------\n");
            AreaResults.setText("");
            cmbBoxPersonaje1.setSelectedIndex(0);
            cmbBoxPersonaje2.setSelectedIndex(0);

        } catch (Exception e) {
            AreaResults.append("Error al finalizar: " + e.getMessage() + "\n");
        }
    }

    private String obtenerFrase(String quien, String conQuien) {
        try {
            Personaje p1 = personajes.get(quien);
            Personaje p2 = personajes.get(conQuien);
            
            if (p1 instanceof Chavo) {
                Chavo c = (Chavo) p1;
                return c.pedirTorta();

            } else if (p1 instanceof Quico) {
                Quico q = (Quico) p1;
                return q.jugarPelota();

            } else if (p1 instanceof DonaFlorinda) {
                DonaFlorinda f = (DonaFlorinda) p1;
                if (p2 instanceof DonRamon) {
                    DonRamon dr = (DonRamon) p2;
                    return f.golpearDonRamon(dr);
                } else {
                    return f.darTorta();
                }

            } else if (p1 instanceof DonRamon) {
                DonRamon dr = (DonRamon) p1;
                return dr.enojarse();
            }

        } catch (Exception e) {
            return "Error al obtener frase: " + e.getMessage();
        }
        return "Buenos dias, vecino!";
    }
}