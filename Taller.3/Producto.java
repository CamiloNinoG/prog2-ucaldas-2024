public class Producto {
    private String nombre_producto = "";
    private Categoria categoria;
    private double Precio = 0;
    private int stock = 0;

    public Producto(String nombre_producto_param, Categoria categoria_param, double precio_param, int stock_param) {
        this.nombre_producto = nombre_producto_param;
        this.categoria = categoria_param;
        Precio = precio_param;
        this.stock = stock_param;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public double getPrecio() {
        return Precio;
    }

    public int getStock() {
        return stock;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setPrecio(double precio) {
        Precio = precio;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
}
