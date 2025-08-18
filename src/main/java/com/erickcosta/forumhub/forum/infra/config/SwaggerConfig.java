package com.erickcosta.forumhub.forum.infra.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI forumHubAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("ForumHub API")
                        .version("1.0")
                        .description("API do Fórum Hub"));
    }
}