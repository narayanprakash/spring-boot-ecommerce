package com.luv2code.ecommerce.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

public class MyConfig implements WebMvcConfigurer {

    @Value("${allowed.origins}")
    private String[] theAllowedOrigins;
    @Value("${spring.data.rest.base-path}")
    private String[] basePath;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        WebMvcConfigurer.super.addCorsMappings(registry);

        registry.addMapping(Arrays.toString(basePath) + "/**").allowedOrigins(theAllowedOrigins);
    }
}
