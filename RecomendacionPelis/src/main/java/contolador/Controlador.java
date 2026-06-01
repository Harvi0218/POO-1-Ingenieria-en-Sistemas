package controlador;

import modelo.Pelicula;
import modelo.SistemaRecomendacion;
import modelo.Usuario;
import vista.VentanaPrincipal;

import java.util.ArrayList;

public class Controlador {

    private SistemaRecomendacion modelo;
    private VentanaPrincipal vista;

    public Controlador(SistemaRecomendacion modelo, VentanaPrincipal vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void iniciarSesion(String nombre) {
        if (nombre.isEmpty()) {
            vista.mostrarMensaje("Escribe tu nombre para iniciar sesion.");
            return;
        }
        Usuario usuario = modelo.iniciarSesion(nombre);
        if (usuario != null) {
            vista.mostrarMensaje("Bienvenido, " + usuario.getNombre() + "! Genero favorito: " + usuario.getGeneroFavorito());
        } else {
            vista.mostrarMensaje("Usuario no encontrado. Verifica el nombre o registrate.");
        }
    }

    public void registrarUsuario(String nombre, String email, String genero) {
        if (nombre.isEmpty() || email.isEmpty()) {
            vista.mostrarMensaje("Completa nombre y email para registrarte.");
            return;
        }
        boolean exito = modelo.registrarUsuario(nombre, email, genero);
        if (exito) {
            vista.mostrarMensaje("Usuario registrado. Ahora puedes iniciar sesion con: " + nombre);
        } else {
            vista.mostrarMensaje("El email ya esta registrado.");
        }
    }

    public ArrayList<Pelicula> obtenerRecomendaciones() {
        Usuario usuario = modelo.getUsuarioActual();
        if (usuario == null) {
            return new ArrayList<>();
        }
        return modelo.generarRecomendaciones(usuario);
    }

    public void calificarPelicula(Pelicula pelicula, int calificacion, String comentario) {
        Usuario usuario = modelo.getUsuarioActual();
        if (usuario == null) {
            vista.mostrarMensaje("Debes iniciar sesion primero.");
            return;
        }
        usuario.calificarPelicula(pelicula, calificacion);
        if (!comentario.isEmpty()) {
            usuario.comentarPelicula(pelicula, comentario);
        }
        vista.mostrarMensaje("Calificaste \"" + pelicula.getTitulo() + "\" con " + calificacion + "/5");
    }

    public ArrayList<Pelicula> buscar(String criterio, String texto) {
        if (texto.isEmpty()) {
            vista.mostrarMensaje("Escribe algo para buscar.");
            return new ArrayList<>();
        }
        ArrayList<Pelicula> resultados;
        switch (criterio) {
            case "Titulo":   resultados = modelo.buscarPorTitulo(texto);   break;
            case "Genero":   resultados = modelo.buscarPorGenero(texto);   break;
            case "Director": resultados = modelo.buscarPorDirector(texto); break;
            default:         resultados = new ArrayList<>();
        }
        vista.mostrarInfo("Se encontraron " + resultados.size() + " resultado(s) para: " + texto);
        vista.cargarListaPeliculas(resultados);
        return resultados;
    }

    public ArrayList<Pelicula> obtenerCatalogo() {
        return modelo.getCatalogo();
    }

    public String obtenerHistorial() {
        Usuario usuario = modelo.getUsuarioActual();
        if (usuario == null) {
            return "Inicia sesion para ver tu historial.";
        }
        StringBuilder sb = new StringBuilder("=== Historial de " + usuario.getNombre() + " ===\n");
        if (usuario.getHistorialCalificaciones().isEmpty()) {
            sb.append("Aun no has calificado ninguna pelicula.");
        } else {
            for (Pelicula p : usuario.getHistorialCalificaciones().keySet()) {
                int cal = usuario.getHistorialCalificaciones().get(p);
                sb.append("- ").append(p.getTitulo()).append(": ").append(cal).append("/5");
                if (usuario.getComentarios().containsKey(p)) {
                    sb.append(" | Comentario: ").append(usuario.getComentarios().get(p));
                }
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}
