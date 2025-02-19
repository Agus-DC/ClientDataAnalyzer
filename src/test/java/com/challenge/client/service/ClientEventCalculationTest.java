package com.challenge.client.service;

import static org.springframework.test.util.AssertionErrors.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ClientEventCalculationTest {

    ClientEventCalculation clientEventCalculation = new ClientEventCalculation();

    @MethodSource("ageProvider")
    @ParameterizedTest
    void returnValidLifeExpectancy(Integer age, Integer expectedLifeExpectancy) {
        Integer lifeExpectancy = clientEventCalculation.calculateLifeExpectancy(age);
        assertEquals("", expectedLifeExpectancy, lifeExpectancy);
    }

    private static Stream<Arguments> ageProvider() {
        return Stream.of(
                Arguments.of(18, 62),
                Arguments.of(80, 0));
    }
}