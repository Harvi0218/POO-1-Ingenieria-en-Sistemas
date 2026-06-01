/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package biblioteca;

import Controlador.ControladorRegistroLibro;
import Controlador.ControladorSolicitarLibro;
import Vista.JFRegistrarLibro;
import Vista.JFSolicitarLibro;

import Modelo.Libro;
import Modelo.General;
import Modelo.Referencia;

import java.util.ArrayList;
import javax.swing.JFrame;


public class Biblioteca {


    public static void main(String[] args) {
    
        //Esta es la lista compartida entre los frames
    ArrayList<Libro> listaLibros = new ArrayList<>();
    
    JFSolicitarLibro frmSolicitarLibro = new JFSolicitarLibro();
    frmSolicitarLibro.setVisible(true);
    ControladorSolicitarLibro controladorSolicitar = new ControladorSolicitarLibro(frmSolicitarLibro, listaLibros);
}
    
}
