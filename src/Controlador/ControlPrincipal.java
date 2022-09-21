/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

//import modelo.ModeloProveedor;

import VIsta.RegistrosdeFacturasGastosBalances;
import VIsta.VistaProveedor;
import VIsta.vistacliente;
import VIsta.vistamenuprincipal;
import modelo.MConexion.ModeloProveedor;
import modelo.MConexion.Modelocliente;

//import modelo.Modelocliente;
//import vistas.VistaProveedor;
//import vistas.vistacliente;
//import vistas.vistamenuprincipal;

/**
 *
 * @author Abel Gomez
 */
public class ControlPrincipal {

    vistamenuprincipal vistamenuprin;

    public ControlPrincipal(vistamenuprincipal vistamenuprin) {
        this.vistamenuprin = vistamenuprin;
        vistamenuprin.setVisible(true);
        vistamenuprin.setSize(1680,950);
        
    }

    public void iniciaControl() {

        vistamenuprin.getBtncrudclientes().addActionListener(l -> crudclientes());
        vistamenuprin.getBtncrudproveedores().addActionListener(l->crudproveedores());
        vistamenuprin.getBtProductos().addActionListener(l-> abrirprodcutos());
    }

    private void crudclientes() {
        //Instancio las clases del Modelo y la Vista.

        Modelocliente modelocliente = new Modelocliente();
        vistacliente vistacliente = new vistacliente();

        //Agregar Vista Personas al Desktop Pane.
        vistamenuprin.getJdpprincipal().add(vistacliente);
        ControladorCliente controlclientes = new ControladorCliente(modelocliente, vistacliente);

        controlclientes.iniciarcontrol();
        //  ControllerPersona controladorCrudPersonas = new ControllerPersona(modeloCrudPersonas, vistaCrudPersonas);
        //  controladorCrudPersonas.iniciaControl();//Empezamos las escuchas a los eventos de la vista, Listeners.

    }

    private void crudproveedores() {

        ModeloProveedor modeloproveedor = new ModeloProveedor();
        VistaProveedor vistaproveedor = new VistaProveedor();
        vistamenuprin.getJdpprincipal().add(vistaproveedor);
        ControladorProveedor controlproveedor = new ControladorProveedor(modeloproveedor, vistaproveedor);
        
        controlproveedor.iniciarcontrol();

    }

    private void abrirprodcutos() {
        VIsta.RegistrosdeFacturasGastosBalances vistaProd = new RegistrosdeFacturasGastosBalances();
        VIsta.Categorias vistaCTG = new VIsta.Categorias();
        
        modelo.MConexion.ModelCategoria modCtg = new modelo.MConexion.ModelCategoria();
        modelo.MConexion.ModelProducto modprod = new modelo.MConexion.ModelProducto();
        vistamenuprin.getJdpprincipal().add(vistaProd);
        
        Controlador.ControladorProducto controlpro = new ControladorProducto(modprod, vistaProd, modCtg, vistaCTG);
        controlpro.iniciaControl();
        
    }

}
