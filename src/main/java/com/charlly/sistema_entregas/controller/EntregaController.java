package com.charlly.sistema_entregas.controller;

import com.charlly.sistema_entregas.model.Entrega;
import com.charlly.sistema_entregas.service.EntregaService;
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

}