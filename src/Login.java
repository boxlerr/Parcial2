import javax.swing.JOptionPane;

public class Login extends Empleado{  //fue lo unico que se me ocurrio para implementar herencia :((((((
		
		private String caja;

	    public Login(String nombre, String dni, String usuario, String contrasena, String caja) {
	    	super(nombre, dni, usuario, contrasena);
	        this.caja = caja;
	    }

	    public String getCaja() {
	        return caja;
	    }

	    public void setCaja(String caja) {
	        this.caja = caja;
	    }

	    public boolean Logear(String us, String pass) {  //verifica que el login este bien admin admin123
	        return "admin".equals(us) && "admin123".equals(pass);
	    }
	    
	    public static int mostrarMenu() {
	        String[] opciones = {"Agregar Libro","Realizar Préstamo","Devolver Libro","Mostrar Información de Libros","Salir"};
	        return JOptionPane.showOptionDialog(null,"Seleccione una opción:","Menú Principal",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,opciones,opciones[0]) + 1;
	    }
	    public static void finalizarDia() {
	    	JOptionPane.showMessageDialog(null, "Gracias por usar el programa! \nQue tengas buen dia!");
	    	
	    }
}
