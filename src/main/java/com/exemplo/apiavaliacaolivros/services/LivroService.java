package com.exemplo.apiavaliacaolivros.services;

import com.exemplo.apiavaliacaolivros.entities.Livro;
import com.exemplo.apiavaliacaolivros.repositories.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    private final LivroRepository repository;

    public LivroService(LivroRepository repository) {
        this.repository = repository;
    }

    public List<Livro> listarTodos() {
        return repository.findAll();
    }

    public Livro buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado com ID: " + id));
    }

    public Livro criar(Livro livro) {
        livro.setId(null);
        return repository.save(livro);
    }

    public Livro atualizar(Long id, Livro dados) {
        Livro livro = buscarPorId(id);

        livro.setTitulo(dados.getTitulo());
        livro.setAutor(dados.getAutor());
        livro.setGenero(dados.getGenero());
        livro.setAnoPublicacao(dados.getAnoPublicacao());

        return repository.save(livro);
    }

    public void deletar(Long id) {
        Livro livro = buscarPorId(id);
        repository.delete(livro);
    }
}
