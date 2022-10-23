package Modelos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;

public class ConexionBD {

    private Connection conexion;
    private int pid;

    public ConexionBD() {
        initConexion();
    }

    public int getPid() {
        return pid;
    }

    private void initConexion() {
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/proyecto_tbd";
            conexion = DriverManager.getConnection(url, "jorge_tbd", "tbd022022");
            pid = getPID();
        } catch (ClassNotFoundException e) {
            System.out.println("Error al registrar el driver de PostgreSQL: " + e);
        } catch (SQLException e) {
            System.out.println("Error SQL: " + e);
        }
    }

    public void cerrarConexion(){
        try {
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private int getPID() {
        int proceso = 0;
        try {
            CallableStatement cs = conexion.prepareCall("{? = call pg_backend_pid()}");
            cs.registerOutParameter(1, Types.INTEGER);
            cs.execute();
            proceso = cs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return proceso;
    }

    public boolean guardarUsuario(Usuario usuario){
        boolean guardado = false;  
        try {
            CallableStatement cs = conexion.prepareCall("{? = call seguridad.guardar_usuario(?, ?, ?, ?, ?)}");
            cs.registerOutParameter(1, Types.BOOLEAN);
            cs.setString(2, usuario.getNombre());
            cs.setString(3, usuario.getPassword());
            cs.setDouble(4, usuario.getSalario());
            cs.setString(5, usuario.getDomicilio());
            cs.setString(6, usuario.getRol());
            cs.execute();
            guardado = cs.getBoolean(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return guardado;  
    }

    public int validarUsuario(String usuario, String password, String ip) {
        int id_usuario = 0;
        try {
            CallableStatement cs = conexion.prepareCall("{? = call seguridad.validar_usuario(?, ?, ?)}");
            cs.registerOutParameter(1, Types.INTEGER);
            cs.setString(2, usuario);
            cs.setString(3, password);
            cs.setString(4, ip);
            cs.execute();
            id_usuario = cs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id_usuario;
    }

    //Obtener interfaces
    public ArrayList<Integer> obtenerInterfaces(int idUsuario){
        ArrayList<Integer> interfaces = new ArrayList<>();
        try {
            Statement st = conexion.createStatement();         
            ResultSet rs = st.executeQuery("SELECT * FROM seguridad.obtener_interfaces(" + idUsuario + ")");
            while(rs.next()){
                interfaces.add(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }   
        return interfaces;     
    }

    public void eliminarSesion(int idUsuario){
        try {
            CallableStatement cs = conexion.prepareCall("{? = call seguridad.borrar_sesion(?, ?)}");
            cs.registerOutParameter(1, Types.BOOLEAN);
            cs.setInt(2, idUsuario);
            cs.setInt(3, pid);
            cs.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }    
    }

    public ResultSet getUsuarios(){
        try {
            Statement st = conexion.createStatement();         
            ResultSet rs = st.executeQuery("SELECT * FROM seguridad.obtener_usuarios()");
            return rs;  
        } catch (SQLException e) {
            e.printStackTrace();
        }   
        return null;    
    }

    public boolean borrarUsuario(int id_usuario){
        boolean borrado = false;
        try {
            CallableStatement cs = conexion.prepareCall("{? = call seguridad.borrar_usuario(?)}");
            cs.registerOutParameter(1, Types.BOOLEAN);
            cs.setInt(2, id_usuario);
            cs.execute();
            borrado = cs.getBoolean(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return borrado;
    }
}