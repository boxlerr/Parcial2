import java.util.Date;

public class Prestamo {
    private Libro libro;
    private String prestatario;
    private String nombreCompletoPrestatario;
    private Date fecha;

    public Prestamo(Libro libro, String prestatario, Date fecha) {
        this.libro = libro;
        this.prestatario = prestatario;
        this.fecha = fecha;
    }

    // Métodos de Acceso
    public Libro getLibro() {
        return libro;
    }

    public String getPrestatario() {
        return prestatario;
    }
    public String getNombreCompletoPrestatario() {
        return nombreCompletoPrestatario;
    }

    public Date getFecha() {
        return fecha;
    }

    @Override
    public String toString() {
        return "Libro: " + libro.getTitulo() + ", Prestatario: " + prestatario + ", Fecha: " + fecha;
    }
}
