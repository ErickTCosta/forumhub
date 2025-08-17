package com.erickcosta.forumhub.forum.controller;

import com.erickcosta.forumhub.forum.domain.usuario.UsuarioRepository;
import com.erickcosta.forumhub.forum.dto.LoginRequest;
import com.erickcosta.forumhub.forum.dto.LoginResponse;
import com.erickcosta.forumhub.forum.infra.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TokenService tokenService;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        var usuario = usuarioRepository.findByEmail(request.email())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (!passwordEncoder.matches(request.senha(), usuario.getSenha())) {
            throw new RuntimeException("Senha inválida");
        }

        String token = tokenService.gerarToken(usuario.getEmail());
        return new LoginResponse(token);
    }
}