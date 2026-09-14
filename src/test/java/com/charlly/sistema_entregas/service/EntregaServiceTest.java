package com.charlly.sistema_entregas.service;

import com.charlly.sistema_entregas.exception.EntregaNaoEncontradaException;
import com.charlly.sistema_entregas.model.Entrega;
import com.charlly.sistema_entregas.repository.EntregaRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EntregaServiceTest {
    
    @Mock
    private EntregaRepository repository; //FALSE

    @InjectMocks
    private EntregaService service; //TRUE <- repository FALSE

    @Test
    void deveBuscarEntregaPorIdComSucesso() {
        // A cenario
        Entrega entrega = new Entrega("Rua A, 123", "pendente", "João");
        when(repository.findById(1L)).thenReturn(Optional.of(entrega));

        // A ação
        Entrega resultado = service.buscaPorId(1L);

        // A verificar
        assertEquals("Rua A, 123", resultado.getDestino());
    }

    @Test
    void deveLancarExcecaoQuandoEntregaNaoExiste() {
        when(repository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(EntregaNaoEncontradaException.class, () -> {
            service.buscaPorId(99L);
        });
    }
}
