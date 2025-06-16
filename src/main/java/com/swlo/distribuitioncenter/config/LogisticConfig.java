package com.swlo.distribuitioncenter.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class LogisticConfig {

    @Value("${hub.address}")
    private String hub;

    @Value("${cd.id}")
    private Long id;

    @Value("${cd.name}")
    private String name;

    @Value("${cd.url}")
    private String address;

    public String getHub() {
        return hub;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}
