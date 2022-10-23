package Vistas;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import Controladores.GestionControlador;
import Modelos.ConexionBD;
import Modelos.Usuario;

public class UsuarioGUI extends JFrame{
    
    private JPanel panel;
    private ConexionBD conexion;
    private JButton aceptar;
    private JButton cancelar;
    private int tipo;
    private GestionControlador gC;

    public UsuarioGUI(ConexionBD conexion, int tipo, GestionControlador gC){
        this.gC = gC;
        this.tipo = tipo;
        this.conexion = conexion;
        initFrame();
        initPanel();
        panel.revalidate();    
        pack(); 
    }

    private void initFrame(){
        panel = new JPanel(new GridBagLayout());
        setContentPane(panel);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);    
        setTitle("Nuevo Usuario");
    }

    private void initPanel(){
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);
        
        JLabel usuario = new JLabel("Nombre:");
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.EAST;
        panel.add(usuario, c);

        JTextField uField = new JTextField();
        uField.setPreferredSize(new Dimension(200, 25));
        c.gridx = 1;
        panel.add(uField, c);

        JLabel password = new JLabel("Password:");
        c.gridx = 0;
        c.gridy = 1;
        panel.add(password, c);

        JTextField pField = new JTextField();
        pField.setPreferredSize(new Dimension(200, 25));
        c.gridx = 1;
        panel.add(pField, c);

        JLabel domicilio = new JLabel("Domicilio:");
        c.gridx = 0;
        c.gridy = 2;
        panel.add(domicilio, c);

        JTextField dField = new JTextField();
        dField.setPreferredSize(new Dimension(200, 25));
        c.gridx = 1;
        panel.add(dField, c);

        JLabel fecha = new JLabel("Fecha registro:");
        c.gridx = 0;
        c.gridy = 3;
        panel.add(fecha, c);

        JTextField fField = new JTextField();
        fField.setPreferredSize(new Dimension(200, 25));
        fField.setEnabled(false);
        c.gridx = 1;
        panel.add(fField, c);

        JLabel rol = new JLabel("Rol:");
        c.gridx = 0;
        c.gridy = 4;
        panel.add(rol, c);

        JTextField rField = new JTextField();
        rField.setPreferredSize(new Dimension(200, 25));
        c.gridx = 1;
        panel.add(rField, c);

        JLabel salario = new JLabel("Salario:");
        c.gridx = 0;
        c.gridy = 5;
        panel.add(salario, c);

        JTextField sField = new JTextField();
        sField.setPreferredSize(new Dimension(200, 25));
        c.gridx = 1;
        panel.add(sField, c);

        JLabel activo = new JLabel("Activo:");
        c.gridx = 0;
        c.gridy = 6;
        panel.add(activo, c);

        JTextField aField = new JTextField();
        aField.setPreferredSize(new Dimension(200, 25));
        aField.setEnabled(false);
        c.gridx = 1;
        panel.add(aField, c);

        JPanel p = new JPanel();

        aceptar = new JButton("Aceptar");
        aceptar.addActionListener((ActionEvent e) -> {
            String nom = uField.getText();
            String pass = pField.getText();
            String dom = dField.getText();
            String ro = rField.getText();
            double sal = Double.parseDouble(sField.getText());
            Usuario u = new Usuario(nom, pass, sal, dom, ro);
            if(conexion.guardarUsuario(u)){
                gC.cargarUsuarios();    
            }    
        });
        p.add(aceptar);

        cancelar = new JButton("Cancelar");
        cancelar.addActionListener((ActionEvent e) -> {
            this.dispose();
        });
        p.add(cancelar);

        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 7;
        panel.add(p, c);
    }
}
