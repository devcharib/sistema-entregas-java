package com.charlly.sistema_entregas.controller;

import com.charlly.sistema_entregas.dto.EntregaRequestDTO;
import com.charlly.sistema_entregas.model.Entrega;
import com.charlly.sistema_entregas.service.EntregaService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController 
@RequestMapping("/entregas")
public class EntregaController {
    private final EntregaService service;

    public EntregaController(EntregaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Entrega> listarEntregas() {
        return service.listarTodas();
    }

    @GetMapping("/{id}")
    public Entrega buscaPorId(@PathVariable Long id) {
        return service.buscaPorId(id);
    }

    @GetMapping("/motorista/{motorista}")
    public List<Entrega> buscarPorMotorista(@PathVariable String motorista) {
        return service.buscaPorMotorista(motorista);
    }

    @PostMapping
    public ResponseEntity<Entrega> criar(@Valid @RequestBody EntregaRequestDTO dto) {
        Entrega novaEntrega = service.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaEntrega);
    }

    @PutMapping("/{id}")
    public Entrega atualizar(@PathVariable Long id, @RequestBody EntregaRequestDTO dto) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}