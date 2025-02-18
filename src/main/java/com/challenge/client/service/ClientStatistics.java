package com.challenge.client.service;

import com.challenge.client.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClientStatistics {

    ClientRepository clientRepository;

    public Double getClientAgeAverage() {
        return clientRepository.getAverage();
    }

    public Double getClientAgeStandardDeviation() {
        return clientRepository.getStandardDeviation();
    }
}
