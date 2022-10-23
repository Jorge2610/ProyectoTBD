import com.formdev.flatlaf.FlatDarkLaf;

import Controladores.IngresarControlador;

public class Main {
    
    public static void main(String[] args){
        FlatDarkLaf.setup();
        IngresarControlador c = new IngresarControlador();
        c.mostrarFrame();            
    }
}
