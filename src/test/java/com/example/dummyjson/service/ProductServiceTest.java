package com.example.dummyjson.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.dummyjson.dto.Product;
import com.example.dummyjson.dto.ProductResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import reactor.core.publisher.Mono;

@SpringBootTest
public class ProductServiceTest {

    private ProductService productService;
    
    private WebClient webClient; 
    
    @Test
    public void testGetAllProducts() {
    	webClient = WebClient.builder()
                .exchangeFunction(clientRequest -> 
                        Mono.just(ClientResponse.create(HttpStatus.OK)
                        .header("content-type", "application/json")
                        .body(objectSerializer(productResponseMock()))
                        .build())
                ).build();
        productService = new ProductService(webClient);
        List<Product> result = productService.getAllProducts();
        assertEquals(2, result.size());
        assertEquals("Product 1", result.get(0).getTitle());
    }

    @Test
    public void testGetProductById() {

    	webClient = WebClient.builder()
                .exchangeFunction(clientRequest -> 
                        Mono.just(ClientResponse.create(HttpStatus.OK)
                        .header("content-type", "application/json")
                        .body(objectSerializer(mockProduct()))
                        .build())
                ).build();
        productService = new ProductService(webClient);
        Product result = productService.getProductById(1L);
        assertEquals("Product 1", result.getTitle());
    }

    
    private String objectSerializer(Object o) {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonBody = "";
        try {
            jsonBody = objectMapper.writeValueAsString(o);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonBody;
    }
    
	private Product mockProduct() {
		Product product = new Product();
        product.setId(1L);
        product.setTitle("Product 1");
		return product;
	}
    
    
    private ProductResponse productResponseMock() {
    	return new ProductResponse(Arrays.asList(productsMock()));
    }
    
	private Product[] productsMock() {
        Product[] products = {mockProduct(), mockProduct()};
		return products;
	}
}
