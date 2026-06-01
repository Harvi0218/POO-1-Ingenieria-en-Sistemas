/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import Modelo.Administrativo;
import Modelo.Estudiante;
import Modelo.General;
import Vista.JFSolicitarLibro;
import Vista.JFRegistrarLibro;
import Modelo.Libro;
import Modelo.Prestamo;
import Modelo.Profesor;
import Modelo.Referencia;
import Modelo.EstadoPrestamo;
import Modelo.Usuario;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ControladorSolicitarLibro implements ActionListener{
    private JFSolicitarLibro frmSolicitarLibro;
    private ArrayList<Libro> listaLibros;
    private HashMap<String,Libro> mapaLibros = new HashMap <>();
    private ArrayList<Prestamo> listaPrestamos = new ArrayList<>();

    public ControladorSolicitarLibro(JFSolicitarLibro frmSolicitarLibro, ArrayList<Libro> listaLibros) {
        this.frmSolicitarLibro = frmSolicitarLibro;
        this.listaLibros = listaLibros;
        this.frmSolicitarLibro.btnPrestar.addActionListener(this);
        this.frmSolicitarLibro.btnDevolver.addActionListener(this);
        this.frmSolicitarLibro.btnRegistrarLibro.addActionListener(this);
        this.frmSolicitarLibro.btnFinalizar.addActionListener(this);
        this.frmSolicitarLibro.btnMostrarLibros.addActionListener(this);
        
    listaLibros.add(new General(5, "Cien años de soledad", "Gabriel García Márquez", "978-1", 1967, "Sudamericana"));
    listaLibros.add(new General(4, "El principito", "Antoine de Saint-Exupéry", "978-2", 1943, "Reynal"));
    listaLibros.add(new General(6, "Don Quijote de la Mancha", "Miguel de Cervantes", "978-3", 1605, "Francisco de Robles"));
    listaLibros.add(new General(3, "Crimen y castigo", "Fiódor Dostoyevski", "978-4", 1866, "El Mensajero Ruso"));
    listaLibros.add(new General(5, "El código Da Vinci", "Dan Brown", "978-5", 2003, "Doubleday"));
    listaLibros.add(new General(4, "Harry Potter y la piedra filosofal", "J.K. Rowling", "978-6", 1997, "Bloomsbury"));
    listaLibros.add(new General(3, "Orgullo y prejuicio", "Jane Austen", "978-7", 1813, "T. Egerton"));
    listaLibros.add(new General(2, "El señor de los anillos", "J.R.R. Tolkien", "978-8", 1954, "Allen & Unwin"));
    listaLibros.add(new Referencia("Diccionario de la RAE", "Real Academia Española", "978-9", 2001, "Espasa"));
    listaLibros.add(new Referencia("Enciclopedia Británica", "Varios Autores", "978-10", 1999, "Encyclopaedia Britannica"));
    listaLibros.add(new Referencia("Atlas Mundial Geográfico", "National Geographic", "978-11", 2010, "National Geographic"));
    listaLibros.add(new Referencia("Manual de Java", "James Gosling", "978-12", 2005, "Sun Microsystems"));
    
    cargarComboBox();
    cargarComboCargo();
    
    frmSolicitarLibro.btnDevolver.setEnabled(false);
}
    public void cargarComboBox() {
    DefaultComboBoxModel modelo = new DefaultComboBoxModel();

    for (Libro l : listaLibros) {
        String clave = l.getTitulo() + " - " + l.getAutor();
        mapaLibros.put(clave, l);
        modelo.addElement(clave);
    }

    frmSolicitarLibro.cmbBoxLibro.setModel(modelo);
}
    
    public void cargarComboCargo(){
    DefaultComboBoxModel modelo = new DefaultComboBoxModel();
    modelo.addElement("Estudiante");
    modelo.addElement("Profesor");
    modelo.addElement("Administrativo");
    frmSolicitarLibro.cmbBoxCargo.setModel(modelo);
}
    
    public void actualizarComboBox() {
    mapaLibros.clear();      
    cargarComboBox();          
}
    
    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource()==frmSolicitarLibro.btnPrestar){
            System.out.println("Hello");
            prestarLibro();
        }
        if (e.getSource()==frmSolicitarLibro.btnDevolver){
            devolverLibro();
        }
        if(e.getSource()== frmSolicitarLibro.btnRegistrarLibro){
            registrarLibro();
        }
        if(e.getSource()== frmSolicitarLibro.btnFinalizar){
            finalizarPrograma();
        }
        if(e.getSource()== frmSolicitarLibro.btnMostrarLibros){
            mostrarLibros();
        }
    }
    public void limpiarCampos(){
    this.frmSolicitarLibro.txtCodigo.setText("");
    this.frmSolicitarLibro.txtFechaDevolucion.setText("");
    this.frmSolicitarLibro.txtFechaPrestamo.setText("");
    this.frmSolicitarLibro.txtNombre.setText("");
    }
    
   public void prestarLibro(){
    frmSolicitarLibro.txtFechaPrestamo.setEnabled(true);
    frmSolicitarLibro.txtFechaDevolucion.setEnabled(false);
    
    try{
        String seleccion = (String) frmSolicitarLibro.cmbBoxLibro.getSelectedItem();
        Libro libroSeleccionado = mapaLibros.get(seleccion);
        
        if(libroSeleccionado instanceof General g){
            if(g.getCopias() <= 0){
                frmSolicitarLibro.AreaResults.setText("No hay copias disponibles de este Libro");
                return;
            }
        }
        
        String nombre = frmSolicitarLibro.txtNombre.getText();
        String codigo = frmSolicitarLibro.txtCodigo.getText();
        String cargo = (String) frmSolicitarLibro.cmbBoxCargo.getSelectedItem();
        
        Usuario usuario = null;
        switch(cargo){
            case "Estudiante":
                usuario = new Estudiante(nombre, codigo);
                break;
            case "Profesor":
                usuario = new Profesor(nombre, codigo);
                break;
            default:
                usuario = new Administrativo(nombre, codigo);
                break;
        }
        if(usuario == null){
            frmSolicitarLibro.AreaResults.setText("Seleccione un cargo válido.");
            return;
        }

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaPrestamo = LocalDate.parse(
            frmSolicitarLibro.txtFechaPrestamo.getText(), formato
        );

        int plazo = 0;
        if(usuario instanceof Estudiante){
            plazo = ((Estudiante) usuario).getPlazoMaximo();
        } else if(usuario instanceof Profesor){
            plazo = ((Profesor) usuario).getPlazoMaximo();
        } else if(usuario instanceof Administrativo){
            plazo = ((Administrativo) usuario).getPlazoMaximo();
        }

        LocalDate fechaDevolucion = fechaPrestamo.plusDays(plazo);

        Prestamo prestamo = new Prestamo(fechaPrestamo, fechaDevolucion, EstadoPrestamo.PRESTADO, libroSeleccionado, usuario);
        listaPrestamos.add(prestamo);
        frmSolicitarLibro.btnDevolver.setEnabled(true);

        if(libroSeleccionado instanceof General){
            General g = (General) libroSeleccionado;
            g.setCopias(g.getCopias() - 1);
        }

        frmSolicitarLibro.AreaResults.setText(
            "Prestamo registrado:\n" +
            "Libro: " + libroSeleccionado.getTitulo() + "\n" +
            "Usuario: " + nombre + "\n" +
            "Cargo: " + cargo + "\n" +
            "Fecha prestamo: " + fechaPrestamo.format(formato) + "\n" +
            "Fecha limite devolucion: " + fechaDevolucion.format(formato)
        );
        limpiarCampos();
        
    } catch(DateTimeParseException e){
        frmSolicitarLibro.AreaResults.setText("La fecha debe tener el formato DD/MM/AAAA.");
    }
}

private boolean esperandoDevolucion = false;
private void devolverLibro(){
    frmSolicitarLibro.txtFechaPrestamo.setEnabled(false);
    frmSolicitarLibro.txtFechaDevolucion.setEnabled(true);
    
    if(!esperandoDevolucion){
        frmSolicitarLibro.txtFechaPrestamo.setEnabled(false);
        frmSolicitarLibro.txtFechaDevolucion.setEnabled(true);
        frmSolicitarLibro.AreaResults.setText("Ingrese la fecha actual en el campo 'Fecha de Devolucion'\n" +"y su codigo, luego presione Devolver nuevamente.");
        esperandoDevolucion = true;
        return;
    }
    
    esperandoDevolucion = false;
    
    try{
        String codigo = frmSolicitarLibro.txtCodigo.getText();
        
        Prestamo prestamoEncontrado = null;
        for(Prestamo p : listaPrestamos){
            if(p.getPide().getCodigo().equals(codigo) && 
               p.getEstado() == EstadoPrestamo.PRESTADO){
                prestamoEncontrado = p;
                break;
            }
        }
        
        if(prestamoEncontrado == null){
            frmSolicitarLibro.AreaResults.setText("No se encontró un préstamo activo para ese código.");
            return;
        }
        
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaActual = LocalDate.parse(
            frmSolicitarLibro.txtFechaDevolucion.getText(), formato
        );
        prestamoEncontrado.VerificarMulta(fechaActual);
        
        if(prestamoEncontrado.getEstado() == EstadoPrestamo.MULTADO){
            frmSolicitarLibro.AreaResults.setText(
                "El usuario tiene una multa pendiente.\n" +
                "Libro: " + prestamoEncontrado.getPrestado().getTitulo() + "\n" +
                "No se puede devolver hasta saldar la multa."
            );
            return;
        }
        
        prestamoEncontrado.setEstado(EstadoPrestamo.DEVUELTO);
        
        if(prestamoEncontrado.getPrestado() instanceof General){
            General g = (General) prestamoEncontrado.getPrestado();
            g.setCopias(g.getCopias() + 1);
        }
        
        frmSolicitarLibro.AreaResults.setText(
            "Devolución exitosa:\n" +
            "Libro: " + prestamoEncontrado.getPrestado().getTitulo() + "\n" +
            "Usuario: " + prestamoEncontrado.getPide().getNombre() + "\n" +
            "Código: " + codigo
        );
        
        frmSolicitarLibro.txtFechaDevolucion.setEnabled(false);
        frmSolicitarLibro.txtFechaPrestamo.setEnabled(true);
        frmSolicitarLibro.btnDevolver.setEnabled(false);
        limpiarCampos();
        
    } catch(DateTimeParseException e){
        frmSolicitarLibro.AreaResults.setText("La fecha debe tener el formato DD/MM/AAAA.");
    }
}
    
    public void registrarLibro(){
    JFRegistrarLibro frmRegistrarLibro = new JFRegistrarLibro();
    frmRegistrarLibro.setVisible(true);
    new ControladorRegistroLibro(frmRegistrarLibro, listaLibros, this); //El this representa el propio controladorSolicitar que ya existe, sirve como un llamado al actualizar de este campo hacia el otro
    }
    
    public void finalizarPrograma(){
    System.exit(0);
    }
    
    public void mostrarLibros(){
    frmSolicitarLibro.AreaResults.setText("");
    if(listaLibros.isEmpty()){
        frmSolicitarLibro.AreaResults.setText("No hay libros registrados.");
        return;
        }
    for(Libro l : listaLibros){
        frmSolicitarLibro.AreaResults.append(l.getTitulo() + " - " + l.getAutor() + "\n");
        }
    }
    
}
