package com.example3.demo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "Cerveceria")
public class Cerveza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cerveceria")
    private String cerveceria;

    @Column(name = "departamento")
    private String departamento;

    @Column(name = "municipio")
    private String municipio;

    @Column(name = "nomenclatura")
    private String nomenclatura;

    @Column(name = "marca")
    private String marca;

    @Column(name = "stock")
    private int stock;

    public Cerveza(String cerveceria, String departamento, String municipio, String nomenclatura, String marca, int stock) {
        this.cerveceria = cerveceria;
        this.departamento = departamento;
        this.municipio = municipio;
        this.nomenclatura = nomenclatura;
        this.marca = marca;
        this.stock = stock;
    }

    public Cerveza() {
    }

    @Override
    public String toString() {
        return "Cerveza [id=" + id + ", cerveceria=" + cerveceria + ", departamento=" + departamento + ", municipio=" + municipio + ", nomenclatura=" + nomenclatura + ", marca=" + marca + ", stock=" + stock + "]";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCerveceria() {
        return cerveceria;
    }

    public void setCerveceria(String cerveceria) {
        this.cerveceria = cerveceria;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getNomenclatura() {
        return nomenclatura;
    }

    public void setNomenclatura(String nomenclatura) {
        this.nomenclatura = nomenclatura;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
