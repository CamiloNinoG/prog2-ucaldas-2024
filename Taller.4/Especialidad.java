public class Especialidad {
    private String nombre_especialidad = "";
    private String descripcion_especialidad = "";

    public Especialidad(String nombre_especialidad, String descripcion_especialidad) {
        this.nombre_especialidad = nombre_especialidad;
        this.descripcion_especialidad = descripcion_especialidad;
    }

    public String getNombre_especialidad() {
        return nombre_especialidad;
    }

    public String getDescripcion_especialidad() {
        return descripcion_especialidad;
    }

    public String toString(){
        return "Nombre especialidad: " + nombre_especialidad +"\nDescripición: " + descripcion_especialidad;
    } 

}
