package com.challenge.client.service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.challenge.client.dto.in.ClientRequest;
import com.challenge.client.exception.ExceptionMessage;
import com.challenge.client.exception.SaveEntityFailException;
import com.challenge.client.exception.SendMessageFailException;
import com.challenge.client.model.Client;
import com.challenge.client.queue.QueueProducer;
import com.challenge.client.repository.ClientRepository;
import com.challenge.client.service.mocks.ClientMother;
import com.challenge.client.service.mocks.ClientRequestMother;
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

    @Mock
    private ModelMapper mapper;

    @Mock
    ClientRepository clientRepository;

    @Mock
    QueueProducer queueProducer;

    @InjectMocks
    ClientCommand clientCommand;

    ClientRequest request;

    @BeforeEach
    void setUp() {
        request = ClientRequestMother.getPaymentRequest();
        MockitoAnnotations.openMocks(this);
        Mockito.when(mapper.map(Mockito.any(), Mockito.any())).thenReturn(ClientMother.getClient());
    }

    @Test
    void createClientSuccess() {
        assertDoesNotThrow(() -> clientCommand.createClient(request));

        verify(clientRepository, times(1)).save(any(Client.class));
        verify(queueProducer, times(1)).sendMessage(anyString());
    }

    @Test
    void createClientFailDatabaseSave() {
        doThrow(new RuntimeException(ExceptionMessage.FAIL_TO_SAVE_CLIENT_ENTITY.getValue())).when(clientRepository).save(any(Client.class));
        Exception exception = assertThrows(SaveEntityFailException.class, () -> clientCommand.createClient(request));

        assertTrue(exception.getMessage().contains(ExceptionMessage.FAIL_TO_SAVE_CLIENT_ENTITY.getValue()));
        verify(clientRepository, times(1)).save(any(Client.class));
        verify(queueProducer, never()).sendMessage(anyString());
    }

    @Test
    void createClientFailQueueSend() {
        doThrow(new RuntimeException(ExceptionMessage.FAIL_TO_SEND_CLIENT_DATA.getValue())).when(queueProducer).sendMessage(anyString());
        Exception exception = assertThrows(SendMessageFailException.class, () -> clientCommand.createClient(request));

        assertTrue(exception.getMessage().contains(ExceptionMessage.FAIL_TO_SEND_CLIENT_DATA.getValue()));
        verify(clientRepository, times(1)).save(any(Client.class));
        verify(queueProducer, times(1)).sendMessage(anyString());
    }
}
