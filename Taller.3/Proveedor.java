public class Proveedor {
    private String nombre_proveedor = "";
    private String telefono = "";
    private String dirreccion = "";

    public Proveedor(String nombre_proveedor, String telefono, String dirreccion) {
        this.nombre_proveedor = nombre_proveedor;
        this.telefono = telefono;
        this.dirreccion = dirreccion;
    }

    public String getNombre_proveedor() {
        return nombre_proveedor;
    }
    public String getTelefono() {
        return telefono;
    }
    public String getDirreccion() {
        return dirreccion;
    }

    
}
