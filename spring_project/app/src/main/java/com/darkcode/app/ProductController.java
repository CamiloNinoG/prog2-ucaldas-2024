package com.darkcode.app;

import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.darkcode.app.domain.Product;

@Controller
public class ProductController {
    
    @GetMapping("/product")
    public String productInformation(Model model){
        Product product1 = new Product();
        Product product2 = new Product();
        product1.setProduct_name("Meat");
        product1.setDescription("red meat");
        product2.setProduct_name("rice");
        product2.setDescription("white rice");
        model.addAttribute("productAtributtes1", product1);
        model.addAttribute("productAtributtes", product2);
        return "product";
    }

    @GetMapping("/products")
    public String listProductsString(Model model){
        Product product1 = new Product();
        Product product2 = new Product();

        product1.setProduct_name("Milk");
        product1.setDescription("Alqueria");
        product2.setProduct_name("Soda");
        product2.setDescription("Coca-Cola");

        ArrayList<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);

        model.addAttribute("productListAttributes", products);
        return "products";
    }
}
