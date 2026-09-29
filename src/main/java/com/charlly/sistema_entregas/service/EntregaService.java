package com.charlly.sistema_entregas.service;

import com.charlly.sistema_entregas.dto.EntregaRequestDTO;
import com.charlly.sistema_entregas.exception.EntregaNaoEncontradaException;
import com.charlly.sistema_entregas.exception.MotoristaNaoEncontradoException;
import com.charlly.sistema_entregas.exception.MotoristaSemEntregaException;
import com.charlly.sistema_entregas.exception.OrdenacaoInvalidaException;


import com.charlly.sistema_entregas.model.Entrega;
import com.charlly.sistema_entregas.model.Motorista;
import com.charlly.sistema_entregas.repository.EntregaRepository;
import com.charlly.sistema_entregas.repository.MotoristaRepository;

// import org.springframework.boot.data.autoconfigure.web.DataWebProperties.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Sort;

import java.util.List;

@Service 
public class EntregaService {
    
    private final EntregaRepository repository;
    private final MotoristaRepository motoristaRepository;

    //tratamento de campos permitidos
    private static final List<String> CAMPOS_PERMITIDOS = List.of("id", "destino", "status", "peso");

    
    //injeção de  dependencia via construtor
    public EntregaService(EntregaRepository repository, MotoristaRepository motoristaRepository) {
        this.repository = repository;
        this.motoristaRepository = motoristaRepository;
    }


    // public List<Entrega> listarTodas() {
    //     return repository.findAll();
    // }
    //pageable
    public Page<Entrega> listarTodas(Pageable pageable) {
        String campoOrdenacao = pageable.getSort().stream()
            .findFirst()
            .map(Sort.Order::getProperty)
            .orElse("id");

        if (!CAMPOS_PERMITIDOS.contains(campoOrdenacao)) {
            throw new OrdenacaoInvalidaException(campoOrdenacao);
        }

        return repository.findAll(pageable);
    }

    public Entrega buscaPorId(long id) {
        return repository.findById(id)
            .orElseThrow(() -> new EntregaNaoEncontradaException(id));
    }

    public List<Entrega> buscaPorMotorista(String motorista) {
        List<Entrega> resultado = repository.findAll().stream()
            .filter(e -> e.getMotorista().getNome().equals(motorista))
            .toList();

        if (resultado.isEmpty()) {
            throw new MotoristaSemEntregaException(motorista);
        }
        return resultado;
    }

    public Entrega salvar(Entrega entrega) {
        return repository.save(entrega);
    }

    public Entrega criar(EntregaRequestDTO dto) {
        Motorista motorista = motoristaRepository.findById(dto.getMotoristaId())
            .orElseThrow(() -> new MotoristaNaoEncontradoException(dto.getMotoristaId()));
        Entrega entrega = new Entrega(dto.getDestino(), dto.getStatus(), motorista, dto.getPeso());
        return repository.save(entrega);
    }

    public Entrega atualizar(Long id, EntregaRequestDTO dto) {
        Entrega entrega = repository.findById(id)
            .orElseThrow(() -> new EntregaNaoEncontradaException(id));

        Motorista motorista = motoristaRepository.findById(dto.getMotoristaId())
            .orElseThrow(() -> new MotoristaNaoEncontradoException(dto.getMotoristaId()));

        entrega.setStatus(dto.getStatus());
        entrega.setMotorista(motorista);
        entrega.setPeso(dto.getPeso());

        return repository.save(entrega);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new EntregaNaoEncontradaException(id);
        }
        repository.deleteById(id);
    }
}
