package com.darkcode.app.repository;

import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// private String tipo_vehiculo = "";
//     private String marca = "";
//     private String modelo = "";
//     private String color = "";

@Entity
@Table(name="TBL_VEHICULO")
public class VehiculoRepository {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "marca")
    private String marca;

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "color")
    private String color;
    
}
