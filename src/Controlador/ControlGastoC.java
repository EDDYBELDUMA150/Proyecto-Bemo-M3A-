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
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.xml.ws.Holder;
import modelo.FacturaGastoCorriente;
import modelo.MConexion.ModelGastoCorriente;
import modelo.Validaciones;

/**
 *
 * @author OWNER
 */
public class ControlGastoC {

    DefaultTableModel estructuraTabla;
    private JFileChooser jfc;
    Date fechaActual = new Date();
    modelo.MConexion.ModelGastoCorriente modeGC;
    VIsta.RegistrosdeFacturasGastosBalances viewGC;
    Validaciones validar = new Validaciones();

    public ControlGastoC() {
    }

    public ControlGastoC(modelo.MConexion.ModelGastoCorriente modeGC, RegistrosdeFacturasGastosBalances viewGC) {
        this.modeGC = modeGC;
        this.viewGC = viewGC;
        cargardatos();
        viewGC.getTxtcodG().setEnabled(false);
    }

    public void iniciaControlC() {
        viewGC.getBtNuevoGC().addActionListener(l2 -> abrirdialogG(1));
        viewGC.getBtModiGastoC().addActionListener(l2 -> abrirdialogG(2));
        viewGC.getBtAgregarModiG().addActionListener(l -> crearEditarGastoC());
        viewGC.getBtEliminarGastoC().addActionListener(l -> eliminarGasto());
        viewGC.getBtSalirG().addActionListener(l -> viewGC.getJdGastos().dispose());
        viewGC.getBtCargarFotoG().addActionListener(l -> examinaFoto());

        viewGC.getDtFecha().setDate(fechaActual);

        viewGC.getTxtprecioG().addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();
                if (viewGC.getTxtprecioG().getText().length() == 30 || (caracter < '0') || (caracter > '9')) {
                    e.consume();
                }

            }

        });
    }

    public void cargardatos() {
        viewGC.getTbGastos().setDefaultRenderer(Object.class, new ImagenTabla());
        viewGC.getTbGastos().setRowHeight(50);

        DefaultTableModel estructuratabla;
        estructuratabla = (DefaultTableModel) viewGC.getTbGastos().getModel();
        estructuratabla.setNumRows(0);

        List<FacturaGastoCorriente> lista_gastoC = modeGC.getGastoC();
        Holder<Integer> i = new Holder<>(0);
        lista_gastoC.stream().forEach(gasto -> {
            estructuratabla.addRow(new Object[5]);
            viewGC.getTbGastos().setValueAt(gasto.getFct_ID(), i.value, 0);
            viewGC.getTbGastos().setValueAt(gasto.getFctG_descripccion(), i.value, 1);
            viewGC.getTbGastos().setValueAt(gasto.getFct_fecha(), i.value, 2);
            viewGC.getTbGastos().setValueAt(gasto.getFct_precio(), i.value, 3);

            Image foto = gasto.getFotoFactura();
            if (foto != null) {
                foto = foto.getScaledInstance(100, 150, Image.SCALE_SMOOTH);
                ImageIcon icono = new ImageIcon(foto);
                DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
                dtcr.setIcon(icono);
                viewGC.getTbGastos().setValueAt(new JLabel(icono), i.value, 4);

            } else {
                viewGC.getTbGastos().setValueAt(null, i.value, 4);
            }

            i.value++;

        });

    }

    public void abrirdialogG(int opcion) {
        int CRg = modeGC.countRegistrosGastosC();

        if (CRg == 0) {
            CRg = 1;
        } else {
            CRg++;
        }

        if (opcion == 1) {
            viewGC.getLbTitulo().setText("NUEVO GASTO");
            viewGC.getJdGastos().setName("C");
            viewGC.getJdGastos().setVisible(true);
            viewGC.getJdGastos().setLocationRelativeTo(viewGC);
            viewGC.getJdGastos().setSize(788, 410);
            viewGC.getTxtcodG().setText(String.valueOf(CRg));
            viewGC.getBtAgregarModiG().setText("Agregar");
            vaciasCampos();
        } else {

            if (llenarGastoE()) {
                viewGC.getJdGastos().setName("E");
                viewGC.getJdGastos().setVisible(true);
                viewGC.getJdGastos().setSize(788, 410);
                viewGC.getLbTitulo().setText("MODIFICAR GASTO");
                viewGC.getJdGastos().setLocationRelativeTo(viewGC);
                viewGC.getBtAgregarModiG().setText("Modificar");
            }
        }
        viewGC.getRbGenerar().setSelected(true);
    }

    private void crearEditarGastoC() {
        boolean ban = false;
        int colorAux = viewGC.getLbFotoG().getBackground().hashCode(), colorAux2 = 0;

        if (viewGC.getJdGastos().getName().contentEquals("C")) {

            if (casillasvacias() == true) {
                if (validarp() == true) {
                    int id = Integer.parseInt(viewGC.getTxtcodG().getText());
                    String descr = viewGC.getTxtdescripG().getText();
                    Date fecha = fechaActual;
                    long d = fecha.getTime();
                    java.sql.Date fch = new java.sql.Date(d);
                    double precio = Double.parseDouble(viewGC.getTxtprecioG().getText());
                    try {
                        FileInputStream img = new FileInputStream(jfc.getSelectedFile());
                        int largo = (int) jfc.getSelectedFile().length();
                        modeGC.setImageFile(img);
                        modeGC.setLength(largo);

                        colorAux2 = viewGC.getLbFotoG().getBackground().hashCode() + 2;
                    } catch (IOException ex) {
                        Logger.getLogger(ControlGastoC.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (NullPointerException e) {
                        colorAux2 = viewGC.getLbFotoG().getBackground().hashCode();
                    }

                    modeGC.setFct_ID(id);
                    modeGC.setFctG_descripccion(descr);
                    modeGC.setFct_fecha(fch);
                    modeGC.setFct_precio(precio);
                    modeGC.setFctG_estado("ACTIVO");

                    if (modeGC.setGastoC()) {
                        JOptionPane.showMessageDialog(viewGC, "Gasto registrado exitosamente");
                        vaciasCampos();
                        cargardatos();
                        viewGC.getJdGastos().setVisible(false);
                        totalesregisGastos();
                    } else {
                        JOptionPane.showMessageDialog(viewGC, "No se ha podido registrar el gasto.");
                    }

                }

            }

        } else {

            if (casillasvacias() == true) {
                if (validarp() == true) {
                    int id = Integer.parseInt(viewGC.getTxtcodG().getText());
                    String descr = viewGC.getTxtdescripG().getText();
                    Date fecha = fechaActual;
                    double precio = Double.parseDouble(viewGC.getTxtprecioG().getText());
                    try {
                        FileInputStream img = new FileInputStream(jfc.getSelectedFile());
                        int largo = (int) jfc.getSelectedFile().length();
                        modeGC.setImageFile(img);
                        modeGC.setLength(largo);

                        colorAux2 = viewGC.getLbFotoG().getBackground().hashCode() + 2;
                    } catch (IOException ex) {
                        Logger.getLogger(ControlGastoC.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (NullPointerException e) {
                        colorAux2 = viewGC.getLbFotoG().getBackground().hashCode();
                    }

                    modeGC.setFct_ID(id);
                    modeGC.setFctG_descripccion(descr);
                    modeGC.setFct_fecha(fecha);
                    modeGC.setFct_precio(precio);
                    modeGC.setFctG_estado("ACTIVO");

                    if (modeGC.updateGastoC()) {
                        JOptionPane.showMessageDialog(viewGC, "Gasto actualizado exitosamente");
                        vaciasCampos();
                        cargardatos();
                        viewGC.getJdGastos().setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(viewGC, "No se ha modificado el gasto.");
                    }

                }

            }

        }
    }

    private void vaciasCampos() {
        viewGC.getTxtdescripG().setText("");
        viewGC.getTxtprecioG().setText("");
        viewGC.getLbFotoG().setIcon(null);
    }

    private void examinaFoto() {        
        String ruta;
        File imgR;
        FileNameExtensionFilter filter = new FileNameExtensionFilter("jpg, png & jpeg", "jpeg", "png", "jpg");

        jfc = new JFileChooser();
        jfc.setFileFilter(filter);
        int estado = jfc.showOpenDialog(viewGC);

        if (estado == JFileChooser.APPROVE_OPTION) {

            try {
                Image imagen = ImageIO.read(jfc.getSelectedFile()).getScaledInstance(
                        viewGC.getLbFotoG().getWidth(),
                        viewGC.getLbFotoG().getHeight(),
                        Image.SCALE_DEFAULT);

                Icon icono = new ImageIcon(imagen);

                viewGC.getLbFotoG().setIcon(icono);
                viewGC.getLbFotoG().updateUI();
                viewGC.getJdGastos().setVisible(true);

            } catch (IOException ex) {
                Logger.getLogger(ControlGastoC.class.getName()).log(Level.SEVERE, null, ex);

            }

        }
    }

    public void eliminarGasto() {
        try {
            int fila = viewGC.getTbGastos().getSelectedRow();

            if (fila >= 0) {
                int id = Integer.parseInt(viewGC.getTbGastos().getValueAt(fila, 0).toString());

                modeGC.setFct_ID(id);

                if (viewGC.getTbGastos().getRowSelectionAllowed()) {

                    int a = JOptionPane.showConfirmDialog(null, "Deseas eliminar " + viewGC.getTxtPronombre().getText().toString());
                    if (a == 0) {
                        modeGC.deleteGastoC();
                        JOptionPane.showMessageDialog(viewGC, "Se eliminado " + viewGC.getTxtPronombre().getText().toString());
                        cargardatos();
                    }
                }

            } else {
                JOptionPane.showMessageDialog(null, "Fila no seleccionada");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString());
        }
    }

    public boolean validarp() {

        boolean validado = true;

        if (!validar.validarprecio(viewGC.getTxtprecioG().getText())) {
            JOptionPane.showMessageDialog(viewGC, "Asegurese de que el precion sea un numero y use el punto para decimales .  Por Favor");
            validado = false;
            //  vistaPro.getLbopcionobligatoriaprecio().setText("*");

        }

        return validado;

    }

    public boolean casillasvacias() {

        int c = 0;
        boolean validado = true;

        if (viewGC.getTxtdescripG().getText().isEmpty()) {
            validado = false;
            c += 1;
            viewGC.getLboodesgasto().setText("*");

        } else {

            viewGC.getLboodesgasto().setText("");

        }

        if (viewGC.getTxtprecioG().getText().isEmpty()) {
            validado = false;
            c += 1;
            viewGC.getLboopreciogasto().setText("*");
        } else {
            viewGC.getLboopreciogasto().setText("");
        }

        if (c > 0) {
            JOptionPane.showMessageDialog(viewGC, " *  Campos Obligatorios");
        }

        return validado;
    }

    private void totalesregisGastos() {

        viewGC.getLbtotalGastos().setText(String.valueOf(viewGC.getTbGastos().getRowCount()));
    }
    
    private boolean llenarGastoE() {
        modelo.MConexion.ModelGastoCorriente gasto = new ModelGastoCorriente();
        int fila = viewGC.getTbGastos().getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione la persona a modificar");
            return false;
        } else {

            String id = viewGC.getTbGastos().getValueAt(fila, 0).toString();
            List<FacturaGastoCorriente> listap = modeGC.getGastoC();
            listap.stream().forEach(up -> {
                if (id.equalsIgnoreCase(String.valueOf(up.getFct_ID()))) {
                    viewGC.getTxtcodG().setText(String.valueOf(up.getFct_ID()));
                    viewGC.getTxtdescripG().setText(String.valueOf(up.getFctG_descripccion()));
                    viewGC.getDtFecha().setDate(up.getFct_fecha());
                    viewGC.getTxtprecioG().setText(String.valueOf(up.getFct_precio()));
                    Image foto = up.getFotoFactura();
                    if (foto != null) {
                        foto = foto.getScaledInstance(100, 150, Image.SCALE_SMOOTH);
                        ImageIcon icono = new ImageIcon(foto);
                        DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
                        dtcr.setIcon(icono);
                        viewGC.getLbFotoG().setIcon(icono);
                    } else {
                        viewGC.getLbFotoG().setIcon(null);
                    }

                }

            });
            return true;
        }
    }
}
