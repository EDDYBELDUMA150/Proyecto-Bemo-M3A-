/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

//import modelo.ModeloProveedor;
import VIsta.RegistrosdeFacturasGastosBalances;
import VIsta.VistaProveedor;
import VIsta.Vista_pedidoPastel;
import VIsta.vista_cotizacion;
import VIsta.vista_factura;
import VIsta.vistacliente;
import VIsta.vistamenuprincipal;
import modelo.MConexion.ModelGastoCorriente;
import modelo.MConexion.ModeloProveedor;
import modelo.MConexion.Modelo_PedidoPastel;
import modelo.MConexion.Modelo_factura_venta;
import modelo.MConexion.Modelocliente;
import modelo.MConexion.modelo_cotizacion;

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
        vistamenuprin.setSize(1680, 950);

    }

    public void iniciaControl() {

        vistamenuprin.getBtncrudclientes().addActionListener(l -> crudclientes());
        vistamenuprin.getBtncrudproveedores().addActionListener(l -> crudproveedores());
        vistamenuprin.getBtProductos().addActionListener(l -> abrirprodcutos());
        vistamenuprin.getBtn_pedido_pastel().addActionListener(l -> crud_pedido());
        vistamenuprin.getBtn_factura().addActionListener(l -> crud_factura());
        vistamenuprin.getBtn_cotizacion().addActionListener(l -> crud_cotizacion());
        vistamenuprin.getMnProducto().addActionListener(l -> menusItems(1));
        vistamenuprin.getMnCategoria().addActionListener(l -> menusItems(2));
        vistamenuprin.getMnCliente().addActionListener(l -> menusItems(3));
        vistamenuprin.getMnProveedore().addActionListener(l -> menusItems(4));
        vistamenuprin.getMnGastos().addActionListener(l -> menusItems(5));
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
        modelo.MConexion.Modelo_factura_venta modventa = new modelo.MConexion.Modelo_factura_venta();
        modelo.MConexion.ModelGastoCorriente mdGC = new ModelGastoCorriente();
        vistamenuprin.getJdpprincipal().add(vistaProd);
        
        Controlador.ControladorProducto controlpro = new ControladorProducto(modprod, vistaProd, modCtg, vistaCTG, modventa, mdGC);
        controlpro.iniciaControl();
    }

    private void crud_factura() {
        Modelo_factura_venta modelo_venta = new Modelo_factura_venta();
        vista_factura vis_factura = new vista_factura();
        vistamenuprin.getJdpprincipal().add(vis_factura);
        Controlador_factura_venta control = new Controlador_factura_venta(modelo_venta, vis_factura);
        control.iniciarcontrol();

    }

    private void crud_pedido() {

        Modelo_PedidoPastel model_pastel = new Modelo_PedidoPastel();
        Vista_pedidoPastel vista_pedidos = new Vista_pedidoPastel();
        vistamenuprin.getJdpprincipal().add(vista_pedidos);
        Controlador_pedidopastel controler_pastel = new Controlador_pedidopastel(model_pastel, vista_pedidos);
        controler_pastel.iniciarcontrol();
    }

    private void crud_cotizacion() {
        modelo_cotizacion modelo_coti = new modelo_cotizacion();
        vista_cotizacion vist_coti = new vista_cotizacion();
        vistamenuprin.getJdpprincipal().add(vist_coti);
        ControladorCotizacion controler = new ControladorCotizacion(modelo_coti, vist_coti);
        controler.iniciarcontrol();
    }

    public void menusItems(int opc) {
        VIsta.RegistrosdeFacturasGastosBalances vistaProd = new RegistrosdeFacturasGastosBalances();
        VIsta.Categorias vistaCTG = new VIsta.Categorias();

        modelo.MConexion.ModelCategoria modCtg = new modelo.MConexion.ModelCategoria();
        modelo.MConexion.ModelProducto modprod = new modelo.MConexion.ModelProducto();
        modelo.MConexion.Modelo_factura_venta modventa = new modelo.MConexion.Modelo_factura_venta();

        Modelocliente modelocliente = new Modelocliente();
        vistacliente vistacliente = new vistacliente();

        //Agregar Vista Personas al Desktop Pane.
        vistamenuprin.getJdpprincipal().add(vistacliente);
        modelo.MConexion.ModelGastoCorriente mdGC = new ModelGastoCorriente();
        ModeloProveedor modeloproveedor = new ModeloProveedor();
        VistaProveedor vistaproveedor = new VistaProveedor();
        vistamenuprin.getJdpprincipal().add(vistaproveedor);

        switch (opc) {
            case 1:
                vistamenuprin.getJdpprincipal().add(vistaProd);

                Controlador.ControladorProducto controlpro = new ControladorProducto(modprod, vistaProd, modCtg, vistaCTG, modventa, mdGC);
                controlpro.iniciaControl();
                controlpro.abrirdialogProd(1);
                break;
            case 2:
                ControladorCategoria ctgCATEG = new ControladorCategoria(modCtg, vistaCTG);
                ctgCATEG.inicioControl();
                ctgCATEG.abrirdialog(1);
                break;
            case 3:
                ControladorCliente controlclientes = new ControladorCliente(modelocliente, vistacliente);
                controlclientes.iniciarcontrol();
                controlclientes.abrirDialogo(1);
                break;
            case 4:
                ControladorProveedor controlproveedor = new ControladorProveedor(modeloproveedor, vistaproveedor);

                controlproveedor.iniciarcontrol();
                controlproveedor.abrirDialogo(1);
                break;
            case 5:
                
                break;
            default:
                throw new AssertionError();
        }
    }
}
