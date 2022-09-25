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
        jLabel6 = new javax.swing.JLabel();
        txt_id_factura = new javax.swing.JTextField();
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
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        btn_guardar_factura = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        btn_imprimir = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        date_fecha = new com.toedter.calendar.JDateChooser();

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

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Nombre");

        jLabel2.setText("Cedula");

        txt_cedula_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cedula_clienteActionPerformed(evt);
            }
        });

        btn_abrir_dialog_cliente.setText("Cargar Cliente");

        jLabel4.setText("Direccion");

        jLabel19.setText("Id");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19)
                .addGap(18, 18, 18)
                .addComponent(txt_id_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txt_nombre_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_cedula_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(txt_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_abrir_dialog_cliente)
                .addContainerGap(302, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_nombre_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txt_cedula_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel19)
                    .addComponent(txt_id_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_abrir_dialog_cliente))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 68, 1144, -1));

        jLabel5.setText("FACTURAS BEMO CAFE");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 184, -1));

        jLabel6.setText("Numero Factura");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 20, -1, -1));
        getContentPane().add(txt_id_factura, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 20, 64, -1));

        jLabel7.setText("Producto");

        jLabel8.setText("Precio Unitario");

        jLabel9.setText("Cantidad");

        jLabel10.setText("Codigo Producto");

        btn_agregar_producto.setText("Agregar Producto");

        btn_abrir_dialog_producto.setText("Cargar Producto");

        btn_quitar_producto.setText("Quitar Producto");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_codigo_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_nombre_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(271, 271, 271)
                        .addComponent(btn_agregar_producto)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(btn_quitar_producto))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_precio_unitario, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(txt_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_abrir_dialog_producto)))
                .addContainerGap(200, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_nombre_producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txt_precio_unitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txt_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txt_codigo_producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_abrir_dialog_producto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_agregar_producto)
                    .addComponent(btn_quitar_producto))
                .addGap(21, 21, 21))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, -1, -1));

        tabla_factura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo Producto", "Nombre Producto", "Precio Unitario", "Cantidad", "Monto"
            }
        ));
        jScrollPane1.setViewportView(tabla_factura);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 284, 944, 179));

        jLabel11.setText("Subtotal");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 480, -1, 20));

        jLabel12.setText("Iva");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 530, -1, 20));

        jLabel13.setText("Total");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 570, -1, 20));
        getContentPane().add(txt_subtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 480, 128, 30));
        getContentPane().add(txt_iva, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 520, 128, 30));
        getContentPane().add(txt_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 560, 128, 30));

        jLabel14.setText("BEMO CAFE S.A.");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 480, -1, -1));

        jLabel15.setText("DIRECCION");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 510, -1, -1));

        jLabel16.setText("TELEFONO");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 540, -1, -1));

        btn_guardar_factura.setText("Guardar Factura");
        getContentPane().add(btn_guardar_factura, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 510, -1, -1));

        btn_cancelar.setText("Cancelar");
        getContentPane().add(btn_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 510, -1, -1));

        btn_imprimir.setText("Imprimir factura");
        getContentPane().add(btn_imprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 510, -1, -1));

        jLabel3.setText("Fecha");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 20, -1, -1));
        getContentPane().add(date_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 20, 175, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_cedula_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cedula_clienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cedula_clienteActionPerformed


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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
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
