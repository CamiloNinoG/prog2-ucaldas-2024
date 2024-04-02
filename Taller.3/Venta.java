public class Venta {
    private Producto producto;
    private int cantidad;
    private Fecha fechaVenta;

    // Constructor
    public Venta(Producto producto_param, int cantidad_param, Fecha fechaVenta_param) {
        this.producto = producto_param;
        this.cantidad = cantidad_param;
        this.fechaVenta = fechaVenta_param;
    }

    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public Fecha getFechaVenta() {
        return fechaVenta;
    }
}
