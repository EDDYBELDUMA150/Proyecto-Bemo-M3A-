/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIsta;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JDesktopPane;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;

/**
 *
 * @author Abel Gomez
 */
public class vistamenuprincipal extends javax.swing.JFrame {

    /**
     * Creates new form vistamenuprincipal
     */
    Toolkit tik = Toolkit.getDefaultToolkit();
    Dimension d = tik.getScreenSize();

    int ancho = (int) d.getWidth();
    int alto = (int) d.getHeight();

    public vistamenuprincipal() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        jdpprincipal.setPreferredSize(new Dimension(d));
    }

    public JButton getBtncrudclientes() {
        return btncrudclientes;
    }

    public void setBtncrudclientes(JButton btncrudclientes) {
        this.btncrudclientes = btncrudclientes;
    }

    public JButton getBtn_pedido_pastel() {
        return btn_pedido_pastel;
    }

    public void setBtn_pedido_pastel(JButton btn_pedido_pastel) {
        this.btn_pedido_pastel = btn_pedido_pastel;
    }

    public JButton getBtn_cotizacion() {
        return btn_cotizacion;
    }

    public void setBtn_cotizacion(JButton btn_cotizacion) {
        this.btn_cotizacion = btn_cotizacion;
    }

    public JButton getBtn_factura() {
        return btn_factura;
    }

    public void setBtn_factura(JButton btn_factura) {
        this.btn_factura = btn_factura;
    }

    public JDesktopPane getJdpprincipal() {
        return jdpprincipal;
    }

    public void setJdpprincipal(JDesktopPane jdpprincipal) {
        this.jdpprincipal = jdpprincipal;
    }

    public JButton getBtncrudproveedores() {
        return btncrudproveedores;
    }

    public void setBtncrudproveedores(JButton btncrudproveedores) {
        this.btncrudproveedores = btncrudproveedores;
    }

    public JButton getBtProductos() {
        return btProductos;
    }

    public void setBtProductos(JButton btProductos) {
        this.btProductos = btProductos;
    }

    public JMenuItem getMnCategoria() {
        return mnCategoria;
    }

    public void setMnCategoria(JMenuItem mnCategoria) {
        this.mnCategoria = mnCategoria;
    }

    public JMenuItem getMnCliente() {
        return mnCliente;
    }

    public void setMnCliente(JMenuItem mnCliente) {
        this.mnCliente = mnCliente;
    }

    public JMenuItem getMnGastos() {
        return mnGastos;
    }

    public void setMnGastos(JMenuItem mnGastos) {
        this.mnGastos = mnGastos;
    }

    public JMenuItem getMnProducto() {
        return mnProducto;
    }

    public void setMnProducto(JMenuItem mnProducto) {
        this.mnProducto = mnProducto;
    }

    public JMenuItem getMnProveedore() {
        return mnProveedore;
    }

    public void setMnProveedore(JMenuItem mnProveedore) {
        this.mnProveedore = mnProveedore;
    }

    public JCheckBoxMenuItem getjCheckboxitemmodooscuro() {
        return jCheckboxitemmodooscuro;
    }

    public void setjCheckboxitemmodooscuro(JCheckBoxMenuItem jCheckboxitemmodooscuro) {
        this.jCheckboxitemmodooscuro = jCheckboxitemmodooscuro;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        ImageIcon icon = new ImageIcon(getClass().getResource("/IconoseImagenes/fondo_pBM.png"));
        Image image = icon.getImage();
        jdpprincipal = new javax.swing.JDesktopPane(){
            public void paintComponent(Graphics g){
                g.drawImage(image,0,0,(int)d.getWidth(),(int)d.getHeight(),this);
            }
        };
        jToolBar2 = new javax.swing.JToolBar();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btn_pedido_pastel = new javax.swing.JButton();
        btncrudproveedores = new javax.swing.JButton();
        btncrudclientes = new javax.swing.JButton();
        btn_cotizacion = new javax.swing.JButton();
        btn_factura = new javax.swing.JButton();
        btProductos = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mnProducto = new javax.swing.JMenuItem();
        mnCategoria = new javax.swing.JMenuItem();
        mnCliente = new javax.swing.JMenuItem();
        mnProveedore = new javax.swing.JMenuItem();
        mnGastos = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jCheckboxitemmodooscuro = new javax.swing.JCheckBoxMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(getMaximumSize());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jdpprincipal.setBackground(new java.awt.Color(153, 204, 255));
        jdpprincipal.setMaximumSize(d);

        javax.swing.GroupLayout jdpprincipalLayout = new javax.swing.GroupLayout(jdpprincipal);
        jdpprincipal.setLayout(jdpprincipalLayout);
        jdpprincipalLayout.setHorizontalGroup(
            jdpprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2147483647, 2147483647)
        );
        jdpprincipalLayout.setVerticalGroup(
            jdpprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        getContentPane().add(jdpprincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, -1, -1));

        jToolBar2.setBorder(null);
        jToolBar2.setRollover(true);
        jToolBar2.setMaximumSize(new java.awt.Dimension(1000, 115));
        jToolBar2.setPreferredSize(getMaximumSize());

        jButton2.setFont(new java.awt.Font("Yu Gothic", 1, 16)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconoseImagenes/logoINICIO - Editado.png"))); // NOI18N
        jButton2.setText("Inicio");
        jButton2.setBorderPainted(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setMargin(new java.awt.Insets(15, 14, 15, 16));
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(jButton2);

        jButton3.setFont(new java.awt.Font("Yu Gothic", 1, 16)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconoseImagenes/export_50px.png"))); // NOI18N
        jButton3.setText("Salir");
        jButton3.setBorderPainted(false);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setMargin(new java.awt.Insets(15, 14, 15, 16));
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(jButton3);

        btn_pedido_pastel.setFont(new java.awt.Font("Yu Gothic", 1, 16)); // NOI18N
        btn_pedido_pastel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconoseImagenes/pedidos.png"))); // NOI18N
        btn_pedido_pastel.setText("Pedidos");
        btn_pedido_pastel.setBorderPainted(false);
        btn_pedido_pastel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_pedido_pastel.setFocusable(false);
        btn_pedido_pastel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_pedido_pastel.setMargin(new java.awt.Insets(15, 14, 15, 16));
        btn_pedido_pastel.setMaximumSize(new java.awt.Dimension(97, 115));
        btn_pedido_pastel.setMinimumSize(new java.awt.Dimension(97, 115));
        btn_pedido_pastel.setPreferredSize(new java.awt.Dimension(97, 115));
        btn_pedido_pastel.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(btn_pedido_pastel);

        btncrudproveedores.setFont(new java.awt.Font("Yu Gothic", 1, 16)); // NOI18N
        btncrudproveedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconoseImagenes/supplier_50px.png"))); // NOI18N
        btncrudproveedores.setText("Proveedores");
        btncrudproveedores.setBorderPainted(false);
        btncrudproveedores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btncrudproveedores.setFocusable(false);
        btncrudproveedores.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btncrudproveedores.setMargin(new java.awt.Insets(15, 14, 15, 16));
        btncrudproveedores.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(btncrudproveedores);

        btncrudclientes.setFont(new java.awt.Font("Yu Gothic", 1, 16)); // NOI18N
        btncrudclientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconoseImagenes/user_group_50px_1.png"))); // NOI18N
        btncrudclientes.setText("Clientes");
        btncrudclientes.setBorderPainted(false);
        btncrudclientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btncrudclientes.setFocusable(false);
        btncrudclientes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btncrudclientes.setMargin(new java.awt.Insets(15, 14, 15, 16));
        btncrudclientes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(btncrudclientes);

        btn_cotizacion.setFont(new java.awt.Font("Yu Gothic", 1, 16)); // NOI18N
        btn_cotizacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconoseImagenes/estimate_50px.png"))); // NOI18N
        btn_cotizacion.setText("Cootización");
        btn_cotizacion.setBorderPainted(false);
        btn_cotizacion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cotizacion.setFocusable(false);
        btn_cotizacion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_cotizacion.setMargin(new java.awt.Insets(15, 14, 15, 16));
        btn_cotizacion.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(btn_cotizacion);

        btn_factura.setFont(new java.awt.Font("Yu Gothic", 1, 16)); // NOI18N
        btn_factura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconoseImagenes/factura.png"))); // NOI18N
        btn_factura.setText("Facturación");
        btn_factura.setBorderPainted(false);
        btn_factura.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_factura.setFocusable(false);
        btn_factura.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_factura.setMargin(new java.awt.Insets(15, 14, 15, 16));
        btn_factura.setPreferredSize(new java.awt.Dimension(89, 83));
        btn_factura.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(btn_factura);

        btProductos.setFont(new java.awt.Font("Yu Gothic", 1, 16)); // NOI18N
        btProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconoseImagenes/cash_register_50px.png"))); // NOI18N
        btProductos.setText("Registros");
        btProductos.setBorderPainted(false);
        btProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btProductos.setFocusable(false);
        btProductos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btProductos.setMargin(new java.awt.Insets(15, 14, 15, 16));
        btProductos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(btProductos);

        getContentPane().add(jToolBar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 115));

        jMenu1.setText("Crear");

        mnProducto.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        mnProducto.setText("Productos");
        jMenu1.add(mnProducto);

        mnCategoria.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.ALT_DOWN_MASK));
        mnCategoria.setText("Categorias");
        jMenu1.add(mnCategoria);

        mnCliente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_DOWN_MASK));
        mnCliente.setText("Clientes");
        jMenu1.add(mnCliente);

        mnProveedore.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.ALT_DOWN_MASK));
        mnProveedore.setText("Proveedores");
        jMenu1.add(mnProveedore);

        mnGastos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.ALT_DOWN_MASK));
        mnGastos.setText("Gastos");
        jMenu1.add(mnGastos);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Reportes");
        jMenuBar1.add(jMenu2);

        jMenu4.setText("Opciones");

        jCheckboxitemmodooscuro.setText("Modo Oscuro");
        jMenu4.add(jCheckboxitemmodooscuro);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(vistamenuprincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(vistamenuprincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(vistamenuprincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(vistamenuprincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new vistamenuprincipal().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btProductos;
    private javax.swing.JButton btn_cotizacion;
    private javax.swing.JButton btn_factura;
    private javax.swing.JButton btn_pedido_pastel;
    private javax.swing.JButton btncrudclientes;
    private javax.swing.JButton btncrudproveedores;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JCheckBoxMenuItem jCheckboxitemmodooscuro;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JDesktopPane jdpprincipal;
    private javax.swing.JMenuItem mnCategoria;
    private javax.swing.JMenuItem mnCliente;
    private javax.swing.JMenuItem mnGastos;
    private javax.swing.JMenuItem mnProducto;
    private javax.swing.JMenuItem mnProveedore;
    // End of variables declaration//GEN-END:variables
}
