package com.charlly.sistema_entregas.controller;

import com.charlly.sistema_entregas.exception.EntregaNaoEncontradaException;
import com.charlly.sistema_entregas.exception.MotoristaSemEntregaException;
import com.charlly.sistema_entregas.model.Entrega;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class EntregaController {
    
    @GetMapping("/entregas")
    public List<Entrega> listarEntregas() {
        return List.of(
            new Entrega(1L, "Rua A, 123", "pendente", "João"),
            new Entrega(2L, "Rua B, 456", "em transito", "Pedro"),
            new Entrega(3L, "Rua C, 789", "entregue", "Diego")
        );
    }

    @GetMapping("/entregas/{id}")
    public Entrega buscaPorId(@PathVariable Long id) {
        return listarEntregas().stream()
            .filter(e -> e.getId().equals(id))
            .findFirst()
            .orElseThrow(() -> new EntregaNaoEncontradaException(id));
    }

    //revisao
    @GetMapping("/entregas/motorista/{motorista}")
    public List<Entrega> buscaPorMotorista(@PathVariable String motorista) {
        List<Entrega> resultado = listarEntregas().stream()
            .filter(e -> e.getMotorista().equals(motorista))
            .collect(Collectors.toList());

        if (resultado.isEmpty()) {
            throw new MotoristaSemEntregaException(motorista);
        }
        return resultado;
    }

}
