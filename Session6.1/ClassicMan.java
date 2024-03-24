import java.util.ArrayList;
import java.util.Scanner;

public class ClassicMan {

    Scanner scan = new Scanner(System.in);

    ArrayList<Shoes> classic_shoes_man = new ArrayList<Shoes>();

    public int opcion = 0, mayor = 0, menor = 0, buscar_talla = 0, buscar_color = 0;
    boolean buscar_envio = false;

    public ArrayList<Shoes> addClassicShoesMan() {
        classic_shoes_man.add(new Shoes("Bosi", "URL10", 7, true, 350, "abc123", 38));
        classic_shoes_man.add(new Shoes("Velez", "URL11", 8, false, 300, "def456", 38));
        classic_shoes_man.add(new Shoes("Arturo Calle", "URL13", 5, true, 250, "ghi789", 40));
        classic_shoes_man.add(new Shoes("Chipichape", "URL12", 5, false, 200, "jklo987", 45));
        return classic_shoes_man;
    }

    // metodo menuRunning
    public void menuClassicMan() {
        System.out.println(
                "Bienvenido a la lista de Tennis tipo running\n1. Ver todos los productos\n2. filtar productos");
        opcion = scan.nextInt();

        if (opcion == 1) {
            mostrarTodosTennisMan();
        } else if (opcion == 2) {
            System.out.println("Filtar por :\n1. Precio\n2. Talla\n3. Envio\n4. Color");
            opcion = scan.nextInt();

            if (opcion == 1) {
                System.out.println("Ingrese el rango de precio\nMayor - menor");
                mayor = scan.nextInt();
                menor = scan.nextInt();
                filtarPorPrecioMan(mayor, menor);
            } else if (opcion == 2) {
                System.out.println("Ingrese la talla a buscar (int)");
                buscar_talla = scan.nextInt();
                filtarPorTallaMan(buscar_talla);
            } else if (opcion == 3) {
                System.out.println("Buscar Tennis que tiene envio: escribir 'true' \\n" + //
                        "2.Tennis que no tienen envio: escribir 'false'");
                buscar_envio = scan.nextBoolean();
                filtarPorEnvioMan(buscar_envio);
            } else if (opcion == 4) {
                System.out.println("Ingrese el minimo de colores a buscar");
                buscar_color = scan.nextInt();
                filtarPorColorMan(buscar_color);
            } else {
                System.out.println("Invalid option");
            }
        }
    }

    // metos forEach mostrar segun filtro
    public void mostrarTodosTennisMan() {
        for (Shoes mostrar : classic_shoes_man) {
            System.out.println("Nombre: " + mostrar.getNombre());
            System.out.println("Foto: " + mostrar.getFoto());
            System.out.println("Colores: " + mostrar.getColores());
            System.out.println("Envio: " + mostrar.getEnvio());
            System.out.println("Referencia:" + mostrar.getReferencia());
            System.out.println("Precio: " + mostrar.getPrecio());
            System.out.println("Talla: " + mostrar.getTalla());
        }
    }

    public void filtarPorTallaMan(int talla) {
        for (Shoes mostrar : classic_shoes_man) {
            if (mostrar.getTalla() == talla) {
                System.out.println("Nombre: " + mostrar.getNombre());
                System.out.println("Foto: " + mostrar.getFoto());
                System.out.println("Colores: " + mostrar.getColores());
                System.out.println("Envio: " + mostrar.getEnvio());
                System.out.println("Precio: " + mostrar.getPrecio());
                System.out.println("Talla: " + mostrar.getTalla());
            }
        }
    }

    public void filtarPorPrecioMan(int mayor, int menor) {
        for (Shoes mostrar : classic_shoes_man) {
            if (mostrar.getPrecio() < mayor && mostrar.getPrecio() > menor) {
                System.out.println("Nombre: " + mostrar.getNombre());
                System.out.println("Foto: " + mostrar.getFoto());
                System.out.println("Colores: " + mostrar.getColores());
                System.out.println("Envio: " + mostrar.getEnvio());
                System.out.println("Precio: " + mostrar.getPrecio());
                System.out.println("Talla: " + mostrar.getTalla());
            }
        }
    }

    public void filtarPorEnvioMan(boolean envio) {
        for (Shoes mostrar : classic_shoes_man) {
            if (mostrar.getEnvio() == envio) {
                System.out.println("Nombre: " + mostrar.getNombre());
                System.out.println("Foto: " + mostrar.getFoto());
                System.out.println("Colores: " + mostrar.getColores());
                System.out.println("Envio: " + mostrar.getEnvio());
                System.out.println("Precio: " + mostrar.getPrecio());
                System.out.println("Talla: " + mostrar.getTalla());
            }
        }
    }

    public void filtarPorColorMan(int color) {
        for (Shoes mostrar : classic_shoes_man) {
            if (mostrar.getColores() >= color) {
                System.out.println("Nombre: " + mostrar.getNombre());
                System.out.println("Foto: " + mostrar.getFoto());
                System.out.println("Colores: " + mostrar.getColores());
                System.out.println("Envio: " + mostrar.getEnvio());
                System.out.println("Precio: " + mostrar.getPrecio());
                System.out.println("Talla: " + mostrar.getTalla());
            }
        }
    }
}
