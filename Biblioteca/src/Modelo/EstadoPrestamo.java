/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package Modelo;

/**
 *
 * @author Pc
 */
public enum EstadoPrestamo {
    PRESTADO,DEVUELTO,MULTADO;

    public static EstadoPrestamo getPRESTADO() {
        return PRESTADO;
    }

    public static EstadoPrestamo getDEVUELTO() {
        return DEVUELTO;
    }

    public static EstadoPrestamo getMULTADO() {
        return MULTADO;
    }
    
    
    
}
