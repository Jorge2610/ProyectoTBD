package Vistas;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ProductosPanel extends JPanel{
    
    private JButton inventarioB;
    private JButton preciosB;
    private JButton informesB;
    private JPanel panelInferior;

    public ProductosPanel() {
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

        panelInferior = new JPanel();
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

        inventarioB = new JButton("Inventario");
        inventarioB.setFont(new Font("Serif", Font.PLAIN, 30));
        c.gridx = 0;
        c.gridy = 0;
        panelBotones.add(inventarioB, c);

        preciosB = new JButton("Precios");
        preciosB.setFont(new Font("Serif", Font.PLAIN, 30));
        c.gridx = 1;
        panelBotones.add(preciosB, c);

        informesB = new JButton("Informes");
        informesB.setFont(new Font("Serif", Font.PLAIN, 30));
        c.gridx = 2;
        panelBotones.add(informesB, c);

        inventarioB.setEnabled(false);
        preciosB.setEnabled(false);
        informesB.setEnabled(false);
    }

    public JButton getInventarioB() {
        return inventarioB;
    }

    public JButton getPreciosB() {
        return preciosB;
    }

    public JButton getInformesB() {
        return informesB;
    }

    public JPanel getPanelInferior() {
        return panelInferior;
    }
    
}
