
// 2. Crea un programa que permita al usuario agregar y eliminar elementos de un ArrayList de cadenas. Puedes solicitar al usuario que ingrese elementos para agregar y el índice de los elementos a eliminar

import java.util.ArrayList;
import java.util.Scanner;

public class Exercise2 {
    public void E2() {

        Scanner sc = new Scanner(System.in);

        ArrayList<String> arrayCadena = new ArrayList<>();

        int decision = 0, otro = 1;
        String agregar = "";

        while (otro == 1) {
            System.out.println("Array List:");

            ShowArrayList(arrayCadena);
            System.out.println("\nDesea agregar un elemento o eliminarlo? 1. agregar  2. eliminar");
            decision = sc.nextInt();

            if (decision == 1) {
                System.out.println("Ingrese el elemento a agregar al array");
                sc.nextLine(); 
                agregar = sc.nextLine(); 
                arrayCadena.add(agregar);
            } 
            else if (decision == 2) {
                System.out.println("Ingrese el índice a eliminar en el array");
                int eliminar = sc.nextInt();
                if (eliminar >= 0 && eliminar < arrayCadena.size()) {
                    arrayCadena.remove(eliminar);
                } else {
                    System.out.println("Índice inválido.");
                }
            } 
            else {
                System.out.println("Opción inválida.");
            }

            System.out.println("Desea realizar otra operación? 1. sí 2. no");
            otro = sc.nextInt();
        }
        System.out.println("Final ArrayList");
        ShowArrayList(arrayCadena);
        sc.close();
    }
    //method showArrayList
    public void ShowArrayList(ArrayList <String> list){
        for (String l: list){
            System.out.print(l+" ");
        }
    }
}
