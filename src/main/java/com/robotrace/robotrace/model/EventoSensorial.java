package com.robotrace.robotrace.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class EventoSensorial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo; // colisão, obstáculo, erro de rota
    private LocalDateTime timestamp;

    private Long roboId;
}
