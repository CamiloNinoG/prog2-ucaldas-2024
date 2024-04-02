import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class RegistrarPacientes {

    private ArrayList<Cita> citas = new ArrayList<>();
    private ArrayList<Especialidad> especialidades = new ArrayList<>();
    private ArrayList<Medico> medicos = new ArrayList<>();
    private ArrayList<Paciente> pacientes = new ArrayList<>();

    Scanner scanInt = new Scanner(System.in);
    Scanner scanLine = new Scanner(System.in);

    int opcion = 0, opcion_filtro = 0, año = 0, mes = 0, dia = 0, hora = 0, minuto = 0;
    String filtro = "", nombre_paciente = "", telefono_paciente = "", direccion_paciente = "", cedula_paciente = "",
            nombre_medico = "", codigo_medico = "", especialidad = "", descripcion = "", estado_cita_nueva = "";

    // constructor class Registro Pacientes
    public RegistrarPacientes() {
        cargarEspecialidades(especialidades);
        cargarMedicos(medicos);
        cargarPacientes(pacientes);
        cargarCitas(citas);
    }

    // menu RegistrarPacientes
    public void menuRegistarPacientes() {
        System.out.println("\nSistema Hospital");

        while (opcion != 10) {
            System.out.println("\nMenu Registro Pacientes\nSeleccione una opcion");
            System.out.println("1. Registar nuev@ paciente");
            System.out.println("2. Registar nuev@ medico");
            System.out.println("3. Registar nueva especialidad ");
            System.out.println("4. Registar cita");
            System.out.println("5. listar pacientes");
            System.out.println("6. listar medicos");
            System.out.println("7. listar especialidades");
            System.out.println("8. listar citas");
            System.out.println("9. buscar citas por filtro");
            System.out.println("10. Exit");
            opcion = scanInt.nextInt();
            switch (opcion) {

                case 1:
                    System.out.println("Ingrese el nombre completo del paciente");
                    nombre_paciente = scanLine.nextLine();
                    System.out.println("Ingrese la cedula del paciente");
                    cedula_paciente = scanLine.nextLine();
                    System.out.println("Ingrese el telefono del paciente");
                    telefono_paciente = scanLine.nextLine();
                    System.out.println("Ingrese la dirección del paciente");
                    direccion_paciente = scanLine.nextLine();

                    Paciente nuevo_paciente = new Paciente(nombre_paciente, cedula_paciente, telefono_paciente,
                            direccion_paciente);
                    registrarPaciente(nuevo_paciente);
                    break;

                case 2:
                    System.out.println("Ingrese la especialidad del medico");
                    especialidad = scanLine.nextLine();

                    Especialidad especilidad = null;
                    for (Especialidad c : especialidades) {
                        if (c.getNombre_especialidad().equals(especialidad)) {
                            especilidad = c;
                            break;
                        }
                    }

                    if (especilidad != null) {
                        System.out.println("Ingrese el codigo del medico");
                        codigo_medico = scanLine.nextLine();
                        System.out.println("Ingrese el nombre completo del nuevo medico");
                        nombre_medico = scanLine.nextLine();

                        Medico nuevo_medico = new Medico(nombre_medico, especilidad, codigo_medico);
                        registrarMedico(nuevo_medico);
                    } else {
                        System.out.println(" No se encontro la especialidad del medico en la base de datos");
                    }
                    break;

                case 3:
                    System.out.println("Ingrese el nombre de la nueva especialidad");
                    especialidad = scanLine.nextLine();
                    System.out.println("Ingrese la descripción de la especialidad");
                    descripcion = scanLine.nextLine();

                    Especialidad especialidad_neuva = new Especialidad(especialidad, descripcion);
                    registrarEspecialidad(especialidad_neuva);
                    break;

                case 4:
                    System.out.println("Ingrese la cedula del paciente");
                    cedula_paciente = scanLine.nextLine();

                    Paciente paciente = null;
                    for (Paciente c : pacientes) {
                        if (c.getCedula().equals(cedula_paciente)) {
                            paciente = c;
                        }
                    }

                    System.out.println("Ingrese el codigo del medico");
                    codigo_medico = scanLine.nextLine();

                    Medico medico = null;
                    for (Medico c : medicos) {
                        if (c.getCodigo_medico().equals(codigo_medico)) {
                            medico = c;
                        }
                    }
                    System.out.println("Ingrese la fecha de la cita\naño");
                    año = scanInt.nextInt();
                    System.out.println("mes");
                    mes = scanInt.nextInt();
                    System.out.println("dia");
                    dia = scanInt.nextInt();
                    System.out.println("hora");
                    hora = scanInt.nextInt();
                    System.out.println("minuto");
                    minuto = scanInt.nextInt();
                    Fecha fecha_nueva_cita = new Fecha(año, mes, dia, hora, minuto);
                    System.out.println("Ingrese el estado de la cita ");
                    estado_cita_nueva = scanLine.nextLine();
                    Cita nueva_cita = new Cita(paciente, medico, fecha_nueva_cita, estado_cita_nueva);

                    if (medico != null && paciente != null) {
                        registrarCita(nueva_cita);
                    } else {
                        System.out.println("No se encontro el paciente o el medico en la base de datos ");
                    }
                    break;

                case 5:
                    listarPacientes();
                    break;

                case 6:
                    listarMedicos();
                    break;

                case 7:
                    listarEspecialidades();
                    break;

                case 8:
                    listarCitas(citas);
                    break;

                case 9:
                    System.out.println("Buscar Cita por:");
                    System.out.println("1. Nombre paciente ");
                    System.out.println("2. Nombre medico");
                    System.out.println("3. Nombre de la especialidad");
                    System.out.println("4. Fecha");
                    opcion_filtro = scanInt.nextInt();

                    if (opcion_filtro == 1 || opcion_filtro == 2 || opcion_filtro == 3) {
                        System.out.println("Ingrese el filtro");
                        filtro = scanLine.nextLine();
                        listarCitas(buscarCita(filtro));

                    } else if (opcion_filtro == 4) {
                        System.out.println("Ingrese el año de la cita");
                        año = scanInt.nextInt();
                        System.out.println("Ingrese el mes de la cita");
                        mes = scanInt.nextInt();
                        System.out.println("Ingrese el dia de la cita");
                        dia = scanInt.nextInt();
                        System.out.println("Ingrese la hora de la cita");
                        hora = scanInt.nextInt();
                        System.out.println("Ingrese los minutos de la cita");
                        minuto = scanInt.nextInt();

                        Fecha fecha_cita_filtro = new Fecha(año, mes, dia, hora, minuto);

                        Cita cita_filtro = null;
                        for (Cita b : citas) {
                            if (b.getFecha_cita().getAño() == año && b.getFecha_cita().getMes() == mes
                                    && b.getFecha_cita().getDia() == dia && b.getFecha_cita().getHora() == hora
                                    && b.getFecha_cita().getMinuto() == minuto) {
                                cita_filtro = b;
                                break;
                            }
                        }
                        if (cita_filtro != null) {
                            System.out.println("Cita hallda!");
                            System.out.println("Paciente: " + cita_filtro.getPaciente().toString());
                            System.out.println("medico: " + cita_filtro.getMedico().toString());
                            System.out.println("fecha: " + fecha_cita_filtro.toString());
                        } else {
                            System.out.println("No se encontro la cita ");
                        }
                    } else {
                        System.out.println("Invalid option");
                    }
                    break;

                case 10:
                    System.out.println("Fin del programa");
                    break;
                default:
                    System.out.println("Opcion Invalida");
                    break;
            }
        }
    }

    // metodos cargar desde archivos txt
    // especialidades
    private void cargarEspecialidades(ArrayList<Especialidad> lista) {
        try {
            BufferedReader lector = new BufferedReader(new FileReader("especialidades.txt"));
            String linea = "";
            while ((linea = lector.readLine()) != null) {
                System.out.println("Línea leída: " + linea);
                String[] componentes = linea.split(";");
                if (componentes.length == 2) {
                    String nombre_especialidad = componentes[0];
                    String descripcion_espececialidad = componentes[1];
                    lista.add(new Especialidad(nombre_especialidad, descripcion_espececialidad));
                } else {
                    System.err.println("La línea no tiene el formato esperado: " + linea);
                }
            }
            lector.close();
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    // medicos
    private void cargarMedicos(ArrayList<Medico> lista) {
        try {
            BufferedReader lector = new BufferedReader(new FileReader("medicos.txt"));
            String linea = "";
            while ((linea = lector.readLine()) != null) {
                System.out.println("Línea leída: " + linea);
                String[] componentes = linea.split(";");
                if (componentes.length == 3) {
                    String nombre_medicoString = componentes[0];
                    String nombre_espececialidad = componentes[1];

                    Especialidad especialidad_medico = null;
                    for (Especialidad a : especialidades) {
                        if (a.getNombre_especialidad().equals(nombre_espececialidad)) {
                            especialidad_medico = a;
                            break;
                        }
                    }
                    String codigo_medico = componentes[2];

                    if (especialidad_medico != null) {
                        lista.add(new Medico(nombre_medicoString, especialidad_medico, codigo_medico));
                    } else {
                        System.out.println("No se encontro la especialidad del medico");
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

    // pacientes
    private void cargarPacientes(ArrayList<Paciente> lista) {
        try {
            BufferedReader lector = new BufferedReader(new FileReader("pacientes.txt"));
            String linea = "";
            while ((linea = lector.readLine()) != null) {
                System.out.println("Línea leída: " + linea);
                String[] componentes = linea.split(";");
                if (componentes.length == 4) {
                    String nombre_paciente = componentes[0];
                    String telefono_paciente = componentes[1];
                    String cedula_paciente = componentes[2];
                    String direccion_paciente = componentes[3];
                    lista.add(new Paciente(nombre_paciente, cedula_paciente, telefono_paciente, direccion_paciente));
                } else {
                    System.err.println("La línea no tiene el formato esperado: " + linea);
                }
            }
            lector.close();
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    // Citas
    private void cargarCitas(ArrayList<Cita> lista) {
        try {
            BufferedReader lector = new BufferedReader(new FileReader("citas.txt"));
            String linea = "";
            while ((linea = lector.readLine()) != null) {
                System.out.println("Línea leída: " + linea);
                String[] componentes = linea.split(";");
                if (componentes.length == 8) {

                    String nombre_paciente = componentes[0];
                    Paciente paciente = null;
                    for (Paciente a : pacientes) {
                        if (a.getNombre().equals(nombre_paciente)) {
                            paciente = a;
                            break;
                        }
                    }

                    String nombre_medico = componentes[1];
                    Medico medico = null;
                    for (Medico a : medicos) {
                        if (a.getNombre_medico().equals(nombre_medico)) {
                            medico = a;
                            break;
                        }
                    }

                    int año = Integer.parseInt(componentes[2]);
                    int mes = Integer.parseInt(componentes[3]);
                    int dia = Integer.parseInt(componentes[4]);
                    int hora = Integer.parseInt(componentes[5]);
                    int minuto = Integer.parseInt(componentes[6]);
                    Fecha fecha_cita = new Fecha(año, mes, dia, hora, minuto);

                    String estado_cita = componentes[7];

                    if (medico != null && paciente != null) {
                        lista.add(new Cita(paciente, medico, fecha_cita, estado_cita));
                    } else {
                        System.out.println("No se encontro el medico o el paciente");
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

    // metodos registar
    private void registrarPaciente(Paciente nuevo_paciente) {
        pacientes.add(nuevo_paciente);
        System.out.println("Paciente registrado con exito");
    }

    private void registrarMedico(Medico nuevo_medico) {
        medicos.add(nuevo_medico);
        System.out.println("Medico registrado con exito");
    }

    private void registrarEspecialidad(Especialidad nueva_especialidad) {
        especialidades.add(nueva_especialidad);
        System.out.println("Especialidad registrado con exito");
    }

    private void registrarCita(Cita nueva_cita) {
        boolean bandera_cita = true;

        while (bandera_cita) {
            // Buscar citas del médico
            ArrayList<Cita> citas_medico = buscarCita(nueva_cita.getMedico().getNombre_medico());

            // Verificar si el médico tiene disponibilidad
            boolean medico_disponible = true;
            for (Cita c : citas_medico) {

                System.out.println("Fecha: " + c.getFecha_cita().toString());
                if (c.getFecha_cita().getAño() == nueva_cita.getFecha_cita().getAño() &&
                        c.getFecha_cita().getMes() == nueva_cita.getFecha_cita().getMes() &&
                        c.getFecha_cita().getDia() == nueva_cita.getFecha_cita().getDia() &&
                        c.getFecha_cita().getHora() == nueva_cita.getFecha_cita().getHora() &&
                        c.getFecha_cita().getMinuto() == nueva_cita.getFecha_cita().getMinuto()) {
                    System.out.println("El médico no tiene disponibilidad. No se pudo registrar la cita.");
                    medico_disponible = false;
                    bandera_cita = false;
                    break;

                }
            }

            // Si el médico tiene disponibilidad, verificar disponibilidad del paciente
            if (medico_disponible) {
                ArrayList<Cita> citas_paciente = buscarCita(nueva_cita.getPaciente().getNombre());

                // Verificar si el paciente tiene disponibilidad
                boolean paciente_disponible = true;
                for (Cita d : citas_paciente) {
                    if (d.getFecha_cita().getAño() == nueva_cita.getFecha_cita().getAño()
                            && d.getFecha_cita().getMes() == nueva_cita.getFecha_cita().getMes()
                            && d.getFecha_cita().getDia() == nueva_cita.getFecha_cita().getDia()
                            && d.getFecha_cita().getHora() == nueva_cita.getFecha_cita().getHora()
                            && d.getFecha_cita().getMinuto() == nueva_cita.getFecha_cita().getMinuto()) {
                        System.out.println("El paciente posee una cita en ese horario. No se pudo registrar la cita.");
                        paciente_disponible = false;
                        bandera_cita = false;

                        break;
                    }
                }

                // Si tanto el médico como el paciente tienen disponibilidad, registrar la cita
                if (paciente_disponible) {
                    citas.add(nueva_cita);
                    bandera_cita = false;
                    System.out.println("Cita registrada correctamente!");
                    System.out.println("Paciente:\n" + nueva_cita.getPaciente().toString());
                    System.out.println("Médico: " + nueva_cita.getMedico().toString());
                    System.out.println("Fecha: " + nueva_cita.getFecha_cita().toString());
                    System.out.println("Estado: " + nueva_cita.getEstado());
                }
            }
        }
    }

    // buscar cita por filtro
    private ArrayList<Cita> buscarCita(String filtro) {
        ArrayList<Cita> cita_filtro = new ArrayList<>();
        for (Cita c : citas) {
            if (c.getPaciente().getNombre().equals(filtro) || c.getMedico().getNombre_medico().equals(filtro)
                    || c.getMedico().getEspecialidad_medico().getNombre_especialidad().equals(filtro)) {
                cita_filtro.add(c);
            }
        }
        return cita_filtro;
    }

    // metodos listar
    private void listarCitas(ArrayList<Cita> lista) {
        System.out.println("\n--Citas Registradas--\n");
        for (Cita cita : lista) {
            System.out.println("Detalle de la cita:");
            System.out.println("Paciente:\n" + cita.getPaciente().toString());
            System.out.println("Médico: " + cita.getMedico().toString());
            System.out.println("Fecha de la cita: " + cita.getFecha_cita().toString());
            System.out.println("Estado: " + cita.getEstado());
            System.out.println();
        }
    }

    private void listarEspecialidades() {
        System.out.println("\n--Especialidades Registradas--\n");
        for (Especialidad especialidad : especialidades) {
            System.out.println(especialidad.toString());
            System.out.println();
        }
    }

    private void listarMedicos() {
        System.out.println("\n--Medicos Registradas--\n");
        for (Medico medico : medicos) {
            System.out.println(medico.toString());
            System.out.println();
        }
    }

    private void listarPacientes() {
        System.out.println("\n--Pacientes Registradas--\n");
        for (Paciente paciente : pacientes) {
            System.out.println(paciente.toString());
            System.out.println();
        }
    }
}