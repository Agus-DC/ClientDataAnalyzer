package com.challenge.client.service;

import com.challenge.client.dto.in.ClientRequest;

public interface CrudClient {
    void createClient(ClientRequest clientRequest);
}
