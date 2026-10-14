package com.exemplo.apiavaliacaolivros.repositories;
import com.exemplo.apiavaliacaolivros.entities.Avaliacao;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;
public interface AvaliacaoRepository extends MongoRepository<Avaliacao,String>{List<Avaliacao> findByLivroId(String livroId);}
