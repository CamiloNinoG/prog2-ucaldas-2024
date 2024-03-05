import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese su correo electrónico: ");
        String email = scanner.nextLine();

        System.out.print("Ingrese su nombre: ");
        String name = scanner.nextLine();

        System.out.print("Ingrese su dirección: ");
        String address = scanner.nextLine();

        System.out.println("Correo electrónico: " + email);
        System.out.println("Nombre: " + name);
        System.out.println("Dirección: " + address);

        scanner.close();
    }
}
