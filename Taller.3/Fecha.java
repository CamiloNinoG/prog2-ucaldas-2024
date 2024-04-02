public class Fecha{
    private int anio = 0;
    private int mes = 0;
    private int dia = 0;
    
    public Fecha(int anio_param, int mes_param, int dia_param) {
        this.anio = anio_param;
        this.mes = mes_param;
        this.dia = dia_param;
    }

    public int getAnio() {
        return anio;
    }

    public int getMes() {
        return mes;
    }

    public int getDia() {
        return dia;
    }
    
}
