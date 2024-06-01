package com.sus2.app.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.sus2.app.domain.Tutorial;

public interface TutoRepository extends JpaRepository<Tutorial, Long>{

    public List<Tutorial> findByPublished(Boolean published);
    public List<Tutorial> findByTitle(String title);
    
}
