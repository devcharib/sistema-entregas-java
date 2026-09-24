package com.charlly.sistema_entregas.repository;

import com.charlly.sistema_entregas.model.Motorista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotoristaRepository  extends JpaRepository<Motorista, Long> {
    
}
