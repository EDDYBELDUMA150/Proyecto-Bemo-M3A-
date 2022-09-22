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
public class PedidoPastel {

   private int pdpt_ID;
    private Date pdpt_fechapedido;
    private Date pdpt_fechaentrga;
    private String pdpt_nombrecliente;
    private String pdpt_apellidocliente;
    private String pdpt_nombreproducto;
    private int pdpt_cantidad;
    private String pdpt_especificacion;
    private double pdpt_abono;
    private Date pdpt_horaentrega;
    private String pdpt_estado;
    private int pdpt_cli_id;
    private int pdpt_prod_id;
    private Image pdpt_fotopastel;
    private FileInputStream imagefile;
    private int lengthfoto;

    public PedidoPastel() {
    }

    public PedidoPastel(int pdpt_ID, Date pdpt_fechapedido, Date pdpt_fechaentrga, String pdpt_nombrecliente, String pdpt_apellidocliente, String pdpt_nombreproducto, int pdpt_cantidad, String pdpt_especificacion, double pdpt_abono, Date pdpt_horaentrega, String pdpt_estado, int pdpt_cli_id, int pdpt_prod_id, Image pdpt_fotopastel, FileInputStream imagefile, int lengthfoto) {
        this.pdpt_ID = pdpt_ID;
        this.pdpt_fechapedido = pdpt_fechapedido;
        this.pdpt_fechaentrga = pdpt_fechaentrga;
        this.pdpt_nombrecliente = pdpt_nombrecliente;
        this.pdpt_apellidocliente = pdpt_apellidocliente;
        this.pdpt_nombreproducto = pdpt_nombreproducto;
        this.pdpt_cantidad = pdpt_cantidad;
        this.pdpt_especificacion = pdpt_especificacion;
        this.pdpt_abono = pdpt_abono;
        this.pdpt_horaentrega = pdpt_horaentrega;
        this.pdpt_estado = pdpt_estado;
        this.pdpt_cli_id = pdpt_cli_id;
        this.pdpt_prod_id = pdpt_prod_id;
        this.pdpt_fotopastel = pdpt_fotopastel;
        this.imagefile = imagefile;
        this.lengthfoto = lengthfoto;
    }

    public int getPdpt_ID() {
        return pdpt_ID;
    }

    public void setPdpt_ID(int pdpt_ID) {
        this.pdpt_ID = pdpt_ID;
    }

    public Date getPdpt_fechapedido() {
        return pdpt_fechapedido;
    }

    public void setPdpt_fechapedido(Date pdpt_fechapedido) {
        this.pdpt_fechapedido = pdpt_fechapedido;
    }

    public Date getPdpt_fechaentrga() {
        return pdpt_fechaentrga;
    }

    public void setPdpt_fechaentrga(Date pdpt_fechaentrga) {
        this.pdpt_fechaentrga = pdpt_fechaentrga;
    }

    public String getPdpt_nombrecliente() {
        return pdpt_nombrecliente;
    }

    public void setPdpt_nombrecliente(String pdpt_nombrecliente) {
        this.pdpt_nombrecliente = pdpt_nombrecliente;
    }

    public String getPdpt_apellidocliente() {
        return pdpt_apellidocliente;
    }

    public void setPdpt_apellidocliente(String pdpt_apellidocliente) {
        this.pdpt_apellidocliente = pdpt_apellidocliente;
    }

    public String getPdpt_nombreproducto() {
        return pdpt_nombreproducto;
    }

    public void setPdpt_nombreproducto(String pdpt_nombreproducto) {
        this.pdpt_nombreproducto = pdpt_nombreproducto;
    }

    public int getPdpt_cantidad() {
        return pdpt_cantidad;
    }

    public void setPdpt_cantidad(int pdpt_cantidad) {
        this.pdpt_cantidad = pdpt_cantidad;
    }

    public String getPdpt_especificacion() {
        return pdpt_especificacion;
    }

    public void setPdpt_especificacion(String pdpt_especificacion) {
        this.pdpt_especificacion = pdpt_especificacion;
    }

    public double getPdpt_abono() {
        return pdpt_abono;
    }

    public void setPdpt_abono(double pdpt_abono) {
        this.pdpt_abono = pdpt_abono;
    }

    public Date getPdpt_horaentrega() {
        return pdpt_horaentrega;
    }

    public void setPdpt_horaentrega(Date pdpt_horaentrega) {
        this.pdpt_horaentrega = pdpt_horaentrega;
    }

    public String getPdpt_estado() {
        return pdpt_estado;
    }

    public void setPdpt_estado(String pdpt_estado) {
        this.pdpt_estado = pdpt_estado;
    }

    public int getPdpt_cli_id() {
        return pdpt_cli_id;
    }

    public void setPdpt_cli_id(int pdpt_cli_id) {
        this.pdpt_cli_id = pdpt_cli_id;
    }

    public int getPdpt_prod_id() {
        return pdpt_prod_id;
    }

    public void setPdpt_prod_id(int pdpt_prod_id) {
        this.pdpt_prod_id = pdpt_prod_id;
    }

    public Image getPdpt_fotopastel() {
        return pdpt_fotopastel;
    }

    public void setPdpt_fotopastel(Image pdpt_fotopastel) {
        this.pdpt_fotopastel = pdpt_fotopastel;
    }

    public FileInputStream getImagefile() {
        return imagefile;
    }

    public void setImagefile(FileInputStream imagefile) {
        this.imagefile = imagefile;
    }

    public int getLengthfoto() {
        return lengthfoto;
    }

    public void setLengthfoto(int lengthfoto) {
        this.lengthfoto = lengthfoto;
    }

    
    @Override
    public String toString() {
        return "PedidoPastel{" + "pdpt_ID=" + pdpt_ID + ", pdpt_fechapedido=" + pdpt_fechapedido + ", pdpt_fechaentrga=" + pdpt_fechaentrga + ", pdpt_nombrecliente=" + pdpt_nombrecliente + ", pdpt_nombreproducto=" + pdpt_nombreproducto + ", pdpt_cantidad=" + pdpt_cantidad + ", pdpt_especificacion=" + pdpt_especificacion + ", pdpt_abono=" + pdpt_abono + ", pdpt_horaentrega=" + pdpt_horaentrega + ", pdpt_estado=" + pdpt_estado + ", pdpt_fotopastel=" + pdpt_fotopastel + '}';
    }
    
    

}
