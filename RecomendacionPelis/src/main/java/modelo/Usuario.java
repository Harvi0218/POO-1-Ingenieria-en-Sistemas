package modelo;

import java.util.ArrayList;
import java.util.HashMap;

public class Usuario {

    private int id;
    private String nombre;
    private String email;
    private String generoFavorito;

    // Historial: pelicula -> calificacion dada por el usuario
    private HashMap<Pelicula, Integer> historialCalificaciones;

    // Comentarios: pelicula -> comentario
    private HashMap<Pelicula, String> comentarios;


    public Usuario(int id, String nombre, String email, String generoFavorito) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.generoFavorito = generoFavorito;
        this.historialCalificaciones = new HashMap<>();
        this.comentarios = new HashMap<>();
    }

    
    public void calificarPelicula(Pelicula pelicula, int calificacion) {
        if (calificacion >= 1 && calificacion <= 5) {
            historialCalificaciones.put(pelicula, calificacion);
        }
    }

  
    public void comentarPelicula(Pelicula pelicula, String comentario) {
        comentarios.put(pelicula, comentario);
    }

    // Obtener películas vistas (con calificación)
    public ArrayList<Pelicula> getPeliculasVistas() {
        return new ArrayList<>(historialCalificaciones.keySet());
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGeneroFavorito() {
        return generoFavorito;
    }

    public void setGeneroFavorito(String generoFavorito) {
        this.generoFavorito = generoFavorito;
    }

    public HashMap<Pelicula, Integer> getHistorialCalificaciones() {
        return historialCalificaciones;
    }

    public HashMap<Pelicula, String> getComentarios() {
        return comentarios;
    }

    @Override
    public String toString() {
        return nombre + " (" + email + ")";
    }
}
