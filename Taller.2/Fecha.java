public class Fecha {
    private int anio = 0;
    private int mes = 0;
    private int dia = 0;

    public Fecha(int anio, int mes, int dia){
        if (String.valueOf(anio).length() <= 4) {
            this.anio = anio;
        } else {
            System.out.println("El año no debe tener más de 4 cifras");
        }
        
        if (mes >= 1 && mes <= 12) {
            this.mes = mes;
        } else {
            System.out.println("El mes debe estar en el rango de 1 a 12");
        }
        
        if (dia >= 1 && dia <= 31) {
            this.dia = dia;
        } else {
            System.out.println("El día debe estar en el rango de 1 a 31");
        }
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

    public String toString() {
        return String.format("%04d-%02d-%02d", anio, mes, dia);
    }
    
}
