package com.example.javajwtdemo.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    private SecurityScheme createAPIKeyScheme() {
        return new SecurityScheme().type(SecurityScheme.Type.HTTP)
                .bearerFormat("JWT")
                .scheme("Bearer");
    }

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI().addSecurityItem(new SecurityRequirement().
                        addList("Authorization"))
                .components(new Components().addSecuritySchemes
                        ("Authorization", createAPIKeyScheme()))
                .info(new Info().title("ROSACEAE REST API")
//                        .description("Some custom description of API.")
//                        .version("1.0").contact(new Contact().name("XiJinPing")
//                                .email( "xi@gmail.com").url("xi.com"))
//                        .license(new License().name("License of API")
//                                .url("API license URL"))
                                );
    }
}
