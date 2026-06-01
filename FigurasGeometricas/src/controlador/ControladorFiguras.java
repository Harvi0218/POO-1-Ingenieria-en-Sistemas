package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Circulo;
import modelo.Cuadrado;
import modelo.Triangulo;
import vista.JFFiguras;

public class ControladorFiguras implements ActionListener {

    private JFFiguras vista;

    public ControladorFiguras(JFFiguras vista) {

        this.vista = vista;

        this.vista.getBtnCalcularArea().addActionListener(this);
        this.vista.getBtnCalcularPerimetro().addActionListener(this);
        this.vista.getBtnLimpiar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // =====================================================
        // BOTON AREA
        // =====================================================

        if (e.getSource() == vista.getBtnCalcularArea()) {

            calcularArea();
        }

        // =====================================================
        // BOTON PERIMETRO
        // =====================================================

        if (e.getSource() == vista.getBtnCalcularPerimetro()) {

            calcularPerimetro();
        }

        // =====================================================
        // BOTON LIMPIAR
        // =====================================================

        if (e.getSource() == vista.getBtnLimpiar()) {

            limpiar();
        }
    }

    // =====================================================
    // CALCULAR AREA
    // =====================================================

    public void calcularArea() {

        try {

            String figura = vista.getCbFigura().getSelectedItem().toString();

            double area = 0;

            if (figura.equals("Circulo")) {

                double radio = Double.parseDouble(vista.getTxtDato1().getText());

                Circulo c = new Circulo(radio, "", "", 0, 0);

                area = c.calcularArea();
            }

            if (figura.equals("Cuadrado")) {

                double lado = Double.parseDouble(vista.getTxtDato1().getText());

                Cuadrado c = new Cuadrado(lado, "", "", 0, 0);

                area = c.calcularArea();
            }

            if (figura.equals("Triangulo")) {

                double base = Double.parseDouble(vista.getTxtDato1().getText());

                double altura = Double.parseDouble(vista.getTxtDato2().getText());

                Triangulo t = new Triangulo(
                        1, 1, 1,
                        base,
                        altura,
                        "",
                        "",
                        0,
                        0
                );

                area = t.calcularArea();
            }

            vista.getLblResultadoArea().setText("Area: " + area);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null,
                    "Ingrese datos validos");
        }
    }

    // =====================================================
    // CALCULAR PERIMETRO
    // =====================================================

    public void calcularPerimetro() {

        try {

            String figura = vista.getCbFigura().getSelectedItem().toString();

            double perimetro = 0;

            if (figura.equals("Circulo")) {

                double radio = Double.parseDouble(vista.getTxtDato1().getText());

                Circulo c = new Circulo(radio, "", "", 0, 0);

                perimetro = c.calcularPerimetro();
            }

            if (figura.equals("Cuadrado")) {

                double lado = Double.parseDouble(vista.getTxtDato1().getText());

                Cuadrado c = new Cuadrado(lado, "", "", 0, 0);

                perimetro = c.calcularPerimetro();
            }

            if (figura.equals("Triangulo")) {

                double lado1 = Double.parseDouble(vista.getTxtDato1().getText());

                double lado2 = Double.parseDouble(vista.getTxtDato2().getText());

                double lado3 = Double.parseDouble(vista.getTxtDato3().getText());

                Triangulo t = new Triangulo(
                        lado1,
                        lado2,
                        lado3,
                        1,
                        1,
                        "",
                        "",
                        0,
                        0
                );

                perimetro = t.calcularPerimetro();
            }

            vista.getLblResultadoPerimetro()
                    .setText("Perimetro: " + perimetro);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null,
                    "Ingrese datos validos");
        }
    }

    // =====================================================
    // LIMPIAR
    // =====================================================

    public void limpiar() {

        vista.getTxtCodigo().setText("");
        vista.getTxtColor().setText("");
        vista.getTxtDato1().setText("");
        vista.getTxtDato2().setText("");
        vista.getTxtDato3().setText("");

        vista.getLblResultadoArea().setText("Area:");
        vista.getLblResultadoPerimetro().setText("Perimetro:");
    }
}