package com.exemplo.apiavaliacaolivros.entities;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection="avaliacoes") public class Avaliacao {
 @Id private String id;
 private String livroId,nomeUsuario,comentario;
 private Integer nota;
 public Avaliacao(){}
 public String getId(){return id;} public void setId(String v){id=v;}
 public String getLivroId(){return livroId;} public void setLivroId(String v){livroId=v;}
 public String getNomeUsuario(){return nomeUsuario;} public void setNomeUsuario(String v){nomeUsuario=v;}
 public String getComentario(){return comentario;} public void setComentario(String v){comentario=v;}
 public Integer getNota(){return nota;} public void setNota(Integer v){nota=v;}
}
