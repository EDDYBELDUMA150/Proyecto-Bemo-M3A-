/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import VIsta.vista_factura;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.PrintJob;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.xml.ws.Holder;
import modelo.Cliente;
import modelo.FacturaVenta;
import modelo.MConexion.Modelo_PedidoPastel;
import modelo.MConexion.Modelo_factura_venta;
import modelo.OCconection;
import modelo.Productos;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author carlos
 */
public class Controlador_factura_venta implements Printable {

    private int i;
    private Modelo_factura_venta modelo_venta;
    private vista_factura vis_factura;
    private VIsta.RegistrosdeFacturasGastosBalances vista_regis_factur;
    int id_cuerpo;
    ArrayList<FacturaVenta> lista_factura = new ArrayList<>();
    Modelo_factura_venta mi_factura = new Modelo_factura_venta();
    OCconection conexion = new OCconection();
    Date fechaActual = new Date();

    public Controlador_factura_venta() {

        cargarTablaregistrofactura();
    }

    public Controlador_factura_venta(Modelo_factura_venta modelo_venta, vista_factura vis_factura) {
        this.modelo_venta = modelo_venta;
        this.vis_factura = vis_factura;
        vis_factura.setVisible(true);
        vis_factura.getTxt_id_factura().setEnabled(false);
    }

    public Controlador_factura_venta(Modelo_factura_venta modelo_venta, VIsta.RegistrosdeFacturasGastosBalances vista_regis_factur) {
        this.modelo_venta = modelo_venta;
        this.vista_regis_factur = vista_regis_factur;
        vista_regis_factur.setVisible(true);
    }

    public void iniciarcontrol() {
        cargarTablacliente();
        cargartablaProducto();
        consumidor_final();
        vis_factura.getDate_fecha().setDate(fechaActual);

        vis_factura.getTxt_id_factura().setText(String.valueOf(modelo_venta.numeroidfactura() + 1));
        vis_factura.getBtn_abrir_dialog_cliente().addActionListener(l -> abrirDialogocliente());
        vis_factura.getBtn_abrir_dialog_producto().addActionListener(l -> abrirDialogoProducto());
        vis_factura.getBtb_cargar_cliente().addActionListener(l -> cargar_cliente());
        vis_factura.getBtn_aceptar_producto().addActionListener(l -> cargar_producto());
        vis_factura.getBtn_agregar_producto().addActionListener(l -> llenar_factura());
        vis_factura.getBtn_quitar_producto().addActionListener(l -> quitar_producto());
        vis_factura.getBtn_guardar_factura().addActionListener(l -> guar_todo_factu());
        vis_factura.getBtn_imprimir().addActionListener(l -> imprimirfactura());
//        vis_factura.getBtn_guardar_cliente().addActionListener(l-> guardar_cabecera());

        vis_factura.getTxt_cantidad().addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();
                if (vis_factura.getTxt_cantidad().getText().length() == 10 || (caracter < '0') || (caracter > '9')) {
                    e.consume();
                }

            }

        });
        vis_factura.getTxt_buscar_producto().addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {

                buscarProducto();
            }
        });

        vis_factura.getTxt_buscar_cliente().addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {

                busqueda_cliente();
            }
        });

    }

    public void buscarProducto() {

        String filtro = vis_factura.getTxt_buscar_producto().getText() + "%";
        DefaultTableModel estructuratabla;
        estructuratabla = (DefaultTableModel) vis_factura.getTabla_productos().getModel();
        estructuratabla.setNumRows(0);
        List<Productos> listaproducto = modelo_venta.busquedaProducto(filtro);

        Holder<Integer> i = new Holder<>(0);
        listaproducto.stream().forEach(produ -> {
            estructuratabla.addRow(new Object[3]);

            vis_factura.getTabla_productos().setValueAt(produ.getPrd_ID(), i.value, 0);
            vis_factura.getTabla_productos().setValueAt(produ.getPrd_nombre(), i.value, 1);
            vis_factura.getTabla_productos().setValueAt(produ.getPrd_precio(), i.value, 2);

            i.value++;

        });

    }

    public void busqueda_cliente() {
        String filtro = vis_factura.getTxt_buscar_cliente().getText() + "%";
        DefaultTableModel estructuraTabla;
        estructuraTabla = (DefaultTableModel) vis_factura.getTabla_cliente_pedido().getModel();
        estructuraTabla.setNumRows(0);
        List<Cliente> listap = modelo_venta.busqueda_cliente(filtro);
        i = 0;

        if (!listap.isEmpty()) {
            listap.stream().forEach(pe -> {
                estructuraTabla.addRow(new Object[4]);

                vis_factura.getTabla_cliente_pedido().setValueAt(pe.getCl_ID(), i, 0);
                vis_factura.getTabla_cliente_pedido().setValueAt(pe.getPrs_cedula(), i, 1);
                vis_factura.getTabla_cliente_pedido().setValueAt(pe.getPrs_nombre1(), i, 2);
                vis_factura.getTabla_cliente_pedido().setValueAt(pe.getPrs_apellido1(), i, 3);

                i = i + 1;

            });

        } else {
//            JOptionPane.showMessageDialog(vista_pedido, "No se encuentra el registro");
        }

    }

    public void iniciarcontrol2() {
        cargarTablaregistrofactura();
    }

    public void consumidor_final() {
        vis_factura.getTxt_nombre_cliente().setText("consumidor final");
        vis_factura.getTxt_cedula_cliente().setText("9999999999");
        vis_factura.getTxt_direccion().setText("sin direccion");

    }

    public void cargarTablacliente() {
        DefaultTableModel tb = (DefaultTableModel) vis_factura.getTabla_cliente_pedido().getModel();
        tb.setNumRows(0);
        List<Cliente> com = modelo_venta.lista_cli();
        com.stream().forEach(p -> {
            String[] cami = {String.valueOf(p.getCl_ID()), p.getPrs_cedula(), p.getPrs_nombre1(), p.getPrs_apellido1(), p.getPrs_direccion()};
            tb.addRow(cami);
        });
    }

    public void cargartablaProducto() {
        DefaultTableModel tb = (DefaultTableModel) vis_factura.getTabla_productos().getModel();
        tb.setNumRows(0);
        List<Productos> com = modelo_venta.list_producto();
        com.stream().forEach(p -> {
            String[] cami = {String.valueOf(p.getPrd_ID()), p.getPrd_nombre(), String.valueOf(p.getPrd_precio())};
            tb.addRow(cami);
        });
    }

    public void cargar_producto() {
        int seleccion = vis_factura.getTabla_productos().getSelectedRow();

        if (seleccion == -1) {
            JOptionPane.showMessageDialog(null, "Aun no ha seleccionado una fila");
        } else {
            int codigo = Integer.parseInt(vis_factura.getTabla_productos().getValueAt(seleccion, 0).toString());
            modelo_venta.list_producto().forEach((p) -> {
                if (p.getPrd_ID() == codigo) {

                    vis_factura.getTxt_codigo_producto().setText(String.valueOf(p.getPrd_ID()));
                    vis_factura.getTxt_nombre_producto().setText(p.getPrd_nombre());
                    vis_factura.getTxt_precio_unitario().setText(String.valueOf(p.getPrd_precio()));
                    vis_factura.getDialog_buscar_producto().dispose();
                }
            });
        }
        vis_factura.getTxt_cantidad().setText("1");
    }

    public void cargar_cliente() {
        int seleccion = vis_factura.getTabla_cliente_pedido().getSelectedRow();

        if (seleccion == -1) {
            JOptionPane.showMessageDialog(null, "Aun no ha seleccionado una fila");
        } else {
            int codigo = Integer.parseInt(vis_factura.getTabla_cliente_pedido().getValueAt(seleccion, 0).toString());
            modelo_venta.lista_cli().forEach((p) -> {
                if (p.getCl_ID() == codigo) {
                    vis_factura.getTxt_id_cliente().setText(String.valueOf(p.getCl_ID()));

                    vis_factura.getTxt_nombre_cliente().setText(p.getPrs_nombre1() + " " + p.getPrs_apellido1());
                    vis_factura.getTxt_cedula_cliente().setText(p.getPrs_cedula());
                    vis_factura.getTxt_direccion().setText(p.getPrs_direccion());
                    vis_factura.getDialog_buscar_cliente().dispose();
                }
            });
        }
    }

    private void abrirDialogocliente() {

        vis_factura.getDialog_buscar_cliente().setVisible(true);
        vis_factura.getDialog_buscar_cliente().setSize(650, 500);
        vis_factura.getDialog_buscar_cliente().setLocationRelativeTo(vis_factura);

    }

    public void cargarTablaregistrofactura() {
        DefaultTableModel tb = (DefaultTableModel) vista_regis_factur.getTabla_factura_registro().getModel();
        tb.setNumRows(0);
        List<FacturaVenta> com = modelo_venta.consulta_factura();
        com.stream().forEach(p -> {
            String[] cami = {String.valueOf(p.getFactura_id()), String.valueOf(p.getCliente_id()), p.getNombre_cliente() + " " + p.getApellido_cliente(),
                p.getCedula_cliente(), String.valueOf(p.getFecha_factura()), String.valueOf(p.getTotal())};
            tb.addRow(cami);
        });
    }

    private void abrirDialogoProducto() {

        vis_factura.getDialog_buscar_producto().setVisible(true);
        vis_factura.getDialog_buscar_producto().setSize(650, 500);
        vis_factura.getDialog_buscar_producto().setLocationRelativeTo(vis_factura);

    }

    private void llenar_factura() {

        if (casillasvacias() == true) {
            double suma_total = 0;
            DefaultTableModel estructuratabla;
            estructuratabla = (DefaultTableModel) vis_factura.getTabla_factura().getModel();
//        estructuratabla.setNumRows(0);
            int cantidad = Integer.parseInt(vis_factura.getTxt_cantidad().getText());
            double precio_unit = Double.parseDouble(vis_factura.getTxt_precio_unitario().getText());
            double sub_to = cantidad * precio_unit;

            String cod_prod = vis_factura.getTxt_codigo_producto().getText();
            String nomb_prod = vis_factura.getTxt_nombre_producto().getText();
            String pre_uni = vis_factura.getTxt_precio_unitario().getText();
            String can = vis_factura.getTxt_cantidad().getText();
            String sub_tota = String.valueOf(sub_to);

            Object[] lista = new Object[5];
            lista[0] = cod_prod;
            lista[1] = nomb_prod;
            lista[2] = pre_uni;
            lista[3] = can;
            lista[4] = sub_tota;
            estructuratabla.addRow(lista);
            actualizar_totales();
            limpiar_produ();

        }

    }

    private void actualizar_totales() {
        vis_factura.getTxt_iva().setText("0");
        vis_factura.getTxt_subtotal().setText("0");

        int ta = vis_factura.getTabla_factura().getRowCount();
        int c = 0;
        do {
            try {
                int f = c++;
                Double n1 = Double.parseDouble(vis_factura.getTabla_factura().getValueAt(f, 4).toString());
                String nu = vis_factura.getTxt_subtotal().getText();
                double nu2 = Double.parseDouble(nu);
                double re = (n1 + nu2);
                vis_factura.getTxt_subtotal().setText(String.valueOf(re));
                double sub = Double.parseDouble(vis_factura.getTxt_subtotal().getText());
                int iva = Integer.parseInt(vis_factura.getTxt_iva().getText());
                double gasto_total = sub + (sub * iva);
                vis_factura.getTxt_total().setText(String.valueOf(gasto_total));

            } catch (Exception e) {

            }

        } while (c < ta);

    }

    public void quitar_producto() {
        DefaultTableModel estructuratabla;
        estructuratabla = (DefaultTableModel) vis_factura.getTabla_factura().getModel();
        int fila = vis_factura.getTabla_factura().getSelectedRow();
        if (fila >= 0) {
            estructuratabla.removeRow(vis_factura.getTabla_factura().getSelectedRow());
            actualizar_totales();
        } else {
            JOptionPane.showMessageDialog(vis_factura, "Seleccione el producto que desea eliminar");
        }
    }

    public void guardar_cuerpo_factura() {

        double ivita = 0;
//        if (vis_factura.getTabla_factura().getRowCount() == 0) {
//
//            JOptionPane.showMessageDialog(vis_factura, "Seleccione el producto que desea eliminar");
//        } else {
        for (int i = 0; i < vis_factura.getTabla_factura().getRowCount(); i++) {

            int id_cabe = modelo_venta.consultar_id_cabecera();
            double iva = ivita;
            int cod_prod1 = Integer.parseInt(vis_factura.getTabla_factura().getValueAt(i, 0).toString());
            String nom_prod = vis_factura.getTabla_factura().getValueAt(i, 1).toString();
            double prec_uni = Double.parseDouble(vis_factura.getTabla_factura().getValueAt(i, 2).toString());
            int cantid = Integer.parseInt(vis_factura.getTabla_factura().getValueAt(i, 3).toString());
            double montito = Double.parseDouble(vis_factura.getTabla_factura().getValueAt(i, 4).toString());
            double sub_to = Double.parseDouble(vis_factura.getTxt_subtotal().getText());
            double total = Double.parseDouble(vis_factura.getTxt_total().getText());
            FacturaVenta mi_venta = new FacturaVenta();
            Modelo_factura_venta mi_facturita1 = new Modelo_factura_venta();

            mi_venta.setProducto_id(cod_prod1);
            mi_venta.setNombre_producto(nom_prod);
            mi_venta.setCantidad_producto(cantid);
            mi_venta.setIva(iva);
            mi_venta.setSubtotal(sub_to);
            mi_venta.setTotal(total);
            mi_venta.setPrecio_unitario_producto(prec_uni);
            mi_venta.setMonto(montito);
            mi_venta.setCabecera_id(id_cabe);
            mi_facturita1.Insertcuerpito(mi_venta);

//            }
        }

//        if (mi_facturita1.setCabecerita()) {
//            JOptionPane.showMessageDialog(vis_factura, "Factura registrada exitosamente");
//        }
    }

    public void guardar_cabecera() {
        int id_cabecera = 0;

        if (modelo_venta.numeroidcabecera() == 0) {
            id_cabecera = 1;
        } else {
            id_cabecera = modelo_venta.numeroidcabecera() + 1;
        }

        int id_cli = Integer.parseInt(vis_factura.getTxt_id_cliente().getText());
        String cabe_est = "Activo";

        Date date = vis_factura.getDate_fecha().getDate(); //ic es la interfaz, jDate el JDatechooser
        long d = date.getTime(); //guardamos en un long el tiempo
        java.sql.Date fecha_factura1 = new java.sql.Date(d);// parseamos al formato del sql  
        Modelo_factura_venta mi_facturita1 = new Modelo_factura_venta();

        mi_facturita1.setCabecera_id(id_cabecera);
        mi_facturita1.setCliente_id(id_cli);
        mi_facturita1.setFecha_factura(fecha_factura1);
        mi_facturita1.setCabecera_estado(cabe_est);

        mi_facturita1.setCabecerita();
    }

    public void guardar_facturita() {
        int id_factura = 0;
        if (modelo_venta.numeroidfactura() == 0) {
            id_factura = 1;
        } else {
            id_factura = modelo_venta.numeroidfactura() + 1;
        }
        int id_factu = Integer.parseInt(vis_factura.getTxt_id_factura().getText());
        int id_cabe = modelo_venta.consultar_id_cabecera();
        int id_cue = modelo_venta.consultar_id_cuerpo();
        Modelo_factura_venta mi_facturita1 = new Modelo_factura_venta();

        mi_facturita1.setFactura_id(id_factu);
        mi_facturita1.setCabecera_id(id_cabe);
        mi_facturita1.setCuerpo_id(id_cue);
        if (mi_facturita1.setFacturita()) {
            JOptionPane.showMessageDialog(vis_factura, "Factura registrada exitosamente");
        }
    }

    public void guar_todo_factu() {
        if (vis_factura.getTabla_factura().getRowCount() == 0) {

            JOptionPane.showMessageDialog(vis_factura, "Seleccione el producto que desea eliminar");
        } else {
            guardar_cabecera();
            guardar_cuerpo_factura();
            guardar_facturita();
            limpiar_todo();
            imprimeFactura(Integer.parseInt(vis_factura.getTxt_id_factura().getText()));
        }

    }

    public void limpiar_produ() {
        vis_factura.getTxt_nombre_producto().setText("");
        vis_factura.getTxt_precio_unitario().setText("");
        vis_factura.getTxt_codigo_producto().setText("");
        vis_factura.getTxt_cantidad().setText("");
    }

    public void limpiar_todo() {
        vis_factura.getTxt_nombre_producto().setText("");
        vis_factura.getTxt_precio_unitario().setText("");
        vis_factura.getTxt_codigo_producto().setText("");
        vis_factura.getTxt_cantidad().setText("");
        vis_factura.getTxt_nombre_cliente().setText("");
        vis_factura.getTxt_cedula_cliente().setText("");
        vis_factura.getTxt_direccion().setText("");
        vis_factura.getDate_fecha().setDate(null);
        vis_factura.getTxt_iva().setText("");
        vis_factura.getTxt_subtotal().setText("");
        vis_factura.getTxt_total().setText("");
        limpiar_tabla();

    }

    private void limpiar_tabla() {
        DefaultTableModel dm = (DefaultTableModel) vis_factura.getTabla_factura().getModel();
        dm.getDataVector().removeAllElements();
        dm.fireTableDataChanged();

      
    }

    private void imprimirfactura() {

        try {
            // Open printer dialog and pass JPanel to print
            PrinterJob job = PrinterJob.getPrinterJob();
            job.setPrintable(this);

            if (job.printDialog()) {
                job.print();
            }

        } catch (PrinterException ex) {
            Logger.getLogger(Controlador_factura_venta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {

        if (pageIndex > 0) {
            /* We have only one page, and 'page' is zero-based */
            return NO_SUCH_PAGE;
        }

        Graphics2D g2d = (Graphics2D) graphics;
        g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
        vis_factura.printAll(graphics);

        return PAGE_EXISTS;

    }

    public void imprimeFactura(int idFactura) {
        //Instanciamos la conexion proyecto
        OCconection con = new OCconection();

        JasperReport jr;
        try {
            jr = (JasperReport) JRLoader.loadObject(getClass().getResource("/VIsta/reportes/Factura.jasper"));
            Map<String, Object> parametros = new HashMap<String, Object>();

            parametros.put("Cabecera", idFactura);

            JasperPrint jp = JasperFillManager.fillReport(jr, parametros, con.getConex());//llena el reporte con datos.
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);
        } catch (JRException ex) {
            java.util.logging.Logger.getLogger(Controlador_factura_venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

    }

    public boolean casillasvacias() {

        boolean validar = true;

        if (vis_factura.getTxt_id_cliente().getText().isEmpty()) {
            validar = false;
            vis_factura.getLboocliente().setText("Seleccione un Cliente");

        } else {
            vis_factura.getLboocliente().setText("");

        }
        if (vis_factura.getTxt_codigo_producto().getText().isEmpty()) {
            validar = false;
            vis_factura.getLbooproducto().setText("Seleccione un Producto");

        } else {
            vis_factura.getLbooproducto().setText("");

        }

        return validar;

    }

}
