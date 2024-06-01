package com.sus1.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sus1.demo.domain.Programa;
import com.sus1.demo.services.ProgramaService;

@Controller
public class ProgramaController {

    @Autowired
    private ProgramaService programService;

    @GetMapping("/programa")
    public String listarPrograma(Model model) {
        Programa programa1 = new Programa();

        programa1.setNivel("Profesional");
        programa1.setNombreProgram("Ingenieria");
        programa1.setCreditos(10);
        programa1.setEstado("ofertado");

        model.addAttribute("programaAttributes", programa1);
        return "programa";
    }

    @GetMapping("/programas")
    public String listarProgramas(Model model) {
        model.addAttribute("programaListAttribute", programService.programList());
        return "programas";
    }

    @GetMapping("/new-programa")
    public String showAddprograma(Model model) {
        model.addAttribute("programa", new Programa());
        return "add_programa";
    }

    @PostMapping("/new-programa")
    public String saveprograma(@ModelAttribute("programa") Programa programa) {
        programService.saveProgram(programa);
        return "redirect:/programas";
    }

    @GetMapping("/programa/{nombreProgram}")
    public String verDetallesPrograma(@PathVariable String nombreProgram, Model model) {
        Programa programa = programService.showProgramByName(nombreProgram);
        model.addAttribute("programa", programa);
        return "programa";
    }
}
