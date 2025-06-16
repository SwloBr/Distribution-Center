package com.swlo.distribuitioncenter.services;

import com.swlo.distribuitioncenter.business.clients.HubClient;
import com.swlo.distribuitioncenter.business.dto.CdDto;
import com.swlo.distribuitioncenter.config.LogisticConfig;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StartupService {

    private final HubClient hubClient;
    private final LogisticConfig logisticConfig;

    @PostConstruct
    public void registerDistributionCenter() {
        CdDto cdDto = new CdDto(
            logisticConfig.getId(),
            logisticConfig.getName(),
            logisticConfig.getAddress()
        );
        hubClient.registerDistributionCenter(cdDto);
    }
}
