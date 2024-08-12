package com.contact.manag.agenda.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import io.swagger.v3.oas.models.OpenAPI;

@Configuration
public class SwaggerConfig {

    private final ResourceLoader resourceLoader;

    public SwaggerConfig(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Bean
    public OpenAPI customOpenAPI() {
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        OpenAPI openAPI = null;
        try {
            Resource resource = resourceLoader.getResource("classpath:openapi.yaml");
            openAPI = objectMapper.readValue(resource.getInputStream(), OpenAPI.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return openAPI;
    }
}
