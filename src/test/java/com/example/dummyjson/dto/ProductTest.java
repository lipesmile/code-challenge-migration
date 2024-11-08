package com.example.dummyjson.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductTest {

    @Test
    public void testGetAndSetter(){
        Long expectId = 1L;
        String expectedTitle = "A dummy title";
        String expectedDescription = "A dummy description";
        Double expectedPrice = Double.valueOf("2.1");

        Product product1 = new Product();
        product1.setId(1L);
        product1.setTitle("A dummy title");
        product1.setDescription("A dummy description");
        product1.setPrice(Double.valueOf("2.1"));

        Assertions.assertEquals(expectId, product1.getId());
        Assertions.assertEquals(expectedTitle, product1.getTitle());
        Assertions.assertEquals(expectedDescription, product1.getDescription());
        Assertions.assertEquals(expectedPrice, product1.getPrice());
    }
}
