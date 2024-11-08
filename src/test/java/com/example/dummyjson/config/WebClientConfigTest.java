package com.example.dummyjson.config;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
@AutoConfigureMockMvc
public class WebClientConfigTest {
   
    WebClientConfig config;

    ApiProperties api;
    
    @Autowired
    public WebClientConfigTest() {
    	api = mock(ApiProperties.class);
    	
    }
    
    @Test
    public void testRestTemplateConfig(){
    	when(api.getBaseUrl()).thenReturn("");
    	config = new WebClientConfig(api);
        Assert.notNull(config.getWebClient(), "not null");
    }
}
