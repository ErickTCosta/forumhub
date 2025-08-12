package com.erickcosta.forumhub.forum.repository;

import com.erickcosta.forumhub.forum.domain.topico.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository <Topico, Long> {
    boolean existsByTituleAndMensagem(String titulo, String mensagem);
}
