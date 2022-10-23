package Vistas;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PersonalPanel extends JPanel{
    
    private JButton gestionB;
    private JButton planillasB;
    private JButton informesB;   
    
    public PersonalPanel() {
        setLayout(new GridBagLayout());
        initPanel();
    }

    private void initPanel() {
        GridBagConstraints c = new GridBagConstraints();

        JLabel cabecera = new JLabel("Productos");
        cabecera.setFont(new Font("Serif", Font.BOLD, 45));
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.NORTHWEST;
        add(cabecera, c);

        JPanel panelBotones = new JPanel(new GridBagLayout());
        initPanelBotones(panelBotones);
        c.gridy = 1;
        add(panelBotones, c);

        JPanel panelInferior = new JPanel();
        c.gridy = 2;
        c.weighty = 1.0;
        c.weightx = 1.0;
        c.anchor = GridBagConstraints.CENTER;
        c.fill = GridBagConstraints.BOTH;
        add(panelInferior, c);
    }

    private void initPanelBotones(JPanel panelBotones) {
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(20, 20, 20, 20);

        gestionB = new JButton("Gestion");
        gestionB.setFont(new Font("Serif", Font.PLAIN, 30));
        c.gridx = 0;
        c.gridy = 0;
        panelBotones.add(gestionB, c);

        planillasB = new JButton("Planillas");
        planillasB.setFont(new Font("Serif", Font.PLAIN, 30));
        c.gridx = 1;
        panelBotones.add(planillasB, c);

        informesB = new JButton("Informes");
        informesB.setFont(new Font("Serif", Font.PLAIN, 30));
        c.gridx = 2;
        panelBotones.add(informesB, c);

        gestionB.setEnabled(false);
        planillasB.setEnabled(false);
        informesB.setEnabled(false);
    }

    public JButton getGestionB() {
        return gestionB;
    }

    public JButton getPlanillasB() {
        return planillasB;
    }

    public JButton getInformesB() {
        return informesB;
    }

    public void setPanelInferior(JPanel panel) {
        remove(2);
        GridBagConstraints c = new GridBagConstraints();
        c.gridy = 2;
        c.weighty = 1.0;
        c.weightx = 1.0;
        c.anchor = GridBagConstraints.CENTER;
        c.fill = GridBagConstraints.BOTH;
        add(panel, c);
    } 
}
