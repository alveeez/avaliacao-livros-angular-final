package com.exemplo.apiavaliacaolivros.services;

import com.exemplo.apiavaliacaolivros.entities.Avaliacao;
import com.exemplo.apiavaliacaolivros.entities.Livro;
import com.exemplo.apiavaliacaolivros.repositories.AvaliacaoRepository;
import com.exemplo.apiavaliacaolivros.repositories.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvaliacaoService {

    private final AvaliacaoRepository avaliacaoRepository;
    private final LivroRepository livroRepository;

    public AvaliacaoService(AvaliacaoRepository avaliacaoRepository,
                            LivroRepository livroRepository) {
        this.avaliacaoRepository = avaliacaoRepository;
        this.livroRepository = livroRepository;
    }

    public List<Avaliacao> listarTodos() {
        return avaliacaoRepository.findAll();
    }

    public Avaliacao buscarPorId(Long id) {
        return avaliacaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Avaliação não encontrada com ID: " + id));
    }

    public Avaliacao criar(Avaliacao avaliacao) {
        if (avaliacao.getLivro() == null || avaliacao.getLivro().getId() == null) {
            throw new RuntimeException("É necessário informar o ID do livro.");
        }

        Livro livro = livroRepository.findById(avaliacao.getLivro().getId())
                .orElseThrow(() -> new RuntimeException("Livro não encontrado."));

        avaliacao.setId(null);
        avaliacao.setLivro(livro);

        return avaliacaoRepository.save(avaliacao);
    }

    public Avaliacao atualizar(Long id, Avaliacao dados) {
        Avaliacao avaliacao = buscarPorId(id);

        avaliacao.setNota(dados.getNota());
        avaliacao.setComentario(dados.getComentario());

        if (dados.getLivro() != null && dados.getLivro().getId() != null) {
            Livro livro = livroRepository.findById(dados.getLivro().getId())
                    .orElseThrow(() -> new RuntimeException("Livro não encontrado."));
            avaliacao.setLivro(livro);
        }

        return avaliacaoRepository.save(avaliacao);
    }

    public void deletar(Long id) {
        Avaliacao avaliacao = buscarPorId(id);
        avaliacaoRepository.delete(avaliacao);
    }
}
