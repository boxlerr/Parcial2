import java.util.Date;

public class Prestamo {
    private Libro libro;
    private String prestado;
    private String cliente;
    private Date fecha;

    public Prestamo(Libro libro, String prestado, Date fecha) {
        this.libro = libro;
        this.prestado = prestado;
        this.fecha = fecha;
    }

    // Métodos de Acceso
    public Libro getLibro() {
        return libro;
    }

    public String getprestado() {
        return prestado;
    }
    public String getcliente() {
        return cliente;
    }

    public Date getFecha() {
        return fecha;
    }
    @Override
    public String toString() {
        return "Libro: " + libro.getTitulo() + ", prestado: " + prestado + ", Fecha: " + fecha;
    }
}
