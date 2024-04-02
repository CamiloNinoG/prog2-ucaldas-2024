public class Medico {
    private String nombre_medico = "";
    private Especialidad especialidad_medico;
    private String codigo_medico = "";

    public Medico(String nombre_medico, Especialidad especialidad_medico, String codigo_medico) {
        this.nombre_medico = nombre_medico;
        this.especialidad_medico = especialidad_medico;
        this.codigo_medico = codigo_medico;
    }

    public String getNombre_medico() {
        return nombre_medico;
    }

    public Especialidad getEspecialidad_medico() {
        return especialidad_medico;
    }

    public String getCodigo_medico() {
        return codigo_medico;
    }

    public String toString() {
        return "\nNombre: " + nombre_medico + "\nEspecialidad: " + especialidad_medico.getNombre_especialidad() + "\nCodigo: " + codigo_medico ;
    }

}
