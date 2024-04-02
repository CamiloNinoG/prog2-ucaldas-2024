public class Categoria{
    private String nombre_categoria = "";
    private String descripcion = "";

    public Categoria(String nombre_categoria_param, String descripcion_param){
        this.nombre_categoria =nombre_categoria_param;
        this.descripcion =descripcion_param;
    }

    public String getNombre_categoria() {
        return nombre_categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    
}
