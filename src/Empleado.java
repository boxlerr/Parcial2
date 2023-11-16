public class Empleado {

    private String nombre;
    private String dni;
    private String usuario;
    private String contrasena;

    public Empleado(String nombre, String dni, String usuario, String contrasena) {
        this.nombre = nombre;
        this.dni = dni;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public boolean Login(String us, String pass) {  //iniciar sesion
        if (usuario.equals(us) && contrasena.equals(pass)) {
            System.out.println("Inicio de sesión exitoso.");
            return true;
        } else {
            System.out.println("Inicio de sesión fallido. Usuario o contraseña incorrectos.");
            return false;
        }
    }
}
