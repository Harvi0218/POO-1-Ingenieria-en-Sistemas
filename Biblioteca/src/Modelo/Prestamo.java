/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.time.LocalDate;

public class Prestamo {
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
    private EstadoPrestamo estado;
    private Libro prestado;
    private Usuario pide;

    public Prestamo() {}

    public Prestamo(LocalDate fechaPrestamo, LocalDate fechaDevolucion, EstadoPrestamo estado, Libro prestado, Usuario pide) {
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.estado = estado;
        this.prestado = prestado;
        this.pide = pide;
    }

    public LocalDate getFechaPrestamo() { return fechaPrestamo; }
    public void setFechaPrestamo(LocalDate fechaPrestamo) { this.fechaPrestamo = fechaPrestamo; }

    public LocalDate getFechaDevolucion() { return fechaDevolucion; }
    public void setFechaDevolucion(LocalDate fechaDevolucion) { this.fechaDevolucion = fechaDevolucion; }

    public EstadoPrestamo getEstado() { return estado; }
    public void setEstado(EstadoPrestamo estado) { this.estado = estado; }

    public Libro getPrestado() { return prestado; }
    public void setPrestado(Libro prestado) { this.prestado = prestado; }

    public Usuario getPide() { return pide; }
    public void setPide(Usuario pide) { this.pide = pide; }

    public void VerificarMulta(LocalDate fechaActual) {
        if(estado == EstadoPrestamo.PRESTADO){
            if(fechaActual.isAfter(fechaDevolucion)){
                estado = EstadoPrestamo.MULTADO;
            }
        }
    }
}
