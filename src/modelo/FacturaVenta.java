/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;

/**
 *
 * @author Abel Gomez
 */
public class FacturaVenta extends Factura{
    
    
   private int factura_id;
   private int cliente_id;
   private int producto_id;
   private String nombre_cliente;
   private String apellido_cliente;
   private String cedula_cliente;
   private String nombre_producto;
   private int cantidad_producto;
   private double precio_unitario_producto;
   private String cabecera_estado;
   private Date fecha_factura;
   private double iva;
   private double subtotal;
   private double total;
   private int cabecera_id;
   private int cuerpo_id;
   private double monto;

    public FacturaVenta() {
    }

    public FacturaVenta(int factura_id, int cliente_id, int producto_id, String nombre_cliente, String apellido_cliente, String cedula_cliente, String nombre_producto, int cantidad_producto, double precio_unitario_producto, String cabecera_estado, Date fecha_factura, double iva, double subtotal, double total, int cabecera_id, int cuerpo_id, double monto) {
        this.factura_id = factura_id;
        this.cliente_id = cliente_id;
        this.producto_id = producto_id;
        this.nombre_cliente = nombre_cliente;
        this.apellido_cliente = apellido_cliente;
        this.cedula_cliente = cedula_cliente;
        this.nombre_producto = nombre_producto;
        this.cantidad_producto = cantidad_producto;
        this.precio_unitario_producto = precio_unitario_producto;
        this.cabecera_estado = cabecera_estado;
        this.fecha_factura = fecha_factura;
        this.iva = iva;
        this.subtotal = subtotal;
        this.total = total;
        this.cabecera_id = cabecera_id;
        this.cuerpo_id = cuerpo_id;
        this.monto = monto;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

  

    public int getCuerpo_id() {
        return cuerpo_id;
    }

    public void setCuerpo_id(int cuerpo_id) {
        this.cuerpo_id = cuerpo_id;
    }

  

    public int getFactura_id() {
        return factura_id;
    }

    public void setFactura_id(int factura_id) {
        this.factura_id = factura_id;
    }

    public int getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

    public int getProducto_id() {
        return producto_id;
    }

    public void setProducto_id(int producto_id) {
        this.producto_id = producto_id;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public String getApellido_cliente() {
        return apellido_cliente;
    }

    public void setApellido_cliente(String apellido_cliente) {
        this.apellido_cliente = apellido_cliente;
    }

    public String getCedula_cliente() {
        return cedula_cliente;
    }

    public void setCedula_cliente(String cedula_cliente) {
        this.cedula_cliente = cedula_cliente;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public int getCantidad_producto() {
        return cantidad_producto;
    }

    public void setCantidad_producto(int cantidad_producto) {
        this.cantidad_producto = cantidad_producto;
    }

    public double getPrecio_unitario_producto() {
        return precio_unitario_producto;
    }

    public void setPrecio_unitario_producto(double precio_unitario_producto) {
        this.precio_unitario_producto = precio_unitario_producto;
    }

    public String getCabecera_estado() {
        return cabecera_estado;
    }

    public void setCabecera_estado(String cabecera_estado) {
        this.cabecera_estado = cabecera_estado;
    }

    public Date getFecha_factura() {
        return fecha_factura;
    }

    public void setFecha_factura(Date fecha_factura) {
        this.fecha_factura = fecha_factura;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
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

    public int getCabecera_id() {
        return cabecera_id;
    }

    public void setCabecera_id(int cabecera_id) {
        this.cabecera_id = cabecera_id;
    }
    
    
    
    
}
