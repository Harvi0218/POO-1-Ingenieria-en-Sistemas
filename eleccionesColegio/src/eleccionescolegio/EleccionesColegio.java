package eleccionescolegio;

import Modelo.Animal;
import Modelo.Terrestre;
import Modelo.Aereo;
import Modelo.Acuatico;
import Modelo.Estudiante;
import Modelo.CandidatoPersonero;
import Modelo.CandidatoRepresentante;
import Modelo.Votacion;
import Controlador.ControladorPersonero;
import Controlador.ControladorRepresentante;
import vista.JFPersonero;
import vista.JFRepresentante;
import java.util.ArrayList;

public class EleccionesColegio {

    public static void main(String[] args) {
        
        Terrestre perro = new Terrestre(1, "Rex", "Macho", 3, "Leal y fuerte");
        Aereo aguila = new Aereo(2, "Aguila", "Hembra", 5, "Veloz y libre");
        Acuatico pez = new Acuatico(3, "Nemo", "Macho", 1, "Ágil y rápido");
        
        Estudiante est1 = new Estudiante("Ana", "García", 10, 1);
        Estudiante est2 = new Estudiante("Luis", "Martínez", 11, 2);
        
        CandidatoPersonero p1 = new CandidatoPersonero("Juan", "Pérez", 10, "A", "Juntos podemos!", 1, perro);
        CandidatoPersonero p2 = new CandidatoPersonero("María", "López", 11, "B", "Adelante!", 2, aguila);
        CandidatoPersonero p3 = new CandidatoPersonero("Carlos", "Gil", 9, "A", "Por un mejor colegio!", 3, pez);
        
        CandidatoRepresentante r1 = new CandidatoRepresentante("Pedro", "Ruiz", 10, "A", "Fuerza!", 4, est1);
        CandidatoRepresentante r2 = new CandidatoRepresentante("Laura", "Torres", 11, "B", "Siempre adelante!", 5, est2);
        
        ArrayList<CandidatoPersonero> listaPersoneros = new ArrayList<>();
        listaPersoneros.add(p1);
        listaPersoneros.add(p2);
        listaPersoneros.add(p3);
        
        ArrayList<CandidatoRepresentante> listaRepresentantes = new ArrayList<>();
        listaRepresentantes.add(r1);
        listaRepresentantes.add(r2);
        
        Votacion votacion = new Votacion();
        
        JFPersonero frmPersonero = new JFPersonero();
        JFRepresentante frmRepresentante = new JFRepresentante();
        
        for (CandidatoPersonero c : listaPersoneros) {
            frmPersonero.cmbPersonero.addItem(c.getNombre() + " " + c.getApellido());
        }
        
        for (CandidatoRepresentante c : listaRepresentantes) {
            frmRepresentante.cmbPersonero.addItem(c.getNombre() + " " + c.getApellido());
        }
        
        ControladorPersonero ctrlPersonero = new ControladorPersonero(frmPersonero, votacion, listaPersoneros);
        ControladorRepresentante ctrlRepresentante = new ControladorRepresentante(frmRepresentante, votacion, listaRepresentantes);
        
        frmPersonero.setVisible(true);
        frmRepresentante.setVisible(true);
    }
}