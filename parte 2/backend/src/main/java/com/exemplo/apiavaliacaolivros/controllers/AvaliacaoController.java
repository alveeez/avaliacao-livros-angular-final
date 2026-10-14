package com.exemplo.apiavaliacaolivros.controllers;
import com.exemplo.apiavaliacaolivros.entities.Avaliacao;
import com.exemplo.apiavaliacaolivros.repositories.*;
import java.util.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/avaliacoes") public class AvaliacaoController {
 private final AvaliacaoRepository repo;private final LivroRepository livros;
 public AvaliacaoController(AvaliacaoRepository repo,LivroRepository livros){this.repo=repo;this.livros=livros;}
 @GetMapping public List<Avaliacao> listar(){return repo.findAll();}
 @GetMapping("/livro/{livroId}") public List<Avaliacao> porLivro(@PathVariable String livroId){return repo.findByLivroId(livroId);}
 @GetMapping("/{id}") public ResponseEntity<Avaliacao> buscar(@PathVariable String id){return ResponseEntity.of(repo.findById(id));}
 @PostMapping public ResponseEntity<?> criar(@RequestBody Avaliacao a){String erro=validar(a);if(erro!=null)return ResponseEntity.badRequest().body(Map.of("erro",erro));a.setId(null);return ResponseEntity.status(201).body(repo.save(a));}
 @PutMapping("/{id}") public ResponseEntity<?> atualizar(@PathVariable String id,@RequestBody Avaliacao a){if(!repo.existsById(id))return ResponseEntity.notFound().build();String erro=validar(a);if(erro!=null)return ResponseEntity.badRequest().body(Map.of("erro",erro));a.setId(id);return ResponseEntity.ok(repo.save(a));}
 @DeleteMapping("/{id}") public ResponseEntity<Void> excluir(@PathVariable String id){if(!repo.existsById(id))return ResponseEntity.notFound().build();repo.deleteById(id);return ResponseEntity.noContent().build();}
 private String validar(Avaliacao a){if(a==null||a.getLivroId()==null||!livros.existsById(a.getLivroId()))return "Livro não encontrado.";if(a.getNomeUsuario()==null||a.getNomeUsuario().isBlank())return "Informe seu nome.";if(a.getNota()==null||a.getNota()<1||a.getNota()>5)return "A nota deve estar entre 1 e 5.";if(a.getComentario()==null||a.getComentario().isBlank())return "Informe um comentário.";return null;}
}
