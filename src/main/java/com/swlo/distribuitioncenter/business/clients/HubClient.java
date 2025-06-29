package com.swlo.distribuitioncenter.business.clients;


import com.swlo.distribuitioncenter.business.dto.CdDto;
import com.swlo.distribuitioncenter.business.dto.QuotationResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Component
@FeignClient(name= "hubClient", url = "${hub.address}")
public interface HubClient {

    @GetMapping("/product/{productName}")
    String getProductId(@PathVariable("productName") String productName);

    @GetMapping("/cds/disponiveis")
    CdDto[] getAllDistributionCenters();

    @PostMapping("/quotation/{productId}/{quantity}")
    List<QuotationResponseDto> getQuotation(
            @PathVariable("productId") String productId,
            @PathVariable("quantity") Integer quantity
    );





}
