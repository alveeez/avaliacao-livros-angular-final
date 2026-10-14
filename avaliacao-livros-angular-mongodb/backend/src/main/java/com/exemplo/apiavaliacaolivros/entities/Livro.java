package com.exemplo.apiavaliacaolivros.entities;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection="livros") public class Livro {
 @Id private String id;
 private String titulo,autor,genero;
 private Integer anoPublicacao;
 public Livro(){}
 public String getId(){return id;} public void setId(String v){id=v;}
 public String getTitulo(){return titulo;} public void setTitulo(String v){titulo=v;}
 public String getAutor(){return autor;} public void setAutor(String v){autor=v;}
 public String getGenero(){return genero;} public void setGenero(String v){genero=v;}
 public Integer getAnoPublicacao(){return anoPublicacao;} public void setAnoPublicacao(Integer v){anoPublicacao=v;}
}
