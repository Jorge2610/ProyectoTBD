package Controladores;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import com.formdev.flatlaf.FlatDarkLaf;

import Modelos.ConexionBD;
import Vistas.PersonalPanel;
import Vistas.PrincipalGUI;
import Vistas.ProductosPanel;
import Vistas.VentasPanel;

public class PrincipalControlador {

    public static void main(String[] args) {
        FlatDarkLaf.setup();
        PrincipalControlador g = new PrincipalControlador(null, 1);
        g.mostrarFrame();
    }

    private PrincipalGUI gui;
    private ConexionBD conexion;
    private VentasPanel ventasPanel;
    private ProductosPanel productosPanel;
    private PersonalPanel personalPanel;
    private int idUsuario;
    private ArrayList<Integer> interfaces;

    public PrincipalControlador(ConexionBD c, int userId) {
        idUsuario = userId;
        conexion = c;
        ventasPanel = new VentasPanel();
        productosPanel = new ProductosPanel();
        personalPanel = new PersonalPanel();
        interfaces = conexion.obtenerInterfaces(userId);
        gui = new PrincipalGUI();
        ventasButtonEvent();
        productosButtonEvent();
        personalButtonEvent();
        salirButtonEvent();
    }

    public void mostrarFrame() {
        gui.setLocationRelativeTo(null);
        obtenerInterfaces();
        gui.setVisible(true);
        gui.setPanelContenido(ventasPanel);
    }

    private void obtenerInterfaces() {
        if (interfaces.size() == 0) {
            habilitarTodo();
        } else {
            for (int i : interfaces) {
                if (i == 1) {
                    gui.getVentasB().setEnabled(true);
                }
                if (i == 2) {
                    ventasPanel.getVentaB().setEnabled(true);
                }
                if (i == 3) {
                    ventasPanel.getClientesB().setEnabled(true);
                }
                if (i == 4) {
                    ventasPanel.getFacturaB().setEnabled(true);
                }
                if (i == 5) {
                    ventasPanel.getInformeB().setEnabled(true);
                }
                if (i == 6) {
                    productosPanel.getInventarioB().setEnabled(true);
                }
                if (i == 7) {
                    productosPanel.getPreciosB().setEnabled(true);
                }
                if (i == 8) {
                    productosPanel.getInformesB().setEnabled(true);
                }
                if (i == 9) {
                    gui.getGestionProdB().setEnabled(true);
                }
                if (i == 10) {
                    gui.getGestionPersB().setEnabled(true);
                }
                if (i == 11) {
                    personalPanel.getGestionB().setEnabled(true);
                }
                if (i == 12) {
                    personalPanel.getPlanillasB().setEnabled(true);
                }
                if (i == 13) {
                    personalPanel.getInformesB().setEnabled(true);
                }
            }
        }
    }

    private void habilitarTodo(){
        gui.getVentasB().setEnabled(true); 
        ventasPanel.getVentaB().setEnabled(true);  
        ventasPanel.getClientesB().setEnabled(true); 
        ventasPanel.getFacturaB().setEnabled(true);
        ventasPanel.getInformeB().setEnabled(true);
        productosPanel.getInventarioB().setEnabled(true);
        productosPanel.getPreciosB().setEnabled(true);
        productosPanel.getInformesB().setEnabled(true);
        gui.getGestionProdB().setEnabled(true);
        gui.getGestionPersB().setEnabled(true);
        personalPanel.getGestionB().setEnabled(true);
        personalPanel.getPlanillasB().setEnabled(true);
        personalPanel.getInformesB().setEnabled(true);
    }

    private void ventasButtonEvent() {
        gui.getVentasB().addActionListener((ActionEvent e) -> {
            ventasPanel = new VentasPanel();
            gui.setPanelContenido(ventasPanel);
            obtenerInterfaces();
        });
    }

    private void productosButtonEvent() {
        gui.getGestionProdB().addActionListener((ActionEvent e) -> {
            productosPanel = new ProductosPanel();
            gui.setPanelContenido(productosPanel);
            obtenerInterfaces();
        });
    }

    private void personalButtonEvent() {
        gui.getGestionPersB().addActionListener((ActionEvent e) -> {
            PersonalControlador pC = new PersonalControlador(conexion);
            personalPanel = (PersonalPanel) pC.getInterfaz();
            gui.setPanelContenido(personalPanel);
            obtenerInterfaces();
        });
    }

    private void salirButtonEvent() {
        gui.getSalirB().addActionListener((ActionEvent e) -> {
            conexion.eliminarSesion(idUsuario);
            conexion.cerrarConexion();
            IngresarControlador c = new IngresarControlador();
            c.mostrarFrame();
            gui.dispose();
        });
    }

}
