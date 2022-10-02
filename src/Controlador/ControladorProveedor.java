/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import VIsta.VistaProveedor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.xml.ws.Holder;
import modelo.Cliente;
import modelo.MConexion.ModeloProveedor;
//import modelo.ModeloProveedor;
//import modelo.Modelocliente;
import modelo.Proveedor;
import modelo.Validaciones;
//import vistas.VistaProveedor;

/**
 *
 * @author Abel Gomez
 */
public class ControladorProveedor {

    private ModeloProveedor modelo;
    private VistaProveedor vista;
    Validaciones validar = new Validaciones();

    public ControladorProveedor(ModeloProveedor modelo, VistaProveedor vista) {
        this.modelo = modelo;
        this.vista = vista;
        vista.setVisible(true);
    }

    public void iniciarcontrol() {

        cargardatos();
        vista.getBtnactualzartabla().addActionListener(l -> cargardatos());
        vista.getBtnagregar().addActionListener(l -> abrirDialogo(1));
        vista.getBtnmodificar().addActionListener(l -> abrirDialogo(2));
        vista.getBtncancelar().addActionListener(l -> btncancelar());
        vista.getBtnagregar1().addActionListener(l -> crearEditarproveedor());
        vista.getBtneleminar().addActionListener(l -> eleiminarprovvedor());
        vista.getBtnlimpiar().addActionListener(l -> limpiardatos());
        vista.getTxtbuscarproveedor().addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent ke) {

                buscar();
            }

        });

        vista.getTxtcedula().addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();
                if (vista.getTxtcedula().getText().length() == 10 || (caracter < '0') || (caracter > '9')) {
                    e.consume();
                }

            }

        });

        vista.getTxtnombre().addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (vista.getTxtnombre().getText().length() == 20 || ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z'))) {
                    e.consume();
                }

            }

        });
        vista.getTxtsegundonombre().addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (vista.getTxtsegundonombre().getText().length() == 20 || ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z'))) {
                    e.consume();
                }

            }

        });

        vista.getTxtapellido().addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (vista.getTxtapellido().getText().length() == 20 || ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z'))) {
                    e.consume();
                }

            }

        });
        vista.getTxtsegundoapellido().addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (vista.getTxtsegundoapellido().getText().length() == 20 || ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z'))) {
                    e.consume();
                }

            }

        });
        vista.getTxttelefono().addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();
                if (vista.getTxttelefono().getText().length() == 10 || (caracter < '0') || (caracter > '9')) {
                    e.consume();
                }

            }

        });

    }

    public void cargardatos() {

        //  vista.getTablaclientes().setDefaultRenderer(Object.class, new ImagenTabla());
        // vista.getTablaclientes().setRowHeight(100);
        DefaultTableModel estructuratabla;
        estructuratabla = (DefaultTableModel) vista.getTablaproveedores().getModel();
        estructuratabla.setNumRows(0);
        List<Proveedor> listaproveedores = modelo.getproveedor();

        Holder<Integer> i = new Holder<>(0);
        listaproveedores.stream().forEach(proveddor -> {
            estructuratabla.addRow(new Object[10]);

            vista.getTablaproveedores().setValueAt(proveddor.getPrs_ID(), i.value, 0);

            vista.getTablaproveedores().setValueAt(proveddor.getPrs_cedula(), i.value, 1);
            vista.getTablaproveedores().setValueAt(proveddor.getPrs_nombre1(), i.value, 2);
            vista.getTablaproveedores().setValueAt(proveddor.getPrs_nombre2(), i.value, 3);
            vista.getTablaproveedores().setValueAt(proveddor.getPrs_apellido1(), i.value, 4);
            vista.getTablaproveedores().setValueAt(proveddor.getPrs_apellido2(), i.value, 5);
            vista.getTablaproveedores().setValueAt(proveddor.getPrs_direccion(), i.value, 6);
            vista.getTablaproveedores().setValueAt(proveddor.getPrs_telefono(), i.value, 7);
            vista.getTablaproveedores().setValueAt(proveddor.getPrs_email(), i.value, 8);
            vista.getTablaproveedores().setValueAt(proveddor.getPrv_empresa(), i.value, 9);

            i.value++;

        });

    }

    public void abrirDialogo(int ope) {
        String titulo;
        if (ope == 1) {
            limpiardatos();
            titulo = "Crear Proveedor";
            vista.getLbtitulo().setText("Crear Proveedor");
            //   vista.getTxtidpersona().setEnabled(true);
            vista.getJdialogproveedor().setName("C");
            vista.getJdialogproveedor().setVisible(true);
            vista.getJdialogproveedor().setTitle(titulo);
            vista.getJdialogproveedor().setSize(900, 850);
            vista.getJdialogproveedor().setLocationRelativeTo(vista);
            vista.getTxtidproveedor().setText(String.valueOf(modelo.numeroidperona() + 1));
            vista.getTxtidproveedor().setEnabled(false);

        } else {

            titulo = "Editar Proveedor";
            vista.getLbtitulo().setText("Editar Proveedor");

            vista.getTxtidproveedor().setEnabled(false);
            vista.getJdialogproveedor().setName("E");

            seleccionarfila();
            //vista.getDlgPersona().setVisible(false);
            vista.getJdialogproveedor().setTitle(titulo);
            vista.getJdialogproveedor().setSize(900, 850);
            vista.getJdialogproveedor().setLocationRelativeTo(vista);
            // vista.getJdialogproveedor().setVisible(true);

        }
        //   vista.getDlgPersona().setTitle(titulo);
        // vista.getJdCliente().setSize(750, 700);
        // vista.getJdCliente().setLocationRelativeTo(vista);
    }

    public void btncancelar() {
        vista.getJdialogproveedor().setVisible(false);

    }

    private void crearEditarproveedor() {

        int idperona = 0;
        // int idcliente = 0;
        if (vista.getJdialogproveedor().getName().contentEquals("C")) {

            if (modelo.numeroidperona() == 0) {
                idperona = 1;
            } else {
                idperona = modelo.numeroidperona() + 1;
            }
//            if (modelo.numeroidclinte() == 0) {
//
//                idcliente = 1;
//
//            } else {
//
//                idcliente = modelo.numeroidclinte() + 1;
//            }

            String cedula = vista.getTxtcedula().getText();
            String nombre1 = vista.getTxtnombre().getText();
            String nombre2 = vista.getTxtsegundonombre().getText();
            String apellido1 = vista.getTxtapellido().getText();
            String apellido2 = vista.getTxtsegundoapellido().getText();
            String telefono = vista.getTxttelefono().getText();
            String direccion = vista.getTxtdireccion().getText();
            String email = vista.getTxtemail().getText();
            String nombreempresa = vista.getTxtnombreempresa().getText();

            ModeloProveedor proveedor = new ModeloProveedor();

            proveedor.setPrs_ID(idperona);

            proveedor.setPrs_cedula(cedula);
            proveedor.setPrs_nombre1(nombre1);
            proveedor.setPrs_nombre2(nombre2);
            proveedor.setPrs_apellido1(apellido1);
            proveedor.setPrs_apellido2(apellido2);
            proveedor.setPrs_direccion(direccion);
            proveedor.setPrs_telefono(telefono);
            proveedor.setPrs_email(email);
            proveedor.setPrv_ID(idperona);
            proveedor.setPrv_empresa(nombreempresa);

            if (espacios_vacios() == true) {
                if (validado() == true) {
                    if (proveedor.setpersona() && proveedor.setproveedor()) {
                        JOptionPane.showMessageDialog(vista, "Proveedor registrado exitosamente");
                        vista.setVisible(true);
                        vista.getJdialogproveedor().setVisible(false);
                        cargardatos();
                        limpiardatos();

                    } else {
                        JOptionPane.showMessageDialog(vista, "fallo persona");

                    }

                }

            }

        }//
        else {
            int respuesta = JOptionPane.showConfirmDialog(vista, "Seguro Desea Actualizar este Registro?");

            if (respuesta == JOptionPane.YES_OPTION) {
                if (vista.getJdialogproveedor().getName().contentEquals("E")) {
                    int id = Integer.valueOf(vista.getTxtidproveedor().getText());
                    String cedula = vista.getTxtcedula().getText();
                    String nombre1 = vista.getTxtnombre().getText();
                    String nombre2 = vista.getTxtsegundonombre().getText();
                    String apellido1 = vista.getTxtapellido().getText();
                    String apellido2 = vista.getTxtsegundoapellido().getText();
                    String telefono = vista.getTxttelefono().getText();
                    String direccion = vista.getTxtdireccion().getText();
                    String email = vista.getTxtemail().getText();
                    String nombreempresa = vista.getTxtnombreempresa().getText();

                    ModeloProveedor proveedor = new ModeloProveedor();

                    proveedor.setPrs_ID(id);

                    proveedor.setPrs_cedula(cedula);
                    proveedor.setPrs_nombre1(nombre1);
                    proveedor.setPrs_nombre2(nombre2);
                    proveedor.setPrs_apellido1(apellido1);
                    proveedor.setPrs_apellido2(apellido2);
                    proveedor.setPrs_direccion(direccion);
                    proveedor.setPrs_telefono(telefono);
                    proveedor.setPrs_email(email);
                    proveedor.setPrv_ID(id);
                    proveedor.setPrv_empresa(nombreempresa);
                    if (espacios_vacios() == true) {
                        if (validado() == true) {
                            if (proveedor.updatepersonaprovee() && proveedor.updateprovedor()) {

                                JOptionPane.showMessageDialog(vista, "Proveedor Actualizada");
                                limpiardatos();

                                cargardatos();

                                vista.getJdialogproveedor().setVisible(false);

                            } else {
                                JOptionPane.showMessageDialog(vista, "Error , datos No Actualizados");
                                //   JOptionPane.showConfirmDialog(vista, "Error , datos No guardados");
                            }

                        }

                    }

                }

            }
        }

    }

    public void seleccionarfila() {

        // SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy-MM-dd");
        try {

            int fila = vista.getTablaproveedores().getSelectedRow();

            if (fila >= 0) {
//                vista.getTxtidproveedor().setText(vista.getTablaproveedores().getValueAt(fila, 0).toString());
//                vista.getTxtcedula().setText(vista.getTablaproveedores().getValueAt(fila, 1).toString());
//                vista.getTxtnombre().setText(vista.getTablaproveedores().getValueAt(fila, 2).toString());
//                vista.getTxtsegundonombre().setText(vista.getTablaproveedores().getValueAt(fila, 3).toString());
//                vista.getTxtapellido().setText(vista.getTablaproveedores().getValueAt(fila, 4).toString());
//                vista.getTxtsegundoapellido().setText(vista.getTablaproveedores().getValueAt(fila, 5).toString());
//                vista.getTxtdireccion().setText(vista.getTablaproveedores().getValueAt(fila, 6).toString());
//                vista.getTxttelefono().setText(vista.getTablaproveedores().getValueAt(fila, 7).toString());
//                vista.getTxtemail().setText(vista.getTablaproveedores().getValueAt(fila, 8).toString());
//                vista.getTxtnombreempresa().setText(vista.getTablaproveedores().getValueAt(fila, 9).toString());

                vista.getTxtidproveedor().setText(vista.getTablaproveedores().getValueAt(fila, 0).toString());
                vista.getTxtcedula().setText(vista.getTablaproveedores().getValueAt(fila, 1).toString());
                vista.getTxtnombre().setText(vista.getTablaproveedores().getValueAt(fila, 2).toString());

                if (vista.getTablaproveedores().getValueAt(fila, 3) == null) {
                    vista.getTxtsegundonombre().setText("");
                } else {
                    vista.getTxtsegundonombre().setText(vista.getTablaproveedores().getValueAt(fila, 3).toString());
                }

                vista.getTxtapellido().setText(vista.getTablaproveedores().getValueAt(fila, 4).toString());

                if (vista.getTablaproveedores().getValueAt(fila, 5) == null) {
                    vista.getTxtsegundoapellido().setText("");

                } else {
                    vista.getTxtsegundoapellido().setText(vista.getTablaproveedores().getValueAt(fila, 5).toString());

                }
                if (vista.getTablaproveedores().getValueAt(fila, 6) == null) {
                    vista.getTxtdireccion().setText("");
                } else {
                    vista.getTxtdireccion().setText(vista.getTablaproveedores().getValueAt(fila, 6).toString());
                }

                vista.getTxttelefono().setText(vista.getTablaproveedores().getValueAt(fila, 7).toString());

                if (vista.getTablaproveedores().getValueAt(fila, 8) == null) {
                    vista.getTxtemail().setText("");
                } else {
                    vista.getTxtemail().setText(vista.getTablaproveedores().getValueAt(fila, 8).toString());
                }
                
                if (vista.getTablaproveedores().getValueAt(fila, 9)==null) {
                    vista.getTxtnombreempresa().setText("");
                }else{
                     vista.getTxtnombreempresa().setText(vista.getTablaproveedores().getValueAt(fila, 9).toString());
                }
               
                vista.getJdialogproveedor().setVisible(true);

            } else {
                JOptionPane.showMessageDialog(null, "Fila no seleccionada");
                vista.getJdialogproveedor().setVisible(false);

            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error: " + e.toString());
        }

    }

    public void eleiminarprovvedor() {

        int idpersona = 0;
        try {
            int fila = vista.getTablaproveedores().getSelectedRow();

            if (fila >= 0) {
                int respuesta = JOptionPane.showConfirmDialog(vista, "Seguro Desea Eliminar este Registro?");
                if (respuesta == JOptionPane.YES_OPTION) {

                    idpersona = Integer.valueOf(vista.getTablaproveedores().getValueAt(fila, 0).toString());

                    ModeloProveedor proveedor = new ModeloProveedor();
                    proveedor.setPrs_ID(idpersona);

                    if (proveedor.removepersona()) {

                        JOptionPane.showMessageDialog(vista, "Dato Eliminado");
                        limpiardatos();
                        cargardatos();
                        vista.getJdialogproveedor().setVisible(false);

                    } else {
                        JOptionPane.showMessageDialog(vista, "Error , dato no eliminado");

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

    public void buscar() {

        String filtro = vista.getTxtbuscarproveedor().getText() + "%";
        DefaultTableModel estructuratabla;
        estructuratabla = (DefaultTableModel) vista.getTablaproveedores().getModel();
        estructuratabla.setNumRows(0);
        List<Proveedor> listaproveedores = modelo.buscarproveedor(filtro);

        Holder<Integer> i = new Holder<>(0);
        listaproveedores.stream().forEach(proveddor -> {
            estructuratabla.addRow(new Object[10]);

            vista.getTablaproveedores().setValueAt(proveddor.getPrs_ID(), i.value, 0);

            vista.getTablaproveedores().setValueAt(proveddor.getPrs_cedula(), i.value, 1);
            vista.getTablaproveedores().setValueAt(proveddor.getPrs_nombre1(), i.value, 2);
            vista.getTablaproveedores().setValueAt(proveddor.getPrs_nombre2(), i.value, 3);
            vista.getTablaproveedores().setValueAt(proveddor.getPrs_apellido1(), i.value, 4);
            vista.getTablaproveedores().setValueAt(proveddor.getPrs_apellido2(), i.value, 5);
            vista.getTablaproveedores().setValueAt(proveddor.getPrs_direccion(), i.value, 6);
            vista.getTablaproveedores().setValueAt(proveddor.getPrs_telefono(), i.value, 7);
            vista.getTablaproveedores().setValueAt(proveddor.getPrs_email(), i.value, 8);
            vista.getTablaproveedores().setValueAt(proveddor.getPrv_empresa(), i.value, 9);

            i.value++;

        });

    }

    public void limpiardatos() {

        //  vista.getTxtidcliente().setText("");
        vista.getTxtcedula().setText("");
        vista.getTxtnombre().setText("");
        vista.getTxtsegundonombre().setText("");
        vista.getTxtapellido().setText("");
        vista.getTxtsegundoapellido().setText("");
        vista.getTxtdireccion().setText("");
        vista.getTxttelefono().setText("");
        vista.getTxtemail().setText("");
        vista.getTxtnombreempresa().setText("");
        vista.getLbodatoovligatoriocedula().setText("");
        vista.getLbodatoovligatorionombre().setText("");
        vista.getLbodatoovligatorioapellido1().setText("");
        vista.getLbodatoovligatoriocelular().setText("");

    }

    public boolean validado() {
        boolean vali = true;

        if (!validar.Validarcedula(vista.getTxtcedula().getText()) || (vista.getTxtcedula().getText().length() < 10) || (vista.getTxtcedula().getText().length() > 10)) {
            JOptionPane.showMessageDialog(null, "Cedula Invalida ");
            vali = false;

        }
//        if (!validar.Validarnombreapellido(vista.getTxtnombre().getText()) || !validar.Validarnombreapellido(vista.getTxtsegundonombre().getText())) {
//            JOptionPane.showMessageDialog(null, "El Nombre debe comensar con Una letra Mayuscula, No se permiten Espacios");
//            vali = false;
//
//        }
//        if (!validar.Validarnombreapellido(vista.getTxtapellido().getText()) || !validar.Validarnombreapellido(vista.getTxtsegundoapellido().getText())) {
//            JOptionPane.showMessageDialog(null, "El Apellido debe comensar con Una letra Mayuscula, No se permiten Espacios");
//            vali = false;
//
//        }
        if (!vista.getTxtemail().getText().isEmpty()) {
            if (!validar.Validarcorreo(vista.getTxtemail().getText())) {
                JOptionPane.showMessageDialog(null, "Correo  Invalido ");
                vali = false;

            }

        }
        if (!validar.validartelefono(vista.getTxttelefono().getText())) {
            JOptionPane.showMessageDialog(null, "Numero de Telefono  Invalido, maximo  10 numeros");
            vali = false;

        }

        return vali;

    }

    public boolean espacios_vacios() {
        int c = 0;
        boolean espacio = true;
//
//        if (vista.getTxtcedula().getText().isEmpty()) {
//            JOptionPane.showMessageDialog(null, "Campo Cedula  Vacio");
//
//            espacio = false;
//        }
//        if (vista.getTxtnombre().getText().isEmpty()) {
//            JOptionPane.showMessageDialog(null, "Campo Primer Nombre  Vacio");
//
//            espacio = false;
//        }
//        if (vista.getTxtsegundonombre().getText().isEmpty()) {
//            JOptionPane.showMessageDialog(null, "Campo Segundo Nombre  Vacio");
//
//            espacio = false;
//        }
//        if (vista.getTxtapellido().getText().isEmpty()) {
//            JOptionPane.showMessageDialog(null, "Campo Primer Apellido  Vacio");
//
//            espacio = false;
//        }
//        if (vista.getTxtsegundoapellido().getText().isEmpty()) {
//            JOptionPane.showMessageDialog(null, "Campo Segundo Apellido  Vacio");
//
//            espacio = false;
//        }
//        if (vista.getTxttelefono().getText().isEmpty()) {
//            JOptionPane.showMessageDialog(null, "Campo Telefono o Celular Vacio");
//
//            espacio = false;
//        }
//        if (vista.getTxtdireccion().getText().isEmpty()) {
//            JOptionPane.showMessageDialog(null, "Campo Direccion  Vacio");
//
//            espacio = false;
//        }
//        if (vista.getTxtemail().getText().isEmpty()) {
//            JOptionPane.showMessageDialog(null, "Campo Email  Vacio");
//
//            espacio = false;
//        }
//        if (vista.getTxtnombreempresa().getText().isEmpty()) {
//            JOptionPane.showMessageDialog(null, "Campo  Nombre Empresa Vacio");
//
//            espacio = false;
//        }

        if (vista.getTxtcedula().getText().isEmpty()) {
            //  JOptionPane.showMessageDialog(null, "Campo Cedula  Vacio");
            c += 1;
            vista.getLbodatoovligatoriocedula().setText("*");

            espacio = false;
        } else {
            vista.getLbodatoovligatoriocedula().setText("");

        }
        if (vista.getTxtnombre().getText().isEmpty()) {
            //JOptionPane.showMessageDialog(null, "Campo Primer Nombre  Vacio");
            c += 1;
            vista.getLbodatoovligatorionombre().setText("*");
            espacio = false;
        } else {
            vista.getLbodatoovligatorionombre().setText("");
        }
        if (vista.getTxtapellido().getText().isEmpty()) {
            //  JOptionPane.showMessageDialog(null, "Campo Primer Apellido  Vacio");
            c += 1;
            vista.getLbodatoovligatorioapellido1().setText("*");
            espacio = false;
        } else {

            vista.getLbodatoovligatorioapellido1().setText("");
        }
        if (vista.getTxttelefono().getText().isEmpty()) {
            // JOptionPane.showMessageDialog(null, "Campo Telefono o Celular Vacio");
            c += 1;
            vista.getLbodatoovligatoriocelular().setText("*");
            espacio = false;
        } else {
            vista.getLbodatoovligatoriocelular().setText("");

        }
//        if (vista.getTxtdireccion().getText().isEmpty()) {
//            //  JOptionPane.showMessageDialog(null, "Campo Direccion  Vacio");
//            c += 1;
//            espacio = false;
//        }
//        if (vista.getTxtemail().getText().isEmpty()) {
//            // JOptionPane.showMessageDialog(null, "Campo Email  Vacio");
//            c += 1;
//            espacio = false;
//        }
        if (c > 0) {
            JOptionPane.showMessageDialog(null, "*  campos Obligatorios.");
        }
        return espacio;

    }

}
