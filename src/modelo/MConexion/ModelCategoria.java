/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.MConexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Abel Gomez
 */
public class ModelCategoria extends modelo.Categoria {

    modelo.OCconection conn = new modelo.OCconection();
    modelo.Categoria mcat = new modelo.Categoria();

    public ModelCategoria() {
    }

    public ModelCategoria(int ctg_ID, String ctg_nombre, String ctg_estado, int Nregistros) {
        super(ctg_ID, ctg_nombre, ctg_estado, Nregistros);
    }

    public java.util.List<modelo.Categoria> getCategorias() {
        
        java.util.List<modelo.Categoria> listaCategorias = new ArrayList<>();
        String sql = "select cate_id, cat_nombre, cate_estado from categoria where cate_estado='ACTIVO' order by cate_id ASC";
        ResultSet rs = conn.consulta(sql);
        try {
            while (rs.next()) {
                modelo.Categoria categoria = new modelo.Categoria();
                categoria.setCtg_ID(rs.getInt(1));
                categoria.setCtg_nombre(rs.getString(2));
                categoria.setCtg_estado(rs.getString(3));
              
                listaCategorias.add(categoria);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModelCategoria.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ModelCategoria.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaCategorias;
    }
    
    public boolean setCategoria() {
        String sql;
        sql = "INSERT INTO categoria (cate_id, cat_nombre, cate_estado)";
        sql += "VALUES (?,?,?)";
        try {
            PreparedStatement ps = conn.conex.prepareStatement(sql);
            ps.setInt(1, getCtg_ID());
            ps.setString(2, getCtg_nombre());
            ps.setString(3, getCtg_estado());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ModelCategoria.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean uptadeCategoria() {
        String sql;
        sql = "UPDATE categoria SET cate_id=? ,cat_nombre=?"
                + "WHERE cate_id='" + getCtg_ID()+ "'";
        try {
            PreparedStatement ps = conn.conex.prepareStatement(sql);
            ps.setInt(1, getCtg_ID());
            ps.setString(2, getCtg_nombre());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ModelCategoria.class.getName()).log(Level.SEVERE, null, ex);
            return false;  
        }
    }
    
    public boolean desactivarProducto() {
        String sql = "UPDATE categoria SET cate_estado='INACTIVO' where cate_id='" + getCtg_ID()+ "'";
        return conn.accion(sql);
    }
    
    public boolean buscarCategoria() {
        String sql = "select * from categoria "
                + "where cate_id like '" + getCtg_ID()+ "%' OR lower(cat_nombre) like'" + getCtg_nombre()+ "%'";
        return conn.accion(sql);
    }
    
    public int countRegistros() {
        String sql = "select count(*) from categoria";

        try {
            PreparedStatement pst = conn.getConex().prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                mcat.setNregistros(rs.getInt(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModelCategoria.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mcat.getNregistros();
    }
}
