public class Fecha {
    private int año = 0;
    private int mes = 0;
    private int dia = 0;
    private int hora = 0;
    private int minuto = 0;

    public Fecha(int año, int mes, int dia, int hora, int minuto) {

        if (String.valueOf(año).length() <= 4) {
            this.año = año;
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
  
        if (hora >= 7 && hora <= 18) {
            this.hora = hora;
        } else {
            System.out.println("La hora debe estar en el rango de 7 a 18 (formato de 24 horas)");
        }
        
        if (minuto >= 0 && minuto <= 59) {
            this.minuto = minuto;
        } else {
            System.out.println("Los minutos deben estar en el rango de 0 a 59");
        }
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getMinuto() {
        return minuto;
    }

    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    public String toString() {
        return String.format("%04d-%02d-%02d / %02d:%02d", año, mes, dia, hora, minuto);
    }
    
}
