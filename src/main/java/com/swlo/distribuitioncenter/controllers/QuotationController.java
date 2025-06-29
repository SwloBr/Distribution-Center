package com.swlo.distribuitioncenter.controllers;

import com.swlo.distribuitioncenter.business.clients.HubClient;
import com.swlo.distribuitioncenter.business.dto.QuotationResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class QuotationController {

    private final HubClient hubClient;

    @GetMapping("/quotation/{productName}/{quantity}")
    public List<QuotationResponseDto> quotation(
            String productName,
            Integer quantity) {
        return hubClient.getQuotation(
                productName, quantity
        );
    }
}
