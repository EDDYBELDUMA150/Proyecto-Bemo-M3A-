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
public class Categoria {
    
    private int ctg_ID;
    private String ctg_nombre;
    private String ctg_estado;
    private int Nregistros;

    public Categoria() {
    }

    public Categoria(int ctg_ID, String ctg_nombre, String ctg_estado, int Nregistros) {
        this.ctg_ID = ctg_ID;
        this.ctg_nombre = ctg_nombre;
        this.ctg_estado = ctg_estado;
        this.Nregistros = Nregistros;
    }

    public int getCtg_ID() {
        return ctg_ID;
    }

    public void setCtg_ID(int ctg_ID) {
        this.ctg_ID = ctg_ID;
    }

    public String getCtg_nombre() {
        return ctg_nombre;
    }

    public void setCtg_nombre(String ctg_nombre) {
        this.ctg_nombre = ctg_nombre;
    }

    public String getCtg_estado() {
        return ctg_estado;
    }

    public void setCtg_estado(String ctg_estado) {
        this.ctg_estado = ctg_estado;
    }

    public int getNregistros() {
        return Nregistros;
    }

    public void setNregistros(int Nregistros) {
        this.Nregistros = Nregistros;
    }
    
}
