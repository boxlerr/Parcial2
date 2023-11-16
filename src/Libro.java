public class Libro {
	private String titulo;
    private String autor;
    private boolean disponible;

    public Libro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.disponible = true;
    }

    // Métodos de Acceso
    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public boolean isDisponible() {
        return disponible;
    }

    // para cambiar la disponibilidad
    public void prestarLibro() {
        if (disponible) {
            disponible = false;
            System.out.println("Libro prestado: " + titulo);
        } else {
            System.out.println("El libro no está disponible para préstamo: " + titulo);
        }
    }

    public void devolverLibro() {
        if (!disponible) {
            disponible = true;
            System.out.println("Libro devuelto: " + titulo);
        } else {
            System.out.println("El libro ya está disponible: " + titulo);
        }
    }

    @Override
    public String toString() {
        return "Titulo: " + titulo + ", Autor: " + autor + ", Disponible: " + disponible;
    }
}