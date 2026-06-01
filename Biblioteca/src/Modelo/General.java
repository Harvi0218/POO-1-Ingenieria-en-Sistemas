/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Pc
 */
public class General extends Libro{
    private int copias;
    
    public General() {
    }

    public General(int copias, String titulo, String autor, String issn, int añoPublicacion, String editorial) {
        super(titulo, autor, issn, añoPublicacion, editorial);
        this.copias = copias;
    }

    public int getCopias() {
        return copias;
    }

    public void setCopias(int copias) {
        this.copias = copias;
    }
    
    
    
}
