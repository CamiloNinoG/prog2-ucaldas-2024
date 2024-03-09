//clase tarea con 5 atributos

public class tarea{
    public String nombre_tarea = "";
    public String duracion = "";
    public String persona = "";
    public String estado = "";

    public tarea(String nombre_tarea_parametro, String duracion_parametro, String persona_parametro, String estado_parametro){
        this.nombre_tarea = nombre_tarea_parametro;
        this.duracion = duracion_parametro;
        this.persona = persona_parametro;
        this.estado = estado_parametro;
    }

    //funciones get
    
    public String getNombre_tarea(){
        return nombre_tarea;
    }

    public String getDuracion(){
        return duracion;
    }

    public String getPersona(){
        return persona;
    }

    public String getEstado(){
        return estado;
    }
}