public class Prestamo {
    private Libro libro;
    private Usuario usuario;
    private Fecha fecha_prestamo;
    private Fecha fecha_devolucion;

    Prestamo(Libro libro_param, Usuario usuario_param, Fecha fecha_prestamo_param, Fecha fecha_devolucion_param) {
        this.libro = libro_param;
        this.usuario = usuario_param;
        this.fecha_prestamo = fecha_prestamo_param;
        this.fecha_devolucion = fecha_devolucion_param;
    }

    public Libro getLibro() {
        return libro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Fecha getFecha_prestamo() {
        return fecha_prestamo;
    }

    public Fecha getFecha_devolucion() {
        return fecha_devolucion;
    }

}
