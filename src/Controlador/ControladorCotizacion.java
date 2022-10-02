/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import VIsta.vista_cotizacion;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.MConexion.modelo_cotizacion;
import modelo.Productos;

/**
 *
 * @author OWNER
 */
public class ControladorCotizacion {

    private modelo_cotizacion modelito_coti;
    private vista_cotizacion vista_coti;

    public ControladorCotizacion() {
    }

    public ControladorCotizacion(modelo_cotizacion modelito_coti, vista_cotizacion vista_coti) {
        this.modelito_coti = modelito_coti;
        this.vista_coti = vista_coti;
        vista_coti.setVisible(true);
    }

    public void iniciarcontrol() {
        cargartablaProducto();
        vista_coti.getBtb_buscar_producto().addActionListener(l -> abrirDialogoProducto());
        vista_coti.getBtn_aceptar_producto().addActionListener(l -> cargar_producto());
        vista_coti.getBtn_agregar_producto().addActionListener(l -> llenar_facturaprodu());
        vista_coti.getBtn_agregar_extra().addActionListener(l -> llenar_facturaextra());
        vista_coti.getBtn_quitar().addActionListener(l -> quitar_producto());

        vista_coti.getTxt_cantidad_producto().addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();
                if (vista_coti.getTxt_cantidad_producto().getText().length() == 10 || (caracter < '0') || (caracter > '9')) {
                    e.consume();
                }

            }

        });

        vista_coti.getTxt_nombre_extra().addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (vista_coti.getTxt_nombre_extra().getText().length() == 150 || ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z'))) {
                    e.consume();
                }

            }

        });
        vista_coti.getTxt_cantidad_extra().addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();
                if (vista_coti.getTxt_cantidad_extra().getText().length() == 10 || (caracter < '0') || (caracter > '9')) {
                    e.consume();
                }

            }

        });
    }

    public void cargartablaProducto() {
        DefaultTableModel tb = (DefaultTableModel) vista_coti.getTabla_productos().getModel();
        tb.setNumRows(0);
        List<Productos> com = modelito_coti.list_producto();
        com.stream().forEach(p -> {
            String[] cami = {String.valueOf(p.getPrd_ID()), p.getPrd_nombre(), String.valueOf(p.getPrd_precio())};
            tb.addRow(cami);
        });
    }

    public void cargar_producto() {
        int seleccion = vista_coti.getTabla_productos().getSelectedRow();

        if (seleccion == -1) {
            JOptionPane.showMessageDialog(null, "Aun no ha seleccionado una fila");
        } else {
            int codigo = Integer.parseInt(vista_coti.getTabla_productos().getValueAt(seleccion, 0).toString());
            modelito_coti.list_producto().forEach((p) -> {
                if (p.getPrd_ID() == codigo) {

                    vista_coti.getTxt_nombre_producto().setText(String.valueOf(p.getPrd_nombre()));

                    vista_coti.getTxt_precio_uni_producto().setText(String.valueOf(p.getPrd_precio()));
                    vista_coti.getDialog_buscar_producto().dispose();
                }
            });
        }
    }

    private void abrirDialogoProducto() {

        vista_coti.getDialog_buscar_producto().setVisible(true);
        vista_coti.getDialog_buscar_producto().setSize(650, 500);
        vista_coti.getDialog_buscar_producto().setLocationRelativeTo(vista_coti);

    }

    private void llenar_facturaprodu() {

        if (validarcasillas() == true) {
            double suma_total = 0;
            DefaultTableModel estructuratabla;
            estructuratabla = (DefaultTableModel) vista_coti.getTabla_cotizacion().getModel();

            int cantidad = Integer.parseInt(vista_coti.getTxt_cantidad_producto().getText());
            double precio_unit = Double.parseDouble(vista_coti.getTxt_precio_uni_producto().getText());
            double sub_to = cantidad * precio_unit;

            String nomb_prod = vista_coti.getTxt_nombre_producto().getText();
            String pre_uni = vista_coti.getTxt_precio_uni_producto().getText();
            String can = vista_coti.getTxt_cantidad_producto().getText();
            String sub_tota = String.valueOf(sub_to);

            Object[] lista = new Object[4];
            lista[0] = nomb_prod;
            lista[1] = pre_uni;
            lista[2] = can;
            lista[3] = sub_tota;
            estructuratabla.addRow(lista);
            actualizar_totales();
            limpiar_datos();

        }

    }

    private void llenar_facturaextra() {
        double suma_total = 0;
        DefaultTableModel estructuratabla;
        estructuratabla = (DefaultTableModel) vista_coti.getTabla_cotizacion().getModel();
        int cantidad = Integer.parseInt(vista_coti.getTxt_cantidad_extra().getText());
        double precio_unit = Double.parseDouble(vista_coti.getTxt_precio_uni_extra().getText());
        double sub_to = cantidad * precio_unit;

        String nomb_prod = vista_coti.getTxt_nombre_extra().getText();
        String pre_uni = vista_coti.getTxt_precio_uni_extra().getText();
        String can = vista_coti.getTxt_cantidad_extra().getText();
        String sub_tota = String.valueOf(sub_to);

        Object[] lista = new Object[4];
        lista[0] = nomb_prod;
        lista[1] = pre_uni;
        lista[2] = can;
        lista[3] = sub_tota;
        estructuratabla.addRow(lista);
        actualizar_totales();
        limpiar_datos();
    }

    private void actualizar_totales() {

        vista_coti.getTxt_subtotal().setText("0");

        int ta = vista_coti.getTabla_cotizacion().getRowCount();
        int c = 0;
        do {
            try {
                int f = c++;
                Double n1 = Double.parseDouble(vista_coti.getTabla_cotizacion().getValueAt(f, 3).toString());
                String nu = vista_coti.getTxt_subtotal().getText();
                double nu2 = Double.parseDouble(nu);
                double re = (n1 + nu2);
                vista_coti.getTxt_subtotal().setText(String.valueOf(re));
//                double sub=Double.parseDouble(vista_coti.getTxt_subtotal().getText());
//                int iva=Integer.parseInt(vista_coti.getTxt_iva().getText());
//                double gasto_total=sub+(sub*iva);
//                vista_coti.getTxt_total().setText(String.valueOf(gasto_total));
//                

            } catch (Exception e) {

            }

        } while (c < ta);

    }

    public void quitar_producto() {
        DefaultTableModel estructuratabla;
        estructuratabla = (DefaultTableModel) vista_coti.getTabla_cotizacion().getModel();
        int fila = vista_coti.getTabla_cotizacion().getSelectedRow();
        if (fila >= 0) {
            estructuratabla.removeRow(vista_coti.getTabla_cotizacion().getSelectedRow());
            actualizar_totales();
        } else {
            JOptionPane.showMessageDialog(vista_coti, "Seleccione el producto que desea eliminar");
        }
    }

    public void limpiar_datos() {
        vista_coti.getTxt_nombre_producto().setText("");
        vista_coti.getTxt_precio_uni_producto().setText("");
        vista_coti.getTxt_cantidad_producto().setText("");
        vista_coti.getTxt_nombre_extra().setText("");
        vista_coti.getTxt_precio_uni_extra().setText("");
        vista_coti.getTxt_cantidad_extra().setText("");
    }

//    public boolean casillasvacias(){
//        
//        
//    
//    
//    }
    public boolean validarcasillas() {

        boolean validado = true;

        if (vista_coti.getTxt_nombre_producto().getText().isEmpty()) {
            validado = false;
            vista_coti.getLboonombreproduct().setText("Seleccione un Producto");

        } else {

            vista_coti.getLboonombreproduct().setText("");

        }

        if (vista_coti.getTxt_cantidad_producto().getText().isEmpty()) {
            validado = false;
            vista_coti.getLboocantidad().setText("Ingrese la cantidad");
        } else {

            vista_coti.getLboocantidad().setText("");

        }

        return validado;

    }
}
