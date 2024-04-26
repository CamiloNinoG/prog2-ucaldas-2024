public class Producto {
    private String name_product = "";
    private int stock = 0;
    private double price = 0;

    public Producto(String name_product, int stock, double price) {
        this.name_product = name_product;
        this.stock = stock;
        this.price = price;
    }

    public String getName_product() {
        return name_product;
    }

    public int getStock() {
        return stock;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "\n Name product: "+ this.name_product+ "\n Price: " + this.price + "\n Stock: "+ this.stock;
    }

    
}
