import java.util.ArrayList;
import java.util.Scanner;

public class AllCategories {

    public int opcion = 0, mayor = 0, menor = 0, buscar_talla = 0, buscar_color = 0;
    boolean buscar_envio = false;

    ArrayList<Shoes> Classic_shoes = new ArrayList<Shoes>();
    ArrayList<Shoes> running_shoes = new ArrayList<Shoes>();

    Scanner scan = new Scanner(System.in);

    public void addAllCategorie() {
        running_shoes.add(new Shoes("Force2", "URL1", 7, true, 100, "abc123", 38));
        running_shoes.add(new Shoes("Adidas Rz", "URL2", 6, false, 890, "def456", 38));
        running_shoes.add(new Shoes("Puma", "URL3", 4, true, 149, "ghi789", 33));
        running_shoes.add(new Shoes("CAT", "URL", 5, false, 150, "jklo987", 20));


        Classic_shoes.add(new Shoes("Nike", "URL4", 7, true, 128, "abc123", 20));
        Classic_shoes.add(new Shoes("Honda Adidas", "URL1", 3, true, 149, "abc123", 38));
        Classic_shoes.add(new Shoes("Adidas RX", "URL2", 6, false, 502, "def456", 38));
        Classic_shoes.add(new Shoes("Tigre", "URL3", 4, true, 99, "ghi789", 38));
        Classic_shoes.add(new Shoes("New balance", "URL", 5, false, 100, "jklo987", 10));

    }

    // metodo menuClassic
    public void menuAllCategories() {
        System.out.println(
                "Bienvenido a la lista de Tennis\n1. Ver todos los productos\n2. Filtar productos");
        opcion = scan.nextInt();

        if (opcion == 1) {
            mostrarTodosTennis();
        } else if (opcion == 2) {
            System.out.println("Filtar por :\n1. Precio\n2. Talla\n3. Envio\n4. Colores");
            opcion = scan.nextInt();

            if (opcion == 1) {
                System.out.println("Ingrese el rango de precio\nMayor - menor");
                mayor = scan.nextInt();
                menor = scan.nextInt();
                filtarPorPrecio(mayor, menor);
            } else if (opcion == 2) {
                System.out.println("Ingrese la talla a buscar (int)");
                buscar_talla = scan.nextInt();
                filtarPorTalla(buscar_talla);
            } else if (opcion == 3) {
                System.out.println("Buscar Tennis que tiene envio: escribir 'true' \n2.Tennis que no tienen envio: escribir 'false'");
                buscar_envio = scan.nextBoolean();
                filtarPorEnvio(buscar_envio);
            } else if (opcion == 4) {
                System.out.println("Ingrese el minimo de colores a buscar");
                buscar_color = scan.nextInt();
                filtarPorColor(buscar_color);
            } else {
                System.out.println("Invalid option");
            }
        }
    }

    // metos forEach mostrar segun filtro
    public void mostrarTodosTennis() {
        for (Shoes mostrar : Classic_shoes) {
            System.out.println("CLASSIC SHOES");
            System.out.println("Nombre: " + mostrar.getNombre());
            System.out.println("Foto: " + mostrar.getFoto());
            System.out.println("Colores: " + mostrar.getColores());
            System.out.println("Envio: " + mostrar.getEnvio());
            System.out.println("Referencia:" + mostrar.getReferencia());
            System.out.println("Precio: " + mostrar.getPrecio());
            System.out.println("Talla: " + mostrar.getTalla());
        }
        System.out.println();
        for (Shoes mostrar1 : running_shoes) {
            System.out.println("RUNNING SHOES");
            System.out.println("Nombre: " + mostrar1.getNombre());
            System.out.println("Foto: " + mostrar1.getFoto());
            System.out.println("Colores: " + mostrar1.getColores());
            System.out.println("Envio: " + mostrar1.getEnvio());
            System.out.println("Referencia:" + mostrar1.getReferencia());
            System.out.println("Precio: " + mostrar1.getPrecio());
            System.out.println("Talla: " + mostrar1.getTalla());
        }
    }

    public void filtarPorTalla(int talla) {
        for (Shoes mostrar : Classic_shoes) {
            if (mostrar.getTalla() == talla) {
                System.out.println("Nombre: " + mostrar.getNombre());
                System.out.println("Foto: " + mostrar.getFoto());
                System.out.println("Colores: " + mostrar.getColores());
                System.out.println("Envio: " + mostrar.getEnvio());
                System.out.println("Precio: " + mostrar.getPrecio());
                System.out.println("Talla: " + mostrar.getTalla());
            }
        }
        System.out.println();
        for (Shoes mostrar1 : Classic_shoes) {
            if (mostrar1.getTalla() == talla) {
                System.out.println("Nombre: " + mostrar1.getNombre());
                System.out.println("Foto: " + mostrar1.getFoto());
                System.out.println("Colores: " + mostrar1.getColores());
                System.out.println("Envio: " + mostrar1.getEnvio());
                System.out.println("Precio: " + mostrar1.getPrecio());
                System.out.println("Talla: " + mostrar1.getTalla());
            }
        }
    }

    public void filtarPorPrecio(int mayor, int menor) {
        for (Shoes mostrar : Classic_shoes) {
            if (mostrar.getPrecio() < mayor && mostrar.getPrecio() > menor) {
                System.out.println("Nombre: " + mostrar.getNombre());
                System.out.println("Foto: " + mostrar.getFoto());
                System.out.println("Colores: " + mostrar.getColores());
                System.out.println("Envio: " + mostrar.getEnvio());
                System.out.println("Precio: " + mostrar.getPrecio());
                System.out.println("Talla: " + mostrar.getTalla());
            }
        }
        System.out.println();
        for (Shoes mostrar1 : running_shoes) {
            if (mostrar1.getPrecio() < mayor && mostrar1.getPrecio() > menor) {
                System.out.println("Nombre: " + mostrar1.getNombre());
                System.out.println("Foto: " + mostrar1.getFoto());
                System.out.println("Colores: " + mostrar1.getColores());
                System.out.println("Envio: " + mostrar1.getEnvio());
                System.out.println("Precio: " + mostrar1.getPrecio());
                System.out.println("Talla: " + mostrar1.getTalla());
            }
        }
    }

    public void filtarPorEnvio(boolean envio) {
        for (Shoes mostrar : Classic_shoes) {
            if (mostrar.getEnvio() == envio) {
                System.out.println("Nombre: " + mostrar.getNombre());
                System.out.println("Foto: " + mostrar.getFoto());
                System.out.println("Colores: " + mostrar.getColores());
                System.out.println("Envio: " + mostrar.getEnvio());
                System.out.println("Precio: " + mostrar.getPrecio());
                System.out.println("Talla: " + mostrar.getTalla());
            }
        }
        System.out.println();
        for (Shoes mostrar1 : running_shoes) {
            if (mostrar1.getEnvio() == envio) {
                System.out.println("Nombre: " + mostrar1.getNombre());
                System.out.println("Foto: " + mostrar1.getFoto());
                System.out.println("Colores: " + mostrar1.getColores());
                System.out.println("Envio: " + mostrar1.getEnvio());
                System.out.println("Precio: " + mostrar1.getPrecio());
                System.out.println("Talla: " + mostrar1.getTalla());
            }
        }
    }

    public void filtarPorColor(int color) {
        for (Shoes mostrar : running_shoes) {
            if (mostrar.getColores() >= color) {
                System.out.println("Nombre: " + mostrar.getNombre());
                System.out.println("Foto: " + mostrar.getFoto());
                System.out.println("Colores: " + mostrar.getColores());
                System.out.println("Envio: " + mostrar.getEnvio());
                System.out.println("Precio: " + mostrar.getPrecio());
                System.out.println("Talla: " + mostrar.getTalla());
            }
        }
        System.out.println();
        for (Shoes mostrar1 : Classic_shoes) {
            if (mostrar1.getColores() >= color) {
                System.out.println("Nombre: " + mostrar1.getNombre());
                System.out.println("Foto: " + mostrar1.getFoto());
                System.out.println("Colores: " + mostrar1.getColores());
                System.out.println("Envio: " + mostrar1.getEnvio());
                System.out.println("Precio: " + mostrar1.getPrecio());
                System.out.println("Talla: " + mostrar1.getTalla());
            }
        }
    }
}