package controlador;

import modelo.*;
import java.util.ArrayList;

public class ControladorJuego
{
    private Caperucita caperucita;
    private Abuela abuela;
    private Lobo lobo;
    private Lenador lenador;
    private Bosque bosque;
    private ArrayList<String> bitacora;

    public ControladorJuego()
    {
        bitacora = new ArrayList<>();
        iniciarHistoria();
    }

    private void iniciarHistoria()
    {
        Arbol arbol = new Arbol("A01", "Pino");
        bosque = new Bosque(100.0, 200.0, arbol);

        caperucita = new Caperucita("P01", "Caperucita Roja", "Protagonista", false);
        abuela = new Abuela("P02", "Abuela", "Secundario", 75, true, false);
        lobo = new Lobo("P03", "Lobo Feroz", "Villano", true);
        lenador = new Lenador("P04", "Leñador", "Secundario");

        registrar("Historia iniciada. El bosque está listo.");
    }


    public String accionLoboHablar()
    {
        String mensaje = lobo.hablar();
        registrar(mensaje);
        return mensaje;
    }

    public String accionLoboDisfrazarse()
    {
        String mensaje = lobo.disfrazarse();
        registrar(mensaje);
        return mensaje;
    }

    public String accionLoboCorrer()
    {
        String mensaje = lobo.correr();
        registrar(mensaje);
        return mensaje;
    }

    public String accionLoboTragar()
    {
        if (!lobo.isVivo())
        {
            String msg = "El lobo ya no puede hacer nada, está muerto.";
            registrar(msg);
            return msg;
        }
        String mensajeLobo = lobo.tragar();
        String mensajeAbuela = abuela.gritar();
        abuela.setSalud(false);
        registrar(mensajeLobo);
        registrar(mensajeAbuela);
        return mensajeLobo + "\n" + mensajeAbuela;
    }


    public String accionCaperucitaVisitar()
    {
        boolean resultado = caperucita.visitarAbuela();
        String msg;
        if (resultado)
        {
            msg = "Caperucita visita a su abuela sana y salva.";
        }
        else
        {
            msg = "Caperucita todavía no puede visitar a su abuela, no ha sido rescatada.";
        }
        registrar(msg);
        return msg;
    }

    public String accionLlenarCesta()
    {
        Cesta cesta = caperucita.getCesta();
        cesta.setBebida(true);
        cesta.setComida(true);
        String msg = "La cesta de Caperucita está llena: " + (cesta.estaLlena() ? "Sí" : "No");
        registrar(msg);
        return msg;
    }

    public String accionAbuelaGritar()
    {
        String msg = abuela.gritar();
        registrar(msg);
        return msg;
    }

    public String accionLenadorRescatar()
    {
        String msg = lenador.rescatar();
        caperucita.setRescatada(true);
        abuela.setRescatada(true);
        registrar(msg);
        registrar("Caperucita fue rescatada.");
        registrar("La abuela fue rescatada.");
        return msg + "\nCaperucita y la abuela han sido rescatadas.";
    }

    public String accionAbrirPanza()
    {
        boolean resultado = lenador.abrirPanza(lobo);
        String msg;
        if (resultado)
        {
            msg = lenador.getNombre() + " abre la panza del lobo con su hacha.";
        }
        else
        {
            msg = "No se puede abrir la panza, el lobo ya está muerto.";
        }
        registrar(msg);
        return msg;
    }

    public String accionRellenarPanza()
    {
        boolean resultado = lenador.rellenarPanza(lobo);
        String msg;
        if (resultado)
        {
            msg = lenador.getNombre() + " rellena la panza con piedras. ¡El lobo está muerto!";
        }
        else
        {
            msg = "No se puede rellenar la panza.";
        }
        registrar(msg);
        return msg;
    }

    public String getEstadoLobo()
    {
        return lobo.isVivo() ? "Vivo" : "Muerto";
    }

    public String getEstadoAbuela()
    {
        if (abuela.isRescatada()) return "Rescatada";
        if (!abuela.isSalud()) return "Tragada por el lobo";
        return "En su casa";
    }

    public String getEstadoCaperucita()
    {
        return caperucita.isRescatada() ? "Rescatada" : "En peligro";
    }

    public String getEstadoCesta()
    {
        return caperucita.getCesta().estaLlena() ? "Llena" : "Vacía";
    }

    public ArrayList<Personaje> getPersonajes()
    {
        ArrayList<Personaje> lista = new ArrayList<>();
        lista.add(caperucita);
        lista.add(abuela);
        lista.add(lobo);
        lista.add(lenador);
        return lista;
    }

    public ArrayList<String> getBitacora()
    {
        return bitacora;
    }

    public Bosque getBosque()
    {
        return bosque;
    }

    private void registrar(String mensaje)
    {
        bitacora.add(mensaje);
    }

    public void reiniciarHistoria()
    {
        bitacora.clear();
        iniciarHistoria();
    }
}
