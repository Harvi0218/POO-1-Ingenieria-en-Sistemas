package Controlador;

import Modelo.Votacion;
import vista.JFPersonero;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import Modelo.CandidatoPersonero;

public class ControladorPersonero implements ActionListener {
    
    private JFPersonero frmPersonero;
    private Votacion votacion;
    private ArrayList<CandidatoPersonero> listaPersoneros;
    
    public ControladorPersonero(JFPersonero frmPersonero, 
                                 Votacion votacion, 
                                 ArrayList<CandidatoPersonero> listaPersoneros) {
        this.frmPersonero = frmPersonero;
        this.votacion = votacion;
        this.listaPersoneros = listaPersoneros;
        
        this.frmPersonero.btnVotar.addActionListener(this);
        this.frmPersonero.btnVotoBlanco.addActionListener(this);
        this.frmPersonero.btnMostrar.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmPersonero.btnVotar) {
            votar();
        } else if (e.getSource() == frmPersonero.btnVotoBlanco) {
            votarBlanco();
        } else if (e.getSource() == frmPersonero.btnMostrar) {
            mostrar();
        }
    }
    
    private void votar() {
        int indice = frmPersonero.cmbPersonero.getSelectedIndex();
        CandidatoPersonero candidato = listaPersoneros.get(indice);
        votacion.registrarVoto(candidato);
        JOptionPane.showMessageDialog(null, "Voto registrado para: " 
                                      + candidato.getNombre());
    }
    
    private void votarBlanco() {
        votacion.registrarVotoBlanco();
        JOptionPane.showMessageDialog(null, "Voto en blanco registrado!");
    }
    
    private void mostrar() {
        String resultado = "";
        for (CandidatoPersonero c : listaPersoneros) {
            resultado += c.getNombre() + " " + c.getApellido() 
                      + ": " + c.obtenerVotos() + " votos\n";
        }
        frmPersonero.txtAreaResult.setText(resultado);
    }
}