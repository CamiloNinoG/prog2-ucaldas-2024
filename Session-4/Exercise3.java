// 3. Implementa un programa que busque un elemento específico en una LinkedList de objetos. Puedes usar una LinkedList de cadenas o cualquier otro tipo de objeto que desees.

import java.util.LinkedList;
import java.util.Scanner;

public class Exercise3 {
    public void E3() {

        Scanner sc = new Scanner(System.in);

        String buscar = "";
        
        LinkedList<String> listaEnlazada = new LinkedList<>();

        listaEnlazada.add("poo");
        listaEnlazada.add("java");
        listaEnlazada.add("php");
        listaEnlazada.add("html");
        listaEnlazada.add("python");
        listaEnlazada.add("c++");

        System.out.println("LinkedList: " + listaEnlazada);
        System.out.println("Ingrese el elemento que desa buscar dentro de la lista");
        buscar = sc.nextLine();

        System.out.println("¿El elemento se encuentra dentro de la lista? : "+Flag(listaEnlazada, buscar));

    }

    //Method to find element on linked list
    public boolean Flag(LinkedList<String> list, String word){
        for(String k:list){
            if(k.equals(word)){
                return true;
            }
        }
        return false;
    }
}
