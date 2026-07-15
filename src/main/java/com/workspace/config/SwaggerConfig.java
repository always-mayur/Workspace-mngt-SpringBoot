package com.workspace.config;
import io.swagger.v3.oas.models.OpenAPI;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class SwaggerConfig
{

    @Bean
    public OpenAPI openAPI()
    {
        SecurityScheme securityScheme =
                new SecurityScheme()
                        .type(SecurityScheme.Type.HTTP)
                        .scheme("bearer")
                        .bearerFormat("JWT");

        return new OpenAPI()
                .components(
                        new Components()
                                .addSecuritySchemes(
                                        "BearerAuth",
                                        securityScheme)) //register above defined security scheme
                .addSecurityItem(
                        new SecurityRequirement()
                                .addList("BearerAuth")); //use that 
    }

}
