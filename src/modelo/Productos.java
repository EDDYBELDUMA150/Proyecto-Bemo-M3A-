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
public class Productos {
    
    private int prd_ID;
    private String prd_nombre;
    private double prd_precio;
    private int prd_IDCategoria;
    private String prd_nombreCategoria;
    private String prd_estado;
    private int NregistrosP;

    public Productos() {
    }

    public Productos(int prd_ID, String prd_nombre, double prd_precio, int prd_IDCategoria, String prd_nombreCategoria, String prd_estado, int NregistrosP) {
        this.prd_ID = prd_ID;
        this.prd_nombre = prd_nombre;
        this.prd_precio = prd_precio;
        this.prd_IDCategoria = prd_IDCategoria;
        this.prd_nombreCategoria = prd_nombreCategoria;
        this.prd_estado = prd_estado;
        this.NregistrosP = NregistrosP;
    }
    
    public int getPrd_ID() {
        return prd_ID;
    }

    public void setPrd_ID(int prd_ID) {
        this.prd_ID = prd_ID;
    }

    public String getPrd_nombre() {
        return prd_nombre;
    }

    public void setPrd_nombre(String prd_nombre) {
        this.prd_nombre = prd_nombre;
    }

    public double getPrd_precio() {
        return prd_precio;
    }

    public void setPrd_precio(double prd_precio) {
        this.prd_precio = prd_precio;
    }

    public int getPrd_IDCategoria() {
        return prd_IDCategoria;
    }

    public void setPrd_IDCategoria(int prd_IDCategoria) {
        this.prd_IDCategoria = prd_IDCategoria;
    }

    public String getPrd_nombreCategoria() {
        return prd_nombreCategoria;
    }

    public void setPrd_nombreCategoria(String prd_nombreCategoria) {
        this.prd_nombreCategoria = prd_nombreCategoria;
    }

    public String getPrd_estado() {
        return prd_estado;
    }

    public void setPrd_estado(String prd_estado) {
        this.prd_estado = prd_estado;
    }

    public int getNregistrosP() {
        return NregistrosP;
    }

    public void setNregistrosP(int NregistrosP) {
        this.NregistrosP = NregistrosP;
    }

}
