package com.erickcosta.forumhub.forum.infra.security;

import io.github.cdimascio.dotenv.Dotenv;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
public class TokenService {
    private final Dotenv dotenv = Dotenv.load();
    private final String secret = dotenv.get("JWT_SECRET", "TESTANDO");
    private final long expiration = 1000 * 60 * 60;

    private final Key key = Keys.hmacShaKeyFor(secret.getBytes());

    public String gerarToken(String subject){
        return Jwts.builder().setSubject(subject).setIssuedAt(new Date()).setExpiration(new Date(System.currentTimeMillis() + expiration)).signWith(key).compact();
    }

    public String getSubject(String token){
        Claims claims = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
        return claims.getSubject();
    }
}