package org.dev.security.l_springsecuritycors.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// @Configuration // another way to configure cross origin using WebMvcConfig
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/coffee")
                .allowedOrigins("https://localhost:3000")
                .allowedMethods("GET", "POST", "PUT", "DELETE");
    }

}
