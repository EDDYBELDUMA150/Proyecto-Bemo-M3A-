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
public class vistacliente extends javax.swing.JInternalFrame {

    /**
     * Creates new form vistacliente
     */
    public vistacliente() {
        initComponents();
    }

    public JButton getBtnagregar() {
        return btnagregar;
    }

    public JButton getBtneleminar() {
        return btneleminar;
    }

    public void setBtneleminar(JButton btneleminar) {
        this.btneleminar = btneleminar;
    }
    

    public JButton getBtnagregar1() {
        return btnagregar1;
    }

    public void setBtnagregar1(JButton btnagregar1) {
        this.btnagregar1 = btnagregar1;
    }

    public JTextField getTxtbuscarcliente() {
        return txtbuscarcliente;
    }

    public void setTxtbuscarcliente(JTextField txtbuscarcliente) {
        this.txtbuscarcliente = txtbuscarcliente;
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

    public JButton getBrnmodificar() {
        return brnmodificar;
    }

    public void setBrnmodificar(JButton brnmodificar) {
        this.brnmodificar = brnmodificar;
    }

    public JButton getBtncancelar() {
        return btncancelar;
    }

    public void setBtncancelar(JButton btncancelar) {
        this.btncancelar = btncancelar;
    }

    public JTextField getTxtidcliente() {
        return txtidcliente;
    }

    public void setTxtidcliente(JTextField txtidcliente) {
        this.txtidcliente = txtidcliente;
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

    public JTextField getTxtnombre() {
        return txtnombre;
    }

    public void setTxtnombre(JTextField txtnombre) {
        this.txtnombre = txtnombre;
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
    
    

    public void setBtnagregar(JButton btnagregar) {
        this.btnagregar = btnagregar;
    }

    public JDialog getDialogclientes() {
        return dialogclientes;
    }

    public void setDialogclientes(JDialog dialogclientes) {
        this.dialogclientes = dialogclientes;
    }

    public JTable getTablaclientes() {
        return tablaclientes;
    }

    public void setTablaclientes(JTable tablaclientes) {
        this.tablaclientes = tablaclientes;
    }

    public JButton getBtncargardatos() {
        return btncargardatos;
    }

    public void setBtncargardatos(JButton btncargardatos) {
        this.btncargardatos = btncargardatos;
    }

    public JButton getBtnlimpiar() {
        return btnlimpiar;
    }

    public void setBtnlimpiar(JButton btnlimpiar) {
        this.btnlimpiar = btnlimpiar;
    }

    public JLabel getLbodatoovligatorioapellido1() {
        return lbodatoovligatorioapellido1;
    }

    public void setLbodatoovligatorioapellido1(JLabel lbodatoovligatorioapellido1) {
        this.lbodatoovligatorioapellido1 = lbodatoovligatorioapellido1;
    }

    public JLabel getLbodatoovligatoriocedula() {
        return lbodatoovligatoriocedula;
    }

    public void setLbodatoovligatoriocedula(JLabel lbodatoovligatoriocedula) {
        this.lbodatoovligatoriocedula = lbodatoovligatoriocedula;
    }

    public JLabel getLbodatoovligatoriocelular() {
        return lbodatoovligatoriocelular;
    }

    public void setLbodatoovligatoriocelular(JLabel lbodatoovligatoriocelular) {
        this.lbodatoovligatoriocelular = lbodatoovligatoriocelular;
    }

    public JLabel getLbodatoovligatorionombre() {
        return lbodatoovligatorionombre;
    }

    public void setLbodatoovligatorionombre(JLabel lbodatoovligatorionombre) {
        this.lbodatoovligatorionombre = lbodatoovligatorionombre;
    }
    
    
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialogclientes = new javax.swing.JDialog();
        txtnombre = new javax.swing.JTextField();
        txtsegundonombre = new javax.swing.JTextField();
        txtapellido = new javax.swing.JTextField();
        txtsegundoapellido = new javax.swing.JTextField();
        txtcedula = new javax.swing.JTextField();
        txttelefono = new javax.swing.JTextField();
        txtdireccion = new javax.swing.JTextField();
        txtemail = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnagregar1 = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        btnlimpiar = new javax.swing.JButton();
        txtidcliente = new javax.swing.JTextField();
        lbtitulo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbodatoovligatoriocelular = new javax.swing.JLabel();
        lbodatoovligatoriocedula = new javax.swing.JLabel();
        lbodatoovligatorionombre = new javax.swing.JLabel();
        lbodatoovligatorioapellido1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaclientes = new javax.swing.JTable();
        btnagregar = new javax.swing.JButton();
        brnmodificar = new javax.swing.JButton();
        btneleminar = new javax.swing.JButton();
        btncargardatos = new javax.swing.JButton();
        txtbuscarcliente = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        dialogclientes.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtnombre.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        dialogclientes.getContentPane().add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 149, 250, 34));

        txtsegundonombre.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        dialogclientes.getContentPane().add(txtsegundonombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(437, 149, 250, 34));

        txtapellido.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        dialogclientes.getContentPane().add(txtapellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 220, 250, 34));

        txtsegundoapellido.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        dialogclientes.getContentPane().add(txtsegundoapellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(437, 220, 250, 34));

        txtcedula.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        dialogclientes.getContentPane().add(txtcedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 322, 250, 34));

        txttelefono.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        dialogclientes.getContentPane().add(txttelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(437, 322, 250, 34));

        txtdireccion.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        dialogclientes.getContentPane().add(txtdireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 414, 654, 34));

        txtemail.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        dialogclientes.getContentPane().add(txtemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 492, 356, 34));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("Nombre:");
        dialogclientes.getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 124, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setText("Segundo nombre:");
        dialogclientes.getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(437, 124, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setText("Apellido:");
        dialogclientes.getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 195, -1, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel5.setText("Segundo apellido:");
        dialogclientes.getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(437, 195, -1, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel6.setText("Cedula/RUC/RISE:");
        dialogclientes.getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 297, -1, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel7.setText(" Celular :");
        dialogclientes.getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(437, 297, -1, -1));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel8.setText("Dirección:");
        dialogclientes.getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 389, -1, -1));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel9.setText("Email:");
        dialogclientes.getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 467, -1, -1));

        btnagregar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconoseImagenes/add_40px.png"))); // NOI18N
        btnagregar1.setText("Agregar");
        dialogclientes.getContentPane().add(btnagregar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 560, 170, 65));

        btncancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconoseImagenes/cancel_40px.png"))); // NOI18N
        btncancelar.setText("Cancelar");
        dialogclientes.getContentPane().add(btncancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(495, 560, 160, 60));

        btnlimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconoseImagenes/broom_40px.png"))); // NOI18N
        btnlimpiar.setText("Limpiar Campos");
        dialogclientes.getContentPane().add(btnlimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 560, 200, 60));

        txtidcliente.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        txtidcliente.setText("jTextField2");
        dialogclientes.getContentPane().add(txtidcliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 69, 50, 50));

        lbtitulo.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbtitulo.setText("jLabel2");
        dialogclientes.getContentPane().add(lbtitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 250, 60));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setText("ID ;");
        dialogclientes.getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, 30, 30));

        lbodatoovligatoriocelular.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lbodatoovligatoriocelular.setForeground(new java.awt.Color(204, 0, 0));
        dialogclientes.getContentPane().add(lbodatoovligatoriocelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 300, 40, 20));

        lbodatoovligatoriocedula.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lbodatoovligatoriocedula.setForeground(new java.awt.Color(204, 0, 0));
        dialogclientes.getContentPane().add(lbodatoovligatoriocedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 330, 40, 20));

        lbodatoovligatorionombre.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lbodatoovligatorionombre.setForeground(new java.awt.Color(204, 0, 0));
        dialogclientes.getContentPane().add(lbodatoovligatorionombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 150, 40, 20));

        lbodatoovligatorioapellido1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lbodatoovligatorioapellido1.setForeground(new java.awt.Color(204, 0, 0));
        dialogclientes.getContentPane().add(lbodatoovligatorioapellido1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 230, 40, 20));

        setClosable(true);
        setPreferredSize(new java.awt.Dimension(1660, 800));

        tablaclientes.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        tablaclientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Cedula", "Primer Nombre ", "Segundo Nombre", "Primer Apellido", "Segundo Apelido", "Direccion", "Telefono", "email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaclientes.setPreferredSize(new java.awt.Dimension(750, 790));
        jScrollPane1.setViewportView(tablaclientes);

        btnagregar.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        btnagregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconoseImagenes/add_user_group_man_man_40px.png"))); // NOI18N
        btnagregar.setText("Nuevo Cliente");

        brnmodificar.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        brnmodificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconoseImagenes/update_user_40px.png"))); // NOI18N
        brnmodificar.setText("Actualizar Cliente");

        btneleminar.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        btneleminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconoseImagenes/delete_user_male_40px.png"))); // NOI18N
        btneleminar.setText("Eliminar Cliente ");
        btneleminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneleminarActionPerformed(evt);
            }
        });

        btncargardatos.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        btncargardatos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconoseImagenes/restart_40px.png"))); // NOI18N
        btncargardatos.setText("Actualizar Tabla.");

        txtbuscarcliente.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        jLabel10.setText("Clientes");

        jLabel11.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconoseImagenes/search_40px.png"))); // NOI18N
        jLabel11.setText("Buscar :");

        jLabel12.setText("Buscar por : Cedula , Nombres , Apellidos o Direccion .");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btncargardatos)
                .addGap(44, 44, 44))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(680, 680, 680))
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtbuscarcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(btnagregar)
                        .addGap(56, 56, 56)
                        .addComponent(brnmodificar)
                        .addGap(37, 37, 37)
                        .addComponent(btneleminar)))
                .addContainerGap(113, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btneleminar)
                    .addComponent(btnagregar)
                    .addComponent(txtbuscarcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(brnmodificar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btncargardatos)
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btneleminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneleminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btneleminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton brnmodificar;
    private javax.swing.JButton btnagregar;
    private javax.swing.JButton btnagregar1;
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btncargardatos;
    private javax.swing.JButton btneleminar;
    private javax.swing.JButton btnlimpiar;
    private javax.swing.JDialog dialogclientes;
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
    private javax.swing.JLabel lbodatoovligatorioapellido1;
    private javax.swing.JLabel lbodatoovligatoriocedula;
    private javax.swing.JLabel lbodatoovligatoriocelular;
    private javax.swing.JLabel lbodatoovligatorionombre;
    private javax.swing.JLabel lbtitulo;
    private javax.swing.JTable tablaclientes;
    private javax.swing.JTextField txtapellido;
    private javax.swing.JTextField txtbuscarcliente;
    private javax.swing.JTextField txtcedula;
    private javax.swing.JTextField txtdireccion;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtidcliente;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtsegundoapellido;
    private javax.swing.JTextField txtsegundonombre;
    private javax.swing.JTextField txttelefono;
    // End of variables declaration//GEN-END:variables
}
