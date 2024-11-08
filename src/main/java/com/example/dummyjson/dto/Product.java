package com.example.dummyjson.dto;

import java.io.Serializable;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Product implements Serializable{

    private static final long serialVersionUID = 1L;

	@NotNull
    @Min(0L)
    @Max(999L)
    private Long id;

    @NotNull
    private String title;

    @NotNull
    private String description;

    @NotNull
    private Double price;

}
