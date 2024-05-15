package com.darkcode.app;

import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.darkcode.app.domain.Mascota;

@Controller
public class MascotaController {

     
    @GetMapping("/mascota")
    public String listarMascota(Model model) {
        Mascota mascota1 = new Mascota();

        mascota1.setNombre("Rex");
        mascota1.setEdad(10);
        mascota1.setSexo("M");
        mascota1.setTipoMascota("Perro");
        mascota1.setVeterinaria("Veterianria caldas");

        model.addAttribute("mascotAttributes", mascota1);
        return "mascota";
    }

    @GetMapping("/mascotas")
    public String listarMascotas(Model model) {
        Mascota mascota1 = new Mascota();
        Mascota mascota2 = new Mascota();

        mascota1.setNombre("Rex");
        mascota1.setEdad(10);
        mascota1.setSexo("M");
        mascota1.setTipoMascota("Perro");
        mascota1.setVeterinaria("Veterianria caldas");
        mascota2.setNombre("Nene");
        mascota2.setEdad(3);
        mascota2.setSexo("F");
        mascota2.setTipoMascota("Gato");
        mascota2.setVeterinaria("Veterianria Manizales");

        ArrayList<Mascota> mascotas = new ArrayList<>();
        mascotas.add(mascota1);
        mascotas.add(mascota2);

        model.addAttribute("mascotasListAttributes", mascotas);
        return "mascotas";
    }
}
