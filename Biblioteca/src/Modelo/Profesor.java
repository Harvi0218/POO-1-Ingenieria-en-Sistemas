/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Pc
 */
public class Profesor extends Usuario{
    
    private int plazoMaximo = 15;

    public Profesor() {
    }
    
    public Profesor(String nombre, String codigo) {
    super(nombre, codigo); // Esto llama al constructor de Usuario
    
    
}

    public int getPlazoMaximo() {
        return plazoMaximo;
    }

    public void setPlazoMaximo(int plazoMaximo) {
        this.plazoMaximo = plazoMaximo;
    }
    
}
