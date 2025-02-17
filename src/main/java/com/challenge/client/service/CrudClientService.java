package com.challenge.client.service;

import com.challenge.client.dto.in.ClientRequest;
import com.challenge.client.model.Client;
import com.challenge.client.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

@Service
@AllArgsConstructor
public class CrudClientService implements CrudClient {

    ModelMapper mapper;
    ClientRepository clientRepository;

    @Override
    public void createClient(ClientRequest clientRequest) {
        Client client = mapper.map(clientRequest, Client.class);
        clientRepository.save(client);
    }
}
