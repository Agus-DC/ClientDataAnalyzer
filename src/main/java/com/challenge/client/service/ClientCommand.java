package com.challenge.client.service;

import com.challenge.client.dto.in.ClientRequest;
import com.challenge.client.dto.out.ClientResponse;
import com.challenge.client.dto.out.Message;
import com.challenge.client.model.Client;
import com.challenge.client.queue.QueueProducer;
import com.challenge.client.repository.ClientRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

@Service
@AllArgsConstructor
public class ClientCommand {

    ModelMapper mapper;
    ClientRepository clientRepository;
    QueueProducer queueProducer;

    public void createClient(ClientRequest clientRequest) {

        ObjectMapper objectMapper = new ObjectMapper();
        Client client = mapper.map(clientRequest, Client.class);

        clientRepository.save(client);

        try {
            queueProducer.sendMessage(objectMapper.writeValueAsString(mapper.map(client, Message.class)));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
