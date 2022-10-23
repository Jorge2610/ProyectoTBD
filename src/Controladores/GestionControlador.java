package Controladores;

import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JPanel;

import Modelos.ConexionBD;
import Vistas.GestionGUI;
import Vistas.UsuarioGUI;

public class GestionControlador {

    private GestionGUI interfaz;
    private ConexionBD conexion;

    public GestionControlador(ConexionBD conexion){
        this.conexion = conexion;
        interfaz = new GestionGUI();
        cargarUsuarios();
        eventos();
    }

    public void cargarUsuarios(){
        ResultSet rs = conexion.getUsuarios();
        interfaz.getDatos().setRowCount(0);
        try {
            while(rs.next()){
                interfaz.getDatos().addRow(new Object[]{rs.getInt(1), rs.getString(2), rs.getString(3),
                    rs.getString(4), rs.getString(6), rs.getDouble(7), rs.getBoolean(8)});    
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }    
    }

    public JPanel getInterfaz(){
        return interfaz;
    }

    private void eventos(){
        interfaz.getNuevo().addActionListener((ActionEvent e) -> {
            UsuarioGUI uG = new UsuarioGUI(conexion, 0, this);
            uG.setLocationRelativeTo(interfaz);
            uG.setVisible(true);        
        });

        interfaz.getBorrar().addActionListener((ActionEvent e) -> {
            conexion.borrarUsuario((int)interfaz.getDatos().getValueAt(interfaz.getTable().getSelectedRow(), 0));
            cargarUsuarios();
        });
    }

}
