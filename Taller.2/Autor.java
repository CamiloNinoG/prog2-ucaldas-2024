public class Autor {
    private String nombre = ""; 
    private String nacionalidad = "";
    
    public Autor(String nombre_param, String nacionalidad_param){
        this.nombre = nombre_param;
        this.nacionalidad = nacionalidad_param;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }
}
