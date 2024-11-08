package com.example.dummyjson.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.dummyjson.dto.Product;
import com.example.dummyjson.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
public class ProductControllerTest {

	private ProductController productController;

    private ProductService productService;
	
    @Autowired
	public ProductControllerTest() {
    	 this.productController = mock(ProductController.class);
    	 this.productService = mock(ProductService.class);
	}
	
    @Test
    public void testGetAllProducts() {
        Product product1 = new Product();
        product1.setId(1L);
        product1.setTitle("Product 1");

        Product product2 = new Product();
        product2.setId(2L);
        product2.setTitle("Product 2");

        List<Product> products = Arrays.asList(product1, product2);
        productController = new ProductController(productService);
        when(productService.getAllProducts()).thenReturn(products);
        List<Product> result = productController.getAllProducts();
        assertEquals(2, result.size());
        assertEquals("Product 1", result.get(0).getTitle());
    }

    @Test
    public void testGetProductById() {
        Product product = new Product();
        product.setId(1L);
        product.setTitle("Product 1");
        productController = new ProductController(productService);
        when(productService.getProductById(anyLong())).thenReturn(product);

        Product result = productController.getProductById(1L);
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
}