import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class RegistroInventario {

    Scanner snc = new Scanner(System.in);
    Scanner sncInt = new Scanner(System.in);
    Scanner sncdouble = new Scanner(System.in);

    ArrayList<Producto> productos = new ArrayList<>();
    ArrayList<Categoria> categorias = new ArrayList<>();
    ArrayList<Proveedor> proveedores = new ArrayList<>();
    ArrayList<Venta> ventas = new ArrayList<>();

    String filtro = "", nombre_producto = "", categoria_nombre = "", descripcion = "", nombre_provedor = "",
            telefono_proveedor = "", dirrecion_proveedor = "";
    int opcion_menu = 0, opcion = 0, opcion_filtro = 0, stock_producto = 0, cantidad_venta = 0,
            anio_venta = 0, mes_venta = 0, dia_venta = 0;
    double precio = 0, precio_filtro = 0;

    // constructor
    public RegistroInventario() {
        cargarCategorias(categorias);
        cargarProductos(productos);
        cargarVentas(ventas);
        cargarProveedores(proveedores);
    }

    // menu Inventario
    public void menuInventario() {
        while (opcion_menu != 10) {
            System.out.println("Menu Inventario");
            System.out.println("1. Registrar Producto");
            System.out.println("2. Registrar Categoria ");
            System.out.println("3. Registrar Proveedor ");
            System.out.println("4. Registrar ventas ");
            System.out.println("5. Listar producto");
            System.out.println("6. Listar categoria");
            System.out.println("7. Listar proveedor");
            System.out.println("8. Listar ventas");
            System.out.println("9. Buscar producto por filtro");
            System.out.println("10. Exit");
            opcion = sncInt.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el nombre de la categoria del producto");
                    categoria_nombre = snc.nextLine();

                    Categoria categoria_nuevo_producto = null;
                    for (Categoria a : categorias) {
                        if (a.getNombre_categoria().equals(categoria_nombre)) {
                            categoria_nuevo_producto = a;
                            break;
                        }
                    }

                    if (categoria_nuevo_producto != null) {
                        System.out.println("Ingrese el nombre del producto");
                        nombre_producto = snc.nextLine();
                        System.out.println("Ingrese el precio del producto");
                        precio = sncdouble.nextDouble();
                        System.out.println("Ingrese el stock del producto");
                        stock_producto = sncInt.nextInt();
                        Producto nuevo_producto = new Producto(nombre_producto, categoria_nuevo_producto, precio,
                                stock_producto);
                        registrarProducto(nuevo_producto);
                    } else {
                        System.out.println("No se encontro la categoria del producto");
                    }
                    break;
                case 2:
                    System.out.println("Ingrese el nombre de la nueva categoria");
                    categoria_nombre = snc.nextLine();
                    System.out.println("Ingrese la descripción de la nueva categoria");
                    descripcion = snc.nextLine();
                    Categoria nueva_categoria = new Categoria(categoria_nombre, descripcion);
                    registrarCategoria(nueva_categoria);
                    break;
                case 3:
                    System.out.println("Ingrese el nombre del nuevo proveedor");
                    nombre_provedor = snc.nextLine();
                    System.out.println("Ingrese el telefono del nuevo proveedor");
                    telefono_proveedor = snc.nextLine();
                    System.out.println("Ingrese la direccion del neuvo proveedor");
                    dirrecion_proveedor = snc.nextLine();

                    Proveedor nuevo_proveedor = new Proveedor(nombre_provedor, telefono_proveedor, dirrecion_proveedor);
                    registrarProveedor(nuevo_proveedor);
                    break;

                case 4:
                    System.out.println("Ingrese el nombre del producto vendido");
                    nombre_producto = snc.nextLine();

                    Producto nuevo_Producto = null;
                    for (Producto b : productos) {
                        if (b.getNombre_producto().equals(nombre_producto)) {
                            nuevo_Producto = b;
                            break;
                        }
                    }

                    if (nuevo_Producto != null) {
                        System.out.println("Ingrese las unidades vendidas");
                        cantidad_venta = sncInt.nextInt();
                        System.out.println("Ingrese la fecha de la venta : \n Año");
                        anio_venta = sncInt.nextInt();
                        System.out.println("Mes");
                        mes_venta = sncInt.nextInt();
                        ;
                        System.out.println("Dia");
                        dia_venta = sncInt.nextInt();

                        Fecha fecha_venta = new Fecha(anio_venta, mes_venta, dia_venta);
                        Venta nueva_venta = new Venta(nuevo_Producto, cantidad_venta, fecha_venta);
                        registrarVenta(nueva_venta);
                    } else {
                        System.out.println("No se encontro el producto");
                    }
                    break;
                case 5:
                    listarProductos(null);
                    break;
                case 6:
                    listarCategorias();
                    break;
                case 7:
                    listarProveedores();
                    break;
                case 8:
                    listarVentas();
                    break;
                case 9:
                    System.out.println("Filtar por :");
                    System.out.println("1. Nombre ");
                    System.out.println("2. Categoria");
                    System.out.println("3. Precio ");
                    opcion_filtro = sncInt.nextInt();
                    if (opcion_filtro == 3) {
                        System.out.println("Ingrese el precio filtro");
                        precio_filtro = sncdouble.nextDouble();
                        BuscarProductoFiltro(precio_filtro);
                    } else {
                        System.out.println("Ingrese el filtro");
                        filtro = snc.nextLine();
                        listarProductos(filtro);
                    }
                    break;
                    
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
        System.out.println("Fin del programa");
    }

    // metodos cargar desde archivo txt

    // Método para cargar productos desde el archivo productos.txt
    private void cargarProductos(ArrayList<Producto> list) {
        try (BufferedReader lector = new BufferedReader(new FileReader("productos.txt"))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                System.out.println("Línea leída: " + linea);
                String[] partes = linea.split(";");
                if (partes.length == 4) {
                    String nombreProducto = partes[0];
                    String nombre_categoria = partes[1];
                    double precio = Double.parseDouble(partes[2]);
                    int stock = Integer.parseInt(partes[3]);

                    // Crear una instancia de categoria
                    Categoria categoria = null;
                    for (Categoria b : categorias) {
                        if (b.getNombre_categoria().equals(nombre_categoria)) {
                            categoria = b;
                            break;
                        }
                    }

                    // Crea un objeto Producto
                    if (categoria != null) {
                        Producto producto = new Producto(nombreProducto, categoria, precio, stock);
                        list.add(producto);
                    } else {
                        System.out.println("No se encontró el nombre de la categoria");
                    }
                } else {
                    System.err.println("Error: formato incorrecto en la línea: " + linea);
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    // Método para cargar ventas desde el archivo ventas.txt
    private void cargarVentas(ArrayList<Venta> list) {
        try (BufferedReader lector = new BufferedReader(new FileReader("ventas.txt"))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                System.out.println("Línea leída: " + linea);
                String[] partes = linea.split(";");
                if (partes.length == 5) {
                    String nombreProducto = partes[0];
                    int cantidad = Integer.parseInt(partes[1]);
                    int anio = Integer.parseInt(partes[2]);
                    int mes = Integer.parseInt(partes[3]);
                    int dia = Integer.parseInt(partes[4]);
                    
                    // Crear objeto Date con la fecha de la venta
                    Fecha fechaVenta = new Fecha(anio, mes, dia);

                    // Crear una instancia de Producto
                    Producto producto = null;
                    for (Producto a : productos) {
                        if (a.getNombre_producto().equals(nombreProducto)) {
                            producto = a;
                            producto.setStock(producto.getStock() - cantidad);
                            break;
                        }
                    }

                    // Crea un objeto venta
                    if (producto != null) {
                        Venta venta = new Venta(producto, cantidad, fechaVenta);
                        list.add(venta);
                    } else {
                        System.out.println("No se encontró el producto");
                    }
                } else {
                    System.err.println("Error: formato incorrecto en la línea: " + linea);
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    // Método para cargar proveedores desde txt
    private void cargarProveedores(ArrayList<Proveedor> list) {
        try (BufferedReader lector = new BufferedReader(new FileReader("proveedores.txt"))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                System.out.println("Línea leída: " + linea);
                String[] partes = linea.split(";");
                if (partes.length == 3) {
                    String nombre_provedor = partes[0];
                    String telefono_provedor = partes[1];
                    String dirrecion_provedor = partes[2];

                    Proveedor provedor = new Proveedor(nombre_provedor, telefono_provedor, dirrecion_provedor);
                    list.add(provedor);
                } else {
                    System.err.println("Error: formato incorrecto en la línea: " + linea);
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    // Método para cargar categorias desde txt
    private void cargarCategorias(ArrayList<Categoria> list) {
        try (BufferedReader lector = new BufferedReader(new FileReader("categorias.txt"))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                System.out.println("Línea leída: " + linea);
                String[] partes = linea.split(";");
                if (partes.length == 2) {
                    String nombre_categoria = partes[0];
                    String descripcion = partes[1];

                    Categoria categoria = new Categoria(nombre_categoria, descripcion);
                    list.add(categoria);
                } else {
                    System.err.println("Error: formato incorrecto en la línea: " + linea);
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    // metodos imprimir

    private void listarProductos(String filtro) {
        System.out.println("\nProductos registrados\n");
        if (filtro == null) {
            for (Producto mostrar_producto : productos) {
                System.out.println("Nombre : " + mostrar_producto.getNombre_producto());
                System.out.println("Categoria : " + mostrar_producto.getCategoria().getNombre_categoria() + " "
                        + mostrar_producto.getCategoria().getDescripcion());
                System.out.println("Precio : " + mostrar_producto.getPrecio());
                System.out.println("Stock : " + mostrar_producto.getStock());
                System.out.println();
            }
        } else {
            for (Producto mostrar_producto : productos) {
                if (mostrar_producto.getNombre_producto().equals(filtro)
                        || mostrar_producto.getCategoria().getNombre_categoria().equals(filtro)) {
                    System.out.println("Nombre : " + mostrar_producto.getNombre_producto());
                    System.out.println("Categoria : " + mostrar_producto.getCategoria().getNombre_categoria() + " "
                            + mostrar_producto.getCategoria().getDescripcion());
                    System.out.println("Precio : " + mostrar_producto.getPrecio());
                    System.out.println("Stock : " + mostrar_producto.getStock());
                    System.out.println();
                }
            }
        }
    }

    private void listarCategorias() {
        System.out.println("\nCategorias registardos\n");
        for (Categoria mostrar_categoria : categorias) {
            System.out.println("Nombre : " + mostrar_categoria.getNombre_categoria());
            System.out.println("Descripción : " + mostrar_categoria.getDescripcion());
            System.out.println();
        }
    }

    private void listarProveedores() {
        System.out.println("\nProveedores registardos\n");
        for (Proveedor mostrar_proveedor : proveedores) {
            System.out.println("Nombre : " + mostrar_proveedor.getNombre_proveedor());
            System.out.println("Telefono : " + mostrar_proveedor.getTelefono());
            System.out.println("Dirrección : " + mostrar_proveedor.getDirreccion());
            System.out.println();
        }
    }

    private void listarVentas() {
        System.out.println("\nVentas registardos\n");
        for (Venta mostrar_venta : ventas) {
            System.out.println("Producto : " + mostrar_venta.getProducto().getNombre_producto());
            System.out.println("Cantidad : " + mostrar_venta.getCantidad());
            System.out.println("Fecha : " + mostrar_venta.getFechaVenta().getAnio() + " / " + mostrar_venta.getFechaVenta().getMes() +" / "+mostrar_venta.getFechaVenta().getDia());
            System.out.println();
        }
    }

    private void BuscarProductoFiltro(Double precio_filtro) {
        for (Producto mostrar_producto : productos) {
            if (mostrar_producto.getPrecio() == precio_filtro) {
                System.out.println("\nNombre : " + mostrar_producto.getNombre_producto());
                System.out.println("Categoria : " + mostrar_producto.getCategoria().getNombre_categoria() + " : "
                        + mostrar_producto.getCategoria().getDescripcion());
                System.out.println("Precio : " + mostrar_producto.getPrecio());
                System.out.println("Stock : " + mostrar_producto.getStock());
                System.out.println();
            }
        }
    }

    // metodos agregar obejecto a las respectivas listas.

    private void registrarProducto(Producto producto) {
        productos.add(producto);
    }

    private void registrarCategoria(Categoria categoria) {
        categorias.add(categoria);
    }

    private void registrarProveedor(Proveedor proveedor) {
        proveedores.add(proveedor);
    }

    private void registrarVenta(Venta venta) {
        int validar = venta.getProducto().getStock() - venta.getCantidad();
        if (validar > 0) {
            ventas.add(venta);
            venta.getProducto().setStock(venta.getProducto().getStock() - venta.getCantidad());
            System.out.println("Venta registrada con exito");
        } else {
            System.out.println("El producto no posee suficientes unidades disponibles\nUnidades disponibles : "
                    + venta.getProducto().getStock());
        }
    }

}