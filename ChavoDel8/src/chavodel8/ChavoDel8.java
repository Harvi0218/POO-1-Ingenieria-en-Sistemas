/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package chavodel8;

import Controlador.ControladorInteraccion;
import Modelo.Chavo;
import Modelo.Diagolo;
import Modelo.DonRamon;
import Modelo.DonaFlorinda;
import Modelo.Personaje;
import Modelo.Quico;
import Modelo.Usuario;
import Modelo.Vecindad;
import Vista.Interaccion;
import java.util.HashMap;

/**
 *
 * @author Pc
 */
public class ChavoDel8 {

    public static void main(String[] args) {
 
        System.out.println("===== SISTEMA CHAVO DEL 8 =====\n");
 
        Chavo chavo = new Chavo();
        Quico quico = new Quico();
        DonaFlorinda florinda = new DonaFlorinda();
        DonRamon donRamon = new DonRamon();
 
        HashMap<String, Personaje> personajes = new HashMap<>();
        personajes.put("El Chavo",chavo);
        personajes.put("Quico",quico);
        personajes.put("Doña Florinda",florinda);
        personajes.put("Don Ramon",donRamon);
 
        // Mostrar todos los personajes
        System.out.println("--- Personajes cargados ---");
        for (String nombre : personajes.keySet()) {
            System.out.println(personajes.get(nombre).toString());
        }
 
        System.out.println();
 
        // Probar acciones de cada personaje
        System.out.println("--- Acciones especiales ---");
        System.out.println(chavo.pedirTorta());
        System.out.println(quico.jugarPelota());
        System.out.println(florinda.darTorta());
        System.out.println(florinda.golpearDonRamon(donRamon));
        System.out.println(donRamon.huir());
        System.out.println(donRamon.enojarse());
 
        System.out.println();
 
        //movilizarse
        System.out.println("--- Movimiento ---");
        for (String nombre : personajes.keySet()) {
            System.out.println(personajes.get(nombre).movilizarse());
        }
 
        System.out.println();
 
        // Probar Vecindad
        System.out.println("--- Vecindad ---");
        Vecindad vecindad = new Vecindad();
        vecindad.agregarPersonaje(chavo);
        vecindad.agregarPersonaje(quico);
        vecindad.agregarPersonaje(florinda);
        vecindad.agregarPersonaje(donRamon);
        System.out.println(vecindad.mostrarPersonajes());
 
        System.out.println("--- Dialogo ---");
        Diagolo dialogo = new Diagolo("Fue sin querer queriendo!");
        dialogo.agregarPersonaje(chavo);
        dialogo.agregarPersonaje(quico);
        System.out.println(dialogo.iniciarDialogo());
        System.out.println(dialogo.finalizarDialogo());
 
        System.out.println();
 
        System.out.println("--- Usuario ---");
        Usuario usuario = new Usuario("Jugador1");
        System.out.println(usuario.interaccion(chavo));
        System.out.println(usuario.interaccion(donRamon));
        
        java.awt.EventQueue.invokeLater(new Runnable() {public void run() {new Interaccion().setVisible(true);}});
    }
}
    
