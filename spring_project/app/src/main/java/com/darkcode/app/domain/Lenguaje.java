package com.darkcode.app.domain;

import lombok.Data;

@Data
public class Lenguaje {
    String lenguaje = "";
    String tipo_paradigma = "";
    String frameworks = "";
    
    public Lenguaje(String lenguaje, String tipo_paradigma, String frameworks) {
        this.lenguaje = lenguaje;
        this.tipo_paradigma = tipo_paradigma;
        this.frameworks = frameworks;
    }

    public Lenguaje() {
    }

    public void setLenguaje(String lenguaje) {
        this.lenguaje = lenguaje;
    }
    
    public void setTipoParadigma(String tipoParadigma) {
        this.tipo_paradigma = tipoParadigma;
    }
    
    public void setFrameworks(String frameworks) {
        this.frameworks = frameworks;
    }   
}
