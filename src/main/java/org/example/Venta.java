package org.example;

public class Venta {
    private String nombre;
    private double venta;
    public Venta(String nombre, double venta) {
        this.nombre = nombre;
        this.venta = venta;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getVenta() {
        return venta;
    }
    public void setVenta(double venta) {
        this.venta = venta;
    }
    @Override
    public String toString() {
        return "Venta [nombre=" + nombre + ", venta=" + venta + "]";
    }

}
