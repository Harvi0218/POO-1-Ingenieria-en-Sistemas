package modelo;

public class Circulo extends Figura {
    
    private double radio;

    public Circulo(double radio, String codigo, String color, double area, double perimetro) {
        super(codigo, color, area, perimetro);
        this.radio = radio;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    @Override
    public double calcularArea(){
       
       if (radio != 0){
           
           area = Math.PI * Math.pow(radio, radio);
           return area;
           
       } else {
           System.out.println("El radio no puede ser 0");
           return 0.0;
       }
    
    }
    
    @Override
    public double calcularPerimetro(){
       
       if (radio != 0){
           
           perimetro = Math.PI * radio; 
           return perimetro;
           
       } else {
           System.out.println("El radio no puede ser 0");
           return 0.0;
       }
       
}
    }