/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import VIsta.Vista_pedidoPastel;
import VIsta.vistacliente;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.xml.ws.Holder;
import modelo.Cliente;
import modelo.MConexion.Modelo_PedidoPastel;
import modelo.MConexion.Modelocliente;
import modelo.PedidoPastel;
import modelo.Productos;

/**
 *
 * @author carlos
 */
public class Controlador_pedidopastel {

    private String buscar_txt;
    private String buscar_txt2;
    private Modelo_PedidoPastel modelo_pedido;
    private Vista_pedidoPastel vista_pedido;
    private JFileChooser jfc;
    private Modelocliente modelo_cli;
    private vistacliente vista_cliente;
    private Modelocliente modelo_cliente;
    private int i;
    DefaultTableModel estructuraTabla;
    Date fechaActual = new Date();

    public Controlador_pedidopastel() {
    }

    public Controlador_pedidopastel(Modelo_PedidoPastel modelo_pedido, Vista_pedidoPastel vista_pedido) {
        this.modelo_pedido = modelo_pedido;
        this.vista_pedido = vista_pedido;
        vista_pedido.setVisible(true);

    }

    public void iniciarcontrol() {
        cargardatos();
        cargarTablacliente();
        cargartablaProducto();
        vista_pedido.getDate_fecha_pedido().setDate(fechaActual);
        vista_pedido.getBtn_aagregar_pedido().addActionListener(l -> abrirDialogo(1));
        vista_pedido.getBtn_aceptar().addActionListener(l -> crear_editar_pedido());
        vista_pedido.getBtn_modificar_pedido().addActionListener(l -> abrirDialogo(2));
        vista_pedido.getBtn_examinar_foto().addActionListener(l -> examinaFoto());
        vista_pedido.getBtn_eliminar_pedido().addActionListener(l -> eliminar_pedido());
        vista_pedido.getBtb_cargar_cliente().addActionListener(l -> cargar_cliente());
        vista_pedido.getBtn_buscar_cliente().addActionListener(l -> abrirDialogocliente());
        vista_pedido.getBtn_buscar_producto().addActionListener(l -> abrirDialogoProducto());
        vista_pedido.getBtn_aceptar_producto().addActionListener(l -> cargar_producto());
       vista_pedido.getBtn_actualizar_tabla().addActionListener(l -> cargardatos());
//        vista_pedido.getBtn_nuevo_cliente().addActionListener(l -> abrirDialogocliente(1));

        vista_pedido.getTxt_busquedapedido().addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent ke) {

                buscarPedido();
            }

        });
        
        vista_pedido.getTxt_buscar_producto().addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent ke) {

                buscarProducto();
            }

        });
        
        vista_pedido.getTxt_buscar_cliente().addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent ke) {

                busqueda_cliente();
            }

        });
    }

    public void cargardatos() {
        DefaultTableModel estructuratabla;
        vista_pedido.getTabla_pedido().setDefaultRenderer(Object.class, new ImagenTabla());
        estructuratabla = (DefaultTableModel) vista_pedido.getTabla_pedido().getModel();
        estructuratabla.setNumRows(0);

        List<PedidoPastel> lista_pedido1 = modelo_pedido.getPedidoPastel();
        Holder<Integer> i = new Holder<>(0);
        lista_pedido1.stream().forEach(pedido -> {
            estructuratabla.addRow(new Object[10]);
            vista_pedido.getTabla_pedido().setValueAt(pedido.getPdpt_ID(), i.value, 0);
            vista_pedido.getTabla_pedido().setValueAt(pedido.getPdpt_fechapedido(), i.value, 1);
            vista_pedido.getTabla_pedido().setValueAt(pedido.getPdpt_fechaentrga(), i.value, 2);
            vista_pedido.getTabla_pedido().setValueAt(pedido.getPdpt_nombrecliente(), i.value, 3);
            vista_pedido.getTabla_pedido().setValueAt(pedido.getPdpt_nombreproducto(), i.value, 4);
            vista_pedido.getTabla_pedido().setValueAt(pedido.getPdpt_cantidad(), i.value, 5);
            vista_pedido.getTabla_pedido().setValueAt(pedido.getPdpt_especificacion(), i.value, 6);
            vista_pedido.getTabla_pedido().setValueAt(pedido.getPdpt_abono(), i.value, 7);

            vista_pedido.getTabla_pedido().setValueAt(pedido.getPdpt_estado(), i.value, 8);
//             vista_pedido.getTabla_pedido().setValueAt(pedido.getPdpt_fotopastel(), i.value, 9);
            Image foto = pedido.getPdpt_fotopastel();
            if (foto != null) {
                foto = foto.getScaledInstance(100, 150, Image.SCALE_SMOOTH);
                ImageIcon icono = new ImageIcon(foto);
                DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
                dtcr.setIcon(icono);
                vista_pedido.getTabla_pedido().setValueAt(new JLabel(icono), i.value, 9);

            } else {
                vista_pedido.getTabla_pedido().setValueAt(null, i.value, 9);
            }

            i.value++;

        });

    }
     public void cargar_cliente() {
        int seleccion = vista_pedido.getTabla_cliente_pedido().getSelectedRow();

        if (seleccion == -1) {
            JOptionPane.showMessageDialog(null, "Aun no ha seleccionado una fila");
        } else {
            int codigo = Integer.parseInt(vista_pedido.getTabla_cliente_pedido().getValueAt(seleccion, 0).toString());
            modelo_pedido.lista_cli().forEach((p) -> {
                if (p.getCl_ID() == codigo) {
                    vista_pedido.getTxt_id_cliente().setText(String.valueOf(p.getCl_ID()));

                    vista_pedido.getTxt_nombre_cliente().setText(p.getPrs_nombre1());
                    vista_pedido.getTxt_apellido_cliente().setText(p.getPrs_apellido1());

                    vista_pedido.getDialog_buscar_cliente().dispose();
                }
            });
        }
    }
     public void cargar_producto() {
        int seleccion = vista_pedido.getTabla_productos().getSelectedRow();

        if (seleccion == -1) {
            JOptionPane.showMessageDialog(null, "Aun no ha seleccionado una fila");
        } else {
            int codigo = Integer.parseInt(vista_pedido.getTabla_productos().getValueAt(seleccion, 0).toString());
            modelo_pedido.list_producto().forEach((p) -> {
                if (p.getPrd_ID() == codigo) {
                    vista_pedido.getTxt_producto_id().setText(String.valueOf(p.getPrd_ID()));

                    vista_pedido.getTxt_nombre_producto().setText(p.getPrd_nombre());

                    vista_pedido.getDialog_buscar_producto().dispose();
                }
            });
        }
    }
    private void abrirDialogo(int op) {
        String titulo;
        if (op == 1) {

            titulo = "Crear Pedido";
            vista_pedido.getLabel_titulo().setText(titulo);
            vista_pedido.getDialog_pedido().setName("C");
            vista_pedido.getDialog_pedido().setVisible(true);
            vista_pedido.getTxt_id_pedido().setText(String.valueOf(modelo_pedido.numeroidpedido()+ 1));
            vista_pedido.getTxt_id_pedido().setEnabled(false);

        } else {

            titulo = "Editar Pedido";
           if(llenarDatos()){
                vista_pedido.getLabel_titulo().setText(titulo);
                vista_pedido.getDialog_pedido().setName("E");
                vista_pedido.getTxt_id_cliente().setEnabled(false);
                vista_pedido.getTxt_producto_id().setEnabled(false);
                vista_pedido.getTxt_id_pedido().setEnabled(false);
                vista_pedido.getDialog_pedido().setVisible(true);
            
           }
               

        }
        vista_pedido.getDialog_pedido().setTitle(titulo);
        vista_pedido.getDialog_pedido().setSize(900, 750);
        vista_pedido.getDialog_pedido().setLocationRelativeTo(vista_pedido);

    }
    private void abrirDialogocliente() {
        
        vista_pedido.getDialog_buscar_cliente().setVisible(true);
        vista_pedido.getDialog_buscar_cliente().setSize(650, 500);
        vista_pedido.getDialog_buscar_cliente().setLocationRelativeTo(vista_pedido);

    }
    public void cargarTablacliente() {
        DefaultTableModel tb = (DefaultTableModel) vista_pedido.getTabla_cliente_pedido().getModel();
        tb.setNumRows(0);
        List<Cliente> com = modelo_pedido.lista_cli();
        com.stream().forEach(p -> {
            String[] cami = {String.valueOf(p.getCl_ID()), p.getPrs_cedula(), p.getPrs_nombre1(), p.getPrs_apellido1()};
            tb.addRow(cami);
        });
    }
    private void abrirDialogoProducto() {
  
        vista_pedido.getDialog_buscar_producto().setVisible(true);
        vista_pedido.getDialog_buscar_producto().setSize(650, 500);
        vista_pedido.getDialog_buscar_producto().setLocationRelativeTo(vista_pedido);

    }
    public void cargartablaProducto() {
        DefaultTableModel tb = (DefaultTableModel) vista_pedido.getTabla_productos().getModel();
        tb.setNumRows(0);
        List<Productos> com = modelo_pedido.list_producto();
        com.stream().forEach(p -> {
            String[] cami = {String.valueOf(p.getPrd_ID()), p.getPrd_nombre(),String.valueOf(p.getPrd_precio())};
            tb.addRow(cami);
        });
    }
    public boolean llenarDatos() {
        Modelo_PedidoPastel persona = new Modelo_PedidoPastel();
        int fila = vista_pedido.getTabla_pedido().getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione la persona a modificar");
            return false;
        } else {

            String id = vista_pedido.getTabla_pedido().getValueAt(fila, 0).toString();
            List<PedidoPastel> listap = modelo_pedido.getPedidoPastel();
            listap.stream().forEach(up -> {
                if (id.equalsIgnoreCase(String.valueOf(up.getPdpt_ID()))) {
                    vista_pedido.getTxt_id_cliente().setText(String.valueOf(up.getPdpt_cli_id()));
                    vista_pedido.getTxt_id_pedido().setText(String.valueOf(up.getPdpt_ID()));
                    vista_pedido.getTxt_nombre_cliente().setText(up.getPdpt_nombrecliente());
                    vista_pedido.getDate_fecha_pedido().setDate(up.getPdpt_fechapedido());
                    vista_pedido.getDate_fecha_entrega().setDate(up.getPdpt_fechaentrga());
                    vista_pedido.getTxt_area_especificacion().setText(up.getPdpt_especificacion());
                    vista_pedido.getTxt_apellido_cliente().setText(up.getPdpt_apellidocliente());
                    vista_pedido.getTxt_abono().setText(String.valueOf(up.getPdpt_abono()));
                    vista_pedido.getTxt_cantidad().setText(String.valueOf(up.getPdpt_cantidad()));
                    vista_pedido.getTxt_producto_id().setText(String.valueOf(up.getPdpt_prod_id()));
                    vista_pedido.getTxt_nombre_producto().setText(up.getPdpt_nombreproducto());
                    Image foto = up.getPdpt_fotopastel();
                    if (foto != null) {
                        foto = foto.getScaledInstance(100, 150, Image.SCALE_SMOOTH);
                        ImageIcon icono = new ImageIcon(foto);
                        DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
                        dtcr.setIcon(icono);
                        vista_pedido.getLabel_foto_pedido().setIcon(icono);
                    } else {
                        vista_pedido.getLabel_foto_pedido().setIcon(null);
                    }

                }

            });
            return true;
        }
    }
    
    public void eliminar_pedido() {

        int id_pedido = 0;
        try {
            int fila = vista_pedido.getTabla_pedido().getSelectedRow();

            if (fila >= 0) {
                int respuesta = JOptionPane.showConfirmDialog(vista_pedido, "Seguro Desea Eliminar este Registro?");
                if (respuesta == JOptionPane.YES_OPTION) {

                    id_pedido = Integer.valueOf(vista_pedido.getTabla_pedido().getValueAt(fila, 0).toString());

                    Modelo_PedidoPastel pedido = new Modelo_PedidoPastel();
                    pedido.setPdpt_ID(id_pedido);

                    if (pedido.deletePedido()) {

                        JOptionPane.showMessageDialog(vista_pedido, "Dato Eliminado");
                        limpiardatos();
                        cargardatos();
//                        vista_pedido.getDialogclientes().setVisible(false);

                    } else {
                        JOptionPane.showMessageDialog(vista_pedido, "Error , dato no eliminado");

                    }
                } else {

                }
            } else {

                JOptionPane.showMessageDialog(null, "Fila no seleccionada");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString());
        }

    }
    
     public void limpiardatos() {

        //  vista.getTxtidcliente().setText("");
        vista_pedido.getTxt_abono().setText("");
        vista_pedido.getTxt_apellido_cliente().setText("");
        vista_pedido.getTxt_area_especificacion().setText("");
        vista_pedido.getTxt_cantidad().setText("");
        vista_pedido.getTxt_id_cliente().setText("");
        vista_pedido.getTxt_id_pedido().setText("");
        vista_pedido.getTxt_nombre_cliente().setText("");
        vista_pedido.getTxt_nombre_producto().setText("");
        vista_pedido.getTxt_producto_id().setText("");
        vista_pedido.getDate_fecha_entrega().setCalendar(null);
        vista_pedido.getDate_fecha_pedido().setCalendar(null);

    }
     
    private void examinaFoto() {
        jfc = new JFileChooser();
        jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int estado = jfc.showOpenDialog(vista_pedido);
        if (estado == JFileChooser.APPROVE_OPTION) {
            try {
                Image imagen = ImageIO.read(jfc.getSelectedFile()).getScaledInstance(
                        vista_pedido.getLabel_foto_pedido().getWidth(),
                        vista_pedido.getLabel_foto_pedido().getHeight(),
                        Image.SCALE_DEFAULT);

                Icon icono = new ImageIcon(imagen);
                vista_pedido.getLabel_foto_pedido().setIcon(icono);
                vista_pedido.getLabel_foto_pedido().updateUI();
            } catch (IOException ex) {
                Logger.getLogger(Controlador_pedidopastel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    } 
    private void crear_editar_pedido() {
        int id_pedido = 0;
        if (vista_pedido.getDialog_pedido().getName().contentEquals("C")) {
            if (modelo_pedido.numeroidpedido()== 0) {
                id_pedido = 1;
            } else {
                id_pedido = modelo_pedido.numeroidpedido()+ 1;
            }
            Modelo_PedidoPastel mi_pedido = new Modelo_PedidoPastel();
            Date date = vista_pedido.getDate_fecha_pedido().getDate(); //ic es la interfaz, jDate el JDatechooser
            long d = date.getTime(); //guardamos en un long el tiempo
            java.sql.Date fecha_pedido = new java.sql.Date(d);// parseamos al formato del sql  

            Date date1 = vista_pedido.getDate_fecha_entrega().getDate(); //ic es la interfaz, jDate el JDatechooser
            long d1 = date1.getTime(); //guardamos en un long el tiempo
            java.sql.Date fecha_entrega = new java.sql.Date(d1);// parseamos al formato del sql  

            int cli_id = Integer.parseInt(vista_pedido.getTxt_id_cliente().getText());
            int prod_id = Integer.parseInt(vista_pedido.getTxt_producto_id().getText());
            int cantidad = Integer.parseInt(vista_pedido.getTxt_cantidad().getText());
            String especificacion = vista_pedido.getTxt_area_especificacion().getText();
            double abono = Double.parseDouble(vista_pedido.getTxt_abono().getText());
            String estado = "Activo";           
            try {
                FileInputStream img = new FileInputStream(jfc.getSelectedFile());
                int largo = (int) jfc.getSelectedFile().length();
                mi_pedido.setImagefile(img);
                mi_pedido.setLengthfoto(largo);

            } catch (IOException ex) {
                Logger.getLogger(Controlador_pedidopastel.class.getName()).log(Level.SEVERE, null, ex);
            }

            mi_pedido.setPdpt_ID(id_pedido);
            mi_pedido.setPdpt_fechapedido(fecha_pedido);
            mi_pedido.setPdpt_fechaentrga(fecha_entrega);
            mi_pedido.setPdpt_cli_id(cli_id);
            mi_pedido.setPdpt_prod_id(prod_id);
            mi_pedido.setPdpt_cantidad(cantidad);
            mi_pedido.setPdpt_especificacion(especificacion);
            mi_pedido.setPdpt_abono(abono);
            mi_pedido.setPdpt_estado(estado);
            try {
                FileInputStream img = new FileInputStream(jfc.getSelectedFile());
                int largo = (int) jfc.getSelectedFile().length();
                mi_pedido.setImagefile(img);
                mi_pedido.setLengthfoto(largo);

            } catch (IOException ex) {
                Logger.getLogger(Controlador_pedidopastel.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (mi_pedido.setPedidoPastelito()) {
                JOptionPane.showMessageDialog(vista_pedido, "Pedido registrada exitosamente");
                vista_pedido.setVisible(true);
                vista_pedido.getDialog_pedido().setVisible(false);
                limpiardatos();
            } else {
                JOptionPane.showMessageDialog(vista_pedido, "El Pedido no se pudo registrar");
            }
        } else {
            int respuesta = JOptionPane.showConfirmDialog(vista_pedido, "Seguro Desea Actualizar este Registro?");

            if (respuesta == JOptionPane.YES_OPTION) {

                Modelo_PedidoPastel mi_pedido = new Modelo_PedidoPastel();
                int id_pedido1=Integer.valueOf(vista_pedido.getTxt_id_pedido().getText());
                Date date = vista_pedido.getDate_fecha_pedido().getDate(); //ic es la interfaz, jDate el JDatechooser
                long d = date.getTime(); //guardamos en un long el tiempo
                java.sql.Date fecha_pedido = new java.sql.Date(d);// parseamos al formato del sql  

                Date date1 = vista_pedido.getDate_fecha_entrega().getDate(); //ic es la interfaz, jDate el JDatechooser
                long d1 = date1.getTime(); //guardamos en un long el tiempo
                java.sql.Date fecha_entrega = new java.sql.Date(d1);// parseamos al formato del sql  

                int cli_id = Integer.parseInt(vista_pedido.getTxt_id_cliente().getText());
                int prod_id = Integer.parseInt(vista_pedido.getTxt_producto_id().getText());
                int cantidad = Integer.parseInt(vista_pedido.getTxt_cantidad().getText());
                String especificacion = vista_pedido.getTxt_area_especificacion().getText();
                double abono = Double.parseDouble(vista_pedido.getTxt_abono().getText());
                String estado = "Pendiente";
                try {
                    FileInputStream img = new FileInputStream(jfc.getSelectedFile());
                    int largo = (int) jfc.getSelectedFile().length();
                    mi_pedido.setImagefile(img);
                    mi_pedido.setLengthfoto(largo);

                } catch (IOException ex) {
                    Logger.getLogger(Controlador_pedidopastel.class.getName()).log(Level.SEVERE, null, ex);
                }

                    mi_pedido.setPdpt_ID(id_pedido1);
                mi_pedido.setPdpt_fechapedido(fecha_pedido);
                mi_pedido.setPdpt_fechaentrga(fecha_entrega);
                mi_pedido.setPdpt_cli_id(cli_id);
                mi_pedido.setPdpt_prod_id(prod_id);
                mi_pedido.setPdpt_cantidad(cantidad);
                mi_pedido.setPdpt_especificacion(especificacion);
                mi_pedido.setPdpt_abono(abono);
                mi_pedido.setPdpt_estado(estado);
                if (mi_pedido.updatePedido()) {
                    JOptionPane.showMessageDialog(vista_pedido, "Pedido modificado exitosamente");
                    limpiardatos();
                    cargardatos();
                    vista_pedido.setVisible(true);
                    
                    vista_pedido.getDialog_pedido().setVisible(false);
                    
                } else {
                    JOptionPane.showMessageDialog(vista_pedido, "El Pedido no se pudo modificar");
                }
            }
        }
    }
     
      public void buscarPedido() {

        String filtro = vista_pedido.getTxt_busquedapedido().getText() + "%";
        DefaultTableModel estructuratabla;
        estructuratabla = (DefaultTableModel) vista_pedido.getTabla_pedido().getModel();
        estructuratabla.setNumRows(0);
        List<PedidoPastel> listaPedido = modelo_pedido.buscarpedido(filtro);

        Holder<Integer> i = new Holder<>(0);
        listaPedido.stream().forEach(pedido -> {
            estructuratabla.addRow(new Object[10]);

           vista_pedido.getTabla_pedido().setValueAt(pedido.getPdpt_ID(), i.value, 0);
            vista_pedido.getTabla_pedido().setValueAt(pedido.getPdpt_fechapedido(), i.value, 1);
            vista_pedido.getTabla_pedido().setValueAt(pedido.getPdpt_fechaentrga(), i.value, 2);
            vista_pedido.getTabla_pedido().setValueAt(pedido.getPdpt_nombrecliente(), i.value, 3);
            vista_pedido.getTabla_pedido().setValueAt(pedido.getPdpt_nombreproducto(), i.value, 4);
            vista_pedido.getTabla_pedido().setValueAt(pedido.getPdpt_cantidad(), i.value, 5);
            vista_pedido.getTabla_pedido().setValueAt(pedido.getPdpt_especificacion(), i.value, 6);
            vista_pedido.getTabla_pedido().setValueAt(pedido.getPdpt_abono(), i.value, 7);
            vista_pedido.getTabla_pedido().setValueAt(pedido.getPdpt_estado(), i.value, 8);
            vista_pedido.getTabla_pedido().setValueAt(pedido.getPdpt_fotopastel(), i.value, 9);
            i.value++;

        });

    }
      
      public void buscarProducto() {

        String filtro = vista_pedido.getTxt_buscar_producto().getText() + "%";
        DefaultTableModel estructuratabla;
        estructuratabla = (DefaultTableModel) vista_pedido.getTabla_productos().getModel();
        estructuratabla.setNumRows(0);
        List<Productos> listaproducto = modelo_pedido.busquedaProducto(filtro);

        Holder<Integer> i = new Holder<>(0);
        listaproducto.stream().forEach(produ -> {
            estructuratabla.addRow(new Object[3]);

           vista_pedido.getTabla_productos().setValueAt(produ.getPrd_ID(), i.value, 0);
            vista_pedido.getTabla_productos().setValueAt(produ.getPrd_nombre(), i.value, 1);
            vista_pedido.getTabla_productos().setValueAt(produ.getPrd_precio(), i.value, 2);
            
            i.value++;

        });
        
        

    }
      
      public void busqueda_cliente() {
       String filtro = vista_pedido.getTxt_buscar_cliente().getText() + "%";
          DefaultTableModel estructuraTabla;
        estructuraTabla = (DefaultTableModel) vista_pedido.getTabla_cliente_pedido().getModel();
        estructuraTabla.setNumRows(0);
        List<Cliente> listap = modelo_pedido.busqueda_cliente(filtro);
        i = 0;

        if (!listap.isEmpty()) {
            listap.stream().forEach(pe -> {
                estructuraTabla.addRow(new Object[4]);

                vista_pedido.getTabla_cliente_pedido().setValueAt(pe.getCl_ID(), i, 0);
                vista_pedido.getTabla_cliente_pedido().setValueAt(pe.getPrs_cedula(), i, 1);
                vista_pedido.getTabla_cliente_pedido().setValueAt(pe.getPrs_nombre1(), i, 2);
                vista_pedido.getTabla_cliente_pedido().setValueAt(pe.getPrs_apellido1(), i, 3);

                i = i + 1;

            });

        } else {
//            JOptionPane.showMessageDialog(vista_pedido, "No se encuentra el registro");
        }

    }
}
