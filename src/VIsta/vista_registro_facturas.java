/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIsta;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author carlos
 */
public class vista_registro_facturas extends javax.swing.JInternalFrame {

    /**
     * Creates new form vista_registro_facturas
     */
    public vista_registro_facturas() {
        initComponents();
    }

    public JButton getBtn_regresar_factura_regis() {
        return btn_regresar_factura_regis;
    }

    public void setBtn_regresar_factura_regis(JButton btn_regresar_factura_regis) {
        this.btn_regresar_factura_regis = btn_regresar_factura_regis;
    }

    public JTable getTabla_factura_registro() {
        return tabla_factura_registro;
    }

    public void setTabla_factura_registro(JTable tabla_factura_registro) {
        this.tabla_factura_registro = tabla_factura_registro;
    }

    public JTextField getTxt_total_factu_registro() {
        return txt_total_factu_registro;
    }

    public void setTxt_total_factu_registro(JTextField txt_total_factu_registro) {
        this.txt_total_factu_registro = txt_total_factu_registro;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_factura_registro = new javax.swing.JTable();
        btn_regresar_factura_regis = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txt_total_factu_registro = new javax.swing.JTextField();

        jLabel1.setText("Registro de facturas");

        tabla_factura_registro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "FACTURA ID", "CLIENTE ID", "NOMBRES", "CEDULA", "FECHA", "TOTAL FACTURA"
            }
        ));
        jScrollPane1.setViewportView(tabla_factura_registro);

        btn_regresar_factura_regis.setText("Regresar");

        jLabel2.setText("Total ventas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(342, 342, 342)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 724, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(btn_regresar_factura_regis)))
                .addContainerGap(109, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(30, 30, 30)
                .addComponent(txt_total_factu_registro, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel1)
                .addGap(44, 44, 44)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_total_factu_registro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(btn_regresar_factura_regis)
                .addGap(54, 54, 54))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_regresar_factura_regis;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla_factura_registro;
    private javax.swing.JTextField txt_total_factu_registro;
    // End of variables declaration//GEN-END:variables
}