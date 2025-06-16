package com.swlo.distribuitioncenter.business.clients;


import com.swlo.distribuitioncenter.business.dto.CdDto;
import com.swlo.distribuitioncenter.business.dto.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;

@FeignClient(name= "hubClient", url = "${hub.address}")
public interface HubClient {

    @GetMapping("/product/{productName}")
    String getProductId(@PathVariable("productName") String productName);

    @PostMapping("/cd")
    void registerDistributionCenter(
            @RequestBody CdDto cdDto
    );

    @GetMapping("/cd/all")
    CdDto[] getAllDistributionCenters();

    @PostMapping("/quotation/{productId}/{quantity}")
    HashMap<String, ProductDto> getQuotation(
            @PathVariable("productId") String productId,
            @PathVariable("quantity") Integer quantity
    );





}
