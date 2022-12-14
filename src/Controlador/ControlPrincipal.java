/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

//import modelo.ModeloProveedor;
import VIsta.Contraseña;
import VIsta.RegistrosdeFacturasGastosBalances;
import VIsta.VistaProveedor;
import VIsta.Vista_pedidoPastel;
import VIsta.vista_cotizacion;
import VIsta.vista_factura;
import VIsta.vistacliente;
import VIsta.vistamenuprincipal;
import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.extras.FlatAnimatedLafChange;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
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

    Toolkit tik = Toolkit.getDefaultToolkit();
    Dimension d = tik.getScreenSize();

    int ancho = (int) d.getWidth();
    int alto = (int) d.getHeight();

    vistamenuprincipal vistamenuprin;
    

    public ControlPrincipal(vistamenuprincipal vistamenuprin) {
        this.vistamenuprin = vistamenuprin;
        EventQueue.invokeLater(() -> {
            FlatAnimatedLafChange.showSnapshot();
            FlatIntelliJLaf.setup();
            FlatLaf.updateUI();
            FlatAnimatedLafChange.hideSnapshotWithAnimation();
        });
        vistamenuprin.setVisible(true);
        vistamenuprin.getJdpprincipal().setPreferredSize(d);
    }

    public void iniciaControl() {

        vistamenuprin.getBtncrudclientes().addActionListener(l -> crudclientes());
        vistamenuprin.getBtncrudproveedores().addActionListener(l -> crudproveedores());
        vistamenuprin.getBtProductos().addActionListener(l -> abrirprodcutos());
        vistamenuprin.getBtn_pedido_pastel().addActionListener(l -> crud_pedido());
        vistamenuprin.getBtn_factura().addActionListener(l -> crud_factura());
        vistamenuprin.getBtn_cotizacion().addActionListener(l -> crud_cotizacion());
        vistamenuprin.getMnProducto().addActionListener(l -> menusItemsCrear(1));
        vistamenuprin.getMnCategoria().addActionListener(l -> menusItemsCrear(2));
        vistamenuprin.getMnCliente().addActionListener(l -> menusItemsCrear(3));
        vistamenuprin.getMnProveedore().addActionListener(l -> menusItemsCrear(4));
        vistamenuprin.getMnGastos().addActionListener(l -> menusItemsCrear(5));
        vistamenuprin.getBtCrearFact().addActionListener(l -> menusItemsCrear(6));
        vistamenuprin.getBtCootizarM().addActionListener(l -> menusItemsCrear(7));

        vistamenuprin.getjCheckboxitemmodooscuro().addActionListener(l -> modooscurro());
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

    public void menusItemsCrear(int opc) {
        VIsta.RegistrosdeFacturasGastosBalances vistaProd = new RegistrosdeFacturasGastosBalances();
        VIsta.Categorias vistaCTG = new VIsta.Categorias();

        modelo.MConexion.ModelCategoria modCtg = new modelo.MConexion.ModelCategoria();
        modelo.MConexion.ModelProducto modprod = new modelo.MConexion.ModelProducto();
        modelo.MConexion.Modelo_factura_venta modventa = new modelo.MConexion.Modelo_factura_venta();
        modelo.MConexion.ModelGastoCorriente modgasto = new ModelGastoCorriente();
        Modelocliente modelocliente = new Modelocliente();

        vistacliente vistacliente = new vistacliente();
        VIsta.vista_factura vistafact = new vista_factura();
        //Agregar Vista Personas al Desktop Pane.
        vistamenuprin.getJdpprincipal().add(vistacliente);
        modelo.MConexion.ModelGastoCorriente mdGC = new ModelGastoCorriente();
        ModeloProveedor modeloproveedor = new ModeloProveedor();
        VistaProveedor vistaproveedor = new VistaProveedor();
        vistamenuprin.getJdpprincipal().add(vistaproveedor);
        vistamenuprin.getJdpprincipal().add(vistaProd);

        switch (opc) {
            case 1:
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
                ControlGastoC controlgasto = new ControlGastoC(modgasto, vistaProd);

                controlgasto.iniciaControlC();
                controlgasto.abrirdialogG(1);
                break;
            case 6:
                crud_factura();
                break;
            case 7:
                crud_cotizacion();
                break;
            default:
                throw new AssertionError();
        }
    }

    public void menusItemsReportes(int opc) {
        VIsta.RegistrosdeFacturasGastosBalances vistaProd = new RegistrosdeFacturasGastosBalances();
        VIsta.Categorias vistaCTG = new VIsta.Categorias();

        modelo.MConexion.ModelCategoria modCtg = new modelo.MConexion.ModelCategoria();
        modelo.MConexion.ModelProducto modprod = new modelo.MConexion.ModelProducto();
        modelo.MConexion.Modelo_factura_venta modventa = new modelo.MConexion.Modelo_factura_venta();
        modelo.MConexion.ModelGastoCorriente modgasto = new ModelGastoCorriente();

        vistamenuprin.getJdpprincipal().add(vistaProd);

        switch (opc) {
            case 1:
                Controlador.ControladorProducto controlpro = new ControladorProducto(modprod, vistaProd, modCtg, vistaCTG, modventa, modgasto);
                controlpro.iniciaControl();
                controlpro.imprimeVentas();
                break;
            case 2:
                Controlador.ControladorProducto controlpro2 = new ControladorProducto(modprod, vistaProd, modCtg, vistaCTG, modventa, modgasto);
                controlpro2.iniciaControl();
                controlpro2.imprimeProducto();
                break;
            case 3:
                Controlador.ControladorProducto controlpro3 = new ControladorProducto(modprod, vistaProd, modCtg, vistaCTG, modventa, modgasto);
                controlpro3.iniciaControl();
                controlpro3.imprimeGasto();
                break;
            default:
                throw new AssertionError();
        }
    }

    private void modooscurro() {

        if (vistamenuprin.getjCheckboxitemmodooscuro().isSelected()) {
            EventQueue.invokeLater(() -> {
                FlatAnimatedLafChange.showSnapshot();
                FlatDarculaLaf.setup();
                FlatLaf.updateUI();
                FlatAnimatedLafChange.hideSnapshotWithAnimation();
            });
        } else {
            EventQueue.invokeLater(() -> {
                FlatAnimatedLafChange.showSnapshot();
                FlatIntelliJLaf.setup();
                FlatLaf.updateUI();
                FlatAnimatedLafChange.hideSnapshotWithAnimation();
            });
        }

    }
    
}
