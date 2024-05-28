package com.sus1.demo.repository;

import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TBL_LENGUAJE")
public class ProgramRepo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "Nivel")
    private String nivel;

    @Column(name = "Nombre Programa")
    private String nombreProgram;

    @Column(name = "Cantidad Creditos")
    private String creditos;
    @Column(name = "Estado")
    private String estado;
}
