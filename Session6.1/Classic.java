import java.util.ArrayList;
import java.util.Scanner;

public class Classic {

    public int opcion = 0, mayor = 0, menor = 0, buscar_talla = 0, buscar_color = 0;
    boolean buscar_envio = false;

    ArrayList<Shoes> Classic_shoes = new ArrayList<Shoes>();
    Scanner scan = new Scanner(System.in);

    public ArrayList<Shoes> addCalsssicShoes() {
        Classic_shoes.add(new Shoes("Nike", "URL4", 7, true, 128, "abc123", 20));
        Classic_shoes.add(new Shoes("Force1 Adidas", "URL1", 3, true, 149, "abc123", 38));
        Classic_shoes.add(new Shoes("Adidas RX", "URL2", 6, false, 502, "def456", 38));
        Classic_shoes.add(new Shoes("Tigre", "URL3", 4, true, 99, "ghi789", 38));
        Classic_shoes.add(new Shoes("New balance", "URL", 5, false, 100, "jklo987", 10));
        return Classic_shoes;
    }

    // metodo menuClassic
    public void menuClassic() {
        System.out.println(
                "Bienvenido a la lista de Tennis tipo Classic\n1. Ver todos los productos\n2. filtar productos");
        opcion = scan.nextInt();

        if (opcion == 1) {
            mostrarTodosTennis();
        } else if (opcion == 2) {
            System.out.println("Filtar por :\n1. Precio\n2. Talla\n3. envio\n4. Colores");
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
                System.out.println("Buscar Tennis que tiene envio: escribir 'true' \\n" + //
                                        "2.Tennis que no tienen envio: escribir 'false'");
                buscar_envio = scan.nextBoolean();
                filtarPorEnvio(buscar_envio);
            } else if (opcion == 4){
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
            System.out.println("Nombre: " + mostrar.getNombre());
            System.out.println("Foto: " + mostrar.getFoto());
            System.out.println("Colores: " + mostrar.getColores());
            System.out.println("Envio: " + mostrar.getEnvio());
            System.out.println("Referencia:" + mostrar.getReferencia());
            System.out.println("Precio: " + mostrar.getPrecio());
            System.out.println("Talla: " + mostrar.getTalla());
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
    }

    public void filtarPorColor(int color) {
        for (Shoes mostrar : Classic_shoes) {
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
