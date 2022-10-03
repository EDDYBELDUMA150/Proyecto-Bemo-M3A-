/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author OWNER
 */
public class Usuarios {
    private int usuario_id;
    private String usuario_nombre;
    private String usuario_contra;
    private int usuario_tipo;

    public Usuarios() {
    }

    public Usuarios(int usuario_id, String usuario_nombre, String usuario_contra, int usuario_tipo) {
        this.usuario_id = usuario_id;
        this.usuario_nombre = usuario_nombre;
        this.usuario_contra = usuario_contra;
        this.usuario_tipo = usuario_tipo;
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public String getUsuario_nombre() {
        return usuario_nombre;
    }

    public void setUsuario_nombre(String usuario_nombre) {
        this.usuario_nombre = usuario_nombre;
    }

    public String getUsuario_contra() {
        return usuario_contra;
    }

    public void setUsuario_contra(String usuario_contra) {
        this.usuario_contra = usuario_contra;
    }

    public int getUsuario_tipo() {
        return usuario_tipo;
    }

    public void setUsuario_tipo(int usuario_tipo) {
        this.usuario_tipo = usuario_tipo;
    }
    
    
}
