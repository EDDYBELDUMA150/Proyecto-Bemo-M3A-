/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.MConexion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Cotizacion_pastel;
import modelo.OCconection;
import modelo.Productos;

/**
 *
 * @author carlos
 */
public class modelo_cotizacion extends Cotizacion_pastel{
 
    
    
     OCconection conexion = new OCconection();

    public modelo_cotizacion() {
    }

    public modelo_cotizacion(String nombre_producto, double precio_unitario, int cantidad, String nom_extra, double subtotal, double total) {
        super(nombre_producto, precio_unitario, cantidad, nom_extra, subtotal, total);
    }
     
     
    
    public List<Productos> list_producto() {
        List<Productos> listaProductos = new ArrayList<Productos>();

        String sql = " select prod_id, prod_nombre, prod_precio from producto";

        ResultSet rs = conexion.consulta(sql);
        byte[] bytea;
        try {
            while (rs.next()) {
                Productos produ = new Productos();
                produ.setPrd_ID(rs.getInt(1));
                produ.setPrd_nombre(rs.getString(2));
                produ.setPrd_precio(rs.getDouble(3));
                listaProductos.add(produ);
            }
        } catch (Exception e) {
            Logger.getLogger(Modelocliente.class.getName()).log(Level.SEVERE, null, e);
        }

        try {
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Modelocliente.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaProductos;
    }
    
    public java.util.List<Productos> busquedaProducto(String filtro) {

        java.util.List<Productos> listaProductos = new ArrayList<Productos>();
        String sql = "select prod_id, prod_nombre , prod_precio from producto where prod_id like lower('%" + filtro + "%') OR prod_nombre like lower( '%" + filtro + "%')";
        ResultSet rs = conexion.consulta(sql);
        try {
            while (rs.next()) {

            Productos produ = new Productos();
                produ.setPrd_ID(rs.getInt(1));
                produ.setPrd_nombre(rs.getString(2));
                 produ.setPrd_precio(rs.getDouble(3));
                listaProductos.add(produ);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Modelocliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            rs.close();//cierro conexion BD
        } catch (SQLException ex) {
            Logger.getLogger(Modelocliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaProductos;
    }
    
}
