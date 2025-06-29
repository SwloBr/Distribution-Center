package com.swlo.distribuitioncenter.business.dto;

public record TakeProductRequest(
        String productId,
        Integer quantity,
        String urlCd
) {
}
