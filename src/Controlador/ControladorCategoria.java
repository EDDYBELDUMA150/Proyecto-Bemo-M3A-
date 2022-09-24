/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import VIsta.Categorias;
import com.oracle.jrockit.jfr.Producer;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.xml.ws.Holder;
import modelo.Categoria;
import modelo.MConexion.ModelCategoria;
import modelo.Validaciones;

/**
 *
 * @author OWNER
 */
public class ControladorCategoria {

    private modelo.MConexion.ModelCategoria modeloCat;
    private VIsta.Categorias vistaCat;

    Validaciones validar = new Validaciones();

    public ControladorCategoria(ModelCategoria modeloCat, Categorias vistaCat) {
        this.modeloCat = modeloCat;
        this.vistaCat = vistaCat;
        vistaCat.setVisible(true);
        cargarDatosCat();
        GenerarEditarCodigo();
        habilitarBotones();
    }

    public void inicioControl() {
        habilitarBotones();
        vistaCat.getBtSalirProductos().addActionListener(l -> vistaCat.dispose());
        vistaCat.getBtNuevoCat().addActionListener(l -> abrirdialog(1));
        vistaCat.getBtmodiCat().addActionListener(l -> abrirdialog(2));
        vistaCat.getBtAgregarCAT().addActionListener(l -> crearEditarCategoria());
        vistaCat.getBtCancelarcat().addActionListener(l -> vistaCat.getJdlCat().dispose());
        vistaCat.getBtEliminarCat().addActionListener(l -> eliminarCategoria());
        vistaCat.getBtBuscar().addActionListener(l -> busqueda(vistaCat.getTxtBuscarCat().getText()));
        vistaCat.getBtSalirProductos().addActionListener(l -> vistaCat.dispose());
        vistaCat.getRbGenerar().addActionListener(l -> vistaCat.getTxtCodigocat().setEnabled(false));
        vistaCat.getRbEditar().addActionListener(l -> vistaCat.getTxtCodigocat().setEnabled(true));
        vistaCat.getJtbCate().addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                int fila = vistaCat.getJtbCate().rowAtPoint(e.getPoint());
                int columna = vistaCat.getJtbCate().columnAtPoint(e.getPoint());
                if ((fila > -1) && (columna > -1)) {
                    vistaCat.getBtEliminarCat().setEnabled(true);
                    vistaCat.getBtmodiCat().setEnabled(true);
                } else {
                    vistaCat.getBtEliminarCat().setEnabled(false);
                    vistaCat.getBtmodiCat().setEnabled(false);
                }
            }
        });
    }

    private void cargarDatosCat() {
        DefaultTableModel estucturaTabla;
        estucturaTabla = (DefaultTableModel) vistaCat.getJtbCate().getModel();
        estucturaTabla.setNumRows(0);

        List<Categoria> listcate = modeloCat.getCategorias();

        Holder<Integer> i = new Holder<>(0);
        listcate.stream().forEach(cat -> {
            estucturaTabla.addRow(new Object[2]);
            vistaCat.getJtbCate().setValueAt(cat.getCtg_ID(), i.value, 0);
            vistaCat.getJtbCate().setValueAt(cat.getCtg_nombre(), i.value, 1);
            i.value++;
        });
    }

    private void abrirdialog(int opcion) {
        int CRg = modeloCat.countRegistros();

        if (CRg == 0) {
            CRg = 1;
        } else {
            CRg++;
        }

        if (opcion == 1) {
            vistaCat.getTituloModi().setVisible(false);
            vistaCat.getTituloNuevo().setVisible(true);
            vistaCat.getJdlCat().setName("C");
            vistaCat.getJdlCat().setVisible(true);;
            vistaCat.getJdlCat().setSize(600, 250);
            vistaCat.getTxtCodigocat().setText(String.valueOf(CRg));
            vistaCat.getBtAgregarCAT().setText("Agregar");
            vistaCat.getJdlCat().setLocationRelativeTo(vistaCat);
            vistaCat.getTxtNombrecat().setText("");
        } else {

            vistaCat.getJdlCat().setName("E");

            int fila = vistaCat.getJtbCate().getSelectedRow();

            if (fila >= 0) {
                vistaCat.getTxtCodigocat().setText(vistaCat.getJtbCate().getValueAt(fila, 0).toString());
                vistaCat.getTxtNombrecat().setText(vistaCat.getJtbCate().getValueAt(fila, 1).toString());

                vistaCat.getJdlCat().setVisible(true);
                vistaCat.getJdlCat().setSize(600, 250);
                vistaCat.getTituloModi().setVisible(true);
                vistaCat.getTituloNuevo().setVisible(false);
                vistaCat.getJdlCat().setLocationRelativeTo(vistaCat);

                vistaCat.getBtAgregarCAT().setText("Modificar");
            }

        }
        vistaCat.getRbGenerar().setSelected(true);
    }

    public void crearEditarCategoria() {
        if (vistaCat.getJdlCat().getName().contentEquals("C")) {
            int id = Integer.parseInt(vistaCat.getTxtCodigocat().getText().toString());
            String nombreCat = vistaCat.getTxtNombrecat().getText().toString().toUpperCase();

            modeloCat.setCtg_ID(id);
            modeloCat.setCtg_nombre(nombreCat);
            modeloCat.setCtg_estado("ACTIVO");

            if (casillasvacias() == true) {
                if (modeloCat.setCategoria()) {
                    JOptionPane.showMessageDialog(vistaCat, "Categoría creado!!");
                    cargarDatosCat();
                    vistaCat.getJdlCat().dispose();

                    vistaCat.getTxtNombrecat().setText("");
                    vistaCat.getTxtCodigocat().setText("");
                } else {
                    JOptionPane.showMessageDialog(vistaCat, "Error: verifique que los campos no estén vacios");
                }

            }

        } else {
            if (vistaCat.getJdlCat().getName().contentEquals("E")) {
                if (casillasvacias() == true) {
                    int id = Integer.parseInt(vistaCat.getTxtCodigocat().getText().toString());
                    String nombreCat = vistaCat.getTxtNombrecat().getText().toString().toUpperCase();

                    modeloCat.setCtg_ID(id);
                    modeloCat.setCtg_nombre(nombreCat);

                    if (modeloCat.uptadeCategoria()) {
                        JOptionPane.showMessageDialog(vistaCat, "Categoría modificada con exito!!");
                        cargarDatosCat();
                        vistaCat.getJdlCat().setVisible(false);
                        vistaCat.getTxtNombrecat().setText("");
                        vistaCat.getTxtCodigocat().setText("");
                    } else {
                        JOptionPane.showMessageDialog(vistaCat, "Error: revise si los datos ingresados son correctos!");
                    }

                }

            }
        }
    }

    public void eliminarCategoria() {
        try {
            int fila = vistaCat.getJtbCate().getSelectedRow();

            if (fila >= 0) {
                int id = Integer.parseInt(vistaCat.getJtbCate().getValueAt(fila, 0).toString());

                modeloCat.setCtg_ID(id);

                if (vistaCat.getJtbCate().getRowSelectionAllowed()) {

                    int a = JOptionPane.showConfirmDialog(null, "Deseas eliminar " + vistaCat.getTxtNombrecat().getText().toString());
                    if (a == 0) {
                        modeloCat.desactivarProducto();
                        JOptionPane.showMessageDialog(vistaCat, "Se eliminado " + vistaCat.getTxtNombrecat().getText().toString());
                        cargarDatosCat();
                    }
                }

            } else {
                JOptionPane.showMessageDialog(null, "Fila no seleccionada");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString());
        }
    }

    public void busqueda(String buscador) {

        String nombre = vistaCat.getTxtBuscarCat().getText();

        modeloCat.setCtg_nombre(nombre);
        modeloCat.buscarCategoria();

        List<Categoria> listcat = modeloCat.getCategorias();

        Stream<Categoria> catgr = listcat.stream().filter(c -> {
            return c.getCtg_nombre().equalsIgnoreCase(nombre);
        });

        listcat = catgr.collect(Collectors.toList());
        llenar(listcat);

    }

    private void llenar(List<Categoria> lista) {
        DefaultTableModel estucturaTabla;
        estucturaTabla = (DefaultTableModel) vistaCat.getJtbCate().getModel();
        estucturaTabla.setRowCount(0);

        lista.stream().forEach(p1 -> {
            String[] persona1 = {String.valueOf(p1.getCtg_ID()), p1.getCtg_nombre()};
            estucturaTabla.addRow(persona1);
        });
    }

    public void GenerarEditarCodigo() {
        if (vistaCat.getRbGenerar().isSelected()) {
            vistaCat.getTxtCodigocat().setEnabled(false);
        } else {
            vistaCat.getTxtCodigocat().setEnabled(true);
        }
    }

    public void habilitarBotones() {
        if (vistaCat.getJtbCate().getSelectedRow() >= 1) {
            vistaCat.getBtEliminarCat().setEnabled(true);
            vistaCat.getBtmodiCat().setEnabled(true);
        } else {
            vistaCat.getBtEliminarCat().setEnabled(false);
            vistaCat.getBtmodiCat().setEnabled(false);
        }
    }

    public boolean casillasvacias() {

        boolean validado = true;

        if (vistaCat.getTxtNombrecat().getText().isEmpty() || !validar.validarsololetras(vistaCat.getTxtNombrecat().getText())) {
            JOptionPane.showMessageDialog(vistaCat, "Ingrese solo letras ,por favor ");
            validado = false;

        }

        return validado;

    }

}
