package com.robotrace.robotrace.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class EntregaSimulada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String origem;
    private String destino;
    private String prioridade;
    private String status;

    private Long roboResponsavelId;
}
