package com.example.dummyjson.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    private ApiProperties apiProperties;

    public WebClientConfig(ApiProperties apiProperties) {
        this.apiProperties = apiProperties;
    }

    @Bean
    public WebClient getWebClient(){
        return WebClient.builder().baseUrl(apiProperties.getBaseUrl()).build();
    }

}
