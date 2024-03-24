
class Estudiante{
    public String nombre = "";
    public String codigo = "" ;
    public String carrera = "";
    public double promedio  = 0.0;

    public Estudiante( String nombre_param, String codigo_param, String carrera_param, double promedio_param){
        this.nombre = nombre_param;
        this.codigo = codigo_param;
        this.carrera = carrera_param;
        this.promedio = promedio_param;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getCarrera() {
        return carrera;
    }

    public double getPromedio() {
        return promedio;
    }
    
}