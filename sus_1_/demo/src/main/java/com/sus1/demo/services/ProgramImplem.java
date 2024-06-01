package com.sus1.demo.services;

import java.util.ArrayList;
import java.util.List;
import com.sus1.demo.domain.Programa;
import org.springframework.stereotype.Service;

@Service
public class ProgramImplem implements ProgramaService {

    List<Programa> programas = new ArrayList<>();

    @Override
    public List<Programa> programList() {
        if (programas == null) {
            return new ArrayList<>();
        }
        return programas;
    }

    @Override
    public void saveProgram(Programa programa) {
       programas.add(programa);
    }

    @Override
    public void deleteProgram(Programa programa) {
        programas.remove(programa);
    }

    @Override
    public Programa showProgram(Long id) {
        return programas.stream().filter(programa -> programa.getId().equals(id))
        .findFirst()
        .orElse(null);
    }

    @Override
    public Programa showProgramByName(String name) {
        return programas.stream().filter(programa -> programa.getNombreProgram().equals(name))
        .findFirst()
        .orElse(null);
    }
    
}
