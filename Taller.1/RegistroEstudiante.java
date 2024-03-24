import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class RegistroEstudiante {

    public ArrayList<Estudiante> estudiantes = new ArrayList<>();
    Scanner scn = new Scanner(System.in);

    int opcion = 0, opcion_1 = 0, cuantos = 0;
    String nombre = "", codigo = "", carrera = "", filtro = "";
    double promedio = 0.0;

    // Constructor
    public RegistroEstudiante() {
        cargarEstudiantes(estudiantes);
    }

    // menu
    public void menuRegistro() {
        System.out.println("Sistema de registro universidad");

        while (opcion != 5) {
            System.out.println("Menu Registro");
            System.out.println("1. Agregar estudiante");
            System.out.println("2. Eliminar estudiante");
            System.out.println("3. Listar estudiante");
            System.out.println("4. Buscar estudiante");
            System.out.println("5. Exit");
            opcion = scn.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el numero de estudiantes a agregar ");
                    cuantos = scn.nextInt();
                    agregarEstudiante(cuantos);
                    break;
                case 2:
                    System.out.println("Ingrese el codigo del estudiante a eliminar");
                    codigo = scn.nextLine();
                    codigo = scn.nextLine();
                    eliminarEstudiante(codigo);
                    break;
                case 3:
                    listarEstudiantes();
                    break;
                case 4:
                    System.out.println("Buscar por: \n 1.Nombre\n 2.Codigo\n 3.Carrera");
                    opcion_1 = scn.nextInt();
                    if (opcion_1 == 1 || opcion_1 == 2 || opcion_1 == 3) {
                        System.out.println("Ingrese el filtro");
                        filtro = scn.nextLine();
                        filtro = scn.nextLine();
                        buscarEstudiantes(filtro);
                    } else {
                        System.out.println("Invalid option");
                    }
                    break;
                case 5:
                    System.out.println(("Fin del programa"));
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }

    // metods
    private void cargarEstudiantes(ArrayList<Estudiante> lista) {
        try {
            BufferedReader lector = new BufferedReader(new FileReader("Estudiantes.txt"));
            String linea = "";
            while ((linea = lector.readLine()) != null) {
                System.out.println("Línea leída: " + linea);
                String[] componentes = linea.split(";");
                if (componentes.length == 4) {
                    String nombre = componentes[0];
                    String codigo = componentes[1];
                    String carrera = componentes[2];
                    double promedio = Double.parseDouble(componentes[3]);
                    lista.add(new Estudiante(nombre, codigo, carrera, promedio));
                } else {
                    System.err.println("La línea no tiene el formato esperado: " + linea);
                }
            }
            lector.close();
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    private void agregarEstudiante(int cuantos) {
        for (int i = 1; i <= cuantos; i++) {
            System.out.println("Ingrese los datos del estudiante " + (i));
            System.out.println("Nombre:");
            nombre = scn.nextLine();
            nombre = scn.nextLine();
            System.out.println("Codigo::");
            codigo = scn.nextLine();
            System.out.println("Carrera:");
            carrera = scn.nextLine();
            System.out.println("Promedio:");
            promedio = scn.nextDouble();
            estudiantes.add(new Estudiante(nombre, codigo, carrera, promedio));
        }
    }

    private void eliminarEstudiante(String codigo) {
        boolean flag = false;
        for (int i = 0; i < estudiantes.size(); i++) {
            Estudiante estudiante = estudiantes.get(i);
            if (estudiante.getCodigo().equals(codigo)) {
                estudiantes.remove(i);
                i--;
                flag = true;
                System.out.println("Eliminiación exitosa de la base de datos");
                break;
            }
        }
        if (flag == false) {
            System.out.println("No se encontró al estudiante dentro de la base de datos");
            
        }
    }

    private void listarEstudiantes() {
        System.out.println("Estudiantes registrados\n");
        for (Estudiante estudiante : estudiantes) {
            System.out.println("Nombre: " + estudiante.getNombre());
            System.out.println("Codigo: " + estudiante.getCodigo());
            System.out.println("Carrera: " + estudiante.getCarrera());
            System.out.println("Promedio: " + estudiante.getPromedio());
            System.out.println("");
        }
    }

    // funtion
    private void buscarEstudiantes(String filtro) {
        ArrayList<Estudiante> estudiante_filtro = new ArrayList<>();
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getNombre().equals(filtro) || estudiante.getCodigo().equals(filtro)
                    || estudiante.getCarrera().equals(filtro)) {
                estudiante_filtro.add(new Estudiante(estudiante.getNombre(), estudiante.getCodigo(),
                        estudiante.getCarrera(), estudiante.getPromedio()));
            }
        }
        for(Estudiante mostrar :estudiante_filtro){
            System.out.println("Nombre: " + mostrar.getNombre());
            System.out.println("Codigo: " + mostrar.getCodigo());
            System.out.println("Carrera: " + mostrar.getCarrera());
            System.out.println("Promedio: " + mostrar.getPromedio());
            System.out.println("");
        }
    }
}