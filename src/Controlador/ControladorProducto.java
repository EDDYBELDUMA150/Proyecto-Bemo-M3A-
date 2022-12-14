
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import VIsta.Categorias;
import VIsta.RegistrosdeFacturasGastosBalances;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.xml.ws.Holder;
import modelo.FacturaGastoCorriente;
import modelo.FacturaVenta;
import modelo.MConexion.ModelCategoria;
import modelo.MConexion.ModelGastoCorriente;
import modelo.MConexion.ModelProducto;
import modelo.MConexion.Modelo_factura_venta;
import modelo.OCconection;
import modelo.Productos;
import modelo.Validaciones;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author OWNER
 */
public class ControladorProducto {

    private modelo.MConexion.ModelProducto modeloPro;
    private VIsta.RegistrosdeFacturasGastosBalances vistaPro;
    private modelo.MConexion.ModelCategoria modcate;
    private VIsta.Categorias vistcate;
    private Modelo_factura_venta modelo_venta;
    private modelo.MConexion.ModelGastoCorriente modGasto;
    Date fechaActual = new Date();

    Validaciones validar = new Validaciones();

    public ControladorProducto(ModelProducto modeloPro, RegistrosdeFacturasGastosBalances vistaPro, ModelCategoria modcate, Categorias vistcate, Modelo_factura_venta modelo_venta, ModelGastoCorriente modGasto) {
        this.modeloPro = modeloPro;
        this.vistaPro = vistaPro;
        this.modcate = modcate;
        this.vistcate = vistcate;
        this.modelo_venta = modelo_venta;
        this.modGasto = modGasto;
        vistaPro.setVisible(true);
        inicarGastos();
        cargarDatos();
        habilitarBotones();
        modeloPro.cargarCategoriaCB(vistaPro.getCbProCate());
        GenerarEditarCodigo();
        cargarTablaregistrofactura();
        vistaPro.getDtDesdeVentas().setVisible(false);
        vistaPro.getDtHastaVentas().setVisible(false);
        vistaPro.getLbHastaVentas().setVisible(false);
        vistaPro.getLblDesdeVentas().setVisible(false);
        vistaPro.getDtDesdeGasato().setVisible(false);
        vistaPro.getDtHastaGasto().setVisible(false);
        vistaPro.getLbdesdeGastos().setVisible(false);
        vistaPro.getLbhastaGastos().setVisible(false);
    }

    public void iniciaControl() {
        totalesregisProductos();
        totalesregisFactVentas();
        totalesregisGastos();
        actualizar_totalesVentas();
        actualizar_totalesGatos();
        vistaPro.getLbErrores().setVisible(false);
        vistaPro.getLbErroresGasto().setVisible(false);
        vistaPro.getBtPrevisualizar().addActionListener(l -> previa());
        vistaPro.getBtVerCategoria().addActionListener(l -> abrirCategoria());
        vistaPro.getBtPronuevo().addActionListener(l1 -> abrirdialogProd(1));
        vistaPro.getBtProModif().addActionListener(l1 -> abrirdialogProd(2));
        vistaPro.getBtAgregarModi().addActionListener(l -> crearEditarProducto());
        vistaPro.getBtProdelete().addActionListener(l -> eliminarProducto());
        vistaPro.getBtSalir().addActionListener(l -> vistaPro.getJdProductos().dispose());
        vistaPro.getBtFecha().addActionListener(l -> cargarTablaregistrofacturaPorfecha(1));
        vistaPro.getBtFechaGASTO().addActionListener(l -> cargarTablaregistrofacturaPorfecha(2));
        vistaPro.getCbFechasVentas().addActionListener(l -> esconderDesdeHastaVts());
        vistaPro.getCbFechasGastos().addActionListener(l -> esconderDesdeHastaGastos());
        vistaPro.getBtReportesVentas().addActionListener(l-> imprimeVentas());
        vistaPro.getBtReporteProductos().addActionListener(l-> imprimeProducto());
        vistaPro.getBtReportesGastos().addActionListener(l-> imprimeGasto());
        vistaPro.getTbProductos().addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                int fila = vistaPro.getTbProductos().rowAtPoint(e.getPoint());
                int columna = vistaPro.getTbProductos().columnAtPoint(e.getPoint());
                if ((fila > -1) && (columna > -1)) {
                    vistaPro.getBtProdelete().setEnabled(true);
                    vistaPro.getBtProModif().setEnabled(true);
                } else {
                    vistaPro.getBtProdelete().setEnabled(false);
                    vistaPro.getBtProModif().setEnabled(false);
                }

            }
        });

        vistaPro.getTxtPronombre().addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (vistaPro.getTxtPronombre().getText().length() == 50 || ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z'))) {
                    e.consume();
                }

            }

        });

    }

    private void cargarDatos() {
        DefaultTableModel estucturaTabla;
        estucturaTabla = (DefaultTableModel) vistaPro.getTbProductos().getModel();
        estucturaTabla.setNumRows(0);

        List<Productos> listPro = modeloPro.getproductos();

        Holder<Integer> i = new Holder<>(0);
        listPro.stream().forEach(Pro -> {
            estucturaTabla.addRow(new Object[5]);
            vistaPro.getTbProductos().setValueAt(Pro.getPrd_ID(), i.value, 0);
            vistaPro.getTbProductos().setValueAt(Pro.getPrd_nombre(), i.value, 1);
            vistaPro.getTbProductos().setValueAt(Pro.getPrd_precio(), i.value, 2);
            vistaPro.getTbProductos().setValueAt(Pro.getPrd_nombreCategoria(), i.value, 3);
            vistaPro.getTbProductos().setValueAt(Pro.getPrd_estado(), i.value, 4);

            i.value++;
        });
    }

    public void abrirdialogProd(int opcion) {
        int CRg = modeloPro.countRegistros();

        if (CRg == 0) {
            CRg = 1;
        } else {
            CRg++;
        }

        if (opcion == 1) {
            vistaPro.getLbModificar().setVisible(false);
            vistaPro.getLbNuevo().setVisible(true);
            vistaPro.getJdProductos().setName("C");
            vistaPro.getJdProductos().setVisible(true);
            vistaPro.getJdProductos().setSize(636, 471);
            vistaPro.getTxtCodPro().setText(String.valueOf(CRg));
            vistaPro.getJdProductos().setLocationRelativeTo(vistaPro);
            vistaPro.getBtAgregarModi().setText("Agregar");
            vaciasCampos();
        } else {

            vistaPro.getJdProductos().setName("E");

            int fila = vistaPro.getTbProductos().getSelectedRow();

            if (fila >= 0) {
                vistaPro.getTxtCodPro().setText(vistaPro.getTbProductos().getValueAt(fila, 0).toString());
                vistaPro.getTxtPronombre().setText(vistaPro.getTbProductos().getValueAt(fila, 1).toString());
                vistaPro.getTxtProprecio().setText(vistaPro.getTbProductos().getValueAt(fila, 2).toString());
                vistaPro.getCbProCate().setSelectedIndex(modeloPro.codProducto(vistaPro.getTbProductos().getValueAt(fila, 3).toString()));
                vistaPro.getJdProductos().setLocationRelativeTo(vistaPro);
                vistaPro.getJdProductos().setVisible(true);
                vistaPro.getJdProductos().setSize(636, 471);
                vistaPro.getLbModificar().setVisible(true);
                vistaPro.getLbNuevo().setVisible(false);

                vistaPro.getBtAgregarModi().setText("Modificar");
            }

        }
        vistaPro.getRbGenerar().setSelected(true);
    }

    public void crearEditarProducto() {
        if (vistaPro.getJdProductos().getName().contentEquals("C")) {

            if (casillasvacias() == true) {

                if (validarcasillas() == true) {
                    int id = Integer.parseInt(vistaPro.getTxtCodPro().getText());
                    String nombrePro = vistaPro.getTxtPronombre().getText();
                    String precio = vistaPro.getTxtProprecio().getText();

                    modeloPro.setPrd_ID(id);
                    modeloPro.setPrd_nombre(nombrePro);
                    modeloPro.setPrd_precio(Double.parseDouble(precio));
                    modeloPro.setPrd_IDCategoria(modeloPro.codProducto(vistaPro.getCbProCate().getSelectedItem().toString()));
                    modeloPro.setPrd_estado("ACTIVO");
                    if (modeloPro.setProducto()) {

                        JOptionPane.showMessageDialog(vistaPro, "Producto creado!!");
                        vaciasCampos();
                        cargarDatos();
                        totalesregisProductos();
                        vistaPro.getJdProductos().setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(vistaPro, "Error: verifique que los campos.");
                    }

                }

            }

        } else {
            if (vistaPro.getJdProductos().getName().contentEquals("E")) {

                if (casillasvacias() == true) {
                    if (validarcasillas() == true) {
                        int id = Integer.parseInt(vistaPro.getTxtCodPro().getText());
                        String nombrePro = vistaPro.getTxtPronombre().getText();
                        String precio = vistaPro.getTxtProprecio().getText();

                        modeloPro.setPrd_ID(id);
                        modeloPro.setPrd_nombre(nombrePro);
                        modeloPro.setPrd_precio(Double.parseDouble(precio));
                        modeloPro.setPrd_IDCategoria(modeloPro.codProducto(vistaPro.getCbProCate().getSelectedItem().toString()));

                        if (modeloPro.uptadeProducto()) {
                            JOptionPane.showMessageDialog(vistaPro, "Producto modificada con exito!!");
                            cargarDatos();
                            vaciasCampos();
                            vistaPro.getJdProductos().setVisible(false);
                        } else {
                            JOptionPane.showMessageDialog(vistaPro, "Error: revise si los datos ingresados son correctos!");
                        }

                    }

                }

            }
        }

    }

    public void eliminarProducto() {
        try {
            int fila = vistaPro.getTbProductos().getSelectedRow();

            if (fila >= 0) {
                int id = Integer.parseInt(vistaPro.getTbProductos().getValueAt(fila, 0).toString());

                modeloPro.setPrd_ID(id);

                if (vistaPro.getTbProductos().getRowSelectionAllowed()) {

                    int a = JOptionPane.showConfirmDialog(null, "Deseas eliminar " + vistaPro.getTxtPronombre().getText().toString());
                    if (a == 0) {
                        modeloPro.desactivarProducto();
                        JOptionPane.showMessageDialog(vistaPro, "Se eliminado " + vistaPro.getTxtPronombre().getText().toString());
                        cargarDatos();
                    }
                }

            } else {
                JOptionPane.showMessageDialog(null, "Fila no seleccionada");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString());
        }
    }

    private void llenar(List<Productos> lista) {
        DefaultTableModel estucturaTabla;
        estucturaTabla = (DefaultTableModel) vistaPro.getTbProductos().getModel();
        estucturaTabla.setRowCount(0);

        lista.stream().forEach(p1 -> {
            String[] product1 = {String.valueOf(p1.getPrd_ID()), p1.getPrd_nombre(), String.valueOf(p1.getPrd_precio()), p1.getPrd_nombreCategoria(), p1.getPrd_estado()};
            estucturaTabla.addRow(product1);
        });
    }

    public void GenerarEditarCodigo() {
        if (vistaPro.getRbGenerar().isSelected()) {
            vistaPro.getTxtCodPro().setEnabled(false);
        } else {
            vistaPro.getTxtCodPro().setEnabled(true);
        }
    }

    private void habilitarBotones() {
        if (vistaPro.getTbProductos().getSelectedRow() >= 1) {
            vistaPro.getBtProdelete().setEnabled(true);
            vistaPro.getBtProModif().setEnabled(true);
        } else {
            vistaPro.getBtProdelete().setEnabled(false);
            vistaPro.getBtProModif().setEnabled(false);
        }
    }

    private void abrirCategoria() {
        Controlador.ControladorCategoria contcate = new Controlador.ControladorCategoria(modcate, vistcate);
        contcate.inicioControl();
    }

    private void vaciasCampos() {
        vistaPro.getTxtPronombre().setText("");
        vistaPro.getTxtProprecio().setText("");
        vistaPro.getTxtPrevista().setText("");
        vistaPro.getCbProCate().setSelectedIndex(0);
        vistaPro.getLbopcionobligatoriaprecio().setText("");
        vistaPro.getLbopcionobligatorioselecco().setText("");
        vistaPro.getLbopcionovligatorianombre().setText("");
    }

    private void previa() {
        String pv = vistaPro.getTxtCodPro().getText() + ", " + vistaPro.getTxtPronombre().getText() + ", "
                + "" + vistaPro.getTxtProprecio().getText() + ", " + vistaPro.getCbProCate().getSelectedItem().toString();
        vistaPro.getTxtPrevista().setText(pv);
    }

    public boolean validarcasillas() {
        boolean validado = true;

        if (!validar.validarsololetras(vistaPro.getTxtPronombre().getText())) {
            //  JOptionPane.showMessageDialog(vistaPro, "Asegurese de que el Nombre solo tenga letras .  Por Favor");
            validado = false;
            //vistaPro.getLbopcionovligatorianombre().setText("*");

        }

        if (!validar.validarprecio(vistaPro.getTxtProprecio().getText())) {
            JOptionPane.showMessageDialog(vistaPro, "Asegurese de que el precion sea un numero y use el punto para decimales .  Por Favor");
            validado = false;
            //  vistaPro.getLbopcionobligatoriaprecio().setText("*");

        }

        return validado;

    }

    public boolean casillasvacias() {
        int c = 0;
        boolean validado = true;

        if (vistaPro.getTxtPronombre().getText().isEmpty()) {
            // JOptionPane.showMessageDialog(vistaPro, "Casilla Nombre del Producto Vacia.");
            validado = false;
            vistaPro.getLbopcionovligatorianombre().setText("*");
            c += 1;

        } else {
            vistaPro.getLbopcionovligatorianombre().setText("");

        }
        if (vistaPro.getTxtProprecio().getText().isEmpty()) {
            //  JOptionPane.showMessageDialog(vistaPro, "Casilla Precio del Producto Vacio");
            validado = false;
            c += 1;
            vistaPro.getLbopcionobligatoriaprecio().setText("*");
        } else {
            vistaPro.getLbopcionobligatoriaprecio().setText("");

        }
        if (!(vistaPro.getCbProCate().getSelectedIndex() > 0)) {
            // JOptionPane.showMessageDialog(vistaPro, "Escoja una Categoria, Por favor");
            validado = false;
            c += 1;
            vistaPro.getLbopcionobligatorioselecco().setText("*");

        } else {

            vistaPro.getLbopcionobligatorioselecco().setText("");
        }
        if (c > 0) {

            JOptionPane.showMessageDialog(vistaPro, " * Campos Obligatorios");

        }
        return validado;
    }

    public void cargarTablaregistrofactura() {
        DefaultTableModel tb = (DefaultTableModel) vistaPro.getTabla_factura_registro().getModel();
        tb.setNumRows(0);
        List<FacturaVenta> com = modelo_venta.consulta_factura();
        com.stream().forEach(p -> {
            String[] cami = {String.valueOf(p.getFactura_id()), String.valueOf(p.getCliente_id()), p.getNombre_cliente() + " " + p.getApellido_cliente(),
                p.getCedula_cliente(), String.valueOf(p.getFecha_factura()), String.valueOf(p.getTotal())};
            tb.addRow(cami);
        });
    }

    private void cargarTablaregistrofacturaPorfecha(int opcBtVG) {
        if (opcBtVG == 1) {
            int opcF = vistaPro.getCbFechasVentas().getSelectedIndex();

            DefaultTableModel tb = (DefaultTableModel) vistaPro.getTabla_factura_registro().getModel();
            tb.setNumRows(0);

            switch (opcF) {
                case 0:
                    List<FacturaVenta> com = modelo_venta.consulta_facturaHOY();
                    com.stream().forEach(p -> {
                        String[] cami = {String.valueOf(p.getFactura_id()), String.valueOf(p.getCliente_id()), p.getNombre_cliente() + " " + p.getApellido_cliente(),
                            p.getCedula_cliente(), String.valueOf(p.getFecha_factura()), String.valueOf(p.getTotal())};
                        tb.addRow(cami);
                    });
                    vistaPro.getLbErrores().setVisible(false);
                    break;
                case 1:
                    List<FacturaVenta> com1 = modelo_venta.consulta_facturaESTASEMANA();
                    com1.stream().forEach(p -> {
                        String[] cami = {String.valueOf(p.getFactura_id()), String.valueOf(p.getCliente_id()), p.getNombre_cliente() + " " + p.getApellido_cliente(),
                            p.getCedula_cliente(), String.valueOf(p.getFecha_factura()), String.valueOf(p.getTotal())};
                        tb.addRow(cami);
                    });
                    vistaPro.getLbErrores().setVisible(false);
                    break;
                case 2:
                    List<FacturaVenta> com2 = modelo_venta.consulta_facturaESTEMES();
                    com2.stream().forEach(p -> {
                        String[] cami = {String.valueOf(p.getFactura_id()), String.valueOf(p.getCliente_id()), p.getNombre_cliente() + " " + p.getApellido_cliente(),
                            p.getCedula_cliente(), String.valueOf(p.getFecha_factura()), String.valueOf(p.getTotal())};
                        tb.addRow(cami);
                    });
                    vistaPro.getLbErrores().setVisible(false);
                    break;
                case 3:

                    if (vistaPro.getDtDesdeVentas().getDate() == null || vistaPro.getDtHastaVentas().getDate() == null) {
                        vistaPro.getLbErrores().setVisible(true);
                        vistaPro.getLbErrores().setText("Por favor asegurese de haber elegido bien las fechas");
                    } else {
                        Date date = vistaPro.getDtDesdeVentas().getDate(); //ic es la interfaz, jDate el JDatechooser
                        long d = date.getTime(); //guardamos en un long el tiempo
                        java.sql.Date fechaDesde = new java.sql.Date(d);

                        Date dateh = vistaPro.getDtHastaVentas().getDate(); //ic es la interfaz, jDate el JDatechooser
                        long dh = dateh.getTime(); //guardamos en un long el tiempo
                        java.sql.Date fechaHasta = new java.sql.Date(dh);

                        List<FacturaVenta> com3 = modelo_venta.consulta_facturaDesdeHasta(fechaDesde.toString(), fechaHasta.toString());
                        com3.stream().forEach(p -> {
                            String[] cami = {String.valueOf(p.getFactura_id()), String.valueOf(p.getCliente_id()), p.getNombre_cliente() + " " + p.getApellido_cliente(),
                                p.getCedula_cliente(), String.valueOf(p.getFecha_factura()), String.valueOf(p.getTotal())};
                            tb.addRow(cami);
                        });
                        vistaPro.getLbErrores().setVisible(false);
                    }

                    break;
                case 4:
                    if (vistaPro.getDtDesdeVentas().getDate() == null) {
                        vistaPro.getLbErrores().setVisible(true);
                        vistaPro.getLbErrores().setText("Por favor asegurese de haber elegido bien la fecha");
                    } else {
                        Date dateD = vistaPro.getDtDesdeVentas().getDate(); //ic es la interfaz, jDate el JDatechooser
                        long dD = dateD.getTime(); //guardamos en un long el tiempo
                        java.sql.Date fechaDesdeD = new java.sql.Date(dD);

                        List<FacturaVenta> com4 = modelo_venta.consulta_facturaDIAESPECIF(fechaDesdeD.toString());
                        com4.stream().forEach(p -> {
                            String[] cami = {String.valueOf(p.getFactura_id()), String.valueOf(p.getCliente_id()), p.getNombre_cliente() + " " + p.getApellido_cliente(),
                                p.getCedula_cliente(), String.valueOf(p.getFecha_factura()), String.valueOf(p.getTotal())};
                            tb.addRow(cami);
                        });
                        vistaPro.getLbErrores().setVisible(false);
                    }

                    break;
                default:
                    throw new AssertionError();
            }
            totalesregisFactVentas();
            actualizar_totalesVentas();
        } else {
            int opcV = vistaPro.getCbFechasGastos().getSelectedIndex();
            vistaPro.getTbGastos().setDefaultRenderer(Object.class, new ImagenTabla());
            vistaPro.getTbGastos().setRowHeight(50);

            DefaultTableModel estructuratabla = (DefaultTableModel) vistaPro.getTbGastos().getModel();
            estructuratabla.setNumRows(0);

            switch (opcV) {
                case 0:
                    List<FacturaGastoCorriente> lista_gastoC0 = modGasto.getGastoCHoy();
                    Holder<Integer> i = new Holder<>(0);
                    lista_gastoC0.stream().forEach(gasto -> {
                        estructuratabla.addRow(new Object[5]);
                        vistaPro.getTbGastos().setValueAt(gasto.getFct_ID(), i.value, 0);
                        vistaPro.getTbGastos().setValueAt(gasto.getFctG_descripccion(), i.value, 1);
                        vistaPro.getTbGastos().setValueAt(gasto.getFct_fecha(), i.value, 2);
                        vistaPro.getTbGastos().setValueAt(gasto.getFct_precio(), i.value, 3);

                        Image foto = gasto.getFotoFactura();
                        if (foto != null) {
                            foto = foto.getScaledInstance(100, 150, Image.SCALE_SMOOTH);
                            ImageIcon icono = new ImageIcon(foto);
                            DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
                            dtcr.setIcon(icono);
                            vistaPro.getTbGastos().setValueAt(new JLabel(icono), i.value, 4);

                        } else {
                            vistaPro.getTbGastos().setValueAt(null, i.value, 4);
                        }

                        i.value++;

                    });
                    vistaPro.getLbErroresGasto().setVisible(false);
                    break;
                case 1:
                    List<FacturaGastoCorriente> lista_gastoC1 = modGasto.getGastoCEstaSemana();
                    Holder<Integer> i1 = new Holder<>(0);
                    lista_gastoC1.stream().forEach(gasto -> {
                        estructuratabla.addRow(new Object[5]);
                        vistaPro.getTbGastos().setValueAt(gasto.getFct_ID(), i1.value, 0);
                        vistaPro.getTbGastos().setValueAt(gasto.getFctG_descripccion(), i1.value, 1);
                        vistaPro.getTbGastos().setValueAt(gasto.getFct_fecha(), i1.value, 2);
                        vistaPro.getTbGastos().setValueAt(gasto.getFct_precio(), i1.value, 3);

                        Image foto = gasto.getFotoFactura();
                        if (foto != null) {
                            foto = foto.getScaledInstance(100, 150, Image.SCALE_SMOOTH);
                            ImageIcon icono = new ImageIcon(foto);
                            DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
                            dtcr.setIcon(icono);
                            vistaPro.getTbGastos().setValueAt(new JLabel(icono), i1.value, 4);

                        } else {
                            vistaPro.getTbGastos().setValueAt(null, i1.value, 4);
                        }

                        i1.value++;

                    });
                    vistaPro.getLbErroresGasto().setVisible(false);
                    break;
                case 2:
                    List<FacturaGastoCorriente> lista_gastoC2 = modGasto.getGastoCEstaSemana();
                    Holder<Integer> i2 = new Holder<>(0);
                    lista_gastoC2.stream().forEach(gasto -> {
                        estructuratabla.addRow(new Object[5]);
                        vistaPro.getTbGastos().setValueAt(gasto.getFct_ID(), i2.value, 0);
                        vistaPro.getTbGastos().setValueAt(gasto.getFctG_descripccion(), i2.value, 1);
                        vistaPro.getTbGastos().setValueAt(gasto.getFct_fecha(), i2.value, 2);
                        vistaPro.getTbGastos().setValueAt(gasto.getFct_precio(), i2.value, 3);

                        Image foto = gasto.getFotoFactura();
                        if (foto != null) {
                            foto = foto.getScaledInstance(100, 150, Image.SCALE_SMOOTH);
                            ImageIcon icono = new ImageIcon(foto);
                            DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
                            dtcr.setIcon(icono);
                            vistaPro.getTbGastos().setValueAt(new JLabel(icono), i2.value, 4);

                        } else {
                            vistaPro.getTbGastos().setValueAt(null, i2.value, 4);
                        }

                        i2.value++;

                    });
                    vistaPro.getLbErroresGasto().setVisible(false);
                    break;
                case 3:

                    if (vistaPro.getDtDesdeGasato().getDate() == null || vistaPro.getDtHastaGasto().getDate() == null) {
                        vistaPro.getLbErroresGasto().setVisible(true);
                        vistaPro.getLbErroresGasto().setText("Por favor asegurese de haber elegido bien las fechas");
                    } else {
                        Date date = vistaPro.getDtDesdeGasato().getDate(); //ic es la interfaz, jDate el JDatechooser
                        long d = date.getTime(); //guardamos en un long el tiempo
                        java.sql.Date fechaDesde = new java.sql.Date(d);

                        Date dateh = vistaPro.getDtHastaGasto().getDate(); //ic es la interfaz, jDate el JDatechooser
                        long dh = dateh.getTime(); //guardamos en un long el tiempo
                        java.sql.Date fechaHasta = new java.sql.Date(dh);

                        List<FacturaGastoCorriente> lista_gastoC = modGasto.getGastoCDesdeAhora(fechaDesde.toString(), fechaHasta.toString());
                        Holder<Integer> i3 = new Holder<>(0);
                        lista_gastoC.stream().forEach(gasto -> {
                            estructuratabla.addRow(new Object[5]);
                            vistaPro.getTbGastos().setValueAt(gasto.getFct_ID(), i3.value, 0);
                            vistaPro.getTbGastos().setValueAt(gasto.getFctG_descripccion(), i3.value, 1);
                            vistaPro.getTbGastos().setValueAt(gasto.getFct_fecha(), i3.value, 2);
                            vistaPro.getTbGastos().setValueAt(gasto.getFct_precio(), i3.value, 3);

                            Image foto = gasto.getFotoFactura();
                            if (foto != null) {
                                foto = foto.getScaledInstance(100, 150, Image.SCALE_SMOOTH);
                                ImageIcon icono = new ImageIcon(foto);
                                DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
                                dtcr.setIcon(icono);
                                vistaPro.getTbGastos().setValueAt(new JLabel(icono), i3.value, 4);

                            } else {
                                vistaPro.getTbGastos().setValueAt(null, i3.value, 4);
                            }

                            i3.value++;

                        });
                        vistaPro.getLbErroresGasto().setVisible(false);
                    }

                    break;
                case 4:
                    if (vistaPro.getDtDesdeGasato().getDate() == null) {
                        vistaPro.getLbErroresGasto().setVisible(true);
                        vistaPro.getLbErroresGasto().setText("Por favor asegurese de haber elegido bien la fecha");
                    } else {
                        Date dateD = vistaPro.getDtDesdeGasato().getDate(); //ic es la interfaz, jDate el JDatechooser
                        long dD = dateD.getTime(); //guardamos en un long el tiempo
                        java.sql.Date fechaDesdeD = new java.sql.Date(dD);

                        List<FacturaGastoCorriente> lista_gastoC4 = modGasto.getGastoCDesde(fechaDesdeD.toString());
                        Holder<Integer> i4 = new Holder<>(0);
                        lista_gastoC4.stream().forEach(gasto -> {
                            estructuratabla.addRow(new Object[5]);
                            vistaPro.getTbGastos().setValueAt(gasto.getFct_ID(), i4.value, 0);
                            vistaPro.getTbGastos().setValueAt(gasto.getFctG_descripccion(), i4.value, 1);
                            vistaPro.getTbGastos().setValueAt(gasto.getFct_fecha(), i4.value, 2);
                            vistaPro.getTbGastos().setValueAt(gasto.getFct_precio(), i4.value, 3);

                            Image foto = gasto.getFotoFactura();
                            if (foto != null) {
                                foto = foto.getScaledInstance(100, 150, Image.SCALE_SMOOTH);
                                ImageIcon icono = new ImageIcon(foto);
                                DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
                                dtcr.setIcon(icono);
                                vistaPro.getTbGastos().setValueAt(new JLabel(icono), i4.value, 4);

                            } else {
                                vistaPro.getTbGastos().setValueAt(null, i4.value, 4);
                            }

                            i4.value++;

                        });
                        vistaPro.getLbErroresGasto().setVisible(false);
                    }

                    break;
                default:
                    throw new AssertionError();
            }
            totalesregisGastos();
            actualizar_totalesGatos();
        }

    }

    private void totalesregisProductos() {

        vistaPro.getLbTotalProd().setText(String.valueOf(vistaPro.getTbProductos().getRowCount()));
    }

    private void totalesregisGastos() {

        vistaPro.getLbtotalGastos().setText(String.valueOf(vistaPro.getTbGastos().getRowCount()));
    }

    private void totalesregisFactVentas() {

        vistaPro.getLbTotalventas().setText(String.valueOf(vistaPro.getTabla_factura_registro().getRowCount()));

    }

    private void actualizar_totalesVentas() {

        vistaPro.getLbTotalvendido().setText("0");

        int ta = vistaPro.getTabla_factura_registro().getRowCount();
        int c = 0;
        do {
            try {
                int f = c++;
                Double n1 = Double.parseDouble(vistaPro.getTabla_factura_registro().getValueAt(f, 5).toString());
                String nu = vistaPro.getLbTotalvendido().getText();
                Double nu2 = Double.parseDouble(nu);
                Double re = (n1 + nu2);
                vistaPro.getLbTotalvendido().setText(String.valueOf(re));
            } catch (Exception e) {

            }
        } while (c < ta);
    }

    private void actualizar_totalesGatos() {

        vistaPro.getLbMontostotalesGastos().setText("0");

        int ta = vistaPro.getTbGastos().getRowCount();
        int c = 0;
        do {
            try {
                int f = c++;
                Double n1 = Double.parseDouble(vistaPro.getTbGastos().getValueAt(f, 3).toString());
                String nu = vistaPro.getLbMontostotalesGastos().getText();
                Double nu2 = Double.parseDouble(nu);
                Double re = (n1 + nu2);
                vistaPro.getLbMontostotalesGastos().setText(String.valueOf(re));
            } catch (Exception e) {

            }
        } while (c < ta);
    }

    private void esconderDesdeHastaVts() {
        int op = vistaPro.getCbFechasVentas().getSelectedIndex();
        switch (op) {
            case 3:
                vistaPro.getDtDesdeVentas().setVisible(true);
                vistaPro.getDtHastaVentas().setVisible(true);
                vistaPro.getLbHastaVentas().setVisible(true);
                vistaPro.getLblDesdeVentas().setVisible(true);

                vistaPro.getDtDesdeVentas().setCalendar(null);
                vistaPro.getDtHastaVentas().setCalendar(null);
                break;
            case 4:
                vistaPro.getDtDesdeVentas().setVisible(true);
                vistaPro.getLblDesdeVentas().setVisible(true);
                vistaPro.getDtHastaVentas().setVisible(false);
                vistaPro.getLbHastaVentas().setVisible(false);

                vistaPro.getDtDesdeVentas().setCalendar(null);
                break;
            default:
                vistaPro.getDtDesdeVentas().setVisible(false);
                vistaPro.getDtHastaVentas().setVisible(false);
                vistaPro.getLbHastaVentas().setVisible(false);
                vistaPro.getLblDesdeVentas().setVisible(false);
        }
    }

    private void esconderDesdeHastaGastos() {
        int op = vistaPro.getCbFechasGastos().getSelectedIndex();
        switch (op) {
            case 3:
                vistaPro.getDtDesdeGasato().setVisible(true);
                vistaPro.getDtHastaGasto().setVisible(true);
                vistaPro.getLbdesdeGastos().setVisible(true);
                vistaPro.getLbhastaGastos().setVisible(true);

                vistaPro.getDtDesdeGasato().setCalendar(null);
                vistaPro.getDtHastaGasto().setCalendar(null);
                break;
            case 4:
                vistaPro.getDtDesdeGasato().setVisible(true);
                vistaPro.getLbdesdeGastos().setVisible(true);

                vistaPro.getDtDesdeGasato().setCalendar(null);
                break;
            default:
                vistaPro.getDtDesdeGasato().setVisible(false);
                vistaPro.getDtHastaGasto().setVisible(false);
                vistaPro.getLbdesdeGastos().setVisible(false);
                vistaPro.getLbhastaGastos().setVisible(false);
        }
    }

    private void inicarGastos() {
        Controlador.ControlGastoC controlGasto = new Controlador.ControlGastoC(modGasto, vistaPro);
        controlGasto.iniciaControlC();
    }

    public void imprimeProducto() {
        //Instanciamos la conexion proyecto
        OCconection con = new OCconection();

        JasperReport jr;
        try {
            jr = (JasperReport) JRLoader.loadObject(getClass().getResource("/VIsta/reportes/Producto.jasper"));

            JasperPrint jp = JasperFillManager.fillReport(jr, null, con.getConex());//llena el reporte con datos.
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);
        } catch (JRException ex) {
            java.util.logging.Logger.getLogger(Controlador_factura_venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    public void imprimeGasto() {
        //Instanciamos la conexion proyecto
        OCconection con = new OCconection();

        JasperReport jr;
        try {
            jr = (JasperReport) JRLoader.loadObject(getClass().getResource("/VIsta/reportes/Gastos.jasper"));

            JasperPrint jp = JasperFillManager.fillReport(jr, null, con.getConex());//llena el reporte con datos.
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);
        } catch (JRException ex) {
            java.util.logging.Logger.getLogger(Controlador_factura_venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    public void imprimeVentas() {
        //Instanciamos la conexion proyecto
        OCconection con = new OCconection();

        JasperReport jr;
        try {
            jr = (JasperReport) JRLoader.loadObject(getClass().getResource("/VIsta/reportes/Ventas.jasper"));

            JasperPrint jp = JasperFillManager.fillReport(jr, null, con.getConex());//llena el reporte con datos.
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);
        } catch (JRException ex) {
            java.util.logging.Logger.getLogger(Controlador_factura_venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
}
