/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIsta;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Abel Gomez
 */
public class VistaProveedor extends javax.swing.JInternalFrame {

    /**
     * Creates new form VistaProveedor
     */
    public VistaProveedor() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jdialogproveedor = new javax.swing.JDialog();
        lbtitulo = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        txtsegundonombre = new javax.swing.JTextField();
        txtapellido = new javax.swing.JTextField();
        txtsegundoapellido = new javax.swing.JTextField();
        txtcedula = new javax.swing.JTextField();
        txttelefono = new javax.swing.JTextField();
        txtdireccion = new javax.swing.JTextField();
        txtemail = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnagregar1 = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        btnlimpiar = new javax.swing.JButton();
        txtidproveedor = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtnombreempresa = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaproveedores = new javax.swing.JTable();
        txtbuscarproveedor = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnagregar = new javax.swing.JButton();
        btnmodificar = new javax.swing.JButton();
        btneleminar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnactualzartabla = new javax.swing.JButton();

        jdialogproveedor.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbtitulo.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lbtitulo.setText("jLabel3");
        jdialogproveedor.getContentPane().add(lbtitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 0, 270, 47));

        txtnombre.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jdialogproveedor.getContentPane().add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 149, 250, 34));

        txtsegundonombre.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jdialogproveedor.getContentPane().add(txtsegundonombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(437, 149, 250, 34));

        txtapellido.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jdialogproveedor.getContentPane().add(txtapellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 220, 250, 34));

        txtsegundoapellido.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jdialogproveedor.getContentPane().add(txtsegundoapellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(437, 220, 250, 34));

        txtcedula.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jdialogproveedor.getContentPane().add(txtcedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 322, 250, 34));

        txttelefono.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jdialogproveedor.getContentPane().add(txttelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(437, 322, 250, 34));

        txtdireccion.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jdialogproveedor.getContentPane().add(txtdireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 414, 654, 34));

        txtemail.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jdialogproveedor.getContentPane().add(txtemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 492, 356, 34));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setText("Nombre:");
        jdialogproveedor.getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 124, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setText("Segundo nombre:");
        jdialogproveedor.getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(437, 124, -1, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel5.setText("Apellido:");
        jdialogproveedor.getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 195, -1, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel6.setText("Segundo apellido:");
        jdialogproveedor.getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(437, 195, -1, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel7.setText("Cedula/RUC/RISE:");
        jdialogproveedor.getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 297, -1, -1));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel8.setText("Celular");
        jdialogproveedor.getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(437, 297, -1, -1));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel9.setText("Dirección:");
        jdialogproveedor.getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 389, -1, -1));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel10.setText("Email:");
        jdialogproveedor.getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 467, -1, -1));

        btnagregar1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnagregar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconoseImagenes/add_40px.png"))); // NOI18N
        btnagregar1.setText("Agregar");
        jdialogproveedor.getContentPane().add(btnagregar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 680, 160, 65));

        btncancelar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btncancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconoseImagenes/cancel_40px.png"))); // NOI18N
        btncancelar.setText("Cancelar");
        jdialogproveedor.getContentPane().add(btncancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(615, 680, 180, 65));

        btnlimpiar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnlimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconoseImagenes/broom_40px.png"))); // NOI18N
        btnlimpiar.setText("Limpiar Campos");
        jdialogproveedor.getContentPane().add(btnlimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 680, 220, 65));

        txtidproveedor.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jdialogproveedor.getContentPane().add(txtidproveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 60, 50, 50));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel11.setText("ID :");
        jdialogproveedor.getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, 30, 30));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel12.setText("Nombre de Empresa ");
        jdialogproveedor.getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 570, -1, -1));

        txtnombreempresa.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtnombreempresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombreempresaActionPerformed(evt);
            }
        });
        jdialogproveedor.getContentPane().add(txtnombreempresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 610, 643, 40));

        setClosable(true);
        setMaximumSize(new java.awt.Dimension(1680, 840));
        setPreferredSize(new java.awt.Dimension(1660, 800));

        tablaproveedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Proveedor", "Cedula", "Primer Nombre", "Sungundo Nombre", "Primer Apellido", "Segundo Apellido", "Direccion", "Telefono", "Email", "Nombre Empresa"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaproveedores.setPreferredSize(new java.awt.Dimension(750, 790));
        jScrollPane1.setViewportView(tablaproveedores);

        txtbuscarproveedor.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconoseImagenes/search_40px.png"))); // NOI18N
        jLabel1.setText("Buscar : ");

        btnagregar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnagregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconoseImagenes/add_user_group_man_man_40px.png"))); // NOI18N
        btnagregar.setText("Nuevo Proveedor");

        btnmodificar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnmodificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconoseImagenes/update_user_40px.png"))); // NOI18N
        btnmodificar.setText("Actualizar Proveedor");

        btneleminar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btneleminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconoseImagenes/delete_user_male_40px.png"))); // NOI18N
        btneleminar.setText("Eliminar Proveedor");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        jLabel2.setText("Proveedores");

        btnactualzartabla.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnactualzartabla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconoseImagenes/restart_40px.png"))); // NOI18N
        btnactualzartabla.setText("Actualizar Tabla");
        btnactualzartabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactualzartablaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel1)
                        .addGap(34, 34, 34)
                        .addComponent(txtbuscarproveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 524, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(btnagregar)
                        .addGap(43, 43, 43)
                        .addComponent(btnmodificar)
                        .addGap(32, 32, 32)
                        .addComponent(btneleminar)
                        .addGap(0, 109, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(410, 410, 410)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnactualzartabla, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(122, 122, 122))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtbuscarproveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnmodificar)
                    .addComponent(btneleminar)
                    .addComponent(btnagregar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnactualzartabla)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtnombreempresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombreempresaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombreempresaActionPerformed

    private void btnactualzartablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactualzartablaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnactualzartablaActionPerformed

    public JButton getBtnagregar() {
        return btnagregar;
    }

    public void setBtnagregar(JButton btnagregar) {
        this.btnagregar = btnagregar;
    }

    public JButton getBtnagregar1() {
        return btnagregar1;
    }

    public void setBtnagregar1(JButton btnagregar1) {
        this.btnagregar1 = btnagregar1;
    }

    public JButton getBtncancelar() {
        return btncancelar;
    }

    public void setBtncancelar(JButton btncancelar) {
        this.btncancelar = btncancelar;
    }

    public JButton getBtneleminar() {
        return btneleminar;
    }

    public void setBtneleminar(JButton btneleminar) {
        this.btneleminar = btneleminar;
    }

    public JButton getBtnlimpiar() {
        return btnlimpiar;
    }

    public void setBtnlimpiar(JButton btnlimpiar) {
        this.btnlimpiar = btnlimpiar;
    }

    public JButton getBtnmodificar() {
        return btnmodificar;
    }

    public void setBtnmodificar(JButton btnmodificar) {
        this.btnmodificar = btnmodificar;
    }

    public JButton getBtnactualzartabla() {
        return btnactualzartabla;
    }

    public void setBtnactualzartabla(JButton btnactualzartabla) {
        this.btnactualzartabla = btnactualzartabla;
    }

    public JTable getTablaproveedores() {
        return tablaproveedores;
    }

    public void setTablaproveedores(JTable tablaproveedores) {
        this.tablaproveedores = tablaproveedores;
    }

    public JTextField getTxtbuscarproveedor() {
        return txtbuscarproveedor;
    }

    public void setTxtbuscarproveedor(JTextField txtbuscarproveedor) {
        this.txtbuscarproveedor = txtbuscarproveedor;
    }
    

    public JDialog getJdialogproveedor() {
        return jdialogproveedor;
    }

    public void setJdialogproveedor(JDialog jdialogproveedor) {
        this.jdialogproveedor = jdialogproveedor;
    }

    public JLabel getLbtitulo() {
        return lbtitulo;
    }

    public void setLbtitulo(JLabel lbtitulo) {
        this.lbtitulo = lbtitulo;
    }

    public JTextField getTxtapellido() {
        return txtapellido;
    }

    public void setTxtapellido(JTextField txtapellido) {
        this.txtapellido = txtapellido;
    }

    public JTextField getTxtcedula() {
        return txtcedula;
    }

    public void setTxtcedula(JTextField txtcedula) {
        this.txtcedula = txtcedula;
    }

    public JTextField getTxtdireccion() {
        return txtdireccion;
    }

    public void setTxtdireccion(JTextField txtdireccion) {
        this.txtdireccion = txtdireccion;
    }

    public JTextField getTxtemail() {
        return txtemail;
    }

    public void setTxtemail(JTextField txtemail) {
        this.txtemail = txtemail;
    }

    public JTextField getTxtidproveedor() {
        return txtidproveedor;
    }

    public void setTxtidproveedor(JTextField txtidproveedor) {
        this.txtidproveedor = txtidproveedor;
    }

    public JTextField getTxtnombre() {
        return txtnombre;
    }

    public void setTxtnombre(JTextField txtnombre) {
        this.txtnombre = txtnombre;
    }

    public JTextField getTxtnombreempresa() {
        return txtnombreempresa;
    }

    public void setTxtnombreempresa(JTextField txtnombreempresa) {
        this.txtnombreempresa = txtnombreempresa;
    }

    public JTextField getTxtsegundoapellido() {
        return txtsegundoapellido;
    }

    public void setTxtsegundoapellido(JTextField txtsegundoapellido) {
        this.txtsegundoapellido = txtsegundoapellido;
    }

    public JTextField getTxtsegundonombre() {
        return txtsegundonombre;
    }

    public void setTxtsegundonombre(JTextField txtsegundonombre) {
        this.txtsegundonombre = txtsegundonombre;
    }

    public JTextField getTxttelefono() {
        return txttelefono;
    }

    public void setTxttelefono(JTextField txttelefono) {
        this.txttelefono = txttelefono;
    }

    
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnactualzartabla;
    private javax.swing.JButton btnagregar;
    private javax.swing.JButton btnagregar1;
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btneleminar;
    private javax.swing.JButton btnlimpiar;
    private javax.swing.JButton btnmodificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JDialog jdialogproveedor;
    private javax.swing.JLabel lbtitulo;
    private javax.swing.JTable tablaproveedores;
    private javax.swing.JTextField txtapellido;
    private javax.swing.JTextField txtbuscarproveedor;
    private javax.swing.JTextField txtcedula;
    private javax.swing.JTextField txtdireccion;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtidproveedor;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtnombreempresa;
    private javax.swing.JTextField txtsegundoapellido;
    private javax.swing.JTextField txtsegundonombre;
    private javax.swing.JTextField txttelefono;
    // End of variables declaration//GEN-END:variables
}
