/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto.bemo;

import Controlador.ControlPrincipal;
import Controlador.ControladorLogin;
import VIsta.Contraseña;
import VIsta.vistamenuprincipal;

/**
 *
 * @author OWNER
 */
public class PROYECTOBEMO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        modelo.OCconection oc = new modelo.OCconection();
//        
//        oc.getConex();

        VIsta.Contraseña vistLogin = new Contraseña();
        Controlador.ControladorLogin contLogin = new ControladorLogin(vistLogin);
        contLogin.iniciaLogin();

    }

}
