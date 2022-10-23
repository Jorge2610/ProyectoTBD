package Vistas;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class GestionGUI extends JPanel{

    private DefaultTableModel datos;
    private JButton nuevo;
    private JButton editar;
    private JButton borrar;
    private JTable accesorios;

    public GestionGUI(){
        setLayout(new GridBagLayout());
        initComponentes();
    }

    private void initComponentes(){
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);

        nuevo = new JButton("Nuevo usuario");
        c.gridx = 1;
        c.weightx = 0.0;
        c.weighty = 0.0;
        c.fill = GridBagConstraints.NONE;
        add(nuevo, c);

        editar = new JButton("Editar usuario");
        c.gridy = 1;
        add(editar, c);

        borrar = new JButton("Borrar usuario");
        c.gridy = 2;
        c.anchor = GridBagConstraints.NORTH;
        add(borrar, c);

        JScrollPane scroll = new JScrollPane(getTabla());
        c.gridx = 0;
        c.gridy = 0;
        c.gridheight = 3;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.anchor = GridBagConstraints.CENTER;
        c.fill = GridBagConstraints.BOTH;
        add(scroll, c);
   
    }

    private JTable getTabla(){
        datos = generarModelo();
        accesorios = new JTable();
        JTableHeader header = accesorios.getTableHeader();
        header.setDefaultRenderer(new HeaderRenderer(accesorios));
        accesorios.getTableHeader().setReorderingAllowed(false);
        accesorios.getTableHeader().setFont(new Font("sansserif", Font.BOLD, 13));
        accesorios.setModel(datos);
        accesorios.setSelectionMode(0);
        return accesorios;
    }

    private DefaultTableModel generarModelo(){
        DefaultTableModel datos = new DefaultTableModel(new Object[0][], new String[]{
            "COD", "NOMBRE", "DOMICILIO", "FECHA DE REGISTRO", "ROL", "SALARIO", "ACTIVO"}) {
            Class[] types = {Integer.class, String.class, String.class, String.class, String.class, Double.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false};

            @Override
            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                return this.canEdit[column];
            }
        };
        return datos;
    }

    public DefaultTableModel getDatos(){
        return datos;
    }

    public JButton getNuevo() {
        return nuevo;
    }

    public JButton getEditar() {
        return editar;
    }

    public JButton getBorrar() {
        return borrar;
    }
    
    public JTable getTable(){
        return accesorios;
    }
}
