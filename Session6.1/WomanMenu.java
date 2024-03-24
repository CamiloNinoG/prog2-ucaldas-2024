import java.util.Scanner;

public class WomanMenu {

    Scanner scnW = new Scanner(System.in);

    // menú opcion Woman
    public void ShowMenu() {
        System.out.println("1.Calzado \n2.Ropa \n3.Accesorio \n4.Producto Destacado \n5.Deporte");
    }

    public void ShowMenuWoman() {
        ShowMenu();
        int option = scnW.nextInt();
        switch (option) {
            case 1:
                System.out.println("Calzado");
                System.out.println("Ingrese la clase de calzado buscada\n1. Running\n2. Classic\n3. All Categories");
                int option_2 = scnW.nextInt();
                Running instance_Running = new Running();
                Classic instance_classic = new Classic();
                AllCategories instance_AllCategories = new AllCategories();
                if (option_2 == 1) {
                    instance_Running.addRunningShoes();
                    instance_Running.menuRunning();
                } 
                else if (option_2 == 2) {
                    instance_classic.addCalsssicShoes();
                    instance_classic.menuClassic();
                } 
                else if (option_2 == 3){
                    instance_AllCategories.addAllCategorie();
                    instance_AllCategories.menuAllCategories();
                }
                 else {
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