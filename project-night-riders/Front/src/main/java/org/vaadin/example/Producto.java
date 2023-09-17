package org.vaadin.example;

public class Producto {
    private String nombre;
    private int cantidad;

    private int puntos;

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public Producto(String nombre, int cantidad, int puntos) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.puntos= puntos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
