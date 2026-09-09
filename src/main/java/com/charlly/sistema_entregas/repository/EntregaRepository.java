package com.charlly.sistema_entregas.repository;

import com.charlly.sistema_entregas.model.Entrega;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntregaRepository extends JpaRepository<Entrega, Long>{
    
}
