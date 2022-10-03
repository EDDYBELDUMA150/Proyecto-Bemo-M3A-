/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
import javax.swing.filechooser.FileNameExtensionFilter;
import modelo.FacturaGastoCorriente;
import modelo.OCconection;

/**
 *
 * @author OWNER
 */
public class ModelGastoCorriente extends modelo.FacturaGastoCorriente {

    OCconection conexion = new OCconection();
    modelo.FacturaGastoCorriente modeloFGcorriente = new FacturaGastoCorriente();

    public ModelGastoCorriente() {
    }

    public ModelGastoCorriente(String fctG_descripccion, Image fotoFactura, String fctG_estado, FileInputStream imageFile, int length, int NregistrosGC, int fct_ID, double fct_subtotal, double fct_total, Date fct_fecha, int fct_cantidad, double fct_precio) {
        super(fctG_descripccion, fotoFactura, fctG_estado, imageFile, length, NregistrosGC, fct_ID, fct_subtotal, fct_total, fct_fecha, fct_cantidad, fct_precio);
    }

    public List<FacturaGastoCorriente> getGastoC() {
        List<FacturaGastoCorriente> listaGastoCorrientes = new ArrayList<FacturaGastoCorriente>();
        String sql = "SELECT factgc_id, factgc_descripcion, factgc_fecha, factgc_total, factgc_fotofact FROM factura_gasto_corriente"
                + " WHERE factgc_estado ='ACTIVO' order by factgc_fecha asc";
        ResultSet rs = conexion.consulta(sql);
        byte[] bytea;

        try {
            while (rs.next()) {
                FacturaGastoCorriente fcG = new FacturaGastoCorriente();

                fcG.setFct_ID(rs.getInt(1));
                fcG.setFctG_descripccion(rs.getString(2));
                fcG.setFct_fecha(rs.getDate(3));
                fcG.setFct_precio(rs.getDouble(4));
                bytea = rs.getBytes(5);
                if (bytea != null) {
                    try {
                        fcG.setFotoFactura(getImage(bytea));
                    } catch (IOException ex) {
                        Logger.getLogger(ModelGastoCorriente.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                listaGastoCorrientes.add(fcG);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModelGastoCorriente.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ModelGastoCorriente.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaGastoCorrientes;
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

    public boolean setGastoC() {
        String sql = "INSERT INTO factura_gasto_corriente(factgc_id, factgc_descripcion, factgc_fecha, factgc_total, factgc_fotofact, factgc_estado)";
        sql += "VALUES(?,?,?,?,?,?)";

        try {
            PreparedStatement ps = conexion.conex.prepareStatement(sql);
            ps.setInt(1, getFct_ID());
            ps.setString(2, getFctG_descripccion());
            ps.setDate(3, (java.sql.Date) getFct_fecha());
            ps.setDouble(4, getFct_precio());
            ps.setBinaryStream(5, getImageFile(), getLength());
            ps.setString(6, getFctG_estado());
            ps.executeUpdate();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(ModelGastoCorriente.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean updateGastoC() {
        String sql = "UPDATE factura_gasto_corriente set "
                + "factgc_descripcion=?, "
                + "factgc_total=?, "
                + "factgc_fotofact=? "
                + "where factgc_id= " + getFct_ID();
        try {
            PreparedStatement ps = conexion.conex.prepareStatement(sql);

            ps.setString(1, getFctG_descripccion());
            ps.setDouble(2, getFct_precio());
            ps.setBinaryStream(3, getImageFile(), getLength());
            ps.executeUpdate();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ModelGastoCorriente.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean deleteGastoC() {
        String sql = "UPDATE factura_gasto_corriente SET factgc_estado='INACTIVO' where factgc_id=" + getFct_ID();
        return conexion.accion(sql);//EJECUTAMOS EN DELETE
    }

    public int countRegistrosGastosC() {
        String sql = "select factgc_id "
                + "from factura_gasto_corriente "
                + "where factgc_id ="
                + " ("
                + "   select max(factgc_id) from factura_gasto_corriente"
                + " )";

        try {
            PreparedStatement pst = conexion.getConex().prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                modeloFGcorriente.setNregistrosGC(rs.getInt(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModelCategoria.class.getName()).log(Level.SEVERE, null, ex);
        }
        return modeloFGcorriente.getNregistrosGC();
    }
    
    public List<FacturaGastoCorriente> getGastoCDesdeAhora(String Desde, String Hasta) {
        List<FacturaGastoCorriente> listaGastoCorrientes = new ArrayList<FacturaGastoCorriente>();
        String sql = "SELECT factgc_id, factgc_descripcion, factgc_fecha, factgc_total, factgc_fotofact FROM factura_gasto_corriente"
                + " WHERE factgc_estado ='ACTIVO' AND factgc_fecha BETWEEN to_date('"+Desde+"', 'YYYY/MM/DD') AND to_date('"+Hasta+"', 'YYYY/MM/DD') "
                + "order by factgc_fecha asc";
        ResultSet rs = conexion.consulta(sql);
        byte[] bytea;

        try {
            while (rs.next()) {
                FacturaGastoCorriente fcG = new FacturaGastoCorriente();

                fcG.setFct_ID(rs.getInt(1));
                fcG.setFctG_descripccion(rs.getString(2));
                fcG.setFct_fecha(rs.getDate(3));
                fcG.setFct_precio(rs.getDouble(4));
                bytea = rs.getBytes(5);
                if (bytea != null) {
                    try {
                        fcG.setFotoFactura(getImage(bytea));
                    } catch (IOException ex) {
                        Logger.getLogger(ModelGastoCorriente.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                listaGastoCorrientes.add(fcG);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModelGastoCorriente.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ModelGastoCorriente.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaGastoCorrientes;
    }
    
    public List<FacturaGastoCorriente> getGastoCDesde(String Desde) {
        List<FacturaGastoCorriente> listaGastoCorrientes = new ArrayList<FacturaGastoCorriente>();
        String sql = "SELECT factgc_id, factgc_descripcion, factgc_fecha, factgc_total, factgc_fotofact FROM factura_gasto_corriente"
                + " WHERE factgc_estado ='ACTIVO' AND factgc_fecha BETWEEN to_date('"+Desde+"', 'YYYY/MM/DD') AND to_date('"+Desde+"', 'YYYY/MM/DD') "
                + "order by factgc_fecha asc";
        ResultSet rs = conexion.consulta(sql);
        byte[] bytea;

        try {
            while (rs.next()) {
                FacturaGastoCorriente fcG = new FacturaGastoCorriente();

                fcG.setFct_ID(rs.getInt(1));
                fcG.setFctG_descripccion(rs.getString(2));
                fcG.setFct_fecha(rs.getDate(3));
                fcG.setFct_precio(rs.getDouble(4));
                bytea = rs.getBytes(5);
                if (bytea != null) {
                    try {
                        fcG.setFotoFactura(getImage(bytea));
                    } catch (IOException ex) {
                        Logger.getLogger(ModelGastoCorriente.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                listaGastoCorrientes.add(fcG);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModelGastoCorriente.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ModelGastoCorriente.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaGastoCorrientes;
    }
    
    public List<FacturaGastoCorriente> getGastoCHoy() {
        List<FacturaGastoCorriente> listaGastoCorrientes = new ArrayList<FacturaGastoCorriente>();
        String sql = "SELECT factgc_id, factgc_descripcion, factgc_fecha, factgc_total, factgc_fotofact FROM factura_gasto_corriente"
                + " WHERE factgc_estado ='ACTIVO' AND to_char(factgc_fecha) = to_date(sysdate) "
                + "order by factgc_fecha asc";
        ResultSet rs = conexion.consulta(sql);
        byte[] bytea;

        try {
            while (rs.next()) {
                FacturaGastoCorriente fcG = new FacturaGastoCorriente();

                fcG.setFct_ID(rs.getInt(1));
                fcG.setFctG_descripccion(rs.getString(2));
                fcG.setFct_fecha(rs.getDate(3));
                fcG.setFct_precio(rs.getDouble(4));
                bytea = rs.getBytes(5);
                if (bytea != null) {
                    try {
                        fcG.setFotoFactura(getImage(bytea));
                    } catch (IOException ex) {
                        Logger.getLogger(ModelGastoCorriente.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                listaGastoCorrientes.add(fcG);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModelGastoCorriente.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ModelGastoCorriente.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaGastoCorrientes;
    }
    
    public List<FacturaGastoCorriente> getGastoCEstaSemana() {
        List<FacturaGastoCorriente> listaGastoCorrientes = new ArrayList<FacturaGastoCorriente>();
        String sql = "SELECT factgc_id, factgc_descripcion, factgc_fecha, factgc_total, factgc_fotofact FROM factura_gasto_corriente"
                + " WHERE factgc_estado ='ACTIVO' AND to_char(factgc_fecha, 'WW')= to_char(sysdate, 'WW') "
                + "order by factgc_fecha asc";
        ResultSet rs = conexion.consulta(sql);
        byte[] bytea;

        try {
            while (rs.next()) {
                FacturaGastoCorriente fcG = new FacturaGastoCorriente();

                fcG.setFct_ID(rs.getInt(1));
                fcG.setFctG_descripccion(rs.getString(2));
                fcG.setFct_fecha(rs.getDate(3));
                fcG.setFct_precio(rs.getDouble(4));
                bytea = rs.getBytes(5);
                if (bytea != null) {
                    try {
                        fcG.setFotoFactura(getImage(bytea));
                    } catch (IOException ex) {
                        Logger.getLogger(ModelGastoCorriente.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                listaGastoCorrientes.add(fcG);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModelGastoCorriente.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ModelGastoCorriente.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaGastoCorrientes;
    }
    
    public List<FacturaGastoCorriente> getGastoCEsteMes() {
        List<FacturaGastoCorriente> listaGastoCorrientes = new ArrayList<FacturaGastoCorriente>();
        String sql = "SELECT factgc_id, factgc_descripcion, factgc_fecha, factgc_total, factgc_fotofact FROM factura_gasto_corriente"
                + " WHERE factgc_estado ='ACTIVO' AND TO_char(factgc_fecha, 'MM')= to_char(sysdate, 'MM') "
                + "order by factgc_fecha asc";
        ResultSet rs = conexion.consulta(sql);
        byte[] bytea;

        try {
            while (rs.next()) {
                FacturaGastoCorriente fcG = new FacturaGastoCorriente();

                fcG.setFct_ID(rs.getInt(1));
                fcG.setFctG_descripccion(rs.getString(2));
                fcG.setFct_fecha(rs.getDate(3));
                fcG.setFct_precio(rs.getDouble(4));
                bytea = rs.getBytes(5);
                if (bytea != null) {
                    try {
                        fcG.setFotoFactura(getImage(bytea));
                    } catch (IOException ex) {
                        Logger.getLogger(ModelGastoCorriente.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                listaGastoCorrientes.add(fcG);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModelGastoCorriente.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ModelGastoCorriente.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaGastoCorrientes;
    }
}
