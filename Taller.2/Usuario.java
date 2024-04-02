public class Usuario {
    private String nombre_completo= "";
    private String cedula= "";

    public Usuario(String nombre_completo_param, String cedula_param){
        this.nombre_completo = nombre_completo_param;
        this.cedula = cedula_param;
    }

    public String getNombre_completo() {
        return nombre_completo;
    }

    public String getCedula() {
        return cedula;
    }
    
}
