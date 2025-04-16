package com.robotrace.robotrace.service;

import com.robotrace.robotrace.model.RoboLogistico;
import com.robotrace.robotrace.repository.RoboLogisticoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoboLogisticoService {

    @Autowired
    private RoboLogisticoRepository repository;

    public List<RoboLogistico> listarRobos() {
        return repository.findAll();
    }

    public Optional<RoboLogistico> buscarRoboPorId(Long id) {
        return repository.findById(id);
    }

    public RoboLogistico salvarRobo(RoboLogistico robo) {
        return repository.save(robo);
    }

    public boolean existeRobo(Long id) {
        return repository.existsById(id);
    }

    public boolean excluirRobo(Long id) {
        if (!repository.existsById(id)) return false;
        repository.deleteById(id);
        return true;    }
}