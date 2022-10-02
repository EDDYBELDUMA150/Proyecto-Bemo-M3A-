/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIsta;

import com.toedter.calendar.JDateChooser;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author carlos
 */
public class vista_factura extends javax.swing.JInternalFrame {

    /**
     * Creates new form vista_factura
     */
    public vista_factura() {
        initComponents();
    }

    public JButton getBtb_cargar_cliente() {
        return btb_cargar_cliente;
    }

    public void setBtb_cargar_cliente(JButton btb_cargar_cliente) {
        this.btb_cargar_cliente = btb_cargar_cliente;
    }

    public JButton getBtn_imprimir() {
        return btn_imprimir;
    }

    public void setBtn_imprimir(JButton btn_imprimir) {
        this.btn_imprimir = btn_imprimir;
    }



    public JTextField getTxt_id_cliente() {
        return txt_id_cliente;
    }

    public void setTxt_id_cliente(JTextField txt_id_cliente) {
        this.txt_id_cliente = txt_id_cliente;
    }

    public JButton getBtn_abrir_dialog_cliente() {
        return btn_abrir_dialog_cliente;
    }

    public void setBtn_abrir_dialog_cliente(JButton btn_abrir_dialog_cliente) {
        this.btn_abrir_dialog_cliente = btn_abrir_dialog_cliente;
    }

    public JButton getBtn_abrir_dialog_producto() {
        return btn_abrir_dialog_producto;
    }

    public void setBtn_abrir_dialog_producto(JButton btn_abrir_dialog_producto) {
        this.btn_abrir_dialog_producto = btn_abrir_dialog_producto;
    }

 

    public JButton getBtn_aceptar_producto() {
        return btn_aceptar_producto;
    }

    public void setBtn_aceptar_producto(JButton btn_aceptar_producto) {
        this.btn_aceptar_producto = btn_aceptar_producto;
    }

    public JButton getBtn_agregar_producto() {
        return btn_agregar_producto;
    }

    public void setBtn_agregar_producto(JButton btn_agregar_producto) {
        this.btn_agregar_producto = btn_agregar_producto;
    }

    public JButton getBtn_cancelar() {
        return btn_cancelar;
    }

    public void setBtn_cancelar(JButton btn_cancelar) {
        this.btn_cancelar = btn_cancelar;
    }

    public JButton getBtn_cancelar_cliente() {
        return btn_cancelar_cliente;
    }

    public void setBtn_cancelar_cliente(JButton btn_cancelar_cliente) {
        this.btn_cancelar_cliente = btn_cancelar_cliente;
    }

    public JButton getBtn_guardar_factura() {
        return btn_guardar_factura;
    }

    public void setBtn_guardar_factura(JButton btn_guardar_factura) {
        this.btn_guardar_factura = btn_guardar_factura;
    }

    public JButton getBtn_quitar_producto() {
        return btn_quitar_producto;
    }

    public void setBtn_quitar_producto(JButton btn_quitar_producto) {
        this.btn_quitar_producto = btn_quitar_producto;
    }

    public JDateChooser getDate_fecha() {
        return date_fecha;
    }

    public void setDate_fecha(JDateChooser date_fecha) {
        this.date_fecha = date_fecha;
    }

    public JDialog getDialog_buscar_cliente() {
        return dialog_buscar_cliente;
    }

    public void setDialog_buscar_cliente(JDialog dialog_buscar_cliente) {
        this.dialog_buscar_cliente = dialog_buscar_cliente;
    }

    public JDialog getDialog_buscar_producto() {
        return dialog_buscar_producto;
    }

    public void setDialog_buscar_producto(JDialog dialog_buscar_producto) {
        this.dialog_buscar_producto = dialog_buscar_producto;
    }

    public JTable getTabla_cliente_pedido() {
        return tabla_cliente_pedido;
    }

    public void setTabla_cliente_pedido(JTable tabla_cliente_pedido) {
        this.tabla_cliente_pedido = tabla_cliente_pedido;
    }

    public JTable getTabla_factura() {
        return tabla_factura;
    }

    public void setTabla_factura(JTable tabla_factura) {
        this.tabla_factura = tabla_factura;
    }

    public JTable getTabla_productos() {
        return tabla_productos;
    }

    public void setTabla_productos(JTable tabla_productos) {
        this.tabla_productos = tabla_productos;
    }

    public JTextField getTxt_buscar_cliente() {
        return txt_buscar_cliente;
    }

    public void setTxt_buscar_cliente(JTextField txt_buscar_cliente) {
        this.txt_buscar_cliente = txt_buscar_cliente;
    }

    public JTextField getTxt_buscar_producto() {
        return txt_buscar_producto;
    }

    public void setTxt_buscar_producto(JTextField txt_buscar_producto) {
        this.txt_buscar_producto = txt_buscar_producto;
    }

    public JTextField getTxt_cantidad() {
        return txt_cantidad;
    }

    public void setTxt_cantidad(JTextField txt_cantidad) {
        this.txt_cantidad = txt_cantidad;
    }

    public JTextField getTxt_cedula_cliente() {
        return txt_cedula_cliente;
    }

    public void setTxt_cedula_cliente(JTextField txt_cedula_cliente) {
        this.txt_cedula_cliente = txt_cedula_cliente;
    }

    public JTextField getTxt_codigo_producto() {
        return txt_codigo_producto;
    }

    public void setTxt_codigo_producto(JTextField txt_codigo_producto) {
        this.txt_codigo_producto = txt_codigo_producto;
    }

    public JTextField getTxt_direccion() {
        return txt_direccion;
    }

    public void setTxt_direccion(JTextField txt_direccion) {
        this.txt_direccion = txt_direccion;
    }

    public JTextField getTxt_id_factura() {
        return txt_id_factura;
    }

    public void setTxt_id_factura(JTextField txt_id_factura) {
        this.txt_id_factura = txt_id_factura;
    }

    public JTextField getTxt_iva() {
        return txt_iva;
    }

    public void setTxt_iva(JTextField txt_iva) {
        this.txt_iva = txt_iva;
    }

    public JTextField getTxt_nombre_cliente() {
        return txt_nombre_cliente;
    }

    public void setTxt_nombre_cliente(JTextField txt_nombre_cliente) {
        this.txt_nombre_cliente = txt_nombre_cliente;
    }

    public JTextField getTxt_nombre_producto() {
        return txt_nombre_producto;
    }

    public void setTxt_nombre_producto(JTextField txt_nombre_producto) {
        this.txt_nombre_producto = txt_nombre_producto;
    }

    public JTextField getTxt_precio_unitario() {
        return txt_precio_unitario;
    }

    public void setTxt_precio_unitario(JTextField txt_precio_unitario) {
        this.txt_precio_unitario = txt_precio_unitario;
    }

    public JTextField getTxt_subtotal() {
        return txt_subtotal;
    }

    public void setTxt_subtotal(JTextField txt_subtotal) {
        this.txt_subtotal = txt_subtotal;
    }

    public JTextField getTxt_total() {
        return txt_total;
    }

    public void setTxt_total(JTextField txt_total) {
        this.txt_total = txt_total;
    }

    public JLabel getLboocliente() {
        return lboocliente;
    }

    public void setLboocliente(JLabel lboocliente) {
        this.lboocliente = lboocliente;
    }

    public JLabel getLbooproducto() {
        return lbooproducto;
    }

    public void setLbooproducto(JLabel lbooproducto) {
        this.lbooproducto = lbooproducto;
    }

   
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialog_buscar_cliente = new javax.swing.JDialog();
        jLabel17 = new javax.swing.JLabel();
        txt_buscar_cliente = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabla_cliente_pedido = new javax.swing.JTable();
        btb_cargar_cliente = new javax.swing.JButton();
        btn_cancelar_cliente = new javax.swing.JButton();
        dialog_buscar_producto = new javax.swing.JDialog();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabla_productos = new javax.swing.JTable();
        btn_aceptar_producto = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        txt_buscar_producto = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_nombre_cliente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_cedula_cliente = new javax.swing.JTextField();
        btn_abrir_dialog_cliente = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txt_direccion = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txt_id_cliente = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        date_fecha = new com.toedter.calendar.JDateChooser();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        lboocliente = new javax.swing.JLabel();
        txt_id_factura = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txt_nombre_producto = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_precio_unitario = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_cantidad = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_codigo_producto = new javax.swing.JTextField();
        btn_agregar_producto = new javax.swing.JButton();
        btn_abrir_dialog_producto = new javax.swing.JButton();
        btn_quitar_producto = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_factura = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txt_subtotal = new javax.swing.JTextField();
        txt_iva = new javax.swing.JTextField();
        txt_total = new javax.swing.JTextField();
        btn_guardar_factura = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        btn_imprimir = new javax.swing.JButton();
        lbooproducto = new javax.swing.JLabel();

        jLabel17.setText("Lista Cliente");

        tabla_cliente_pedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Cliente id", "Cedula", "Nombre", "Apellido"
            }
        ));
        jScrollPane3.setViewportView(tabla_cliente_pedido);

        btb_cargar_cliente.setText("Cargar Datos");

        btn_cancelar_cliente.setText("Cancelar");

        javax.swing.GroupLayout dialog_buscar_clienteLayout = new javax.swing.GroupLayout(dialog_buscar_cliente.getContentPane());
        dialog_buscar_cliente.getContentPane().setLayout(dialog_buscar_clienteLayout);
        dialog_buscar_clienteLayout.setHorizontalGroup(
            dialog_buscar_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialog_buscar_clienteLayout.createSequentialGroup()
                .addGroup(dialog_buscar_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dialog_buscar_clienteLayout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addComponent(jLabel17))
                    .addGroup(dialog_buscar_clienteLayout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(txt_buscar_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(dialog_buscar_clienteLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(dialog_buscar_clienteLayout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(btb_cargar_cliente)
                        .addGap(37, 37, 37)
                        .addComponent(btn_cancelar_cliente)))
                .addContainerGap(222, Short.MAX_VALUE))
        );
        dialog_buscar_clienteLayout.setVerticalGroup(
            dialog_buscar_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialog_buscar_clienteLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel17)
                .addGap(31, 31, 31)
                .addComponent(txt_buscar_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89)
                .addGroup(dialog_buscar_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btb_cargar_cliente)
                    .addComponent(btn_cancelar_cliente))
                .addContainerGap(109, Short.MAX_VALUE))
        );

        jLabel18.setText("Tabla Productos");

        tabla_productos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Producto Id", "Nombre Producto", "Precio"
            }
        ));
        jScrollPane4.setViewportView(tabla_productos);

        btn_aceptar_producto.setText("Aceptar");

        jButton1.setText("Cancelar");

        javax.swing.GroupLayout dialog_buscar_productoLayout = new javax.swing.GroupLayout(dialog_buscar_producto.getContentPane());
        dialog_buscar_producto.getContentPane().setLayout(dialog_buscar_productoLayout);
        dialog_buscar_productoLayout.setHorizontalGroup(
            dialog_buscar_productoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialog_buscar_productoLayout.createSequentialGroup()
                .addGroup(dialog_buscar_productoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dialog_buscar_productoLayout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(btn_aceptar_producto)
                        .addGap(80, 80, 80)
                        .addComponent(jButton1))
                    .addGroup(dialog_buscar_productoLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(dialog_buscar_productoLayout.createSequentialGroup()
                        .addGap(289, 289, 289)
                        .addComponent(jLabel18))
                    .addGroup(dialog_buscar_productoLayout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(txt_buscar_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(126, Short.MAX_VALUE))
        );
        dialog_buscar_productoLayout.setVerticalGroup(
            dialog_buscar_productoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialog_buscar_productoLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel18)
                .addGap(23, 23, 23)
                .addComponent(txt_buscar_producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(dialog_buscar_productoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_aceptar_producto)
                    .addComponent(jButton1))
                .addGap(97, 97, 97))
        );

        setClosable(true);
        setPreferredSize(new java.awt.Dimension(1660, 800));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Nombre");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Cedula");

        txt_cedula_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cedula_clienteActionPerformed(evt);
            }
        });

        btn_abrir_dialog_cliente.setFont(new java.awt.Font("Segoe UI Emoji", 1, 12)); // NOI18N
        btn_abrir_dialog_cliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconoseImagenes/add_user_group_man_man_40px.png"))); // NOI18N
        btn_abrir_dialog_cliente.setText("Cargar Cliente");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Direccion");

        txt_direccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_direccionActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel19.setText("ID");

        jLabel5.setBackground(new java.awt.Color(0, 153, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel5.setText("FACTURAS");

        jLabel14.setFont(new java.awt.Font("Trebuchet MS", 2, 36)); // NOI18N
        jLabel14.setText("BEMO CAFE");

        jLabel15.setFont(new java.awt.Font("Palatino Linotype", 2, 18)); // NOI18N
        jLabel15.setText("Cornelio Crespo Vega y Av. de las Américas");

        jLabel16.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); // NOI18N
        jLabel16.setText("Dirección:");

        jLabel3.setText("Fecha");

        jLabel20.setFont(new java.awt.Font("Palatino Linotype", 2, 14)); // NOI18N
        jLabel20.setText("285-5194");

        jLabel21.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); // NOI18N
        jLabel21.setText("Telefono:");

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconoseImagenes/logofondo.png"))); // NOI18N

        lboocliente.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lboocliente.setForeground(new java.awt.Color(204, 0, 0));

        jLabel23.setText("Numero Factura");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_abrir_dialog_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(txt_id_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(txt_cedula_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(txt_nombre_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lboocliente, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel19)
                        .addGap(68, 68, 68)
                        .addComponent(jLabel2)
                        .addGap(130, 130, 130)
                        .addComponent(jLabel1)))
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txt_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_id_factura, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addGap(20, 20, 20))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel22)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel21))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel15))
                            .addComponent(jLabel20)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(457, 457, 457)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 494, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(date_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_id_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_cedula_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_nombre_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lboocliente, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_abrir_dialog_cliente)))
                .addGap(61, 61, 61))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel21))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel15)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(4, 4, 4)
                                .addComponent(date_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, 0)
                        .addComponent(jLabel20)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel23)
                .addGap(18, 18, 18)
                .addComponent(txt_id_factura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1630, 250));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Producto");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Precio Unitario");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Cantidad");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("ID");

        btn_agregar_producto.setFont(new java.awt.Font("Segoe UI Emoji", 1, 12)); // NOI18N
        btn_agregar_producto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconoseImagenes/+.png"))); // NOI18N
        btn_agregar_producto.setText("Agregar Producto");

        btn_abrir_dialog_producto.setFont(new java.awt.Font("Segoe UI Emoji", 1, 12)); // NOI18N
        btn_abrir_dialog_producto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconoseImagenes/agregarPro.png"))); // NOI18N
        btn_abrir_dialog_producto.setText("Cargar Producto");

        btn_quitar_producto.setFont(new java.awt.Font("Segoe UI Emoji", 1, 12)); // NOI18N
        btn_quitar_producto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconoseImagenes/remover.png"))); // NOI18N
        btn_quitar_producto.setText("Quitar Producto");

        tabla_factura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo Producto", "Nombre Producto", "Precio Unitario", "Cantidad", "Monto"
            }
        ));
        jScrollPane1.setViewportView(tabla_factura);

        jLabel11.setFont(new java.awt.Font("Segoe UI Symbol", 1, 24)); // NOI18N
        jLabel11.setText("Subtotal:");

        jLabel12.setFont(new java.awt.Font("Segoe UI Symbol", 1, 24)); // NOI18N
        jLabel12.setText("IVA:");

        jLabel13.setFont(new java.awt.Font("Segoe UI Symbol", 1, 24)); // NOI18N
        jLabel13.setText("Total:");

        txt_total.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        txt_total.setForeground(new java.awt.Color(204, 0, 0));
        txt_total.setText("00");

        btn_guardar_factura.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        btn_guardar_factura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconoseImagenes/GuardarFact.png"))); // NOI18N
        btn_guardar_factura.setText("Guardar Factura");

        btn_cancelar.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        btn_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconoseImagenes/CancelarFACT.png"))); // NOI18N
        btn_cancelar.setText("Cancelar");

        btn_imprimir.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        btn_imprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconoseImagenes/ImprimirFact.png"))); // NOI18N
        btn_imprimir.setText("Imprimir factura");

        lbooproducto.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbooproducto.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(94, 94, 94)
                                .addComponent(btn_guardar_factura)
                                .addGap(35, 35, 35)
                                .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(btn_imprimir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 680, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel13))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txt_iva)
                                        .addComponent(txt_subtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(9, 9, 9)))
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btn_abrir_dialog_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(44, 44, 44)
                                        .addComponent(jLabel10)
                                        .addGap(47, 47, 47))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_codigo_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(txt_nombre_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(41, 41, 41)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_precio_unitario, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8)))
                            .addComponent(lbooproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txt_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 281, Short.MAX_VALUE)
                                .addComponent(btn_agregar_producto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_quitar_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(109, 109, 109))))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel10)
                                .addComponent(jLabel7))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel9)
                                .addComponent(jLabel8)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_codigo_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_nombre_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_precio_unitario, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_quitar_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_agregar_producto)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(btn_abrir_dialog_producto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbooproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_guardar_factura)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btn_cancelar)
                                .addComponent(btn_imprimir))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_subtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_iva, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 1650, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_cedula_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cedula_clienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cedula_clienteActionPerformed

    private void txt_direccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_direccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_direccionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btb_cargar_cliente;
    private javax.swing.JButton btn_abrir_dialog_cliente;
    private javax.swing.JButton btn_abrir_dialog_producto;
    private javax.swing.JButton btn_aceptar_producto;
    private javax.swing.JButton btn_agregar_producto;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_cancelar_cliente;
    private javax.swing.JButton btn_guardar_factura;
    private javax.swing.JButton btn_imprimir;
    private javax.swing.JButton btn_quitar_producto;
    private com.toedter.calendar.JDateChooser date_fecha;
    private javax.swing.JDialog dialog_buscar_cliente;
    private javax.swing.JDialog dialog_buscar_producto;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lboocliente;
    private javax.swing.JLabel lbooproducto;
    private javax.swing.JTable tabla_cliente_pedido;
    private javax.swing.JTable tabla_factura;
    private javax.swing.JTable tabla_productos;
    private javax.swing.JTextField txt_buscar_cliente;
    private javax.swing.JTextField txt_buscar_producto;
    private javax.swing.JTextField txt_cantidad;
    private javax.swing.JTextField txt_cedula_cliente;
    private javax.swing.JTextField txt_codigo_producto;
    private javax.swing.JTextField txt_direccion;
    private javax.swing.JTextField txt_id_cliente;
    private javax.swing.JTextField txt_id_factura;
    private javax.swing.JTextField txt_iva;
    private javax.swing.JTextField txt_nombre_cliente;
    private javax.swing.JTextField txt_nombre_producto;
    private javax.swing.JTextField txt_precio_unitario;
    private javax.swing.JTextField txt_subtotal;
    private javax.swing.JTextField txt_total;
    // End of variables declaration//GEN-END:variables

 
}
