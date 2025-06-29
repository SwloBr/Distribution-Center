package com.swlo.distribuitioncenter.business.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class QuotationResponseDto {
    private String cdUrl;
    private String productId;
    private String name;
    private Double price;
    private Integer availableStock;
}
