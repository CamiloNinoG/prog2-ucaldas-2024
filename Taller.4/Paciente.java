public class Paciente {
    private String nombre = "";
    private String cedula = "";
    private String telefono = "";
    private String direccion = "";

    public Paciente(String nombre, String cedula, String telefono, String direccion) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public String toString() {
        return "Nombre: " + nombre + "\nCedula: " + cedula + "\nTeléfono: " + telefono + "\nDirección: " + direccion;
    }

}
