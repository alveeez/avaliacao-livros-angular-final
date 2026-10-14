package com.exemplo.apiavaliacaolivros.controllers;
import com.exemplo.apiavaliacaolivros.entities.Livro;
import com.exemplo.apiavaliacaolivros.repositories.*;
import java.util.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/livros") public class LivroController {
 private final LivroRepository repo; private final AvaliacaoRepository avaliacoes;
 public LivroController(LivroRepository repo,AvaliacaoRepository avaliacoes){this.repo=repo;this.avaliacoes=avaliacoes;}
 @GetMapping public List<Livro> listar(){return repo.findAll();}
 @GetMapping("/{id}") public ResponseEntity<Livro> buscar(@PathVariable String id){return ResponseEntity.of(repo.findById(id));}
 @PostMapping public ResponseEntity<?> criar(@RequestBody Livro l){if(!valido(l))return ResponseEntity.badRequest().body(Map.of("erro","Título, autor, gênero e ano são obrigatórios."));l.setId(null);return ResponseEntity.status(201).body(repo.save(l));}
 @PutMapping("/{id}") public ResponseEntity<?> atualizar(@PathVariable String id,@RequestBody Livro l){if(!repo.existsById(id))return ResponseEntity.notFound().build();if(!valido(l))return ResponseEntity.badRequest().body(Map.of("erro","Dados inválidos."));l.setId(id);return ResponseEntity.ok(repo.save(l));}
 @DeleteMapping("/{id}") public ResponseEntity<Void> excluir(@PathVariable String id){if(!repo.existsById(id))return ResponseEntity.notFound().build();avaliacoes.deleteAll(avaliacoes.findByLivroId(id));repo.deleteById(id);return ResponseEntity.noContent().build();}
 private boolean valido(Livro l){return l!=null && texto(l.getTitulo()) && texto(l.getAutor()) && texto(l.getGenero()) && l.getAnoPublicacao()!=null && l.getAnoPublicacao()>0;}
 private boolean texto(String s){return s!=null&&!s.isBlank();}
}
