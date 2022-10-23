package Controladores;

import java.awt.event.ActionEvent;

import javax.swing.JPanel;

import Modelos.ConexionBD;
import Vistas.PersonalPanel;

public class PersonalControlador {
    
    private PersonalPanel interfaz;
    private ConexionBD conexion;

    public PersonalControlador(ConexionBD conexion){
        this.conexion = conexion;
        interfaz = new PersonalPanel();
        initEventos();
    }

    private void initEventos(){
        interfaz.getGestionB().addActionListener((ActionEvent e) -> {
            GestionControlador gC = new GestionControlador(conexion);
            interfaz.setPanelInferior(gC.getInterfaz());  
            interfaz.revalidate(); 
        }); 
    }

    public JPanel getInterfaz(){
        return interfaz;
    }
}
