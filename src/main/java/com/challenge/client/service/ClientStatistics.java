package com.challenge.client.service;

import static com.challenge.client.exception.ExceptionMessage.NO_CLIENT_DATA_AVAILABLE_TO_AVERAGE_AGE;
import static com.challenge.client.exception.ExceptionMessage.NO_CLIENT_DATA_AVAILABLE_TO_STANDARD_DEVIATION;

import com.challenge.client.exception.EmptyDataBaseException;
import com.challenge.client.repository.ClientRepository;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClientStatistics {

    ClientRepository clientRepository;

    public Double getClientAgeAverage() {
        return Optional.ofNullable(clientRepository.getAverage())
                .orElseThrow(() -> new EmptyDataBaseException(NO_CLIENT_DATA_AVAILABLE_TO_AVERAGE_AGE.getValue()));

    }

    public Double getClientAgeStandardDeviation() {
        return Optional.ofNullable(clientRepository.getStandardDeviation())
                .orElseThrow(() -> new EmptyDataBaseException(NO_CLIENT_DATA_AVAILABLE_TO_STANDARD_DEVIATION.getValue()));
    }
}
