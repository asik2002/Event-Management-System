package com.fullstack.restApi.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Apply CORS configuration to all endpoints under /api
                .allowedOrigins("http://localhost:3000") // Allow requests from this origin
                .allowedMethods("GET", "POST","PUT","DELETE") // Allow only specified HTTP methods
                .allowedHeaders("*"); // Allow all headers
    }
}
