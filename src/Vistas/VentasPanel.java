package Vistas;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VentasPanel extends JPanel {

    private JButton ventaB;
    private JButton clientesB;
    private JButton facturaB;
    private JButton informeB;
    private JPanel panelInferior;

    public VentasPanel() {
        setLayout(new GridBagLayout());
        initPanel();
    }

    private void initPanel() {
        GridBagConstraints c = new GridBagConstraints();

        JLabel cabecera = new JLabel("Ventas");
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

        ventaB = new JButton("Ventas");
        ventaB.setFont(new Font("Serif", Font.PLAIN, 30));
        c.gridx = 0;
        c.gridy = 0;
        panelBotones.add(ventaB, c);

        clientesB = new JButton("Clientes");
        clientesB.setFont(new Font("Serif", Font.PLAIN, 30));
        c.gridx = 1;
        panelBotones.add(clientesB, c);

        facturaB = new JButton("Facturas");
        facturaB.setFont(new Font("Serif", Font.PLAIN, 30));
        c.gridx = 2;
        panelBotones.add(facturaB, c);

        informeB = new JButton("Informes");
        informeB.setFont(new Font("Serif", Font.PLAIN, 30));
        c.gridx = 3;
        panelBotones.add(informeB, c);

        ventaB.setEnabled(false);
        clientesB.setEnabled(false);
        facturaB.setEnabled(false);
        informeB.setEnabled(false);
    }

    public JButton getVentaB() {
        return ventaB;
    }

    public JButton getClientesB() {
        return clientesB;
    }

    public JButton getFacturaB() {
        return facturaB;
    }

    public JButton getInformeB() {
        return informeB;
    }
    
}
