package com.exemplo.apiavaliacaolivros.repositories;

import com.exemplo.apiavaliacaolivros.entities.Avaliacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {
}
