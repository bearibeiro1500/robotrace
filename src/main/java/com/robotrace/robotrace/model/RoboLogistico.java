package com.robotrace.robotrace.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class RoboLogistico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String status;
    private Double nivelEnergia;
    private String modelo;
}
