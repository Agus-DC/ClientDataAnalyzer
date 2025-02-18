package com.challenge.client.service;

import com.challenge.client.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClientStatisticsService implements ClientStatistics {

    ClientRepository clientRepository;

    @Override
    public Double getClientAgeAverage() {
        return clientRepository.getAverage();
    }

    @Override
    public Double getClientAgeStandardDeviation() {
        return clientRepository.getStandardDeviation();
    }
}
