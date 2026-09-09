package com.charlly.sistema_entregas.service;

import com.charlly.sistema_entregas.dto.EntregasRequestDTO;
import com.charlly.sistema_entregas.exception.EntregaNaoEncontradaException;
import com.charlly.sistema_entregas.exception.MotoristaSemEntregaException;
import com.charlly.sistema_entregas.model.Entrega;
import com.charlly.sistema_entregas.repository.EntregaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service 
public class EntregaService {
    
    private final EntregaRepository repository;

    //injeção de  dependencia via construtor
    public EntregaService(EntregaRepository repository) {
        this.repository = repository;
    }

    public List<Entrega> listarTodas() {
        return repository.findAll();
    }

    public Entrega buscaPorId(long id) {
        return repository.findById(id)
            .orElseThrow(() -> new EntregaNaoEncontradaException(id));
    }

    public List<Entrega> buscaPorMotorista(String motorista) {
        List<Entrega> resultado = repository.findAll().stream()
            .filter(e -> e.getMotorista().equals(motorista))
            .toList();

        if (resultado.isEmpty()) {
            throw new MotoristaSemEntregaException(motorista);
        }
        return resultado;
    }

    public Entrega salvar(Entrega entrega) {
        return repository.save(entrega);
    }

    public Entrega criar(EntregasRequestDTO dto) {
        Entrega entrega = new Entrega(dto.getDestino(), dto.getStatus(), dto.getMotorista());
        return repository.save(entrega);
    }
}
