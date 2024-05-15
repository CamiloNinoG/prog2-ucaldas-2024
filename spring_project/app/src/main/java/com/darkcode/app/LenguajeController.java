package com.darkcode.app;

import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.darkcode.app.domain.Lenguaje;

@Controller
public class LenguajeController {
    
    @GetMapping("/lenguaje")
    public String listarlenguaje(Model model) {
        Lenguaje lenguaje1 = new Lenguaje();

        lenguaje1.setTipoParadigma("Paradigma 1");
        lenguaje1.setLenguaje("Java");
        lenguaje1.setFrameworks("Maven");
    
        model.addAttribute("lenguajeAttributes", lenguaje1);
        return "lenguaje";
    }
    @GetMapping("/lenguajes")
    public String listarMascotas(Model model) {
        Lenguaje lenguaje1 = new Lenguaje();
        Lenguaje lenguaje2 = new Lenguaje();

        lenguaje1.setTipoParadigma("Paradigma 1");
        lenguaje1.setLenguaje("Java");
        lenguaje1.setFrameworks("Maven");
        lenguaje2.setTipoParadigma("Paradigma 2");
        lenguaje2.setLenguaje("Python");
        lenguaje2.setFrameworks("Git hub");

        ArrayList<Lenguaje> lenguajes= new ArrayList<>();
        lenguajes.add(lenguaje1);
        lenguajes.add(lenguaje2);

        model.addAttribute("lenguajesListAttributes", lenguajes);
        return "lenguajes";
    }
}
