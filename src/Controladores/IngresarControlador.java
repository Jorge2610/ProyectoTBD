package Controladores;

import java.awt.event.ActionEvent;
import java.net.InetAddress;
import java.net.UnknownHostException;

import Modelos.ConexionBD;
import Vistas.IngresarGUI;

public class IngresarControlador {

    private IngresarGUI gui;
    private ConexionBD conexion;
    private int id_usuario;

    public IngresarControlador() {
        gui = new IngresarGUI();
        initEvents();
    }

    public void mostrarFrame() {
        gui.setLocationRelativeTo(null);
        gui.setVisible(true);
    }

    private void initEvents() {
        gui.getIngresarButton().addActionListener((ActionEvent e) -> {
            conexion = new ConexionBD();
            String usuario = gui.getNombreUsuarioField().getText();
            String password = String.valueOf(gui.getPassUsuarioField().getPassword());
            String ip = "";
            try {
                InetAddress host = InetAddress.getLocalHost();
                ip = host.getHostAddress();
            } catch (UnknownHostException e1) {
                e1.printStackTrace();
            }
            id_usuario = conexion.validarUsuario(usuario, password, ip);
            if (id_usuario != 0) {
                PrincipalControlador g = new PrincipalControlador(conexion, id_usuario, usuario);
                g.mostrarFrame();
                gui.dispose();
            }
        });
    }
}
