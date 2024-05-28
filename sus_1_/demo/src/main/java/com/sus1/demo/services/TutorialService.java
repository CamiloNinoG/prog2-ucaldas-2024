package com.sus1.demo.services;
import java.util.List;
import com.sus1.demo.domain.Tutorial;

public interface TutorialService {

    public List<Tutorial> tutorialList();
    public void saveTutorial(Tutorial tutorial);
    public void deleteTutorial(Tutorial tutorial);
    public Tutorial showTutorial(Long id);
}

