import java.util.Scanner;

public class Animal{
    Scanner sc = new Scanner(System.in);
    public String tipo_de_animal = "";
    public String nombre_de_animal = "";
    public String años_de_animal = "";

    public void mostrar(){
        System.out.println("Ingrese la informacion");
        System.out.println("Ingrese el nombre de su mascota");
        nombre_de_animal = sc.nextLine();
        System.out.println("Ingrese el tipo de mascota");
        tipo_de_animal = sc.nextLine();
        System.out.println("Ingrese los años del la mascota");
        años_de_animal = sc.nextLine();
    }

    public void inputDataUser() {
        //TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'inputDataUser'");
    }
}