package com.exemplo.apiavaliacaolivros.repositories;
import com.exemplo.apiavaliacaolivros.entities.Livro;
import org.springframework.data.mongodb.repository.MongoRepository;
public interface LivroRepository extends MongoRepository<Livro,String>{}
