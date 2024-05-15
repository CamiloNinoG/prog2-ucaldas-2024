package com.darkcode.app.domain;

import lombok.Data;

@Data
public class Mascota {
    String tipo_mascota = "";
    String nombre = "";
    int edad = 0;
    String sexo = "";
    String veterinaria = "";
    
    public Mascota() {
    }

    public Mascota(String tipo_mascota, String nombre, int edad, String sexo, String veterinaria) {
        this.tipo_mascota = tipo_mascota;
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.veterinaria = veterinaria;
    }

    public void setTipoMascota(String tipoMascota) {
        this.tipo_mascota = tipoMascota;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    public void setVeterinaria(String veterinaria) {
        this.veterinaria = veterinaria;
    }   
}
