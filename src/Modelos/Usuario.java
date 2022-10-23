package Modelos;

public class Usuario {
    
    private String nombre;
    private String password;
    private double salario;
    private String domicilio;
    private String rol;

    public Usuario(String nombre, String password, double salario, String domicilio, String rol) {
        this.nombre = nombre;
        this.password = password;
        this.salario = salario;
        this.domicilio = domicilio;
        this.rol = rol;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPassword() {
        return password;
    }

    public double getSalario() {
        return salario;
    }

    public String getDomicilio() {
        return domicilio;
    }
    
    public String getRol(){
        return rol;
    }
}
