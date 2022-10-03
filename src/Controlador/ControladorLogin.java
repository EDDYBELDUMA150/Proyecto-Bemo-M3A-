/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import VIsta.Contraseña;
import VIsta.vistamenuprincipal;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author OWNER
 */
public class ControladorLogin extends modelo.Usuarios {

    modelo.OCconection conn = new modelo.OCconection();
    modelo.Usuarios Musuario = new modelo.Usuarios();
    VIsta.vistamenuprincipal desktop = new vistamenuprincipal();
    Controlador.ControlPrincipal contPrin = new ControlPrincipal(desktop);
    VIsta.Contraseña login;
    String usuario;

    public ControladorLogin(Contraseña login) {
        this.login = login;
        login.setVisible(true);
        desktop.setVisible(false);
    }

    public ControladorLogin(int usuario_id, String usuario_nombre, String usuario_contra, int usuario_tipo) {
        super(usuario_id, usuario_nombre, usuario_contra, usuario_tipo);
    }

    public void iniciaLogin() {
        login.getBtIngresar().addActionListener(l -> verificarUsuario());
        login.getBtCerrarLogin().addActionListener(l -> cerrarPrograma());
        login.getTxtUsuario().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (login.getTxtUsuario().getText().equals("Ingrese su nombre de usuario")) {
                    login.getTxtUsuario().setText("");
                    login.getTxtUsuario().setForeground(Color.black);
                }
                if (login.getTxtContrase().getText().isEmpty()) {
                    login.getTxtContrase().setText("******");
                    login.getTxtContrase().setForeground(Color.gray);
                }
            }
        });
        login.getTxtContrase().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (login.getTxtContrase().getText().equals("******")) {
                    login.getTxtContrase().setText("");
                    login.getTxtContrase().setForeground(Color.black);
                }
                if (login.getTxtUsuario().getText().isEmpty()) {
                    login.getTxtUsuario().setText("Ingrese su nombre de usuario");
                    login.getTxtUsuario().setForeground(Color.gray);

                }
            }
        });
    }

//    public void verificarUsuario() {
//        if (usuarioVeriAdmin(login.getTxtUsuario().getText(), login.getTxtContrase().getText())) {
//            desktop.setName("A");
//            contPrin.iniciaControl();
//        }
//        if (usuarioVeriCajero(login.getTxtUsuario().getText(), login.getTxtContrase().getText())) {
//            desktop.setName("C");
//            contPrin.iniciaControl();
//        }
//
//    }

    public void verificarUsuario() {
        if (usuarioVeriAdmin(login.getTxtUsuario().getText(), login.getTxtContrase().getText())) {
            login.dispose();
            desktop.setName("A");
            contPrin.iniciaControl();
            desktop.setVisible(true);
            desktop.getBtUsuario().setText(usuario);
        } else {
            if (usuarioVeriCajero(login.getTxtUsuario().getText(), login.getTxtContrase().getText())) {
                desktop.setName("C");
                contPrin.iniciaControl();
            } else {
                JOptionPane.showMessageDialog(null, "Usuario o contraseña invalido");
            }
        }
    }
    
    public boolean usuarioVeriAdmin(String user, String contra) {
        boolean resultado = true;
        try {
            String sql = "SELECT * FROM  usuarios WHERE usu_nombre='" + user + "' AND use_password='" + contra + "' AND use_tipo_user=1";
            Statement query = conn.conex.createStatement();
            ResultSet rs = query.executeQuery(sql);
            if (rs.next()) {
                resultado = true;
            } else {
                resultado = false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControladorLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(String.valueOf(resultado));
        usuario = user;
        return resultado;
    }

    public boolean usuarioVeriCajero(String user, String contra) {
        boolean resultado = true;
        String sql = "SELECT * FROM  usuarios WHERE usu_nombre='" + user + "' AND use_password='" + contra + "' AND use_tipo_user=2";

        ResultSet rs = conn.consulta(sql);
        try {
            if (rs.next()) {
                resultado = true;
            } else {
                resultado = false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControladorLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        usuario = user;
        return resultado;
    }

    private void cerrarPrograma() {
        desktop.dispose();
        login.dispose();
    }
}
