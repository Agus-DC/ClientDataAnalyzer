package com.challenge.client.service;

import com.challenge.client.dto.out.ClientResponse;
import com.challenge.client.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClientQuery {

    ClientRepository clientRepository;
    ClientEventCalculation clientEventCalculation;

    public Page<ClientResponse> getAllClients(Pageable pageable) {
        return clientRepository.findAll(pageable)
                .map(client -> ClientResponse.builder()
                        .name(client.getName())
                        .surname(client.getSurname())
                        .age(client.getAge())
                        .bornDate(client.getBornDate())
                        .lifeExpectancy(clientEventCalculation
                                .calculateLifeExpectancy(client.getAge()))
                        .build()
                );
    }

}
