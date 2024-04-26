public class Date {
    int Año = 0;
    int mes = 0;
    int dia = 0;

    public Date(int año, int mes, int dia) {
        Año = año;
        this.mes = mes;
        this.dia = dia;
    }

    public int getAño() {
        return Año;
    }



    public int getMes() {
        return mes;
    }



    public int getDia() {
        return dia;
    }
    
    @Override
    public String toString() {
        return  Año + "/" + mes + "/" + dia;
    }
}
