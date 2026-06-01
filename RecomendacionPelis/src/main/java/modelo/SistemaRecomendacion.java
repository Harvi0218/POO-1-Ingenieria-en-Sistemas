package modelo;

import java.util.ArrayList;

public class SistemaRecomendacion {

    private ArrayList<Pelicula> catalogo;
    private ArrayList<Usuario> usuarios;
    private Usuario usuarioActual;

    public SistemaRecomendacion() {
        catalogo = new ArrayList<>();
        usuarios = new ArrayList<>();
        cargarDatosEjemplo();
    }

    private void cargarDatosEjemplo() {
        catalogo.add(new Pelicula(1, "El Padrino", "Drama", 1972, 4.8, "Francis Ford Coppola"));
        catalogo.add(new Pelicula(2, "Interstellar", "Ciencia Ficción", 2014, 4.7, "Christopher Nolan"));
        catalogo.add(new Pelicula(3, "Titanic", "Romance", 1997, 4.5, "James Cameron"));
        catalogo.add(new Pelicula(4, "El Rey León", "Animación", 1994, 4.6, "Roger Allers"));
        catalogo.add(new Pelicula(5, "Matrix", "Ciencia Ficción", 1999, 4.7, "Wachowski"));
        catalogo.add(new Pelicula(6, "Toy Story", "Animación", 1995, 4.5, "John Lasseter"));
        catalogo.add(new Pelicula(7, "El Señor de los Anillos", "Fantasía", 2001, 4.9, "Peter Jackson"));
        catalogo.add(new Pelicula(8, "Joker", "Drama", 2019, 4.4, "Todd Phillips"));
        catalogo.add(new Pelicula(9, "Avengers Endgame", "Acción", 2019, 4.6, "Russo Brothers"));
        catalogo.add(new Pelicula(10, "La La Land", "Romance", 2016, 4.3, "Damien Chazelle"));
        catalogo.add(new Pelicula(11, "Inception", "Ciencia Ficción", 2010, 4.8, "Christopher Nolan"));
        catalogo.add(new Pelicula(12, "Up", "Animación", 2009, 4.7, "Pete Docter"));
        catalogo.add(new Pelicula(13, "Pulp Fiction", "Drama", 1994, 4.6, "Quentin Tarantino"));
        catalogo.add(new Pelicula(14, "Gladiador", "Acción", 2000, 4.5, "Ridley Scott"));
        catalogo.add(new Pelicula(15, "Coco", "Animación", 2017, 4.7, "Lee Unkrich"));

        // Agregar usuarios de ejemplo
        usuarios.add(new Usuario(1, "Carlos López", "carlos@email.com", "Ciencia Ficción"));
        usuarios.add(new Usuario(2, "María García", "maria@email.com", "Romance"));
        usuarios.add(new Usuario(3, "Juan Pérez", "juan@email.com", "Animación"));
    }

   
    public ArrayList<Pelicula> generarRecomendaciones(Usuario usuario) {
        ArrayList<Pelicula> recomendaciones = new ArrayList<>();
        ArrayList<Pelicula> peliculasVistas = usuario.getPeliculasVistas();

        for (Pelicula pelicula : catalogo) {
            // Recomendar si el género coincide y no la ha visto
            if (pelicula.getGenero().equals(usuario.getGeneroFavorito())
                    && !peliculasVistas.contains(pelicula)) {
                recomendaciones.add(pelicula);
            }
        }

        // Si no hay suficientes recomendaciones del género favorito,
        // agregar películas con alta calificación que no haya visto
        if (recomendaciones.size() < 3) {
            for (Pelicula pelicula : catalogo) {
                if (!peliculasVistas.contains(pelicula)
                        && !recomendaciones.contains(pelicula)
                        && pelicula.getCalificacionPromedio() >= 4.5) {
                    recomendaciones.add(pelicula);
                }
            }
        }

        return recomendaciones;
    }

    public ArrayList<Pelicula> buscarPorTitulo(String titulo) {
        ArrayList<Pelicula> resultado = new ArrayList<>();
        for (Pelicula p : catalogo) {
            if (p.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                resultado.add(p);
            }
        }
        return resultado;
    }
    public ArrayList<Pelicula> buscarPorGenero(String genero) {
        ArrayList<Pelicula> resultado = new ArrayList<>();
        for (Pelicula p : catalogo) {
            if (p.getGenero().equalsIgnoreCase(genero)) {
                resultado.add(p);
            }
        }
        return resultado;
    }
    
    public ArrayList<Pelicula> buscarPorDirector(String director) {
        ArrayList<Pelicula> resultado = new ArrayList<>();
        for (Pelicula p : catalogo) {
            if (p.getDirector().toLowerCase().contains(director.toLowerCase())) {
                resultado.add(p);
            }
        }
        return resultado;
    }

   
    public boolean registrarUsuario(String nombre, String email, String genero) {
        // Verificar que el email no esté repetido
        for (Usuario u : usuarios) {
            if (u.getEmail().equals(email)) {
                return false;
            }
        }
        int nuevoId = usuarios.size() + 1;
        usuarios.add(new Usuario(nuevoId, nombre, email, genero));
        return true;
    }

    public Usuario iniciarSesion(String nombre) {
        for (Usuario u : usuarios) {
            if (u.getNombre().equalsIgnoreCase(nombre)) {
                usuarioActual = u;
                return u;
            }
        }
        return null;
    }

    public ArrayList<Pelicula> getCatalogo() {
        return catalogo;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public Usuario getUsuarioActual() {
        return usuarioActual;
    }

    public void setUsuarioActual(Usuario usuario) {
        this.usuarioActual = usuario;
    }
}
