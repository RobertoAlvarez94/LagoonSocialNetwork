package com.lagoon.LagoonBackend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@Configuration
public class RestConfig {

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();

        config.setAllowCredentials(true);
        config.setAllowedOrigins(Arrays.asList("*"));
        config.setAllowedHeaders(Arrays.asList("content-type", "authorization"));
        config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "OPTIONS"));
        config.setExposedHeaders(Arrays.asList("authorization"));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        source.registerCorsConfiguration("/**", config);

        CorsFilter corsFilter = new CorsFilter(source);

        return corsFilter;

    }
}

