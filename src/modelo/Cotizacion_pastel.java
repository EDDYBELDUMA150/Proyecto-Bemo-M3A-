/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Abel Gomez
 */
public class Cotizacion_pastel {
    
      
   private String nombre_producto;
   private double precio_unitario;
   private int cantidad;
   private String nom_extra;
   private double subtotal;
   private double total;

    public Cotizacion_pastel() {
    }

    public Cotizacion_pastel(String nombre_producto, double precio_unitario, int cantidad, String nom_extra, double subtotal, double total) {
        this.nombre_producto = nombre_producto;
        this.precio_unitario = precio_unitario;
        this.cantidad = cantidad;
        this.nom_extra = nom_extra;
        this.subtotal = subtotal;
        this.total = total;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public double getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(double precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getNom_extra() {
        return nom_extra;
    }

    public void setNom_extra(String nom_extra) {
        this.nom_extra = nom_extra;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
   
   
    
}
