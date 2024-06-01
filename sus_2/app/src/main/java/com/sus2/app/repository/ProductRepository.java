package com.sus2.app.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.sus2.app.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

    public List<Product> findByStock(int stock);
    public List<Product> findByName(String name);
    
}