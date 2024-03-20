import java.util.Scanner;

public class ManMenu {

    Scanner scnM = new Scanner(System.in);

    // menú opcion Man
    public void ShowMenu() {
        System.out.println("1.Calzado \n2.Ropa \n3.Accesorio \n4.Producto Destacado \n5.Deporte");
    }

    public void ShowMan() {
        ShowMenu();
        int option = scnM.nextInt();
        switch (option) {
            case 1:
                System.out.println("Calzado");
                System.out.println("Ingrese la clase de calzado buscada\n1. Running\n2. Classic");
                int option_2 = scnM.nextInt();
                RunningMan instance_Running_man = new RunningMan();
                ClassicMan instance_classic_man = new ClassicMan();
                if (option_2 == 1) {
                    instance_Running_man.addRunningShoesMan();
                    instance_Running_man.menuRunningMan();
                } else if (option_2 == 2) {
                    instance_classic_man.addClassicShoesMan();
                    instance_classic_man.menuClassicMan();
                } else {
                    System.out.println("Invalid option.");
                }
                break;
            case 2:
                System.out.println("Aviailable soon");
                break;
            case 3:
                System.out.println("Aviailable soon");
                break;
            case 4:
                System.out.println("Aviailable soon");
                break;
            case 5:
                System.out.println("Aviailable soon");
                break;
            default:
                System.out.println("Invadil option");
                break;
        }
    }
}