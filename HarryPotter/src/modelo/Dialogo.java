package modelo;

public class Dialogo {

    private String personaje;

    private String pregunta;

    private String respuesta;

    public Dialogo() {
    }

    public Dialogo(
            String personaje,
            String pregunta,
            String respuesta
    ) {

        this.personaje = personaje;
        this.pregunta = pregunta;
        this.respuesta = respuesta;
    }

    public void hablar() {

        System.out.println(
                personaje + ": "
                + respuesta
        );
    }

    public String getPersonaje() {
        return personaje;
    }

    public String getPregunta() {
        return pregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }

}