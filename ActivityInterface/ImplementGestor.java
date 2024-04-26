import java.util.ArrayList;
import java.util.Scanner;

public class ImplementGestor implements Gestor {

    Scanner scn_line = new Scanner(System.in);
    Scanner scn_int = new Scanner(System.in);
    ArrayList<Vuelo> vuelos = new ArrayList<>();
    ArrayList<Reserva> reservas = new ArrayList<>();

    int opcion_menu = 0, asientos_reser = 0;
    String name = "", id = "", vuelo_number = "";

    public ImplementGestor() {
        vuelos.add(new Vuelo("123", "Colombia", new Date(24, 04, 23), 1000, 100));
        vuelos.add(new Vuelo("456", "USA", new Date(24, 05, 10), 2000, 200));
        vuelos.add(new Vuelo("987", "España", new Date(25, 07, 05), 3000, 150));
    }

    public void menuGestor() {
        System.out.println("\nSistema gestor de vuelos");
        while (opcion_menu != 5) {
            System.out.println("\nIngrese la opcion a realizar");
            System.out.println("1. Mostrar vuelos disponibles");
            System.out.println("2. Agendar vuelo");
            System.out.println("3. Cancelar vuelo");
            System.out.println("4. Mostrar reservas");
            System.out.println("5. Salir");
            opcion_menu = scn_int.nextInt();

            switch (opcion_menu) {
                case 1:
                System.out.println("--- Vuelos disponibles ---");
                    listVuelo();
                    break;
                case 2:
                    System.out.println("Ingrese el nombre del cliente");
                    name = scn_line.nextLine();
                    System.out.println("Ingrese el ID del cliente");
                    id = scn_line.nextLine();
                    System.out.println("Ingrese el numero del vuelo");
                    vuelo_number = scn_line.nextLine();
                    System.out.println("Ingrese el numero de asientos a reservar ");
                    asientos_reser = scn_int.nextInt();
                    Vuelo vuelo_find = findVuelo(vuelo_number);
                    if (vuelo_number != null) {
                        Reserva reserva = new Reserva(name, id, vuelo_find, asientos_reser);
                        int asientos = vuelo_find.getAsientos() - reserva.getAsientos_reser();
                        vuelo_find.setAsientos(asientos);
                        reservarVuelo(reserva);
                    } else {
                        System.out.println("No se encontro el vuelo  buscado");
                    }

                    break;
                case 3:
                    System.out.println("Ingrese el ID del cliente");
                    id = scn_line.nextLine();
                    System.out.println("Ingrese el numero del vuelo");
                    vuelo_number = scn_line.nextLine();
                    Reserva reserva_find = findReserva(id, vuelo_number);
                    if (reserva_find != null) {
                        cancelarVuelo(reserva_find);
                        reserva_find.getVuelo().setAsientos(reserva_find.getVuelo().getAsientos() + reserva_find.getAsientos_reser());
                    } else {
                        System.out.println("No se encpontro la reserva buscada");
                    }
                    break;
                case 4:
                System.out.println("--- Reservas ---");
                listReservas();
                break;

                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        }
        System.out.println("----- FIN -----");
    }

    public Vuelo findVuelo(String vuelo_number) {
        for (Vuelo vuelo_find : vuelos) {
            if (vuelo_find.getNumero_vuelo().equals(vuelo_number)){
            return vuelo_find;
        }
    }
    return null;
}

    public Reserva findReserva(String id, String vuelo_number) {
        for (Reserva vuelo_find : reservas) {
            if (vuelo_find.getId().equals(id) && vuelo_find.getVuelo().getNumero_vuelo().equals(vuelo_number))
                ;
            return vuelo_find;
        }
        return null;
    }

    // implementacion de metodos
    public void reservarVuelo(Reserva reserva) {
        reservas.add(reserva);
    }

    public void cancelarVuelo(Reserva reserva) {
        reservas.remove(reserva);
    }

    public void listVuelo() {
        for (Vuelo vuelo : vuelos) {
            System.out.println(vuelo.toString());
        }
    }

    public void listReservas() {
        for (Reserva reserva : reservas) {
            System.out.println(reserva.toString());
        }
    }

}
