package com.darkcode.app.repository;

import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="TBL_LENGUAJE")
public class LenguajeRepository {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "Lenguaje")
    private String lenguaje;

    @Column(name = "Tipo paradigma")
    private String tipo_paradigma;

    @Column(name = "Frameworks")
    private String frameworks;
}
