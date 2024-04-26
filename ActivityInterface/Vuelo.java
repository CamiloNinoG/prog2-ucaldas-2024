public class Vuelo {
    private String numero_vuelo = ""; 
    private String origen = ""; 
    private Date date; 
    private int capacidad = 0; 
    private int asientos = 0;

    public Vuelo(String numero_vuelo, String origen, Date date, int capacidad, int asientos) {
        this.numero_vuelo = numero_vuelo;
        this.origen = origen;
        this.date = date;
        this.capacidad = capacidad;
        this.asientos = asientos;
    }

    public String getNumero_vuelo() {
        return numero_vuelo;
    }

    public String getOrigen() {
        return origen;
    }

    public Date getDate() {
        return date;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public int getAsientos() {
        return asientos;
    }

    public void setNumero_vuelo(String numero_vuelo) {
        this.numero_vuelo = numero_vuelo;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public void setAsientos(int asientos) {
        this.asientos = asientos;
    } 

    public String toString() {
        return "\nNumero vuelo: " + numero_vuelo + "\norigen: " + origen + "\nFecha: " + date + "\ncapacidad: "
                + capacidad + "\nasientos:" + asientos;
    }
    
}
