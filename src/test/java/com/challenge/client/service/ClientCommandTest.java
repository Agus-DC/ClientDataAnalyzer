package com.challenge.client.service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.challenge.client.dto.in.ClientRequest;
import com.challenge.client.dto.out.Message;
import com.challenge.client.exception.SaveEntityFailException;
import com.challenge.client.exception.SendMessageFailException;
import com.challenge.client.model.Client;
import com.challenge.client.queue.QueueProducer;
import com.challenge.client.repository.ClientRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

@ExtendWith(MockitoExtension.class)
public class ClientCommandTest {

    private ModelMapper mapper = new ModelMapper();

    ClientRepository clientRepository;

    @Mock QueueProducer queueProducer;// = mock(QueueProducer.class);

    private final ObjectMapper objectMapper = new ObjectMapper();

    ClientCommand clientclientCommand = new ClientCommand(mapper, clientRepository, queueProducer);

    @BeforeEach
    void setUp() {
        //MockitoAnnotations.openMocks(this);
        /*when(mapper.map(any(ClientRequest.class), eq(Client.class)))
                .thenReturn(new Client());
        when(mapper.map(any(Client.class), eq(Message.class)))
                .thenReturn(new Message());*/
    }

    @Test
    void testCreateClient_Success() {

        /*
        ClientRequest request = new ClientRequest("Juan", "Pérez", 30, null);

        assertDoesNotThrow(() -> clientCommand.createClient(request));

        verify(clientRepository, times(1)).save(any(Client.class));
        verify(queueProducer, times(1)).sendMessage(anyString());*/
    }
/*
    @Test
    void testCreateClient_Success() {
        ClientRequest request = new ClientRequest("Juan", "Pérez", 30, null);

        assertDoesNotThrow(() -> clientCommand.createClient(request));

        verify(clientRepository, times(1)).save(any(Client.class));
        verify(queueProducer, times(1)).sendMessage(anyString());
    }

    @Test
    void testCreateClient_FailDatabaseSave() {
        ClientRequest request = new ClientRequest("Juan", "Pérez", 30, null);
        doThrow(new RuntimeException("Database error")).when(clientRepository).save(any(Client.class));

        Exception exception = assertThrows(SaveEntityFailException.class, () -> clientCommand.createClient(request));

        assertTrue(exception.getMessage().contains("Database error"));
        verify(clientRepository, times(1)).save(any(Client.class));
        verify(queueProducer, never()).sendMessage(anyString());
    }

    @Test
    void testCreateClient_FailQueueSend() throws Exception {
        ClientRequest request = new ClientRequest("Juan", "Pérez", 30, null);
        doThrow(new RuntimeException("Queue error")).when(queueProducer).sendMessage(anyString());

        Exception exception = assertThrows(SendMessageFailException.class, () -> clientCommand.createClient(request));

        assertTrue(exception.getMessage().contains("Queue error"));
        verify(clientRepository, times(1)).save(any(Client.class));
        verify(queueProducer, times(1)).sendMessage(anyString());
    }*/
}
