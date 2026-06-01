
package modelo;

public class Triangulo extends Figura {
    
    private double ladoA;
    private double ladoB;
    private double ladoC;
    private double base;
    private double altura;

    public Triangulo(double ladoA, double ladoB, double ladoC, double base, double altura, String codigo, String color, double area, double perimetro) {
        super(codigo, color, area, perimetro);
        this.ladoA = ladoA;
        this.ladoB = ladoB;
        this.ladoC = ladoC;
        this.base = base;
        this.altura = altura;
    }

    

    public double getLadoA() {
        return ladoA;
    }

    public void setLadoA(double ladoA) {
        this.ladoA = ladoA;
    }

    public double getLadoB() {
        return ladoB;
    }

    public void setLadoB(double ladoB) {
        this.ladoB = ladoB;
    }

    public double getLadoC() {
        return ladoC;
    }

    public void setLadoC(double ladoC) {
        this.ladoC = ladoC;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
    
   @Override
   public double calcularArea(){
       
       if (base != 0 && altura != 0){
           
           area =(base*altura)/2;
           return area;
           
       } else {
           System.out.println("La base o la altura es igua la 0, verifique los datos");
           return 0.0;
       }
       
   }
   
   @Override
   public double calcularPerimetro(){
       
       if (ladoA != 0 && ladoB != 0 && ladoC != 0){
           
           perimetro = (ladoA+ladoB+ladoC);
           
           return perimetro;
       } else {
           System.out.println("Alguno de los lados o varios de estos son iguales a 0");
           return 0.0;
       }
       
       
   }
    
}
