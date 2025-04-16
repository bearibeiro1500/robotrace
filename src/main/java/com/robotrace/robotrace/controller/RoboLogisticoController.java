package com.robotrace.robotrace.controller;

import com.robotrace.robotrace.model.RoboLogistico;
import com.robotrace.robotrace.service.RoboLogisticoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/robos")
public class RoboLogisticoController {

    @Autowired
    private RoboLogisticoService service;

    @GetMapping
    public List<RoboLogistico> listarRoboLogisticos() {
        return service.listarRobos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoboLogistico> buscarRobosPorId(@PathVariable Long id) {
        Optional<RoboLogistico> robo = service.buscarRoboPorId(id);
        return robo.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RoboLogistico createRoboLogistico(@RequestBody RoboLogistico robo) { return service.salvarRobo(robo); }

    @PutMapping("/{id}")
    public ResponseEntity<RoboLogistico> atualizarRoboLogistico(@PathVariable Long id, @RequestBody RoboLogistico roboAtualizado) {
        if (service.existeRobo(id)) {
            return ResponseEntity.notFound().build();
        }
        roboAtualizado.setId(id);
        return ResponseEntity.ok(service.salvarRobo(roboAtualizado));
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.excluirRobo(id);
    }
}
