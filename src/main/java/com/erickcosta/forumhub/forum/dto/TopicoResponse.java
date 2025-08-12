package com.erickcosta.forumhub.forum.dto;

import java.time.LocalDateTime;

public record TopicoResponse (
        Long id,
        String titulo,
        String mensagem,
        LocalDateTime dataCriacao,
        String status,
        String autor,
        String curso
) {}
