/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.MConexion;

import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import modelo.Cliente;
import modelo.OCconection;
import modelo.PedidoPastel;
import modelo.Productos;

/**
 *
 * @author carlo
 */
public class Modelo_PedidoPastel extends PedidoPastel {

    OCconection conexion = new OCconection();

    public Modelo_PedidoPastel() {
    }

    public Modelo_PedidoPastel(int pdpt_ID, Date pdpt_fechapedido, Date pdpt_fechaentrga, String pdpt_nombrecliente, String pdpt_apellidocliente, String pdpt_nombreproducto, int pdpt_cantidad, String pdpt_especificacion, double pdpt_abono, Date pdpt_horaentrega, String pdpt_estado, int pdpt_cli_id, int pdpt_prod_id, Image pdpt_fotopastel, FileInputStream imagefile, int lengthfoto) {
        super(pdpt_ID, pdpt_fechapedido, pdpt_fechaentrga, pdpt_nombrecliente, pdpt_apellidocliente, pdpt_nombreproducto, pdpt_cantidad, pdpt_especificacion, pdpt_abono, pdpt_horaentrega, pdpt_estado, pdpt_cli_id, pdpt_prod_id, pdpt_fotopastel, imagefile, lengthfoto);
    }

    public List<PedidoPastel> getPedidoPastel() {
        List<PedidoPastel> listaPedidoPastel = new ArrayList<PedidoPastel>();
        String sql = "select pe.pedido_id,pe.pedido_fecha,pe.perdido_entrega,cli.cli_id,pers.pers_nombre1,pers.pers_apellido1,pro.prod_id,pro.prod_nombre, pe.pedido_cantidad,pe.pedido_especificacion,pe.pedido_abono,pe.pedido_foto,pe.pedido_estado\n"
                + "from pedidos pe join producto pro on pe.prod_id=pro.prod_id\n"
                + "join cliente cli on cli.cli_id=pe.cli_id\n"
                + "join persona pers on pers.pers_id=cli.pers_id where pe.pedido_estado='Activo' order by pedido_id";
        ResultSet rs = conexion.consulta(sql);
        byte[] bytea;
        try {
            while (rs.next()) {
                PedidoPastel mi_pedido = new PedidoPastel();

                mi_pedido.setPdpt_ID(rs.getInt(1));
                mi_pedido.setPdpt_fechapedido(rs.getDate(2));
                mi_pedido.setPdpt_fechaentrga(rs.getDate(3));
                mi_pedido.setPdpt_cli_id(rs.getInt(4));
                mi_pedido.setPdpt_nombrecliente(rs.getString(5));
                mi_pedido.setPdpt_apellidocliente(rs.getString(6));
                mi_pedido.setPdpt_prod_id(rs.getInt(7));
                mi_pedido.setPdpt_nombreproducto(rs.getString(8));
                mi_pedido.setPdpt_cantidad(rs.getInt(9));
                mi_pedido.setPdpt_especificacion(rs.getString(10));
                mi_pedido.setPdpt_abono(rs.getDouble(11));
                mi_pedido.setPdpt_estado(rs.getString(13));
                bytea = rs.getBytes(12);
                try {
                    if (bytea != null) {
                        mi_pedido.setPdpt_fotopastel(getImage(bytea));
                    }

                } catch (IOException ex) {
                    Logger.getLogger(Modelo_PedidoPastel.class.getName()).log(Level.SEVERE, null, ex);
                }

                listaPedidoPastel.add(mi_pedido);
            }
        } catch (Exception e) {
            Logger.getLogger(Modelo_PedidoPastel.class.getName()).log(Level.SEVERE, null, e);
        }
        try {
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Modelo_PedidoPastel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaPedidoPastel;
    }

    public Image getImage(byte[] bytes) throws IOException {

        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        Iterator it = ImageIO.getImageReadersByFormatName("jpeg");
        ImageReader imageReader = (ImageReader) it.next();
        Object source = bais;
        ImageInputStream iis = ImageIO.createImageInputStream(source);
        imageReader.setInput(iis, true);
        ImageReadParam param = imageReader.getDefaultReadParam();
        param.setSourceSubsampling(1, 1, 0, 0);

        return imageReader.read(0, param);

    }

    public int numeroidpedido() {
        int id = 0;
        String sql = "select max(pedido_id) from pedidos";
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

    public boolean setPedidoPastelito() {
        String sql;
        sql = "INSERT INTO pedidos (pedido_id,pedido_fecha,pedido_entrega,cli_id,prod_id,pedido_cantidad,pedido_especificacion,pedido_abono,pedido_foto,pedido_estado)";
        sql += "VALUES (?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement ps = conexion.conex.prepareStatement(sql);
            ps.setInt(1, getPdpt_ID());
            ps.setDate(2, (java.sql.Date) getPdpt_fechapedido());
            ps.setDate(3, (java.sql.Date) getPdpt_fechaentrga());
            ps.setInt(4, getPdpt_cli_id());
            ps.setInt(5, getPdpt_prod_id());
            ps.setInt(6, getPdpt_cantidad());
            ps.setString(7, getPdpt_especificacion());
            ps.setDouble(8, getPdpt_abono());
            ps.setBinaryStream(9, getImagefile(), getLengthfoto());
            ps.setString(10, getPdpt_estado());
            ps.executeUpdate();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Modelo_PedidoPastel.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public boolean updatePedido() {

        String sql = "update pedidos set pedido_fecha = ?, "
                + "pedido_entrega = ?,"
                + "pedido_cantidad = ?,"
                + "pedido_especificacion=?,"
                + "pedido_abono=?,"
                + "pedido_foto=? "
                + "where pedido_id = " + getPdpt_ID();
        try {
            PreparedStatement ps = conexion.conex.prepareStatement(sql);
            ps.setDate(1, (java.sql.Date) getPdpt_fechapedido());
            ps.setDate(2, (java.sql.Date) getPdpt_fechaentrga());
            ps.setInt(3, getPdpt_cantidad());
            ps.setString(4, getPdpt_especificacion());
            ps.setDouble(5, getPdpt_abono());
            ps.setBinaryStream(6, getImagefile(), getLengthfoto());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Modelocliente.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public boolean deletePedido() {
        String sql = "UPDATE pedidos SET pedido_estado='Cancelado' where pedido_id=" + getPdpt_ID();
        return conexion.accion(sql);//EJECUTAMOS EN DELETE
    }

    public List<Cliente> lista_cli() {
        List<Cliente> listaclientes = new ArrayList<Cliente>();

        String sql = " select c.cli_id ,p.pers_cedula,p.pers_nombre1,p.pers_apellido1 from cliente c \n"
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

    public List<PedidoPastel> buscarpedido(String filtro) {
        List<PedidoPastel> listaPedido = new ArrayList<PedidoPastel>();

        String sql = "select pe.pedido_id,pe.pedido_fecha,pe.pedido_entrega,cli.cli_id,pers.pers_nombre1,pers.pers_apellido1,pro.prod_id,pro.prod_nombre, pe.pedido_cantidad,pe.pedido_especificacion,pe.pedido_abono,pe.pedido_foto,pe.pedido_estado "
                + " from pedidos pe "
                + " join producto pro on pe.prod_id=pro.prod_id "
                + " join cliente cli on cli.cli_id=pe.cli_id"
                + " join persona pers on pers.pers_id=cli.pers_id"
                + " where   "
                + " (pe.pedido_id) LIKE lower ('" + filtro + "') or"
                + " (pers.pers_nombre1) LIKE lower ('" + filtro + "') or"
                + " (pers.pers_apellido1) LIKE lower ('" + filtro + "') and "
                + " pe.pedido_estado = 'Activo'";
        byte[] bytea;
        ResultSet rs = conexion.consulta(sql);

        try {
            while (rs.next()) {
                PedidoPastel mi_pedido = new PedidoPastel();

                mi_pedido.setPdpt_ID(rs.getInt(1));
                mi_pedido.setPdpt_fechapedido(rs.getDate(2));
                mi_pedido.setPdpt_fechaentrga(rs.getDate(3));
                mi_pedido.setPdpt_cli_id(rs.getInt(4));
                mi_pedido.setPdpt_nombrecliente(rs.getString(5));
                mi_pedido.setPdpt_apellidocliente(rs.getString(6));
                mi_pedido.setPdpt_prod_id(rs.getInt(7));
                mi_pedido.setPdpt_nombreproducto(rs.getString(8));
                mi_pedido.setPdpt_cantidad(rs.getInt(9));
                mi_pedido.setPdpt_especificacion(rs.getString(10));
                mi_pedido.setPdpt_abono(rs.getDouble(11));
                mi_pedido.setPdpt_estado(rs.getString(13));
                bytea = rs.getBytes(12);
                try {
                    if (bytea != null) {
                        mi_pedido.setPdpt_fotopastel(getImage(bytea));
                    }

                } catch (IOException ex) {
                    Logger.getLogger(Modelo_PedidoPastel.class.getName()).log(Level.SEVERE, null, ex);
                }

                listaPedido.add(mi_pedido);
            }
        } catch (Exception e) {
            Logger.getLogger(Modelocliente.class.getName()).log(Level.SEVERE, null, e);
        }

        try {
            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(Modelocliente.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaPedido;
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
}
