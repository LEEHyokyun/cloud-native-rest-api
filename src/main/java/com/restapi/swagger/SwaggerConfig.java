package com.restapi.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
    info = @Info(
            title = "API 명세서",
            description = "CLOUD NATIVE REST API Project에 대한 명세서",
            version = "1.0"
    )
)
@Configuration
@RequiredArgsConstructor
public class SwaggerConfig {
    @Bean
    public GroupedOpenApi groupedOpenApi() {
        String[] paths = {"/users/**", "/admin/**"};

        return GroupedOpenApi
                .builder()
                .group("users에 대한 API 명세")
                .pathsToMatch(paths).build();
    }
}
