package com.exemplo.apiavaliacaolivros.repositories;

import com.exemplo.apiavaliacaolivros.entities.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
