package com.example3.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example3.demo.domain.Cerveza;

public interface CervezaRepository extends JpaRepository<Cerveza, Long>{
    List<Cerveza> findByCerveceria(String cerveceria);
}
