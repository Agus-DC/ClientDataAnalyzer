package com.challenge.client.service;

import static com.challenge.client.exception.ExceptionMessage.NO_CLIENT_DATA_AVAILABLE_TO_AVERAGE_AGE;
import static com.challenge.client.exception.ExceptionMessage.NO_CLIENT_DATA_AVAILABLE_TO_STANDARD_DEVIATION;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.challenge.client.exception.EmptyDataBaseException;
import com.challenge.client.repository.ClientRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ClientStatisticsTest {

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private ClientStatistics clientStatistics;

    @Test
    void testGetClientAgeAverage_Success() {
        when(clientRepository.getAverage()).thenReturn(35.0);

        Double average = clientStatistics.getClientAgeAverage();

        assertEquals(35.0, average);
        verify(clientRepository, times(1)).getAverage();
    }

    @Test
    void testGetClientAgeAverage_ThrowsExceptionWhenNoData() {
        when(clientRepository.getAverage()).thenReturn(null);

        EmptyDataBaseException exception = assertThrows(
                EmptyDataBaseException.class,
                () -> clientStatistics.getClientAgeAverage()
        );

        assertEquals(NO_CLIENT_DATA_AVAILABLE_TO_AVERAGE_AGE.getValue(), exception.getMessage());
    }

    @Test
    void testGetClientAgeStandardDeviation_Success() {
        when(clientRepository.getStandardDeviation()).thenReturn(5.0);

        Double stdDev = clientStatistics.getClientAgeStandardDeviation();

        assertEquals(5.0, stdDev);
        verify(clientRepository, times(1)).getStandardDeviation();
    }

    @Test
    void testGetClientAgeStandardDeviation_ThrowsExceptionWhenNoData() {
        when(clientRepository.getStandardDeviation()).thenReturn(null);

        EmptyDataBaseException exception = assertThrows(
                EmptyDataBaseException.class,
                () -> clientStatistics.getClientAgeStandardDeviation()
        );

        assertEquals(NO_CLIENT_DATA_AVAILABLE_TO_STANDARD_DEVIATION.getValue(), exception.getMessage());
    }
}
