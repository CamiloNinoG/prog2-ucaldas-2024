package com.sus1.demo.services;

import java.util.List;

import com.sus1.demo.domain.Programa;

public interface ProgramaService {
     public List<Programa> programList();
    public void saveProgram(Programa programa);
    public void deleteProgram(Programa programa);
    public Programa showProgram(Long id);
    
}
