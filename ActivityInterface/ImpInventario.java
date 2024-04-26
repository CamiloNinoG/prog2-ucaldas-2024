import java.util.ArrayList;

public class ImpInventario implements Inventario {

    public ArrayList<Producto> inventario1 = new ArrayList<>();


    public ImpInventario(){
        inventario1.add(new Producto("Speakers", 10, 100));
        inventario1.add(new Producto("Mochila", 20, 12000));
        inventario1.add(new Producto("Billetera", 30, 15000));
        inventario1.add(new Producto("Mouse", 30, 30000));
        inventario1.add(new Producto("Laptop", 8, 100000.));
    }
    
    public ArrayList<Producto> obtenerProductos(){
        return inventario1;
    }
}
