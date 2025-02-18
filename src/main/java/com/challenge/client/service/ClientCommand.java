package com.challenge.client.service;

import static com.challenge.client.exception.ExceptionMessage.FAIL_TO_SAVE_CLIENT_ENTITY;
import static com.challenge.client.exception.ExceptionMessage.FAIL_TO_SEND_CLIENT_DATA;

import com.challenge.client.dto.in.ClientRequest;
import com.challenge.client.dto.out.Message;
import com.challenge.client.exception.SaveEntityFailException;
import com.challenge.client.exception.SendMessageFailException;
import com.challenge.client.model.Client;
import com.challenge.client.queue.QueueProducer;
import com.challenge.client.repository.ClientRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

@Service
@AllArgsConstructor
public class ClientCommand {

    ModelMapper mapper;
    ClientRepository clientRepository;
    QueueProducer queueProducer;

    public void createClient(ClientRequest clientRequest) {

        Client client = mapper.map(clientRequest, Client.class);

        dataBaseSaveClient(client);

        queueSendClient(client);
    }

    private void dataBaseSaveClient(Client client) {
        try {
            clientRepository.save(client);
        } catch (Exception e) {
            throw new SaveEntityFailException(FAIL_TO_SAVE_CLIENT_ENTITY.getValue() + ": " + e.getMessage());
        }
    }

    private void queueSendClient(Client client) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            queueProducer.sendMessage(
                    objectMapper.writeValueAsString(
                            mapper.map(client, Message.class)
                    ));
        } catch (Exception e) {
            throw new SendMessageFailException(FAIL_TO_SEND_CLIENT_DATA.getValue() + ": " + e.getMessage());
        }
    }

}
