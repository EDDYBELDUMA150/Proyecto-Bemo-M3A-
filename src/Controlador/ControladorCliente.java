/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import VIsta.vistacliente;

import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.xml.ws.Holder;
import modelo.Cliente;
import modelo.MConexion.Modelocliente;
import modelo.Validaciones;
//import modelo.Modelocliente;
//import vistas.vistacliente;

/**
 *
 * @author Abel Gomez
 */
public class ControladorCliente {

    private Modelocliente modelo;
    private vistacliente vista;
    Validaciones validar = new Validaciones();

    public ControladorCliente(Modelocliente modelo, vistacliente vista) {
        this.modelo = modelo;
        this.vista = vista;
        vista.setVisible(true);
    }

    public ControladorCliente() {
    }

    public void iniciarcontrol() {

        cargardatos();
        vista.getBtncargardatos().addActionListener(l -> cargardatos());
        vista.getBtnagregar().addActionListener(l -> abrirDialogo(1));
        vista.getBrnmodificar().addActionListener(l -> abrirDialogo(2));
        vista.getBtncancelar().addActionListener(l -> btncancelar());
        vista.getBtnagregar1().addActionListener(l -> crearEditarcliente());
        vista.getBtneleminar().addActionListener(l -> eleiminarcliente());
        vista.getBtnlimpiar().addActionListener(l -> limpiardatos());
        vista.getTxtbuscarcliente().addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent ke) {

                buscar();
            }

        });

    }

    public void cargardatos() {

        //  vista.getTablaclientes().setDefaultRenderer(Object.class, new ImagenTabla());
        // vista.getTablaclientes().setRowHeight(100);
        DefaultTableModel estructuratabla;
        estructuratabla = (DefaultTableModel) vista.getTablaclientes().getModel();
        estructuratabla.setNumRows(0);
        List<Cliente> listaclientes = modelo.getclientes();

        Holder<Integer> i = new Holder<>(0);
        listaclientes.stream().forEach(cliente -> {
            estructuratabla.addRow(new Object[9]);

            vista.getTablaclientes().setValueAt(cliente.getPrs_ID(), i.value, 0);
            vista.getTablaclientes().setValueAt(cliente.getPrs_cedula(), i.value, 1);
            vista.getTablaclientes().setValueAt(cliente.getPrs_nombre1(), i.value, 2);
            vista.getTablaclientes().setValueAt(cliente.getPrs_nombre2(), i.value, 3);
            vista.getTablaclientes().setValueAt(cliente.getPrs_apellido1(), i.value, 4);
            vista.getTablaclientes().setValueAt(cliente.getPrs_apellido2(), i.value, 5);
            vista.getTablaclientes().setValueAt(cliente.getPrs_direccion(), i.value, 6);
            vista.getTablaclientes().setValueAt(cliente.getPrs_telefono(), i.value, 7);
            vista.getTablaclientes().setValueAt(cliente.getPrs_email(), i.value, 8);

            i.value++;

        });

    }

    public void abrirDialogo(int ope) {
        String titulo;
        if (ope == 1) {
            limpiardatos();
            titulo = "Crear Persona";
            vista.getBtnagregar1().setText("Agregar");
            vista.getLbtitulo().setText("Crear Cliente");
            //   vista.getTxtidpersona().setEnabled(true);
            vista.getDialogclientes().setName("C");
            vista.getDialogclientes().setVisible(true);
            vista.getDialogclientes().setTitle(titulo);
            vista.getDialogclientes().setSize(750, 700);
            vista.getDialogclientes().setLocationRelativeTo(vista);
            vista.getTxtidcliente().setText(String.valueOf(modelo.numeroidperona() + 1));
            vista.getTxtidcliente().setEnabled(false);

        } else {

            titulo = "Editar Persona";
            vista.getLbtitulo().setText("Editar Cliente");

            vista.getTxtidcliente().setEnabled(false);
            vista.getDialogclientes().setName("E");

            seleccionarfila();
            vista.getBtnagregar1().setText("Actualizar");
            //vista.getDlgPersona().setVisible(false);
            vista.getDialogclientes().setTitle(titulo);
            vista.getDialogclientes().setSize(750, 700);
            vista.getDialogclientes().setLocationRelativeTo(vista);
            //   vista.getDialogclientes().setVisible(true);

        }
        //   vista.getDlgPersona().setTitle(titulo);
        // vista.getJdCliente().setSize(750, 700);
        // vista.getJdCliente().setLocationRelativeTo(vista);
    }

    public void btncancelar() {
        vista.getDialogclientes().setVisible(false);

    }

    private void crearEditarcliente() {
        int idperona = 0;
        int idcliente = 0;
        if (vista.getDialogclientes().getName().contentEquals("C")) {

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
            String nombre1 = vista.getTxtnombre().getText().toUpperCase().trim();
            String nombre2 = vista.getTxtsegundonombre().getText().toUpperCase().trim();
            String apellido1 = vista.getTxtapellido().getText().toUpperCase().trim();
            String apellido2 = vista.getTxtsegundoapellido().getText().toUpperCase().trim();
            String telefono = vista.getTxttelefono().getText();
            String direccion = vista.getTxtdireccion().getText().toUpperCase();
            String email = vista.getTxtemail().getText();

            Modelocliente clienteP = new Modelocliente();

            clienteP.setPrs_ID(idperona);

            clienteP.setPrs_cedula(cedula);
            clienteP.setPrs_nombre1(nombre1);
            clienteP.setPrs_nombre2(nombre2);
            clienteP.setPrs_apellido1(apellido1);
            clienteP.setPrs_apellido2(apellido2);
            clienteP.setPrs_direccion(direccion);
            clienteP.setPrs_telefono(telefono);
            clienteP.setPrs_email(email);
            clienteP.setCl_ID(idperona);

            if (espacios_vacios() == true) {
                if (validado() == true) {
                    if (clienteP.setpersona() && clienteP.setcliente()) {
                        JOptionPane.showMessageDialog(vista, "Cliente registrada exitosamente");
                        vista.setVisible(true);
                        vista.getDialogclientes().setVisible(false);
                        cargardatos();

                    } else {
                        JOptionPane.showMessageDialog(vista, "fallo  en Guardar Cliente");

                    }

                }

            }

//            if (validado() == true ) {
//                if (clienteP.setpersona() && clienteP.setcliente()) {
//                    JOptionPane.showMessageDialog(vista, "Cliente registrada exitosamente");
//                    vista.setVisible(true);
//                    vista.getDialogclientes().setVisible(false);
//                    cargardatos();
//
//                } else {
//                    JOptionPane.showMessageDialog(vista, "fallo  en Guardar Cliente");
//
//                }
//
//            }
        }//
        else {
            int respuesta = JOptionPane.showConfirmDialog(vista, "Seguro Desea Actualizar este Registro?");

            if (respuesta == JOptionPane.YES_OPTION) {
                if (vista.getDialogclientes().getName().contentEquals("E")) {

                    int id = Integer.valueOf(vista.getTxtidcliente().getText());
                    String cedula = vista.getTxtcedula().getText();
                    String nombre1 = vista.getTxtnombre().getText().toUpperCase().trim();
                    String nombre2 = vista.getTxtsegundonombre().getText().toUpperCase().trim();
                    String apellido1 = vista.getTxtapellido().getText().toUpperCase().trim();
                    String apellido2 = vista.getTxtsegundoapellido().getText().toUpperCase().trim();
                    String telefono = vista.getTxttelefono().getText();
                    String direccion = vista.getTxtdireccion().getText();
                    String email = vista.getTxtemail().getText();

                    Modelocliente clienteP = new Modelocliente();

                    clienteP.setPrs_ID(id);

                    clienteP.setPrs_cedula(cedula);
                    clienteP.setPrs_nombre1(nombre1);
                    clienteP.setPrs_nombre2(nombre2);
                    clienteP.setPrs_apellido1(apellido1);
                    clienteP.setPrs_apellido2(apellido2);
                    clienteP.setPrs_direccion(direccion);
                    clienteP.setPrs_telefono(telefono);
                    clienteP.setPrs_email(email);
                    clienteP.setCl_ID(idcliente);

                    if (espacios_vacios() == true) {
                        if (validado() == true) {
                            if (clienteP.updatecliente()) {

                                JOptionPane.showMessageDialog(vista, "Cliente Actualizada");
                                limpiardatos();

                                cargardatos();

                                vista.getDialogclientes().setVisible(false);

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
        Date fechatxt = null;
        try {

            int fila = vista.getTablaclientes().getSelectedRow();

            if (fila >= 0) {
                vista.getTxtidcliente().setText(vista.getTablaclientes().getValueAt(fila, 0).toString());
                vista.getTxtcedula().setText(vista.getTablaclientes().getValueAt(fila, 1).toString());
                vista.getTxtnombre().setText(vista.getTablaclientes().getValueAt(fila, 2).toString());
                vista.getTxtsegundonombre().setText(vista.getTablaclientes().getValueAt(fila, 3).toString());
                vista.getTxtapellido().setText(vista.getTablaclientes().getValueAt(fila, 4).toString());
                vista.getTxtsegundoapellido().setText(vista.getTablaclientes().getValueAt(fila, 5).toString());
                vista.getTxtdireccion().setText(vista.getTablaclientes().getValueAt(fila, 6).toString());
                vista.getTxttelefono().setText(vista.getTablaclientes().getValueAt(fila, 7).toString());
                vista.getTxtemail().setText(vista.getTablaclientes().getValueAt(fila, 8).toString());
                vista.getDialogclientes().setVisible(true);

            } else {
                JOptionPane.showMessageDialog(null, "Fila no seleccionada");
                vista.getDialogclientes().setVisible(false);

            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error: " + e.toString());
        }

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

    }

    public void eleiminarcliente() {

        int idpersona = 0;
        try {
            int fila = vista.getTablaclientes().getSelectedRow();

            if (fila >= 0) {
                int respuesta = JOptionPane.showConfirmDialog(vista, "Seguro Desea Eliminar este Registro?");
                if (respuesta == JOptionPane.YES_OPTION) {

                    idpersona = Integer.valueOf(vista.getTablaclientes().getValueAt(fila, 0).toString());

                    Modelocliente persona = new Modelocliente();
                    persona.setPrs_ID(idpersona);

                    if (persona.removepersona()) {

                        JOptionPane.showMessageDialog(vista, "Dato Eliminado");
                        limpiardatos();
                        cargardatos();
                        vista.getDialogclientes().setVisible(false);

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

        String filtro = vista.getTxtbuscarcliente().getText() + "%";
        DefaultTableModel estructuratabla;
        estructuratabla = (DefaultTableModel) vista.getTablaclientes().getModel();
        estructuratabla.setNumRows(0);
        List<Cliente> listaclientes = modelo.buscarcliente(filtro);

        Holder<Integer> i = new Holder<>(0);
        listaclientes.stream().forEach(cliente -> {
            estructuratabla.addRow(new Object[9]);

            vista.getTablaclientes().setValueAt(cliente.getPrs_ID(), i.value, 0);
            vista.getTablaclientes().setValueAt(cliente.getPrs_cedula(), i.value, 1);
            vista.getTablaclientes().setValueAt(cliente.getPrs_nombre1(), i.value, 2);
            vista.getTablaclientes().setValueAt(cliente.getPrs_nombre2(), i.value, 3);
            vista.getTablaclientes().setValueAt(cliente.getPrs_apellido1(), i.value, 4);
            vista.getTablaclientes().setValueAt(cliente.getPrs_apellido2(), i.value, 5);
            vista.getTablaclientes().setValueAt(cliente.getPrs_direccion(), i.value, 6);
            vista.getTablaclientes().setValueAt(cliente.getPrs_telefono(), i.value, 7);
            vista.getTablaclientes().setValueAt(cliente.getPrs_email(), i.value, 8);

            i.value++;

        });

    }

    public boolean validado() {
        boolean vali = true;

        if (!validar.Validarcedula(vista.getTxtcedula().getText()) || (vista.getTxtcedula().getText().length() < 10) || (vista.getTxtcedula().getText().length() > 10)) {
                 
          JOptionPane.showMessageDialog(null, "Cedula Invalida");
            vali = false;

        }
        if (!validar.Validarnombreapellido(vista.getTxtnombre().getText())) {
            JOptionPane.showMessageDialog(null, "No se permiten Espacios entre letras");
            vali = false;

        }
        if (!validar.Validarnombreapellido(vista.getTxtapellido().getText())) {
            JOptionPane.showMessageDialog(null, "No se permiten Espacios entrre letras");
            vali = false;

        }
        if (!validar.Validarcorreo(vista.getTxtemail().getText())) {
            JOptionPane.showMessageDialog(null, "Correo  Invalido ");
            vali = false;

        }
        if (!validar.validartelefono(vista.getTxttelefono().getText())) {
            JOptionPane.showMessageDialog(null, "Numero de Telefono  Invalido, maximo  10 numeros");
            vali = false;

        }

        return vali;

    }

    public boolean espacios_vacios() {

        boolean espacio = true;

        if (vista.getTxtcedula().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campo Cedula  Vacio");

            espacio = false;
        }
        if (vista.getTxtnombre().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campo Primer Nombre  Vacio");

            espacio = false;
        }
        if (vista.getTxtapellido().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campo Primer Apellido  Vacio");

            espacio = false;
        }
        if (vista.getTxttelefono().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campo Telefono o Celular Vacio");

            espacio = false;
        }
        if (vista.getTxtdireccion().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campo Direccion  Vacio");

            espacio = false;
        }
        if (vista.getTxtemail().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campo Email  Vacio");

            espacio = false;
        }
        return espacio;

    }

}
