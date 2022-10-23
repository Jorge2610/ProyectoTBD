package Vistas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class PrincipalGUI extends JFrame{
    
    private JPanel panel;
    private JPanel panelBotones;
    private JPanel panelContenido;

    private JButton ventasB;
    private JButton gestionProdB;
    private JButton gestionPersB;
    private JButton salirB;

    private Font font;
    private Color color;

    public PrincipalGUI(){
        panel = new JPanel(new GridBagLayout());
        color = new Color(panel.getBackground().getRed() - 20, panel.getBackground().getGreen() - 20, panel.getBackground().getBlue() - 20);
        setContentPane(panel);
        font = new Font("Serif", Font.BOLD, 25);
        initFrame();
        initPanel();    
    }

    private void initFrame(){
        setSize(new Dimension(960, 540));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);    
    }

    private void initPanel(){
        GridBagConstraints c = new GridBagConstraints();
        
        panelBotones = new JPanel(new GridBagLayout());
        initPanelBotones();
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0.075;
        c.weighty = 0.05;
        c.anchor = GridBagConstraints.NORTHWEST;
        c.fill = GridBagConstraints.HORIZONTAL;
        add(panelBotones, c);

        panelContenido = new JPanel(new GridBagLayout());
        c.gridx = 1;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        add(panelContenido, c);

        panel.setBackground(color);
    }

    private void initPanelBotones(){
        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 1.0;
        c.weighty = 0.1;
        panelBotones.setBackground(color);
        
        JLabel logo =  new JLabel();
        ImageIcon icono = new ImageIcon(getClass().getResource("/Vistas/Img/login.png"));
        icono = new ImageIcon(icono.getImage().getScaledInstance(150, 100, Image.SCALE_SMOOTH));
        logo.setIcon(icono);
        c.gridx = 0;
        c.gridy = 0;
        panelBotones.add(logo, c);

        ventasB = new JButton("Ventas");
        ventasB.setFont(font);
        ventasB.setBackground(color);
        ventasB.setBorder(null);
        c.gridy = 1;
        c.fill = GridBagConstraints.BOTH;
        panelBotones.add(ventasB, c);

        gestionProdB = new JButton("Gestión producción");
        gestionProdB.setFont(font);
        gestionProdB.setBackground(color);
        gestionProdB.setBorder(null);
        c.gridy = 2;
        panelBotones.add(gestionProdB, c);

        gestionPersB = new JButton("Gestión personal");
        gestionPersB.setFont(font);
        gestionPersB.setBackground(color);
        gestionPersB.setBorder(null);
        c.gridy = 3;
        panelBotones.add(gestionPersB, c);

        salirB = new JButton("Salir");
        salirB.setFont(font);
        salirB.setBackground(color);
        salirB.setBorder(null);
        c.gridy = 4;
        panelBotones.add(salirB, c);

        ventasB.setEnabled(false);
        gestionProdB.setEnabled(false);
        gestionPersB.setEnabled(false);
    }

    public void setPanelContenido(JPanel p){
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.fill = GridBagConstraints.BOTH;
        if(panelContenido.getComponentCount() == 1){
            panelContenido.remove(0);    
        }
        p.setPreferredSize(panelContenido.getSize());
        panelContenido.add(p, c);
        pack();    
    }

    public JButton getVentasB() {
        return ventasB;
    }

    public JButton getGestionProdB() {
        return gestionProdB;
    }

    public JButton getGestionPersB() {
        return gestionPersB;
    }

    public JButton getSalirB() {
        return salirB;
    }
    
}
