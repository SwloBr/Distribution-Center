package com.swlo.distribuitioncenter.business.dto;

import com.swlo.distribuitioncenter.entities.ProductEntity;

import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;

/**
 * DTO for {@link ProductEntity}
 */
public record CreateProductDto(
        @NotBlank(message = "Product Name cannot be blank")
        String name,
        @NotBlank(message = "Product Price cannot be blank")
        Integer price,
        Integer stock,
        String description) implements Serializable {
}