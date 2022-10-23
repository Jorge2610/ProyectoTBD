package Vistas;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;

public class IngresarGUI extends JFrame{

    private JPanel panel;
    private JTextField nombreUsuarioField;
    private JPasswordField passUsuarioField;
    private JButton ingresarButton;
    private Font font;
    
    public IngresarGUI(){
        initFrame();
        font = new Font("Serif", Font.PLAIN, 15);
        initPanel(); 
        Dimension d = new Dimension(getPreferredSize().width + 10, getPreferredSize().height + 40);
        setSize(d); 
    }

    private void initFrame(){
        panel = new JPanel(new GridBagLayout()); 
        setContentPane(panel);
        setTitle("Compra Rapida");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);   
        setResizable(false);   
    }

    private void initPanel(){
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(10, 10, 10, 10);

        JLabel img = new JLabel();
        ImageIcon icono = new ImageIcon(getClass().getResource("/Vistas/Img/login.png"));
        icono = new ImageIcon(icono.getImage().getScaledInstance(250, 200, Image.SCALE_SMOOTH));
        img.setIcon(icono);
        c.gridx = 0;
        c.gridy = 0;
        add(img, c);

        c.insets = new Insets(0, 0, 0, 0);
        c.anchor = GridBagConstraints.EAST; 
        JPanel p1 = new JPanel(new GridBagLayout());
        initP1(p1);
        c.gridy = 1;
        c.weightx = 1.0;
        c.fill = GridBagConstraints.HORIZONTAL;
        add(p1, c);


        c.insets = new Insets(10, 10, 10, 10);
        c.anchor = GridBagConstraints.CENTER; 
        ingresarButton = new JButton("Ingresar");
        ingresarButton.setFont(font);
        c.gridy = 2;
        c.weightx = 0.0;
        c.fill = GridBagConstraints.NONE;
        add(ingresarButton, c);
    }

    private void initP1(JPanel p1){
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(10, 5, 10, 5);
        c.anchor = GridBagConstraints.EAST;  
        
        JLabel nombreLabel = new JLabel("Usuario:");
        nombreLabel.setFont(font);
        c.gridx = 0;
        c.gridy = 0;
        p1.add(nombreLabel, c);

        nombreUsuarioField = new JTextField();
        nombreUsuarioField.setFont(font);
        c.gridx = 1;
        c.weightx = 1.0;
        c.fill = GridBagConstraints.HORIZONTAL;
        p1.add(nombreUsuarioField, c);

        JLabel passLabel = new JLabel("Contraseña:");
        passLabel.setFont(font);
        c.gridx = 0;
        c.gridy = 1;
        c.weightx = 0.0;
        c.fill = GridBagConstraints.NONE;
        p1.add(passLabel, c);

        passUsuarioField = new JPasswordField();
        passUsuarioField.setFont(font);
        c.gridx = 1;
        c.weightx = 1.0;
        c.fill = GridBagConstraints.HORIZONTAL;
        p1.add(passUsuarioField, c);
    }

    public JTextField getNombreUsuarioField() {
        return nombreUsuarioField;
    }

    public JPasswordField getPassUsuarioField() {
        return passUsuarioField;
    }

    public JButton getIngresarButton() {
        return ingresarButton;
    }

}
