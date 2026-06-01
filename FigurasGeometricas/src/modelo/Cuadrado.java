
package modelo;

public class Cuadrado extends Figura {
    
    private double ladoX;

    public Cuadrado(double ladoX, String codigo, String color, double area, double perimetro) {
        super(codigo, color, area, perimetro);
        this.ladoX = ladoX;
    }

    public double getLado() {
        return ladoX;
    }

    public void setLado(double lado) {
        this.ladoX= ladoX;
    }
    
    @Override
   public double calcularArea(){
       
       if (ladoX != 0){
           
           area = (ladoX * ladoX);
           return area;
           
       } else {
           System.out.println("El lado sea cualquiera tiene que ser diferente de 0 e igual a los otros 3 lados");
           return 0.0;
       }
       
   }
   
   @Override
   public double calcularPerimetro(){
       
       if (ladoX != 0){
           
           perimetro = (4*ladoX);
           return perimetro;
           
       } else {
           System.out.println("El lado sea cualquiera tiene que ser diferente de 0 e igual a los otros 3 lados");
           return 0.0;
       }
    
}
}
