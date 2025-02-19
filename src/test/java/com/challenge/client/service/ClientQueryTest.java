package com.challenge.client.service;

import static com.challenge.client.exception.ExceptionMessage.DATABASE_IS_EMPTY;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.challenge.client.dto.out.ClientResponse;
import com.challenge.client.exception.EmptyDataBaseException;
import com.challenge.client.model.Client;
import com.challenge.client.repository.ClientRepository;
import com.challenge.client.service.mocks.ClientMother;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.*;


@ExtendWith(MockitoExtension.class)
class ClientQueryTest {

    @Mock
    private ClientRepository clientRepository;

    @Mock
    private ClientEventCalculation clientEventCalculation;

    @InjectMocks
    private ClientQuery clientQuery;

    private Pageable pageable;
    private Client client;

    @BeforeEach
    void setUp() {
        pageable = PageRequest.of(0, 10, Sort.by("name").ascending());
        client = ClientMother.getClient();
    }

    @Test
    void testGetAllClients_Success() {
        Page<Client> clientPage = new PageImpl<>(List.of(client), pageable, 1);
        when(clientRepository.findAll(pageable)).thenReturn(clientPage);
        when(clientEventCalculation.calculateLifeExpectancy(19)).thenReturn(61);

        Page<ClientResponse> responsePage = clientQuery.getAllClients(pageable);

        assertEquals(1, responsePage.getTotalElements());
        assertEquals("pepe", responsePage.getContent().get(0).getName());
        assertEquals("pipon", responsePage.getContent().get(0).getSurname());
        assertEquals(19, responsePage.getContent().get(0).getAge());
        assertEquals(61, responsePage.getContent().get(0).getLifeExpectancy());

        verify(clientRepository, times(1)).findAll(pageable);
        verify(clientEventCalculation, times(1)).calculateLifeExpectancy(19);
    }

    @Test
    void testGetAllClients_ThrowsExceptionWhenDatabaseIsEmpty() {
        Page<Client> emptyPage = Page.empty();
        when(clientRepository.findAll(pageable)).thenReturn(emptyPage);

        EmptyDataBaseException exception = assertThrows(
                EmptyDataBaseException.class,
                () -> clientQuery.getAllClients(pageable)
        );

        assertEquals(DATABASE_IS_EMPTY.getValue(), exception.getMessage());
        verify(clientRepository, times(1)).findAll(pageable);
        verify(clientEventCalculation, never()).calculateLifeExpectancy(anyInt());
    }
}
