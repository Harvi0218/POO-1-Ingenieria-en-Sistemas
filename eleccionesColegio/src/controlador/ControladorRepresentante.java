package Controlador;

import Modelo.CandidatoRepresentante;
import Modelo.Votacion;
import vista.JFRepresentante;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ControladorRepresentante implements ActionListener {
    
    private JFRepresentante frmRepresentante;
    private Votacion votacion;
    private ArrayList<CandidatoRepresentante> listaRepresentantes;
    
    public ControladorRepresentante(JFRepresentante frmRepresentante, 
                                     Votacion votacion, 
                                     ArrayList<CandidatoRepresentante> listaRepresentantes) {
        this.frmRepresentante = frmRepresentante;
        this.votacion = votacion;
        this.listaRepresentantes = listaRepresentantes;
        
        this.frmRepresentante.btnVotarRp.addActionListener(this);
        this.frmRepresentante.btnVotoBlancoRp.addActionListener(this);
        this.frmRepresentante.btnMostrarRp.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmRepresentante.btnVotarRp) {
            votar();
        } else if (e.getSource() == frmRepresentante.btnVotoBlancoRp) {
            votarBlanco();
        } else if (e.getSource() == frmRepresentante.btnMostrarRp) {
            mostrar();
        }
    }
    
    private void votar() {
        int indice = frmRepresentante.cmbPersonero.getSelectedIndex();
        CandidatoRepresentante candidato = listaRepresentantes.get(indice);
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
        for (CandidatoRepresentante c : listaRepresentantes) {
            resultado += c.getNombre() + " " + c.getApellido() 
                      + ": " + c.obtenerVotos() + " votos\n";
        }
        frmRepresentante.txtAreaResultRp.setText(resultado);
    }
}
