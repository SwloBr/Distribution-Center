package com.swlo.distribuitioncenter.business.dto;

import java.io.Serializable;

/**
 * DTO for {@link com.swlo.distribuitioncenter.entities.ProductEntity}
 */
public record ProductDto(String id, String name, Integer price, Integer stock,
                         String description) implements Serializable {
}