package controlador;

import modelo.Juego;
import modelo.WonderWoman;
import modelo.Enemigo;
import modelo.Aliado;
import modelo.Objeto;
import vista.VistaJuegoSwing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;


// ======================================================
// CONTROLADOR DE COMBATE
// ======================================================

class CombateControlador
{
    private VistaJuegoSwing vista;

    public CombateControlador(VistaJuegoSwing vista)
    {
        this.vista = vista;
    }

    public void procesarTurno(WonderWoman diana, Enemigo enemigo)
    {
        int danioDiana;

        if (diana.isModoFuria())
        {
            danioDiana = WonderWoman.DANIO_FURIA;
        }
        else
        {
            danioDiana = WonderWoman.DANIO_NORMAL;
        }

        enemigo.recibirDanio(danioDiana);

        vista.escribirLog("⚔ Diana ataca a "
                + enemigo.getNombre()
                + " y causa "
                + danioDiana
                + " de daño.");

        // ======================================================
        // SI EL ENEMIGO SIGUE VIVO
        // ======================================================

        if (enemigo.estaVivo())
        {
            int danioEnemigo = enemigo.getFuerza() / 2;

            boolean bloqueado =
                    diana.recibirDanioConInfo(danioEnemigo);

            if (bloqueado)
            {
                vista.escribirLog(
                        "🛡 El ataque de "
                        + enemigo.getNombre()
                        + " fue bloqueado."
                );
            }
            else
            {
                vista.escribirLog(
                        enemigo.getNombre()
                        + " contraataca y causa "
                        + danioEnemigo
                        + " de daño."
                );
            }
        }
        else
        {
            vista.escribirLogDestacado(
                    "☠ " + enemigo.getNombre()
                    + " ha sido derrotado."
            );
        }
    }

    // ======================================================
    // OBJETOS
    // ======================================================

    public void aplicarEfectoObjeto(
            WonderWoman diana,
            Objeto objeto,
            Enemigo enemigo)
    {

        if (!objeto.estaDisponible())
        {
            vista.escribirLog(
                    "❌ El objeto "
                    + objeto.getNombre()
                    + " ya fue utilizado."
            );

            return;
        }

        objeto.usar();

        // ======================================================
        // ESCUDO
        // ======================================================

        if (objeto.getTipo().equals("Defensa"))
        {
            diana.activarEscudo();

            vista.escribirLog(
                    "🛡 Diana usa "
                    + objeto.getNombre()
                    + ". El siguiente ataque será bloqueado."
            );
        }

        // ======================================================
        // LAZO
        // ======================================================

        else if (
                objeto.getTipo().equals("Arma")
                && objeto.getReduccionFuerza() > 0
        )
        {
            int reduccion = objeto.getReduccionFuerza();

            enemigo.reducirFuerza(reduccion);

            vista.escribirLog(
                    "🌀 "
                    + objeto.getNombre()
                    + " reduce la fuerza de "
                    + enemigo.getNombre()
                    + " en "
                    + reduccion
                    + " puntos."
            );
        }

        // ======================================================
        // OTROS OBJETOS
        // ======================================================

        else
        {
            vista.escribirLog(
                    "✨ Diana usa "
                    + objeto.getNombre()
                    + "."
            );
        }
    }
}


// ======================================================
// CONTROLADOR DE DIALOGOS
// ======================================================

class DialogoControlador
{
    private VistaJuegoSwing vista;

    public DialogoControlador(VistaJuegoSwing vista)
    {
        this.vista = vista;
    }

    public void iniciarDialogo(Aliado aliado)
    {
        String linea = aliado.getSiguienteDialogo();

        vista.mostrarDialogo(
                aliado.getNombre(),
                linea
        );

        vista.escribirLog(
                "💬 "
                + aliado.getNombre()
                + ": "
                + linea
        );
    }
}


// ======================================================
// CONTROLADOR PRINCIPAL
// ======================================================

public class JuegoControlador
{
    private Juego juego;

    private VistaJuegoSwing vista;

    private CombateControlador combateCtrl;

    private DialogoControlador dialogoCtrl;


    // ======================================================
    // CONSTRUCTOR
    // ======================================================

    public JuegoControlador()
    {
        juego = new Juego();

        vista = new VistaJuegoSwing();

        combateCtrl =
                new CombateControlador(vista);

        dialogoCtrl =
                new DialogoControlador(vista);
    }


    // ======================================================
    // INICIAR JUEGO
    // ======================================================

    public void iniciar()
    {
        conectarBotones();

        sincronizarVista();

        vista.mostrarDialogo(
                "Steve Trevor",
                "Diana, debemos detener a Ares."
        );

        vista.escribirLog("══════════════════════════════════════");
        vista.escribirLog("🎮 JUEGO INICIADO");
        vista.escribirLog("══════════════════════════════════════");

        vista.escribirLog(
                "⚔ Diana enfrenta a Ares."
        );

        vista.escribirLog(
                "🔥 Usa habilidades y objetos para ganar."
        );

        vista.escribirLog("══════════════════════════════════════");

        vista.mostrar();
    }


    // ======================================================
    // BOTONES
    // ======================================================

    private void conectarBotones()
    {

        // ======================================================
        // BOTON ATACAR
        // ======================================================

        vista.btnAtacar.addActionListener(
                new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        accionAtacar();
                    }
                }
        );

        // ======================================================
        // BOTON FURIA
        // ======================================================

        vista.btnFuria.addActionListener(
                new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        accionActivarFuria();
                    }
                }
        );

        // ======================================================
        // BOTON LAZO
        // ======================================================

        vista.btnLazo.addActionListener(
                new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        accionUsarLazo();
                    }
                }
        );

        // ======================================================
        // BOTON ESCUDO
        // ======================================================

        vista.btnEscudo.addActionListener(
                new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        accionUsarEscudo();
                    }
                }
        );

        // ======================================================
        // BOTON DIALOGO
        // ======================================================

        vista.btnDialogo.addActionListener(
                new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        accionHablarConSteve();
                    }
                }
        );

        // ======================================================
        // BOTON NUEVO JUEGO
        // ======================================================

        vista.btnNuevoJuego.addActionListener(
                new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        accionNuevoJuego();
                    }
                }
        );
    }


    // ======================================================
    // ACCION ATACAR
    // ======================================================

    private void accionAtacar()
    {
        if (juego.isTerminado())
        {
            return;
        }

        int turno = juego.avanzarTurno();

        vista.actualizarTurno(turno);

        vista.escribirLog(
                "────────── TURNO "
                + turno
                + " ──────────"
        );

        combateCtrl.procesarTurno(
                juego.getDiana(),
                juego.getAres()
        );

        sincronizarVista();

        // ======================================================
        // VALIDAR GANADOR
        // ======================================================

        if (!juego.getAres().estaVivo())
        {
            terminarJuego(true);
        }
        else if (!juego.getDiana().estaVivo())
        {
            terminarJuego(false);
        }
    }


    // ======================================================
    // FURIA
    // ======================================================

    private void accionActivarFuria()
    {
        if (
                juego.isTerminado()
                || juego.getDiana().isModoFuria()
        )
        {
            return;
        }

        juego.getDiana().activarFuria();

        vista.actualizarModoFuria(true);

        vista.escribirLog(
                "🔥 Diana activa el MODO FURIA."
        );

        vista.escribirLog(
                "⚡ El daño ahora es de "
                + WonderWoman.DANIO_FURIA
        );

        vista.deshabilitarBoton(
                vista.btnFuria
        );
    }


    // ======================================================
    // LAZO
    // ======================================================

    private void accionUsarLazo()
    {
        if (juego.isTerminado())
        {
            return;
        }

        combateCtrl.aplicarEfectoObjeto(
                juego.getDiana(),
                juego.getLazo(),
                juego.getAres()
        );

        if (!juego.getLazo().estaDisponible())
        {
            vista.deshabilitarBoton(
                    vista.btnLazo
            );
        }
    }


    // ======================================================
    // ESCUDO
    // ======================================================

    private void accionUsarEscudo()
    {
        if (juego.isTerminado())
        {
            return;
        }

        combateCtrl.aplicarEfectoObjeto(
                juego.getDiana(),
                juego.getEscudo(),
                juego.getAres()
        );

        if (!juego.getEscudo().estaDisponible())
        {
            vista.deshabilitarBoton(
                    vista.btnEscudo
            );
        }
    }


    // ======================================================
    // DIALOGO
    // ======================================================

    private void accionHablarConSteve()
    {
        dialogoCtrl.iniciarDialogo(
                juego.getSteve()
        );
    }


    // ======================================================
    // NUEVO JUEGO
    // ======================================================

    private void accionNuevoJuego()
    {
        int opcion = JOptionPane.showConfirmDialog(
                vista,
                "¿Deseas iniciar una nueva partida?",
                "Nuevo Juego",
                JOptionPane.YES_NO_OPTION
        );

        if (opcion != JOptionPane.YES_OPTION)
        {
            return;
        }

        juego.reiniciar();

        combateCtrl =
                new CombateControlador(vista);

        dialogoCtrl =
                new DialogoControlador(vista);

        vista.limpiarLog();

        vista.habilitarBotones(true);

        vista.actualizarModoFuria(false);

        vista.actualizarTurno(0);

        vista.mostrarDialogo(
                "Steve Trevor",
                "Diana, debemos detener a Ares."
        );

        sincronizarVista();

        vista.escribirLog("══════════════════════════════════════");
        vista.escribirLog("🎮 NUEVA PARTIDA");
        vista.escribirLog("══════════════════════════════════════");
    }


    // ======================================================
    // SINCRONIZAR DATOS
    // ======================================================

    private void sincronizarVista()
    {
        vista.actualizarSaludDiana(
                juego.getDiana().getSalud(),
                WonderWoman.SALUD_MAX
        );

        vista.actualizarSaludAres(
                juego.getAres().getSalud(),
                Juego.SALUD_MAX_ARES
        );

        vista.actualizarEscenario(
                juego.getEscenario().getNombre(),
                juego.getEscenario().getUbicacion()
        );
    }


    // ======================================================
    // TERMINAR JUEGO
    // ======================================================

    private void terminarJuego(boolean victoria)
    {
        juego.terminar(victoria);

        vista.habilitarBotones(false);

        // ======================================================
        // VICTORIA
        // ======================================================

        if (victoria)
        {
            vista.escribirLogDestacado(
                    "🏆 ¡VICTORIA! Diana derrotó a Ares."
            );

            vista.mostrarDialogo(
                    "Diana Prince",
                    "La paz ha sido restaurada."
            );

            JOptionPane.showMessageDialog(
                    vista,
                    "🏆 ¡HAS GANADO!",
                    "Victoria",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }

        // ======================================================
        // DERROTA
        // ======================================================

        else
        {
            vista.escribirLogDestacado(
                    "☠ Diana ha sido derrotada."
            );

            vista.mostrarDialogo(
                    "Ares",
                    "La guerra nunca terminará."
            );

            JOptionPane.showMessageDialog(
                    vista,
                    "☠ HAS PERDIDO",
                    "Derrota",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
}