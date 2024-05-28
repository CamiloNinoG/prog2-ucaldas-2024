package com.sus1.demo.domain;

import lombok.Data;

@Data
public class Tutorial {

    private Long id;
    private String nombre = "";
    private String descripcion = "";
    private String url = "";
    private String estado = "";

    public Tutorial(String nombre, String descripcion, String url, String estado) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.url = url;
        this.estado = estado;
    }

    public Tutorial() {
    }

    public String getUrl() {
        return url;
    }

    public String getEstado() {
        return estado;

    }

    public void setUrl(String url) {
        this.url = url;
    }


    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
