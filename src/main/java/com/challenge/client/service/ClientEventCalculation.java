package com.challenge.client.service;

import org.springframework.stereotype.Service;

@Service
public class ClientEventCalculation {

    private static final int LIFE_EXPECTANCY_YEARS = 80;

    public Integer calculateLifeExpectancy(Integer age) {
        if (age >= LIFE_EXPECTANCY_YEARS) {
            return 0; // Has already reached or exceeded life expectancy
        }
        return LIFE_EXPECTANCY_YEARS - age;
    }
}
