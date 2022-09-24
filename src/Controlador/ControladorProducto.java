/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import VIsta.Categorias;
import VIsta.RegistrosdeFacturasGastosBalances;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.xml.ws.Holder;
import modelo.Categoria;
import modelo.MConexion.ModelCategoria;
import modelo.MConexion.ModelProducto;
import modelo.MConexion.ModelProducto;
import modelo.OCconection;
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

    Validaciones validar = new Validaciones();

    public ControladorProducto(ModelProducto modeloPro, RegistrosdeFacturasGastosBalances vistaPro, ModelCategoria modcate, Categorias vistcate) {
        this.modeloPro = modeloPro;
        this.vistaPro = vistaPro;
        this.modcate = modcate;
        this.vistcate = vistcate;
        vistaPro.setVisible(true);
        cargarDatos();
        habilitarBotones();
        modeloPro.cargarCategoriaCB(vistaPro.getCbProCate());
        GenerarEditarCodigo();
    }

    public void iniciaControl() {
        vistaPro.getBtPrevisualizar().addActionListener(l -> previa());
        vistaPro.getBtVerCategoria().addActionListener(l -> abrirCategoria());
        vistaPro.getBtPronuevo().addActionListener(l -> abrirdialog(1));
        vistaPro.getBtProModif().addActionListener(l -> abrirdialog(2));
        vistaPro.getBtAgregarModi().addActionListener(l -> crearEditarProducto());
        vistaPro.getBtProdelete().addActionListener(l -> eliminarProducto());
        vistaPro.getBtSalir().addActionListener(l -> vistaPro.getJdProductos().dispose());
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

    private void abrirdialog(int opcion) {
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

                        JOptionPane.showMessageDialog(vistaPro, "Categoría creado!!");
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
                            JOptionPane.showMessageDialog(vistaPro, "Categoría modificada con exito!!");
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
}
