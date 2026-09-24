package com.charlly.sistema_entregas.controller;

import com.charlly.sistema_entregas.dto.MotoristaRequestDTO;
import com.charlly.sistema_entregas.model.Motorista;
import com.charlly.sistema_entregas.service.MotoristaService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/motoristas")
public class MotoristaController {
    private final MotoristaService service;

    public MotoristaController(MotoristaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Motorista> listarMotoristas() {
        return service.listarTodosMotoristas();
    }

    @GetMapping("/{id}")
    public Motorista buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public ResponseEntity<Motorista> criar(@Valid @RequestBody MotoristaRequestDTO dto) {
        Motorista novoMotorista = service.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoMotorista);
    }

}
