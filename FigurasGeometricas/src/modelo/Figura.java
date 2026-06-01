package modelo;

public abstract class Figura {
    
    protected String codigo;
    protected String color;
    protected double area;
    protected double perimetro;

    public Figura(String codigo, String color, double area, double perimetro) {
        this.codigo = codigo;
        this.color = color;
        this.area = area;
        this.perimetro = perimetro;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getPerimetro() {
        return perimetro;
    }

    public void setPerimetro(double perimetro) {
        this.perimetro = perimetro;
    }

    public abstract double calcularArea();
    
    public abstract double calcularPerimetro();
    
}
