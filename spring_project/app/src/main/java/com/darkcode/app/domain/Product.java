package com.darkcode.app.domain;

import lombok.Data;

@Data
public class Product {
    private String product_name = "";
    private String description = "";

    public Product(String product_name, String description) {
        this.product_name = product_name;
        this.description = description;
    }

    public Product() {
    }

    public void setProduct_name(String name){
        this.product_name = name;
    }

    public void setFullname(String description){
        this.description = description;
    }
    
}


