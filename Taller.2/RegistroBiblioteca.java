import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class RegistroBiblioteca {

    String nacionalidad_autor = "", nombre_autor = "", titulo = "", isbn = "", categoria = "", filtro = "",
            cedula_usuario = "";
    int ejemplares = 0, opcion_menu = 0, cuantos = 0, opcion_1 = 0, anio_prestamo = 0, mes_prestamo = 0,
            dia_prestamo = 0, anio_devolucion = 0, mes_devolucion = 0, dia_devolucion = 0;

    Scanner snline = new Scanner(System.in);
    Scanner snint = new Scanner(System.in);

    ArrayList<Autor> autores = new ArrayList<>();
    ArrayList<Libro> libros = new ArrayList<>();
    ArrayList<Usuario> usuarios = new ArrayList<>();
    ArrayList<Prestamo> prestamos = new ArrayList<>();

    // constructor
    RegistroBiblioteca() {
        cargarAurtores(autores);
        cargarLibros(libros);
        cargarUsuarios(usuarios);
        cargarPrestamos(prestamos);
    }

    // menu Biblioteca
    public void menuBiblioteca() {
        System.out.println("Sistema Biblioteca");
        while (opcion_menu != 9) {
            System.out.println("\nMenu biblioteca\n");
            System.out.println("1. Registrar libro");
            System.out.println("2. Registrar autor");
            System.out.println("3. Registrar prestamo");
            System.out.println("4. Registar devolución");
            System.out.println("5. Mostrar todos los autores");
            System.out.println("6. Mostrar todos los libros");
            System.out.println("7. Mostrar todos los prestamos");
            System.out.println("8. Buscar libro por filtro");
            System.out.println("9. Exit");
            opcion_menu = snint.nextInt();

            switch (opcion_menu) {
                case 1:
                    System.out.println("¿Cuantos libros desea ingresar?");
                    cuantos = snint.nextInt();
                    for (int i = 1; i <= cuantos; i++) {

                        System.out.println("Ingrese el nombre del autor " + (i));
                        nombre_autor = snline.nextLine();
                        Autor autor = null;
                        for (Autor a : autores) {
                            if (a.getNombre().equals(nombre_autor)) {
                                autor = a;
                                break;
                            }
                        }

                        if (autor != null) {
                            // datos del libro
                            System.out.println("Ingrese el titulo del libro " + (i));
                            titulo = snline.nextLine();
                            System.out.println("Ingrese la categoria del libro " + (i));
                            categoria = snline.nextLine();
                            System.out.println("Ingrese el codigo isbn del libro " + (i));
                            isbn = snline.nextLine();
                            System.out.println("Ingrese la cantidad de ejemplares del libro " + (i));
                            ejemplares = snint.nextInt();
                            // creacion de objeto libro e ingreso al arrayList libros
                            Libro libro_nuevo = new Libro(titulo, isbn, categoria, ejemplares, autor);
                            registrarLibro(libro_nuevo);
                        } else {
                            System.out.println("No se encontro el autor");
                        }

                    }
                    break;

                case 2:
                    System.out.println("¿Cuantos autores desea ingresar?");
                    cuantos = snint.nextInt();
                    for (int i = 1; i <= cuantos; i++) {
                        System.out.println("Ingrese el nombre del autor " + (i));
                        nombre_autor = snline.nextLine();
                        System.out.println("Ingrese la nacionalidad " + (i));
                        nacionalidad_autor = snline.nextLine();
                        Autor autor_libro = new Autor(nombre_autor, nacionalidad_autor);
                        registarAutor(autor_libro);
                    }
                    break;

                case 3:
                    System.out.println("Ingrese la cedula del usuario");
                    cedula_usuario = snline.nextLine();

                    Usuario usuario = null;
                    for (Usuario a : usuarios) {
                        // validar si el usuario esta dentro del array usuarios
                        if (a.getCedula().equals(cedula_usuario)) {
                            usuario = a;
                            break;
                        }
                    }

                    System.out.println("Ingrese el isbn del libro");
                    isbn = snline.nextLine();
                    Libro libro = null;
                    for (Libro b : libros) {
                        // validar si el libro esta dentro del array usuarios
                        if (b.getIsbn().equals(isbn)) {
                            libro = b;
                            break;
                        }
                    }
                    if (libro != null && usuario != null) {
                        System.out.println("Ingrese la fecha de prestamo: \naño");
                        anio_prestamo = snint.nextInt();
                        System.out.println("mes");
                        mes_prestamo = snint.nextInt();
                        System.out.println("dia");
                        dia_prestamo = snint.nextInt();
                        Fecha fecha_prestamo = new Fecha(anio_prestamo, mes_prestamo, dia_prestamo);

                        System.out.println("Ingrese la fecha de devolución: \naño");
                        anio_devolucion = snint.nextInt();
                        System.out.println("mes");
                        mes_devolucion = snint.nextInt();
                        System.out.println("dia");
                        dia_devolucion = snint.nextInt();
                        Fecha fecha_devolucion = new Fecha(anio_devolucion, mes_devolucion, dia_devolucion);

                        Prestamo nuevo_prestamo = new Prestamo(libro, usuario, fecha_prestamo, fecha_devolucion);
                        registrarPrestamo(nuevo_prestamo);
                    } else {
                        System.out
                                .println("El usuario o el libro no se encuentra en la base de datos. debe registrarse");
                    }
                    break;
                case 4:
                    System.out.println("Ingrese la cedula del usuario");
                    cedula_usuario = snline.nextLine();
                    System.out.println("Ingrese el isbn del libro");
                    isbn = snline.nextLine();
                    Prestamo devolucion = null;
                    for (Prestamo c : prestamos) {
                        if (c.getUsuario().getCedula().equals(cedula_usuario) && c.getLibro().getIsbn().equals(isbn)) {
                            devolucion = c;
                            break;
                        }
                    }
                    if (devolucion != null) {
                        registrarDevolucion(devolucion);
                    } else {
                        System.out.println("No se encontro el prestamo sobre la cedula del usaurio");
                    }
                    break;
                case 5:
                    ListarAutores();
                    break;
                case 6:
                    listarLibros(libros);
                    break;
                case 7:
                    listarPrestamos();
                    break;
                case 8:
                    System.out.println("Buscar Libro por:");
                    System.out.println("1.Titulo");
                    System.out.println("2.Autor");
                    System.out.println("3.ISBN");
                    System.out.println("4.Autor");
                    opcion_1 = snint.nextInt();

                    if (opcion_1 == 1 || opcion_1 == 2 || opcion_1 == 3 || opcion_1 == 4) {
                        System.out.println("Ingrese el filtro");
                        filtro = snline.nextLine();
                        listarLibros(buscarLibro(filtro));

                    } else {
                        System.out.println("Invalid option");
                    }
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
        System.out.println("Fin del programa ;3");
    }

    // metodo cargarAutores al array desde txt
    private void cargarAurtores(ArrayList<Autor> lista) {
        try {
            BufferedReader lector = new BufferedReader(new FileReader("autores.txt"));
            String linea = "";
            while ((linea = lector.readLine()) != null) {
                System.out.println("Línea leída: " + linea);
                String[] componentes = linea.split(";");
                if (componentes.length == 2) {
                    String nombre = componentes[0];
                    String nacionalidad = componentes[1];
                    lista.add(new Autor(nombre, nacionalidad));
                } else {
                    System.err.println("La línea no tiene el formato esperado: " + linea);
                }
            }
            lector.close();
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    // metodo cargar libros al arrayList desde archivo txt
    public void cargarLibros(ArrayList<Libro> list_Libros) {
        try (BufferedReader lector = new BufferedReader(new FileReader("libros.txt"))) {
            String linea = "";
            while ((linea = lector.readLine()) != null) {
                System.out.println("Línea leída: " + linea);
                String[] componentes = linea.split(";");

                if (componentes.length == 5) {
                    String titulo = componentes[0];
                    String isbn = componentes[1];
                    String categoria = componentes[2];
                    int ejemplares = Integer.parseInt(componentes[3]);
                    String nombreAutor = componentes[4];

                    // Encuentra el autor correspondiente en la lista de autores
                    Autor autor_libro = null;
                    for (Autor a : autores) {
                        if (a.getNombre().equals(nombreAutor)) {
                            autor_libro = a;
                            break;
                        }
                    }

                    // Crea un objeto Libro si se encontró el autor y se agrega al ArrayList de
                    // libros.
                    if (autor_libro != null) {
                        Libro libro = new Libro(titulo, isbn, categoria, ejemplares, autor_libro);
                        libros.add(libro);
                    } else {
                        System.out.println("No se encontró el autor para el libro: " + titulo);
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

    // metodo cargar usuarios al arrayList desde archivo txt
    private void cargarUsuarios(ArrayList<Usuario> lista) {
        try {
            BufferedReader lector = new BufferedReader(new FileReader("usuarios.txt"));
            String linea = "";
            while ((linea = lector.readLine()) != null) {
                System.out.println("Línea leída: " + linea);
                String[] componentes = linea.split(";");
                if (componentes.length == 2) {
                    String nombre = componentes[0];
                    String cedula = componentes[1];
                    usuarios.add(new Usuario(nombre, cedula));
                } else {
                    System.err.println("La línea no tiene el formato esperado: " + linea);
                }
            }
            lector.close();
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    // metodo cargar prestamos al arrayList desde archivo txt
    private void cargarPrestamos(ArrayList<Prestamo> lista) {
        try {
            BufferedReader lector = new BufferedReader(new FileReader("prestamos.txt"));
            String linea = "";
            while ((linea = lector.readLine()) != null) {
                System.out.println("Línea leída: " + linea);
                String[] componentes = linea.split(";");
                if (componentes.length == 8) {

                    // buscar libro por su isbn
                    String Isbn_del_libro = componentes[0];
                    Libro libro_buscar = null;
                    for (Libro a : libros) {
                        if (a.getIsbn().equals(Isbn_del_libro)) {
                            libro_buscar = a;
                            libro_buscar.setEjemplares(libro_buscar.getEjemplares() - 1);
                            break;
                        }
                    }
                    // buscar usuario por la cedula
                    String cedula_del_usuario = componentes[1];
                    Usuario buscar_usuario = null;
                    for (Usuario b : usuarios) {
                        if (b.getCedula().equals(cedula_del_usuario)) {
                            buscar_usuario = b;
                            break;
                        }
                    }

                    int prestamo_anio = Integer.parseInt(componentes[2]);
                    int prestamo_mes_txt = Integer.parseInt(componentes[3]);
                    int prestamo_dia_txt = Integer.parseInt(componentes[4]);
                    Fecha fecha_prestamo = new Fecha(prestamo_anio, prestamo_mes_txt, prestamo_dia_txt);

                    int anio_devolucion_txt = Integer.parseInt(componentes[5]);
                    int mes_devolucion_txt = Integer.parseInt(componentes[6]);
                    int dia_devolucion_txt = Integer.parseInt(componentes[7]);
                    Fecha fecha_devolucion = new Fecha(anio_devolucion_txt, mes_devolucion_txt, dia_devolucion_txt);

                    // Crea objeto de libro prestamo y se agrega al arrayList de prestamos
                    if (libro_buscar != null && cedula_del_usuario != null) {

                        Prestamo prestamo = new Prestamo(libro_buscar, buscar_usuario, fecha_prestamo,
                                fecha_devolucion);
                        prestamos.add(prestamo);

                    } else {
                        System.out.println("no se encontro registro");
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

    // metodos imprimir
    // metodos imprimir Autores
    private void ListarAutores() {
        System.out.println("\nAutores registrados\n");
        for (Autor mostrar_autores : autores) {
            System.out.println("Nombre: " + mostrar_autores.getNombre());
            System.out.println("Nacionalidad: " + mostrar_autores.getNacionalidad());
            System.out.println();
        }
    }

    // metodos imprimir Libros
    private void listarLibros(ArrayList<Libro> lista) {
        System.out.println("\nLibros registrados\n");
        for (Libro mostrar_libros : lista) {
            System.out.println("Libro: " + mostrar_libros.toString());
            System.out.println(mostrar_libros.getAutor().getNacionalidad());
            System.out.println();
        }
    }

    // metodo imprimir prestamos
    private void listarPrestamos() {
        System.out.println("\nRegistro de Prestamos\n");
        for (Prestamo mostrar_prestamo : prestamos) {
            System.out.println("Libro: \n" + mostrar_prestamo.getLibro().toString());

            System.out.println("Usuario: " + mostrar_prestamo.getUsuario().getNombre_completo() + " CC: "
                    + mostrar_prestamo.getUsuario().getCedula());

            System.out.println("Fecha prestamo : "
                    + mostrar_prestamo.getFecha_prestamo().toString());

            System.out.println("Fecha devolucion : "
                    + mostrar_prestamo.getFecha_devolucion().toString());
            System.out.println();
        }
    }

    // funcion buscar libro por filtro
    private ArrayList<Libro> buscarLibro(String filtro) {
        ArrayList<Libro> libros_filtro_ArrayList = new ArrayList<>();
        for (Libro libro_filtro : libros) {
            if (libro_filtro.getTitulo().equals(filtro) || libro_filtro.getCategoria().equals(filtro)
                    || libro_filtro.getIsbn().equals(filtro) || libro_filtro.getAutor().getNombre().equals(filtro)) {

                titulo = libro_filtro.getTitulo();
                categoria = libro_filtro.getCategoria();
                isbn = libro_filtro.getIsbn();
                ejemplares = libro_filtro.getEjemplares();
                Autor autor_libro = libro_filtro.getAutor();

                if (autor_libro != null) {
                    Libro libro = new Libro(titulo, isbn, categoria, ejemplares, autor_libro);
                    libros_filtro_ArrayList.add(libro);
                } else {
                    System.out.println("No se encontró el libro dentro de la base de datos " + titulo);
                }
            }
        }
        return libros_filtro_ArrayList;
    }

    // metodos registrar
    private void registarAutor(Autor autor) {
        autores.add(autor);
        System.out.println("Autor registrado con exito");
    }

    private void registrarLibro(Libro libro) {
        libros.add(libro);
        System.out.println("Libro registrado con exito");

    }

    private void registrarPrestamo(Prestamo prestamo) {
        //fecha actual
        LocalDate fechaActual = LocalDate.now();
        if (prestamo.getLibro().getEjemplares() < 0) {
            System.out.println("No hay ejemplares del libro disponibles");
        }
        // buscar si el usuario tiene prestamos registrados
        Prestamo buscar_prestamo = null;
        boolean encontrado = false;
        for (Prestamo c : prestamos) {
            if (c.getUsuario().getNombre_completo().equals(prestamo.getUsuario().getNombre_completo())) {
                buscar_prestamo = c;
                encontrado = true;
            }
        }
        if (encontrado) {
            // validar si el usuario tiene prestamos vencidos comparando la fecha actual si
            // se encontro un prestamo a su nombre
            if ( buscar_prestamo.getFecha_devolucion().getAnio() >= fechaActual.getYear() && buscar_prestamo.getFecha_devolucion().getMes() >= fechaActual.getMonthValue() && fechaActual.getDayOfMonth() >= buscar_prestamo.getFecha_devolucion().getDia() ) {

                System.out.println("El usuario cuenta con un prestamo pendiente mas NO vencido");
                prestamos.add(prestamo);
                prestamo.getLibro().setEjemplares(prestamo.getLibro().getEjemplares() - 1);
                System.out.println("Prestamo registrado con exito");
            
            } else {
                System.out.println("El usuario cuenta con prestamos vencidos");
            }
        } else {
            System.out.println("El usuario no contaba con prestamos dentro de la base de datos, este es el primero");
            prestamos.add(prestamo);
            prestamo.getLibro().setEjemplares(prestamo.getLibro().getEjemplares() - 1);
            System.out.println("Prestamo registrado con exito");
        }
    }

    private void registrarDevolucion(Prestamo prestamo) {
        System.out.println("Devolución registrada con exito");
        prestamo.getLibro().setEjemplares(prestamo.getLibro().getEjemplares() + 1);
        prestamos.remove(prestamo);
    }
}