
package Controlador;

import Vista.JFRegistrarLibro;
import Modelo.Libro;
import Modelo.General;
import Modelo.Referencia;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class ControladorRegistroLibro implements ActionListener {
    private JFRegistrarLibro frmRegistrarLibro;
    private ArrayList<Libro> listaLibro;
    private ControladorSolicitarLibro controladorSolicitar;

    public ControladorRegistroLibro(JFRegistrarLibro frmRegistrarLibro, ArrayList<Libro> listaLibro, ControladorSolicitarLibro controladorSolicitar) {
        this.frmRegistrarLibro = frmRegistrarLibro;
        this.listaLibro = listaLibro;
        this.controladorSolicitar = controladorSolicitar;
        this.frmRegistrarLibro.btnGuardar.addActionListener(this);
        this.frmRegistrarLibro.btnLimpiar.addActionListener(this);
        this.frmRegistrarLibro.btnFinalizarRegistro.addActionListener(this);
        cargarComboBox();
        configurarEventos();
    }
    
    public void cargarComboBox(){
    DefaultComboBoxModel modelo = new DefaultComboBoxModel();
    modelo.addElement("General");
    modelo.addElement("Referencia");
    frmRegistrarLibro.cmbBoxTipoLibro.setModel(modelo);
    frmRegistrarLibro.txtCopias.setEnabled(false);
    
}
    public void configurarEventos(){
    frmRegistrarLibro.cmbBoxTipoLibro.addActionListener(e -> {
        String tipo = (String) frmRegistrarLibro.cmbBoxTipoLibro.getSelectedItem();
        if (tipo.equals("General")) {
            frmRegistrarLibro.txtCopias.setEnabled(true);
        } else {
            frmRegistrarLibro.txtCopias.setEnabled(false);
            frmRegistrarLibro.txtCopias.setText("");
        }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource()==frmRegistrarLibro.btnGuardar){
            System.out.println("Hello");
            guardarLibro();
        }
        if (e.getSource()==frmRegistrarLibro.btnLimpiar){
            limpiarCampos();
        }
        if(e.getSource()== frmRegistrarLibro.btnFinalizarRegistro){
            cerrarFrame();
        }
    }
    
    private void guardarLibro() {
    try {
        String tipo = (String) frmRegistrarLibro.cmbBoxTipoLibro.getSelectedItem();
        String nombre = frmRegistrarLibro.txtNombreLibro.getText();
        String autor = frmRegistrarLibro.txtAutor.getText();
        String issn = frmRegistrarLibro.txtISSN.getText();
        String editorial = frmRegistrarLibro.txtEditorial.getText();
        int año = Integer.parseInt(frmRegistrarLibro.txtAñoPublicacion.getText());

        Libro nuevo;
        if (tipo.equals("General")) {
            int copias = Integer.parseInt(frmRegistrarLibro.txtCopias.getText());
            nuevo = new General(copias, nombre, autor, issn, año, editorial);
        } else {
            nuevo = new Referencia(nombre, autor, issn, año, editorial);
        }

        listaLibro.add(nuevo);
        controladorSolicitar.actualizarComboBox(); 
        frmRegistrarLibro.AreaLibros.setText("Libro registrado con éxito.");
        limpiarCampos();

    } catch (NumberFormatException e) {
        frmRegistrarLibro.AreaLibros.setText( "El año y las copias deben ser números enteros.");
    }
}
    public void limpiarCampos(){
        this.frmRegistrarLibro.txtNombreLibro.setText("");
        this.frmRegistrarLibro.txtAutor.setText("");
        this.frmRegistrarLibro.txtISSN.setText("");
        this.frmRegistrarLibro.txtAñoPublicacion.setText("");
        this.frmRegistrarLibro.txtEditorial.setText("");
        this.frmRegistrarLibro.txtCopias.setText("");
    }
    public void cerrarFrame(){
    frmRegistrarLibro.dispose();
    }
}
