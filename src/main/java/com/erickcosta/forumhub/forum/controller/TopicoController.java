package com.erickcosta.forumhub.forum.controller;
import com.erickcosta.forumhub.forum.domain.topico.Topico;
import com.erickcosta.forumhub.forum.dto.TopicoRequest;
import com.erickcosta.forumhub.forum.dto.TopicoResponse;
import com.erickcosta.forumhub.forum.repository.TopicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @PostMapping
    public TopicoResponse criar(@RequestBody @Valid TopicoRequest request) {
        if (repository.existsByTituloAndMensagem(request.titulo(), request.mensagem())) {
            throw new RuntimeException("Tópico duplicado!");
        }
        Topico topico = new Topico(null, request.titulo(), request.mensagem(), null, null, request.autor(), request.curso());
        repository.save(topico);
        return new TopicoResponse(topico.getId(), topico.getTitulo(), topico.getMensagem(),
                topico.getDataCriacao(), topico.getStatus(), topico.getAutor(), topico.getCurso());
    }

    @GetMapping
    public List<TopicoResponse> listar() {
        return repository.findAll().stream()
                .map(t -> new TopicoResponse(t.getId(), t.getTitulo(), t.getMensagem(),
                        t.getDataCriacao(), t.getStatus(), t.getAutor(), t.getCurso())).toList();

    }
}