public class Reserva {
    private String name = "";
    private String id = "";
    private Vuelo vuelo;
    private int asientos_reser = 0;

    public Reserva(String name, String id, Vuelo vuelo, int asientos_reser) {
        this.name = name;
        this.vuelo = vuelo;
        this.asientos_reser = asientos_reser;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    public int getAsientos_reser() {
        return asientos_reser;
    }

    public String toString() {
        return "\nNombre cliente: " + name + "\nID: "+ this.id + "\nVuelo: " + vuelo.getNumero_vuelo() + "\n asientos reservados" + asientos_reser;
    }
}
