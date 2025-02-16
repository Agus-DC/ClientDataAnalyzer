package com.challenge.client.service;

import com.challenge.client.dto.in.ClientRequest;
import com.challenge.client.dto.out.ClientStatistic;

public interface ClientService {
    void createClient(ClientRequest clientRequest);
    ClientStatistic calculateStatistics();
    String calculateLifeExpectancy();
}
