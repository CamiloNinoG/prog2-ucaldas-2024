import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Inscription {

    Scanner scan = new Scanner(System.in);
    Scanner scan1 = new Scanner(System.in);
    Student student = new Student("Rosario", "320 547", "rosario@ucaldas.edu.co", "1234", 4.6f);
    private ArrayList<Professor> professors = new ArrayList<>();
    private ArrayList<Seminar> seminars = new ArrayList<>();

    int opcion_menu = 0;
    String nombre_seminar = "";

    // constructor
    public Inscription() {
        addProfesors(professors);
        addsSeminars(seminars);
    }

    // menu
    public void menuInscription() {

        student.elegibletoEnroll();

        System.out.println("\nBienvenido al menu");

        while (opcion_menu != 4) {
            System.out.println("\nIngrese la accion a realizar");
            System.out.println("1. Mostrar todos seminarios");
            System.out.println("2. Inscribir seminario");
            System.out.println("3. Mostrar las seminarios inscritas");
            System.out.println("4. Salir");
            opcion_menu = scan1.nextInt();
            switch (opcion_menu) {

                case 1:
                    listArraylistSeminars(seminars);
                    break;

                case 2:
                    System.out.println(
                            "Ingrese el nombre del seminario que desea inscribir \nNOTA: Tenga encuenta espacios");
                    nombre_seminar = scan.nextLine();
                    Seminar a = findSeminar(nombre_seminar);
                    if (a != null){
                    student.addSeminar(a);
                    } else {
                        System.out.println("No se encontro el seminario buscado");
                    }
                    break;

                case 3:
                    student.getSeminarsTaken();
                    break;

                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
        System.out.println("Fin del programa");
    }

    // cargar profesores al arrayist
    private void addProfesors(ArrayList<Professor> lista) {
        try {
            BufferedReader lector = new BufferedReader(new FileReader("profesors.txt"));
            String linea = "";
            while ((linea = lector.readLine()) != null) {
                System.out.println("Línea leída: " + linea);
                String[] componentes = linea.split(";");
                if (componentes.length == 3) {
                    String name_profesor = componentes[0];
                    String phone = componentes[1];
                    String email = componentes[2];
                    lista.add(new Professor(name_profesor, phone, email));
                } else {
                    System.err.println("La línea no tiene el formato esperado: " + linea);
                }
            }
            lector.close();
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    // cargar seminarios al arrayist
    private void addsSeminars(ArrayList<Seminar> lista) {
        try {
            BufferedReader lector = new BufferedReader(new FileReader("seminars.txt"));
            String linea = "";
            while ((linea = lector.readLine()) != null) {
                System.out.println("Línea leída: " + linea);
                String[] componentes = linea.split(";");

                if (componentes.length == 3) {
                    String name_seminars = componentes[0];
                    int hours = Integer.parseInt(componentes[1]);
                    String name_profesor = componentes[2];

                    Professor find = null;
                    for (Professor a : professors) {
                        if (a.getName().equals(name_profesor)) {
                            find = a;
                            break;
                        }
                    }

                    if (find != null) {
                        lista.add(new Seminar(name_seminars, hours, find));
                    } else {
                        System.out.println("No se encontro el professor");
                    }
                } else {
                    System.err.println("La línea no tiene el formato esperado: " + linea);
                }
            }
            lector.close();
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public void listArraylistSeminars(ArrayList<Seminar> list) {
        System.out.println("Seminarios Disponibles");
        for (Seminar a : list) {
            System.out.println(a.toString());
        }
    }

    public Seminar findSeminar(String name_course) {
        Seminar find_seminar = null;
        for (Seminar a : seminars) {
            if (a.getName_seminars().equals(name_course)) {
                find_seminar = a;
                return find_seminar;
            }
        }
        return null;
    }
}
