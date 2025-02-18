package com.challenge.client.service;

import com.challenge.client.dto.out.ClientResponse;
import com.challenge.client.exception.EmptyDataBaseException;
import com.challenge.client.model.Client;
import com.challenge.client.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import static com.challenge.client.exception.ExceptionMessage.DATABASE_IS_EMPTY;

@Service
@AllArgsConstructor
public class ClientQuery {

    ClientRepository clientRepository;
    ClientEventCalculation clientEventCalculation;

    public Page<ClientResponse> getAllClients(Pageable pageable) {

        Page<Client> client = clientRepository.findAll(pageable);

        if (client.isEmpty()) {
            throw new EmptyDataBaseException(DATABASE_IS_EMPTY.getValue());
        }

        return client.map(c -> ClientResponse.builder()
                        .name(c.getName())
                        .surname(c.getSurname())
                        .age(c.getAge())
                        .bornDate(c.getBornDate())
                        .lifeExpectancy(clientEventCalculation
                                .calculateLifeExpectancy(c.getAge()))
                        .build()
                );
    }

}
