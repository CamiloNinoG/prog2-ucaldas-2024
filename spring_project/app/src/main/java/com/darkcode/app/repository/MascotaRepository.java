package com.darkcode.app.repository;

import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="TBL_MASCOTA")
public class MascotaRepository {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "Tipo mascota ")
    private String tipo_mascota;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Edad")
    private String edad;

    @Column(name = "Sexo")
    private String sexo;

    @Column(name = "Veterianaria")
    private String tipo_paradigma;
}
