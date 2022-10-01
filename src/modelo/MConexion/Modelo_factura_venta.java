/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.MConexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Cliente;
import modelo.FacturaVenta;
import modelo.OCconection;
import modelo.Productos;

/**
 *
 * @author carlos
 */
public class Modelo_factura_venta extends FacturaVenta {

    OCconection conexion = new OCconection();

    public Modelo_factura_venta() {
    }

    public Modelo_factura_venta(int factura_id, int cliente_id, int producto_id, String nombre_cliente, String apellido_cliente, String cedula_cliente, String nombre_producto, int cantidad_producto, double precio_unitario_producto, String cabecera_estado, Date fecha_factura, double iva, double subtotal, double total, int cabecera_id, int cuerpo_id, double monto) {
        super(factura_id, cliente_id, producto_id, nombre_cliente, apellido_cliente, cedula_cliente, nombre_producto, cantidad_producto, precio_unitario_producto, cabecera_estado, fecha_factura, iva, subtotal, total, cabecera_id, cuerpo_id, monto);
    }

    public List<FacturaVenta> getFacturita() {
        List<FacturaVenta> lista_factu = new ArrayList<FacturaVenta>();
        String sql = "select ca.cabecera_id, ca.cli_id,pers.pers_nombre1,pers.pers_apellido1,pers.pers_cedula, \n"
                + "ca.cabecera_fecha, ca.cabecera_estado, cu.cuerpo_id, cu.prod_id, cu.cuerpo_descripcion, \n"
                + "cu.cuerpo_cantidad, cu.cuerpo_iva, cu.cuerpo_subtotal, cu.cuerpo_total, fa.factura_id \n"
                + "from cabecera_factura ca join factura fa on ca.cabecera_id=fa.cabecera_id\n"
                + "join cuerpo_factura cu on cu.cuerpo_id=fa.cuerpo_id\n"
                + "join cliente cli on cli.cli_id=ca.cli_id\n"
                + "join persona pers on pers.pers_id=cli.pers_id";

        ResultSet rs = conexion.consulta(sql);
        try {
            while (rs.next()) {
                FacturaVenta mi_venta = new FacturaVenta();
                mi_venta.setCabecera_id(rs.getInt(1));
                mi_venta.setCliente_id(rs.getInt(2));
                mi_venta.setNombre_cliente(rs.getString(3));
                mi_venta.setApellido_cliente(rs.getString(4));
                mi_venta.setCedula_cliente(rs.getString(5));
                mi_venta.setFecha_factura(rs.getDate(6));
                mi_venta.setCabecera_estado(rs.getString(7));
                mi_venta.setCuerpo_id(rs.getInt(8));
                mi_venta.setProducto_id(rs.getInt(9));
                mi_venta.setNombre_producto(rs.getString(10));
                mi_venta.setCantidad_producto(rs.getInt(11));
                mi_venta.setIva(rs.getDouble(12));
                mi_venta.setSubtotal(rs.getDouble(13));
                mi_venta.setTotal(rs.getDouble(14));
                mi_venta.setFactura_id(rs.getInt(15));
                lista_factu.add(mi_venta);
            }
        } catch (Exception e) {
            Logger.getLogger(Modelo_factura_venta.class.getName()).log(Level.SEVERE, null, e);
        }
        try {
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Modelo_factura_venta.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista_factu;
    }

    public boolean setCabecerita() {
        String sql;
        sql = "insert into cabecera_factura (cabecera_id,cabecera_fecha,cli_id,cabecera_estado) values(?,?,?,?)";
        try {
            PreparedStatement ps = conexion.conex.prepareStatement(sql);
            ps.setInt(1, getCabecera_id());
            ps.setDate(2, (java.sql.Date) getFecha_factura());
            ps.setInt(3, getCliente_id());
            ps.setString(4, getCabecera_estado());
            ps.executeUpdate();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Modelo_factura_venta.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public void Insertcuerpito(FacturaVenta factve) {

        try {
            Connection cnx = OCconection.getConetion();
            PreparedStatement pst = cnx.prepareStatement("INSERT INTO cuerpo_factura(prod_id,cuerpo_descripcion,cuerpo_cantidad,cuerpo_iva,"
                    + " cuerpo_subtotal,cuerpo_total,cuerpo_prec_unitario,cuerpo_monto,cabecera_id)"
                    + " VALUES(?,?,?,?,?,?,?,?,?)");

            pst.setInt(1, factve.getProducto_id());
            pst.setString(2, factve.getNombre_producto());
            pst.setInt(3, factve.getCantidad_producto());
            pst.setDouble(4, factve.getIva());
            pst.setDouble(5, factve.getSubtotal());
            pst.setDouble(6, factve.getTotal());
            pst.setDouble(7, factve.getPrecio_unitario_producto());
            pst.setDouble(8, factve.getMonto());
            pst.setInt(9, factve.getCabecera_id());

            pst.executeQuery();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error en Ingresar datos");
        }
    }

    public boolean setFacturita() {
        String sql = "";
        sql = "insert into factura (factura_id,cabecera_id,cuerpo_id) values (?,?,?)";
        try {
            PreparedStatement ps = conexion.conex.prepareStatement(sql);
            ps.setInt(1, getFactura_id());
            ps.setInt(2, getCabecera_id());
            ps.setInt(3, getCuerpo_id());
            ps.executeUpdate();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(Modelo_factura_venta.class.getName()).log(Level.SEVERE, null, ex);

            return false;
        }

    }

    public int numeroidfactura() {
        int id = 0;
        String sql = "select max(factura_id) from factura";
        ResultSet rs = conexion.consulta(sql);

        try {
            while (rs.next()) {
                id = rs.getInt(1);

            }
        } catch (Exception e) {
            Logger.getLogger(Modelocliente.class.getName()).log(Level.SEVERE, null, e);
        }

        try {
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Modelocliente.class.getName()).log(Level.SEVERE, null, ex);
        }

        return id;

    }

    public int numeroidcuerpo() {
        int id = 0;
        String sql = "select max(cuerpo_id) from cuerpo_factura";
        ResultSet rs = conexion.consulta(sql);

        try {
            while (rs.next()) {
                id = rs.getInt(1);

            }
        } catch (Exception e) {
            Logger.getLogger(Modelocliente.class.getName()).log(Level.SEVERE, null, e);
        }

        try {
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Modelocliente.class.getName()).log(Level.SEVERE, null, ex);
        }

        return id;

    }

    public int numeroidcabecera() {
        int id = 0;
        String sql = "select max(cabecera_id) from cabecera_factura";
        ResultSet rs = conexion.consulta(sql);

        try {
            while (rs.next()) {
                id = rs.getInt(1);

            }
        } catch (Exception e) {
            Logger.getLogger(Modelocliente.class.getName()).log(Level.SEVERE, null, e);
        }

        try {
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Modelocliente.class.getName()).log(Level.SEVERE, null, ex);
        }

        return id;

    }

    public int consultar_id_cabecera() {
        int id = 0;
        String sql = "select max(cabecera_id) from cabecera_factura";
        ResultSet rs = conexion.consulta(sql);

        try {
            while (rs.next()) {
                id = rs.getInt(1);

            }
        } catch (Exception e) {
            Logger.getLogger(Modelocliente.class.getName()).log(Level.SEVERE, null, e);
        }

        try {
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Modelocliente.class.getName()).log(Level.SEVERE, null, ex);
        }

        return id;

    }

    public int consultar_id_cuerpo() {
        int id = 0;
        String sql = "select max(cuerpo_id) from cuerpo_factura";
        ResultSet rs = conexion.consulta(sql);

        try {
            while (rs.next()) {
                id = rs.getInt(1);

            }
        } catch (Exception e) {
            Logger.getLogger(Modelocliente.class.getName()).log(Level.SEVERE, null, e);
        }

        try {
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Modelocliente.class.getName()).log(Level.SEVERE, null, ex);
        }

        return id;

    }

    public List<Cliente> lista_cli() {
        List<Cliente> listaclientes = new ArrayList<Cliente>();

        String sql = " select c.cli_id ,p.pers_cedula,p.pers_nombre1,p.pers_apellido1,p.pers_direccion from cliente c \n"
                + "join persona p on (p.pers_id = c.pers_id)";

        ResultSet rs = conexion.consulta(sql);
        byte[] bytea;
        try {
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setCl_ID(rs.getInt(1));
                cliente.setPrs_cedula(rs.getString(2));
                cliente.setPrs_nombre1(rs.getString(3));
                cliente.setPrs_apellido1(rs.getString(4));
                cliente.setPrs_direccion(rs.getString(5));
                listaclientes.add(cliente);
            }
        } catch (Exception e) {
            Logger.getLogger(Modelocliente.class.getName()).log(Level.SEVERE, null, e);
        }

        try {
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Modelocliente.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaclientes;
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

    public java.util.List<Cliente> busqueda_cliente(String filtro) {

        java.util.List<Cliente> listacliente = new ArrayList<Cliente>();
        String sql = " select c.cli_id ,p.pers_cedula,p.pers_nombre1,p.pers_apellido1  from cliente c \n"
                + "join persona p on (p.pers_id = c.pers_id) where c.cli_id like lower('%" + filtro + "%') OR p.pers_cedula like lower( '%" + filtro + "%' )"
                + "OR p.pers_nombre1 like lower('%" + filtro + "%')"
                + "OR p.pers_apellido1 like lower('%" + filtro + "%')";
        ResultSet rs = conexion.consulta(sql);
        try {
            while (rs.next()) {

                Cliente cliente = new Cliente();
                cliente.setCl_ID(rs.getInt(1));
                cliente.setPrs_cedula(rs.getString(2));
                cliente.setPrs_nombre1(rs.getString(3));
                cliente.setPrs_apellido1(rs.getString(4));
                listacliente.add(cliente);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Modelocliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            rs.close();//cierro conexion BD
        } catch (SQLException ex) {
            Logger.getLogger(Modelocliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listacliente;
    }

    public List<FacturaVenta> consulta_factura() {
        List<FacturaVenta> lista_factu = new ArrayList<FacturaVenta>();

        String sql = "select  fa.factura_id, ca.cli_id,pers.pers_nombre1,pers.pers_apellido1,pers.pers_cedula, ca.cabecera_fecha, cu.cuerpo_total\n"
                + "from cabecera_factura ca join factura fa on ca.cabecera_id=fa.cabecera_id join cuerpo_factura cu on cu.cuerpo_id=fa.cuerpo_id\n"
                + "join cliente cli on cli.cli_id=ca.cli_id join persona pers on pers.pers_id=cli.pers_id where ca.cabecera_id=cu.cabecera_id";

        ResultSet rs = conexion.consulta(sql);
        try {
            while (rs.next()) {
                FacturaVenta mi_venta = new FacturaVenta();
                mi_venta.setFactura_id(rs.getInt(1));
                mi_venta.setCliente_id(rs.getInt(2));
                mi_venta.setNombre_cliente(rs.getString(3));
                mi_venta.setApellido_cliente(rs.getString(4));
                mi_venta.setCedula_cliente(rs.getString(5));
                mi_venta.setFecha_factura(rs.getDate(6));
                mi_venta.setTotal(rs.getDouble(7));

                lista_factu.add(mi_venta);
            }
        } catch (Exception e) {
            Logger.getLogger(Modelo_factura_venta.class.getName()).log(Level.SEVERE, null, e);
        }
        try {
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Modelo_factura_venta.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista_factu;
    }
    
    public List<FacturaVenta> consulta_facturaDesdeHasta(String Desde, String Hasta) {
        List<FacturaVenta> lista_factu = new ArrayList<FacturaVenta>();

            String sql = "select  fa.factura_id, ca.cli_id,pers.pers_nombre1,pers.pers_apellido1,pers.pers_cedula, ca.cabecera_fecha, cu.cuerpo_total\n"
                + "from cabecera_factura ca join factura fa on ca.cabecera_id=fa.cabecera_id join cuerpo_factura cu on cu.cuerpo_id=fa.cuerpo_id\n"
                + "join cliente cli on cli.cli_id=ca.cli_id join persona pers on pers.pers_id=cli.pers_id where ca.cabecera_id=cu.cabecera_id "
                    + "AND cabecera_fecha BETWEEN to_date('"+Desde+"', 'YYYY/MM/DD') AND to_date('"+Hasta+"', 'YYYY/MM/DD')";

        ResultSet rs = conexion.consulta(sql);
        try {
            while (rs.next()) {
                FacturaVenta mi_venta = new FacturaVenta();
                mi_venta.setFactura_id(rs.getInt(1));
                mi_venta.setCliente_id(rs.getInt(2));
                mi_venta.setNombre_cliente(rs.getString(3));
                mi_venta.setApellido_cliente(rs.getString(4));
                mi_venta.setCedula_cliente(rs.getString(5));
                mi_venta.setFecha_factura(rs.getDate(6));
                mi_venta.setTotal(rs.getDouble(7));

                lista_factu.add(mi_venta);
            }
        } catch (Exception e) {
            Logger.getLogger(Modelo_factura_venta.class.getName()).log(Level.SEVERE, null, e);
        }
        try {
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Modelo_factura_venta.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista_factu;
    }
    
    public List<FacturaVenta> consulta_facturaDIAESPECIF(String Desde) {
        List<FacturaVenta> lista_factu = new ArrayList<FacturaVenta>();

            String sql = "select  fa.factura_id, ca.cli_id,pers.pers_nombre1,pers.pers_apellido1,pers.pers_cedula, ca.cabecera_fecha, cu.cuerpo_total\n"
                + "from cabecera_factura ca join factura fa on ca.cabecera_id=fa.cabecera_id join cuerpo_factura cu on cu.cuerpo_id=fa.cuerpo_id\n"
                + "join cliente cli on cli.cli_id=ca.cli_id join persona pers on pers.pers_id=cli.pers_id where ca.cabecera_id=cu.cabecera_id "
                        + "AND cabecera_fecha BETWEEN to_date('"+Desde+"', 'YYYY/MM/DD') AND to_date('"+Desde+"', 'YYYY/MM/DD')";

        ResultSet rs = conexion.consulta(sql);
        try {
            while (rs.next()) {
                FacturaVenta mi_venta = new FacturaVenta();
                mi_venta.setFactura_id(rs.getInt(1));
                mi_venta.setCliente_id(rs.getInt(2));
                mi_venta.setNombre_cliente(rs.getString(3));
                mi_venta.setApellido_cliente(rs.getString(4));
                mi_venta.setCedula_cliente(rs.getString(5));
                mi_venta.setFecha_factura(rs.getDate(6));
                mi_venta.setTotal(rs.getDouble(7));

                lista_factu.add(mi_venta);
            }
        } catch (Exception e) {
            Logger.getLogger(Modelo_factura_venta.class.getName()).log(Level.SEVERE, null, e);
        }
        try {
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Modelo_factura_venta.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista_factu;
    }
    
    public List<FacturaVenta> consulta_facturaHOY() {
        List<FacturaVenta> lista_factu = new ArrayList<FacturaVenta>();

            String sql = "select  fa.factura_id, ca.cli_id,pers.pers_nombre1,pers.pers_apellido1,pers.pers_cedula, ca.cabecera_fecha, cu.cuerpo_total\n"
                + "from cabecera_factura ca join factura fa on ca.cabecera_id=fa.cabecera_id join cuerpo_factura cu on cu.cuerpo_id=fa.cuerpo_id\n"
                + "join cliente cli on cli.cli_id=ca.cli_id join persona pers on pers.pers_id=cli.pers_id where ca.cabecera_id=cu.cabecera_id "
                    + "AND cabecera_fecha = to_date(sysdate)";

        ResultSet rs = conexion.consulta(sql);
        try {
            while (rs.next()) {
                FacturaVenta mi_venta = new FacturaVenta();
                mi_venta.setFactura_id(rs.getInt(1));
                mi_venta.setCliente_id(rs.getInt(2));
                mi_venta.setNombre_cliente(rs.getString(3));
                mi_venta.setApellido_cliente(rs.getString(4));
                mi_venta.setCedula_cliente(rs.getString(5));
                mi_venta.setFecha_factura(rs.getDate(6));
                mi_venta.setTotal(rs.getDouble(7));

                lista_factu.add(mi_venta);
            }
        } catch (Exception e) {
            Logger.getLogger(Modelo_factura_venta.class.getName()).log(Level.SEVERE, null, e);
        }
        try {
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Modelo_factura_venta.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista_factu;
    }
    
    public List<FacturaVenta> consulta_facturaESTASEMANA() {
        List<FacturaVenta> lista_factu = new ArrayList<FacturaVenta>();

            String sql = "select  fa.factura_id, ca.cli_id,pers.pers_nombre1,pers.pers_apellido1,pers.pers_cedula, ca.cabecera_fecha, cu.cuerpo_total\n"
                + "from cabecera_factura ca join factura fa on ca.cabecera_id=fa.cabecera_id join cuerpo_factura cu on cu.cuerpo_id=fa.cuerpo_id\n"
                + "join cliente cli on cli.cli_id=ca.cli_id join persona pers on pers.pers_id=cli.pers_id where ca.cabecera_id=cu.cabecera_id "
                    + "AND ca.cabecera_id=cu.cabecera_id AND TO_char(cabecera_fecha, 'WW')= to_char(sysdate, 'WW')";

        ResultSet rs = conexion.consulta(sql);
        try {
            while (rs.next()) {
                FacturaVenta mi_venta = new FacturaVenta();
                mi_venta.setFactura_id(rs.getInt(1));
                mi_venta.setCliente_id(rs.getInt(2));
                mi_venta.setNombre_cliente(rs.getString(3));
                mi_venta.setApellido_cliente(rs.getString(4));
                mi_venta.setCedula_cliente(rs.getString(5));
                mi_venta.setFecha_factura(rs.getDate(6));
                mi_venta.setTotal(rs.getDouble(7));

                lista_factu.add(mi_venta);
            }
        } catch (Exception e) {
            Logger.getLogger(Modelo_factura_venta.class.getName()).log(Level.SEVERE, null, e);
        }
        try {
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Modelo_factura_venta.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista_factu;
    }
     
     public List<FacturaVenta> consulta_facturaESTEMES() {
        List<FacturaVenta> lista_factu = new ArrayList<FacturaVenta>();

            String sql = "select  fa.factura_id, ca.cli_id,pers.pers_nombre1,pers.pers_apellido1,pers.pers_cedula, ca.cabecera_fecha, cu.cuerpo_total\n"
                + "from cabecera_factura ca join factura fa on ca.cabecera_id=fa.cabecera_id join cuerpo_factura cu on cu.cuerpo_id=fa.cuerpo_id\n"
                + "join cliente cli on cli.cli_id=ca.cli_id join persona pers on pers.pers_id=cli.pers_id where ca.cabecera_id=cu.cabecera_id "
                    + "AND ca.cabecera_id=cu.cabecera_id AND TO_char(cabecera_fecha, 'MM')= to_char(sysdate, 'MM')";

        ResultSet rs = conexion.consulta(sql);
        try {
            while (rs.next()) {
                FacturaVenta mi_venta = new FacturaVenta();
                mi_venta.setFactura_id(rs.getInt(1));
                mi_venta.setCliente_id(rs.getInt(2));
                mi_venta.setNombre_cliente(rs.getString(3));
                mi_venta.setApellido_cliente(rs.getString(4));
                mi_venta.setCedula_cliente(rs.getString(5));
                mi_venta.setFecha_factura(rs.getDate(6));
                mi_venta.setTotal(rs.getDouble(7));

                lista_factu.add(mi_venta);
            }
        } catch (Exception e) {
            Logger.getLogger(Modelo_factura_venta.class.getName()).log(Level.SEVERE, null, e);
        }
        try {
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Modelo_factura_venta.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista_factu;
    }
}
