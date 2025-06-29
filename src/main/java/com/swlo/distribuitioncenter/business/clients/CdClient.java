package com.swlo.distribuitioncenter.business.clients;

import org.springframework.web.client.RestTemplate;

public class CdClient {
    private final String baseUrl;
    private final RestTemplate restTemplate;

    public CdClient(String baseUrl) {
        this.baseUrl = baseUrl;
        this.restTemplate = new RestTemplate();
    }

    public void sendProduct(String productName, int quantity) {
        String url = baseUrl + "/products/send/" + productName + "/" + quantity;
        restTemplate.getForObject(url, Void.class);
    }

}
