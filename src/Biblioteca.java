import javax.swing.*;
import java.util.Date;
import java.util.LinkedList;

public class Biblioteca {
    private LinkedList<Libro> libros = new LinkedList<>();
    private LinkedList<Prestamo> prestamos = new LinkedList<>();

    
    
    
    public void agregarLibro(String titulo, String autor, boolean manual) {   //agregar libro
        Libro nuevoLibro = new Libro(titulo, autor);
        libros.add(nuevoLibro);
        if (manual) {
            JOptionPane.showMessageDialog(null, "Libro agregado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
		}
}

    public void realizarPrestamo() {
        if (libros.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay libros disponibles para préstamo.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Libro libroSeleccionado = libroDispo();
        if (libroSeleccionado != null) {
            String nombreCompletoPrestatario = JOptionPane.showInputDialog("Ingrese el nombre completo del prestatario:");
            libroSeleccionado.prestarLibro();
            Prestamo prestamo = new Prestamo(libroSeleccionado, nombreCompletoPrestatario, new Date());
            prestamos.add(prestamo);
            JOptionPane.showMessageDialog(null, "Préstamo realizado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No hay libros disponibles para préstamo.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
 
    private Libro libroDispo() {   //selec libro
        LinkedList<Libro> librosDisponibles = new LinkedList<>();
        for (Libro libro : libros) {
            if (libro.isDisponible()) {
                librosDisponibles.add(libro);
            }
       }
        if (librosDisponibles.isEmpty()) {
            return null;
       }
        Libro[] librosArray = librosDisponibles.toArray(new Libro[0]);
        return (Libro) JOptionPane.showInputDialog(null,"Seleccione un libro para préstamo:","Libros Disponibles",JOptionPane.QUESTION_MESSAGE,null,librosArray,librosArray[0]);
   }


    private Libro libroParaDevolucion() {  //selec libro para devolver
        if (prestamos.isEmpty()) {
            return null;
        }

        LinkedList<Libro> librosPrestados = new LinkedList<>();
        for (Prestamo prestamo : prestamos) {
            librosPrestados.add(prestamo.getLibro());
        }

        Libro[] librosArray = librosPrestados.toArray(new Libro[0]);
        return (Libro) JOptionPane.showInputDialog(
                null,
                "Seleccione un libro para devolución:",
                "Libros Prestados",
                JOptionPane.QUESTION_MESSAGE,
                null,
                librosArray,
                librosArray[0]);
    }

    private Prestamo buscarPrestamoPorLibro(Libro libro) {
    	for (Prestamo prestamo : prestamos) {
    		if (prestamo.getLibro().equals(libro)) {
    			return prestamo;
    		}
    	}
    	return null;
    }
    
    public void devolverLibro() {  //devolver libro
        Libro libroSeleccionado = libroParaDevolucion();

        if (libroSeleccionado != null) {
            Prestamo prestamoAsociado = buscarPrestamoPorLibro(libroSeleccionado);
            if (prestamoAsociado != null) {
                prestamoAsociado.getLibro().devolverLibro();
                prestamos.remove(prestamoAsociado);
                JOptionPane.showMessageDialog(null, "Devolución realizada con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Error al seleccionar el préstamo para devolución.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay libros prestados para devolver.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    public void mostrarLibros() {  //info libros
        StringBuilder librosInfo = new StringBuilder("Información de Libros:\n");
        for (Libro libro : libros) {
            librosInfo.append(libro).append("\n");
        }
        JOptionPane.showMessageDialog(null, librosInfo.toString(), "Libros", JOptionPane.INFORMATION_MESSAGE);
    }

    public void mostrarPrestamos() {  //info prestamos
        StringBuilder prestamosInfo = new StringBuilder("Información de Préstamos:\n");
        for (Prestamo prestamo : prestamos) {
            prestamosInfo.append(prestamo).append("\n");
        }
        JOptionPane.showMessageDialog(null, prestamosInfo.toString(), "Préstamos", JOptionPane.INFORMATION_MESSAGE);
    }

    public int getCantidadTotalLibrosPrestados() { //cant total de libros prestados
        int total = 0;
        for (Prestamo prestamo : prestamos) {
            if (!prestamo.getLibro().isDisponible()) {
                total++;
            }
        }
        return total;
    }

    private String libroMasPrestado() { //libro + prestado
    	String libroMasPrestado = null;
    	int cantidadMaxima = 0;
    	
    	for (Prestamo prestamo : prestamos) {
    		String titulo = prestamo.getLibro().getTitulo();
    		int contador = 0;
    		
    		for (Prestamo otroPrestamo : prestamos) {
    			if (otroPrestamo.getLibro().getTitulo().equals(titulo)) {
    				contador++;
    			}
    		}
    		
    		if (contador > cantidadMaxima) {
    			cantidadMaxima = contador;
    			libroMasPrestado = titulo;
    		}
    	}
    	
    	return libroMasPrestado;
    }
    
    public void estatsGenerales() {  //stats
        JOptionPane.showMessageDialog(null,
                "Total de libros prestados: " + getCantidadTotalLibrosPrestados() +
                        "\nTotal de libros disponibles: " + (libros.size() - getCantidadTotalLibrosPrestados()) +
                        "\nLibro más prestado: " + libroMasPrestado(),
                "Estadísticas Generales", JOptionPane.INFORMATION_MESSAGE);
    }
    

}