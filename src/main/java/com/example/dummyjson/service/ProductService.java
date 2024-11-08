package com.example.dummyjson.service;

import static org.springframework.http.MediaType.APPLICATION_JSON;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.dummyjson.dto.Product;
import com.example.dummyjson.dto.ProductResponse;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class ProductService {

    private static final String URI = "/products";
    private static final String URI_WITH_ID = "/products/{id}";

    private final WebClient webClient;

    public List<Product> getAllProducts() {
    	Mono<ProductResponse> response = webClient.get()
    			.uri(URI)
                .accept(APPLICATION_JSON)
                .retrieve()
                .bodyToMono(ProductResponse.class);
    	return response.block().getProducts();
    }

    public Product getProductById(Long id) {
    	
    	return 	webClient.get()
    			.uri(URI_WITH_ID, id)
                .accept(APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Product.class)
                .block();

    }
}
