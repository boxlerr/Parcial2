import javax.swing.*;

public class Main {

    public static void main(String[] args) {
    	Biblioteca biblioteca = new Biblioteca();

        Login empleado = new Login("Eduardo", "23.274.584", "admin", "admin123", "Caja 1");
        boolean inicioSesionExitoso = false;
        int intentos = 3;
        do {
            String usuario = JOptionPane.showInputDialog("Ingrese el nombre de usuario:");
            String contrasena = JOptionPane.showInputDialog("Ingrese la contraseña:");
            inicioSesionExitoso = empleado.Login(usuario, contrasena);
            if (inicioSesionExitoso) {
                JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso.");
                int opcion;
                do {
                    opcion = Login.mostrarMenu();

                    switch (opcion) {
                        case 1:
                        	String nuevoTitulo = JOptionPane.showInputDialog("Ingrese el título del nuevo libro:");
                            String nuevoAutor = JOptionPane.showInputDialog("Ingrese el autor del nuevo libro:");
                            biblioteca.agregarLibro(nuevoTitulo, nuevoAutor);
                            break;
                        case 2:
                            biblioteca.realizarPrestamo();
                            break;
                        case 3:
                            biblioteca.devolverLibro();
                            break;
                        case 4:
                        	biblioteca.mostrarLibros();
                            biblioteca.mostrarPrestamos();
                            break;
                        case 5:
                            Login.finalizarDia();
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, elija una opción del menú.");
                    }

                } while (opcion != 5);
            } else {
                JOptionPane.showMessageDialog(null, "Error al iniciar sesión. Intentos restantes: " + (--intentos));
            }
        } while (!inicioSesionExitoso && intentos > 0);
        if (!inicioSesionExitoso) {
            JOptionPane.showMessageDialog(null, "Número máximo de intentos alcanzado. La aplicación se cerrará.");
        }
    }
}
