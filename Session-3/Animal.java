import java.util.Scanner;

public class Animal{
    public void animals(){

    Scanner sc = new Scanner(System.in);

    String tipoDeAnimal = "", nombreDeAnimal = "";
    int añosDeAnimal = 0;

        System.out.println("Ingrese la informacion");
        System.out.println("Ingrese el nombre de su mascota");
        nombreDeAnimal = sc.nextLine();
        System.out.println("Ingrese el tipo de mascota");
        tipoDeAnimal = sc.nextLine();
        System.out.println("Ingrese los años del la mascota");
        añosDeAnimal = sc.nextInt();

        System.out.println("Información ingresada:");
        System.out.println("Nombre: " + nombreDeAnimal);
        System.out.println("Tipo: " + tipoDeAnimal);
        System.out.println("Edad: " + añosDeAnimal);
        
        sc.close();
    }
}
