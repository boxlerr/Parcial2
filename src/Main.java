import javax.swing.*;

public class Main {

    public static void main(String[] args) {
    	Biblioteca biblioteca = new Biblioteca();

        Login empleado = new Login("Eduardo", "23.274.584", "admin", "admin123", "Caja 1");
        
        biblioteca.agregarLibro("El Señor de los Anillos", "J.R.R. Tolkien", false);        //libros
        biblioteca.agregarLibro("Cien años de soledad", "Gabriel García Márquez", false);
        biblioteca.agregarLibro("1984", "George Orwell", false);
        biblioteca.agregarLibro("To Kill a Mockingbird", "Harper Lee", false);
        biblioteca.agregarLibro("Harry Potter y la piedra filosofal", "J.K. Rowling", false);
        biblioteca.agregarLibro("The Great Gatsby", "F. Scott Fitzgerald", false);
        biblioteca.agregarLibro("One Hundred Years of Solitude", "Gabriel García Márquez", false);
        biblioteca.agregarLibro("The Catcher in the Rye", "J.D. Salinger", false);
        biblioteca.agregarLibro("The Hobbit", "J.R.R. Tolkien", false);
        biblioteca.agregarLibro("Pride and Prejudice", "Jane Austen", false);

        
        
        boolean inicioSesionExitoso = false;
        int intentos = 3;
        do {
        	//iniciar sesion admin admin123
            String usuario = JOptionPane.showInputDialog("Ingrese el nombre de usuario:");
            String contrasena = JOptionPane.showInputDialog("Ingrese la contraseña:");
            inicioSesionExitoso = empleado.Login(usuario, contrasena);
            if (inicioSesionExitoso) {
                JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso.");
                int opcion;
                do {
                    opcion = Login.mostrarMenu();

                    switch (opcion) {  //menu
                        case 1:
                        	String nuevoTitulo = JOptionPane.showInputDialog("Ingrese el título del nuevo libro:");
                            String nuevoAutor = JOptionPane.showInputDialog("Ingrese el autor del nuevo libro:");
                            
                            biblioteca.agregarLibro(nuevoTitulo, nuevoAutor, true);  
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
                biblioteca.estatsGenerales();   //mostrar datos del dia
            } else {
                JOptionPane.showMessageDialog(null, "Error al iniciar sesión. Intentos restantes: " + (--intentos));  //3 intentos, si fallas mensaje de error al iniciar
            }
        } while (!inicioSesionExitoso && intentos > 0);
        if (!inicioSesionExitoso) {
            JOptionPane.showMessageDialog(null, "Número máximo de intentos alcanzado. La aplicación se cerrará.");
        }
    }
}
