public class Shoes {
    public String nombre = "";
    public String foto = "";
    public int colores = 0;
    public boolean envio = false;
    public int precio = 0;
    public String referencia = "";
    public int talla = 0;

    // constructor de la clase
    public Shoes(String nombre_param, String foto_param, int colores_param, boolean envio_param, int precio_param,
            String referencia_param, int talla_param) {
        this.nombre = nombre_param;
        this.foto = foto_param;
        this.colores = colores_param;
        this.envio = envio_param;
        this.precio = precio_param;
        this.referencia = referencia_param;
        this.talla = talla_param;
    }

    // funciones Get
    public String getNombre() {
        return nombre;
    }

    public String getFoto() {
        return foto;
    }

    public int getColores() {
        return colores;
    }

    public boolean getEnvio() {
        return envio;
    }

    public int getPrecio() {
        return precio;
    }

    public String getReferencia() {
        return referencia;
    }

    public int getTalla() {
        return talla;
    }

    // metodos Set
    public void setFoto(String fotoN) {
        foto = fotoN;
    }

    public void setNombre(String nombreN) {
        nombre = nombreN;
    }

    public void setColores(int colorN) {
        colores = colorN;
    }

    public void setEnvio(boolean envioN) {
        envio = envioN;
    }

    public void setPrecio(int precioN) {
        precio = precioN;
    }

    public void setReferencia(String referN) {
        referencia = referN;
    }

    public void setTalla(int tallaN) {
        talla = tallaN;
    }
}
