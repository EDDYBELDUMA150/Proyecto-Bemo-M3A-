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
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaclientes = new javax.swing.JTable();
        btnagregar = new javax.swing.JButton();
        brnmodificar = new javax.swing.JButton();
        btneleminar = new javax.swing.JButton();
        btncargardatos = new javax.swing.JButton();
        txtbuscarcliente = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        dialogclientes.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        dialogclientes.getContentPane().add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 149, 250, 34));
        dialogclientes.getContentPane().add(txtsegundonombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(437, 149, 250, 34));
        dialogclientes.getContentPane().add(txtapellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 220, 250, 34));
        dialogclientes.getContentPane().add(txtsegundoapellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(437, 220, 250, 34));
        dialogclientes.getContentPane().add(txtcedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 322, 250, 34));
        dialogclientes.getContentPane().add(txttelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(437, 322, 250, 34));
        dialogclientes.getContentPane().add(txtdireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 414, 654, 34));
        dialogclientes.getContentPane().add(txtemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 492, 356, 34));

        jLabel1.setFont(new java.awt.Font("STXihei", 0, 14)); // NOI18N
        jLabel1.setText("Nombre:");
        dialogclientes.getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 124, -1, -1));

        jLabel3.setFont(new java.awt.Font("STXihei", 0, 14)); // NOI18N
        jLabel3.setText("Segundo nombre:");
        dialogclientes.getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(437, 124, -1, -1));

        jLabel4.setFont(new java.awt.Font("STXihei", 0, 14)); // NOI18N
        jLabel4.setText("Apellido:");
        dialogclientes.getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 195, -1, -1));

        jLabel5.setFont(new java.awt.Font("STXihei", 0, 14)); // NOI18N
        jLabel5.setText("Segundo apellido:");
        dialogclientes.getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(437, 195, -1, -1));

        jLabel6.setFont(new java.awt.Font("STXihei", 0, 14)); // NOI18N
        jLabel6.setText("Cedula/RUC/RISE:");
        dialogclientes.getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 297, -1, -1));

        jLabel7.setFont(new java.awt.Font("STXihei", 0, 14)); // NOI18N
        jLabel7.setText("Teléfono:");
        dialogclientes.getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(437, 297, -1, -1));

        jLabel8.setFont(new java.awt.Font("STXihei", 0, 14)); // NOI18N
        jLabel8.setText("Dirección:");
        dialogclientes.getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 389, -1, -1));

        jLabel9.setFont(new java.awt.Font("STXihei", 0, 14)); // NOI18N
        jLabel9.setText("Email:");
        dialogclientes.getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 467, -1, -1));

        btnagregar1.setText("Agregar");
        dialogclientes.getContentPane().add(btnagregar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 560, 125, 65));

        btncancelar.setText("Cancelar");
        dialogclientes.getContentPane().add(btncancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 560, 125, 65));

        btnlimpiar.setText("Limpiar Campos");
        dialogclientes.getContentPane().add(btnlimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 560, 125, 65));

        txtidcliente.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtidcliente.setText("jTextField2");
        dialogclientes.getContentPane().add(txtidcliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, -1, -1));

        lbtitulo.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbtitulo.setText("jLabel2");
        dialogclientes.getContentPane().add(lbtitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, 250, 60));

        jLabel2.setText("ID ;");
        dialogclientes.getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(218, 90, 30, 30));

        setClosable(true);
        setPreferredSize(new java.awt.Dimension(1210, 720));

        tablaclientes.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        tablaclientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "id clientes", "id perona", "cedula", "nombre 1", "nombre2", "apellido", "apelido2", "direccion", "Telefono", "email"
            }
        ));
        jScrollPane1.setViewportView(tablaclientes);

        btnagregar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnagregar.setText("agregar");

        brnmodificar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        brnmodificar.setText("editar");

        btneleminar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btneleminar.setText("Eliminar");

        btncargardatos.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btncargardatos.setText("Actualizar Tabla.");

        txtbuscarcliente.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel10.setText("Clientes");

        jLabel11.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel11.setText("Buscar :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btncargardatos)
                .addGap(44, 44, 44))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel11)
                        .addGap(39, 39, 39)
                        .addComponent(txtbuscarcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(btnagregar)
                        .addGap(41, 41, 41)
                        .addComponent(brnmodificar)
                        .addGap(49, 49, 49)
                        .addComponent(btneleminar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(421, 421, 421)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 951, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel11))
                    .addComponent(txtbuscarcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnagregar)
                    .addComponent(brnmodificar)
                    .addComponent(btneleminar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btncargardatos)
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
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
