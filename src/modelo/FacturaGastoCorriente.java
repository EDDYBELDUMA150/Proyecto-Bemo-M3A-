/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.Image;
import java.io.FileInputStream;
import java.util.Date;

/**
 *
 * @author Abel Gomez
 */
public class FacturaGastoCorriente extends Factura{
    
    private String fctG_descripccion;
    private Image fotoFactura;
    private String fctG_estado;
    
    private FileInputStream imageFile;
    private int length;
    private int NregistrosGC;

    public FacturaGastoCorriente() {
    }

    public FacturaGastoCorriente(String fctG_descripccion, Image fotoFactura, String fctG_estado, FileInputStream imageFile, int length, int NregistrosGC, int fct_ID, double fct_subtotal, double fct_total, Date fct_fecha, int fct_cantidad, double fct_precio) {
        super(fct_ID, fct_subtotal, fct_total, fct_fecha, fct_cantidad, fct_precio);
        this.fctG_descripccion = fctG_descripccion;
        this.fotoFactura = fotoFactura;
        this.fctG_estado = fctG_estado;
        this.imageFile = imageFile;
        this.length = length;
        this.NregistrosGC = NregistrosGC;
    }

    public String getFctG_descripccion() {
        return fctG_descripccion;
    }

    public void setFctG_descripccion(String fctG_descripccion) {
        this.fctG_descripccion = fctG_descripccion;
    }

    public Image getFotoFactura() {
        return fotoFactura;
    }

    public void setFotoFactura(Image fotoFactura) {
        this.fotoFactura = fotoFactura;
    }

    public FileInputStream getImageFile() {
        return imageFile;
    }

    public void setImageFile(FileInputStream imageFile) {
        this.imageFile = imageFile;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getFctG_estado() {
        return fctG_estado;
    }

    public void setFctG_estado(String fctG_estado) {
        this.fctG_estado = fctG_estado;
    }

    public int getNregistrosGC() {
        return NregistrosGC;
    }

    public void setNregistrosGC(int NregistrosGC) {
        this.NregistrosGC = NregistrosGC;
    }
    
    
}
