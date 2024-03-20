import java.util.Scanner;

// Actividad calificable:
// 1. Listar todos los tennis running de talla 38
// 2. Listar todos los tennis classic que tengan más de 5 colores disponible
// 3. Listar todos los tennis running y classic que tengan un precio mayor a USD150
// 4. Listar todos los tennis running cuyo envio a casa no este disponible
public class Main {
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {

        int option = 0;

        while (option != 3) {
            System.out.println(("Menu Inicial\n1. Woman\n2. Man\n3. Exit"));
            option = scn.nextInt();

            switch (option) {
                case 1:
                    WomanMenu instance_woman = new WomanMenu();
                    instance_woman.ShowMenuWoman();
                    break;
                case 2:
                    ManMenu instance_man = new ManMenu();
                    instance_man.ShowMan();
                    break;
                case 3:
                    System.out.println("Fin Programa");
                    break;
                default:
                    System.out.println(("Opcion Invalida"));
                    break;
            }
        }
    }
}