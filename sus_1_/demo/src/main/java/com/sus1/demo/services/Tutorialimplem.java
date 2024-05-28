package com.sus1.demo.services;

import java.util.ArrayList;
import java.util.List;
import com.sus1.demo.domain.Tutorial;
import org.springframework.stereotype.Service;

@Service
public class Tutorialimplem implements  TutorialService{

    List<Tutorial> tutoriales = new ArrayList<>();

    @Override
    public List<Tutorial> tutorialList() {
         if (tutoriales == null) {
            return new ArrayList<>();
        }
        return tutoriales;
    }

    @Override
    public void saveTutorial(Tutorial tutorial) {
        tutoriales.add(tutorial);
    }

    @Override
    public void deleteTutorial(Tutorial tutorial) {
        tutoriales.remove(tutorial);
    }

    @Override
    public Tutorial showTutorial(Long id) {
        return tutoriales.stream().filter(tutorial -> tutorial.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
    
}
