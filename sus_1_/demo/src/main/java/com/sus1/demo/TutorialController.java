package com.sus1.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sus1.demo.domain.Tutorial;
import com.sus1.demo.services.TutorialService;

@Controller
public class TutorialController {

    @Autowired
    private TutorialService tutorialService;

    @GetMapping("/tutorial")
    public String listarTutorial(Model model) {
        Tutorial tutorial1 = new Tutorial();

        tutorial1.setNombre("Politecnico");
        tutorial1.setDescripcion("especializaciones gratis");
        tutorial1.setUrl("www.politecnicos.com");
        tutorial1.setEstado("ofertado");

        model.addAttribute("tutorialAttributes", tutorial1);
        return "tutorial";
    }

    @GetMapping("/tutoriales")
    public String listarTutoriales(Model model) {
        model.addAttribute("tutorialListAttribute", tutorialService.tutorialList());
        return "tutoriales";
    }

    @GetMapping("/new-tutorial")
    public String showAddTutorial(Model model) {
        model.addAttribute("tutorial", new Tutorial());
        return "add_tutorial";
    }

    @PostMapping("/new-tutorial")
    public String saveTutorial(@ModelAttribute("tutorial") Tutorial tutorial) {
        tutorialService.saveTutorial(tutorial);
        return "redirect:/tutoriales";
    }
}
