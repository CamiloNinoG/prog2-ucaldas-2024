package com.sus1.demo.domain;

public class Programa {
    private Long id;
    private String nivel = "";
    private String nombreProgram = "";
    private int creditos = 0;
    private String estado = "";

    public Programa() {}

    public Programa(String nivel, String nombreProgram, int creditos, String estado) {
        this.nivel = nivel;
        this.nombreProgram = nombreProgram;
        this.creditos = creditos;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getNombreProgram() {
        return nombreProgram;
    }

    public void setNombreProgram(String nombreProgram) {
        this.nombreProgram = nombreProgram;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
