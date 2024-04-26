import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        //Activity 1
        ImpInventario inventario = new ImpInventario();
        ArrayList<Producto> productos = inventario.obtenerProductos();
        listProduct(productos);
        
        //Activity 2
        ImplementGestor gestor = new ImplementGestor();
        gestor.menuGestor();

    }

    public static void listProduct(ArrayList<Producto> array){
        for(Producto a: array ){
            System.out.println(a.toString());
        }
    }

}