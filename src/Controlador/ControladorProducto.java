/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import VIsta.Categorias;
import VIsta.RegistrosdeFacturasGastosBalances;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.xml.ws.Holder;
import modelo.FacturaVenta;
import modelo.MConexion.ModelCategoria;
import modelo.MConexion.ModelGastoCorriente;
import modelo.MConexion.ModelProducto;
import modelo.MConexion.Modelo_factura_venta;
import modelo.Productos;
import modelo.Validaciones;

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
        actualizar_totalesregis();
        actualizar_totalesregisFact();
        actualizar_totalesvendiFact();
        vistaPro.getLbErrores().setVisible(false);
        vistaPro.getBtPrevisualizar().addActionListener(l -> previa());
        vistaPro.getBtVerCategoria().addActionListener(l -> abrirCategoria());
        vistaPro.getBtPronuevo().addActionListener(l1 -> abrirdialogProd(1));
        vistaPro.getBtProModif().addActionListener(l1 -> abrirdialogProd(2));
        vistaPro.getBtAgregarModi().addActionListener(l -> crearEditarProducto());
        vistaPro.getBtProdelete().addActionListener(l -> eliminarProducto());
        vistaPro.getBtSalir().addActionListener(l -> vistaPro.getJdProductos().dispose());
        vistaPro.getBtFecha().addActionListener(l -> cargarTablaregistrofacturaPorfecha());
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
        vistaPro.getCbFechasVentas().addActionListener(l -> esconderDesdeHastaVts());
        vistaPro.getCbFechasGastos().addActionListener(l -> esconderDesdeHastaGastos());
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
            vistaPro.getJdProductos().setSize(700, 600);
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
                vistaPro.getJdProductos().setSize(700, 500);
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
    }

    private void previa() {
        String pv = vistaPro.getTxtCodPro().getText() + ", " + vistaPro.getTxtPronombre().getText() + ", "
                + "" + vistaPro.getTxtProprecio().getText() + ", " + vistaPro.getCbProCate().getSelectedItem().toString();
        vistaPro.getTxtPrevista().setText(pv);
    }

    public boolean validarcasillas() {
        boolean validado = true;

        if (!validar.validarsololetras(vistaPro.getTxtPronombre().getText())) {
            JOptionPane.showMessageDialog(vistaPro, "Asegurese de que el Nombre solo tenga letras .  Por Favor");
            validado = false;

        }

        if (!validar.validarprecio(vistaPro.getTxtProprecio().getText())) {
            JOptionPane.showMessageDialog(vistaPro, "Asegurese de que el precion sea un numero y use el punto para decimales .  Por Favor");
            validado = false;

        }

        return validado;

    }

    public boolean casillasvacias() {

        boolean validado = true;

        if (vistaPro.getTxtPronombre().getText().isEmpty()) {
            JOptionPane.showMessageDialog(vistaPro, "Casilla Nombre del Producto Vacia.");
            validado = false;

        }
        if (vistaPro.getTxtProprecio().getText().isEmpty()) {
            JOptionPane.showMessageDialog(vistaPro, "Casilla Precio del Producto Vacio");
            validado = false;
        }
        if (!(vistaPro.getCbProCate().getSelectedIndex() > 0)) {
            JOptionPane.showMessageDialog(vistaPro, "Escoja una Categoria, Por favor");
            validado = false;

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

    public void cargarTablaregistrofacturaPorfecha() {

        int opcF = vistaPro.getCbFechasVentas().getSelectedIndex();

        DefaultTableModel tb = (DefaultTableModel) vistaPro.getTabla_factura_registro().getModel();
        tb.setNumRows(0);
        if (fechasVacias()==false) {
            vistaPro.getLbErrores().setText("Ingrese una fecha.");
            vistaPro.getLbErrores().setVisible(true);
        } else {
            switch (opcF) {
                case 0:
                    List<FacturaVenta> com = modelo_venta.consulta_facturaHOY();
                    com.stream().forEach(p -> {
                        String[] cami = {String.valueOf(p.getFactura_id()), String.valueOf(p.getCliente_id()), p.getNombre_cliente() + " " + p.getApellido_cliente(),
                            p.getCedula_cliente(), String.valueOf(p.getFecha_factura()), String.valueOf(p.getTotal())};
                        tb.addRow(cami);
                    });
                    break;
                case 1:
                    List<FacturaVenta> com1 = modelo_venta.consulta_facturaESTASEMANA();
                    com1.stream().forEach(p -> {
                        String[] cami = {String.valueOf(p.getFactura_id()), String.valueOf(p.getCliente_id()), p.getNombre_cliente() + " " + p.getApellido_cliente(),
                            p.getCedula_cliente(), String.valueOf(p.getFecha_factura()), String.valueOf(p.getTotal())};
                        tb.addRow(cami);
                    });
                    break;
                case 2:
                    List<FacturaVenta> com2 = modelo_venta.consulta_facturaESTEMES();
                    com2.stream().forEach(p -> {
                        String[] cami = {String.valueOf(p.getFactura_id()), String.valueOf(p.getCliente_id()), p.getNombre_cliente() + " " + p.getApellido_cliente(),
                            p.getCedula_cliente(), String.valueOf(p.getFecha_factura()), String.valueOf(p.getTotal())};
                        tb.addRow(cami);
                    });
                    break;
                case 3:
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
                    break;
                case 4:
                    Date dateD = vistaPro.getDtDesdeVentas().getDate(); //ic es la interfaz, jDate el JDatechooser
                    long dD = dateD.getTime(); //guardamos en un long el tiempo
                    java.sql.Date fechaDesdeD = new java.sql.Date(dD);

                    List<FacturaVenta> com4 = modelo_venta.consulta_facturaDIAESPECIF(fechaDesdeD.toString());
                    com4.stream().forEach(p -> {
                        String[] cami = {String.valueOf(p.getFactura_id()), String.valueOf(p.getCliente_id()), p.getNombre_cliente() + " " + p.getApellido_cliente(),
                            p.getCedula_cliente(), String.valueOf(p.getFecha_factura()), String.valueOf(p.getTotal())};
                        tb.addRow(cami);
                    });
                    break;
                default:
                    throw new AssertionError();
            }
        }
        actualizar_totalesregisFact();
    }

    private void actualizar_totalesregis() {

        vistaPro.getLbTotalProd().setText("0");

        int ta = vistaPro.getTbProductos().getRowCount();
        int c = 0;
        do {
            try {
                int f = c++;
                int n1 = Integer.parseInt(vistaPro.getTabla_factura_registro().getValueAt(f, 1).toString());
                String nu = vistaPro.getLbTotalProd().getText();
                int nu2 = Integer.parseInt(nu);
                int re = (n1 + nu2);
                vistaPro.getLbTotalProd().setText(String.valueOf(re));
            } catch (Exception e) {

            }
        } while (c < ta);
    }

    private void actualizar_totalesregisFact() {

        vistaPro.getLbTotalventas().setText("0");

        int ta = vistaPro.getTabla_factura_registro().getRowCount();
        int c = 0;
        do {
            try {
                int f = c++;
                int n1 = Integer.parseInt(vistaPro.getTabla_factura_registro().getValueAt(f, 5).toString());
                String nu = vistaPro.getLbTotalventas().getText();
                int nu2 = Integer.parseInt(nu);
                int re = (n1 + nu2);
                vistaPro.getLbTotalventas().setText(String.valueOf(re));
            } catch (Exception e) {

            }
        } while (c < ta);
    }

    private void actualizar_totalesvendiFact() {

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
                break;
            case 4:
                vistaPro.getDtDesdeGasato().setVisible(true);
                vistaPro.getLbdesdeGastos().setVisible(true);
                break;
            default:
                vistaPro.getDtDesdeGasato().setVisible(false);
                vistaPro.getDtHastaGasto().setVisible(false);
                vistaPro.getLbdesdeGastos().setVisible(false);
                vistaPro.getLbhastaGastos().setVisible(false);
        }
    }

    private boolean fechasVacias() {
        boolean d = vistaPro.getDtDesdeVentas().getCalendar()==null;
        boolean h = vistaPro.getDtHastaGasto().getCalendar()==null;
        boolean result= true;
        if (d==true||vistaPro.getCbFechasVentas().getSelectedIndex()==4) {
            result = false;
        }
        if ((d==true||h==true)&&(vistaPro.getCbFechasVentas().getSelectedIndex()==3)) {
            result = false;
        }
        
        return result;
    }
    
    private void inicarGastos(){
        Controlador.ControlGastoC controlGasto = new Controlador.ControlGastoC(modGasto, vistaPro);
        controlGasto.iniciaControlC();
    }
}
