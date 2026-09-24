package com.charlly.sistema_entregas.service;

import com.charlly.sistema_entregas.exception.MotoristaNaoEncontradoException;
import com.charlly.sistema_entregas.model.Motorista; 
import com.charlly.sistema_entregas.repository.MotoristaRepository;
import com.charlly.sistema_entregas.dto.MotoristaRequestDTO;

import org.springframework.stereotype.Service;

import java.util.List;

@Service 
public class MotoristaService {
    private final MotoristaRepository repository;

    public MotoristaService(MotoristaRepository repository) {
        this.repository = repository;
    }

    public List<Motorista> listarTodosMotoristas() {
        return repository.findAll();
    }

    public Motorista buscarPorId(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new MotoristaNaoEncontradoException(id));
    }

    public Motorista criar(MotoristaRequestDTO dto) {
        Motorista motorista = new Motorista(dto.getNome(), dto.getTelefone());
        return repository.save(motorista);
    }
}
