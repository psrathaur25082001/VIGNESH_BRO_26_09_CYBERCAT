package com.cybercat.user.config;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    // Define the general information about your API
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("CyberCat API")
                        .version("1.0")
                        .description("This is the CyberCat API documentation."));
    }

    // Configure a specific group for the policy controller APIs
    @Bean
    public GroupedOpenApi policyGroup() {
        return GroupedOpenApi.builder()
                .group("policy-api")
                .pathsToMatch("/policy/**")
                .build();
    }
}
