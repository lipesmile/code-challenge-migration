package com.example.dummyjson.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix = "api")
public class ApiProperties {

	@Value("${api.base.url}")
    private String baseUrl;
    
}
