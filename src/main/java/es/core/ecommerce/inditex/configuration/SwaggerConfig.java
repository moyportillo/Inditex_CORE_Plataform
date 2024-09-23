package es.core.ecommerce.inditex.configuration;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().info(new Info()
                .title("Prueba Técnica Inditex CORE Plataform")
                .version("1.0")
                .description("Prueba tecnica API-Rest para el manejo de datos de precios para Inditex core plataform"));
    }
}
