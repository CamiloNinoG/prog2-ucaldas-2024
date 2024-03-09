//lista con 5 objetos de clase 

import java.util.ArrayList;
import java.util.Scanner;

public class lista{

    Scanner scn = new Scanner(System.in);

    //creacion arrayList tipo tarea (4 atributos)
    public ArrayList <tarea> lista_dia = new ArrayList <tarea>();

    public lista (){
        
    //variables
    String nombre_tarea = "", duracion = "", persona = "", estado = "";
    

    System.out.println("Ingrese la informacion sobre las 5 tareas diarias");

    for ( int i = 1; i <=1; i++){
        boolean bandera = true;
        System.out.println("Ingrese el nombre de la tarea "+i);
        nombre_tarea = scn.nextLine();
        System.out.println("Ingrese la duracion de la tarea "+i);
        duracion = scn.nextLine();
        System.out.println("Ingrese la persona encargada de la tarea "+i);
        persona = scn.nextLine();
            while (bandera) {
                System.out.println("Ingrese el estado de la tarea "+i);
                estado = scn.nextLine();

                if (estado.equals("activo") || estado.equals("en desarrollo") || estado.equals("realizada")){
                    bandera = false;
            } 
            else {
            System.out.println("'estado' invalido\n recuerde que solo puede ser 'activo';'en desarrollo';'realizada'");
            }
        }
        lista_dia.add(new tarea(nombre_tarea, duracion, persona, estado));  
    }
    }
    public void mostrarArrayTarea(){
        int q = 1;
        for(tarea j: lista_dia){
            System.out.println("\nTarea "+q);
            System.out.println("Nombre tarea : "+j.getNombre_tarea());
            System.out.println("Duracion : "+j.getDuracion());
            System.out.println("Persona encargada: "+j.getPersona());
            System.out.println("Estado tarea: "+j.getEstado());
            q++;
        }
    }

}