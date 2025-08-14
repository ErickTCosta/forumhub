package com.erickcosta.forumhub.forum.model;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="topicos")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    @Column(columnDefinition = "TEXT")
    private String mensagem;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao = LocalDateTime.now();

    private String autor;
    private String curso;

    public Topico(){}

    public Topico(String titulo, String mensagem, String autor, String curso){
        this.titulo = titulo;
        this.mensagem = mensagem;
        this.autor = autor;
        this.curso = curso;
    }
}