package com.challenge.client.controller;

import com.challenge.client.service.ClientEventCalculation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users/event")
@AllArgsConstructor
public class ClientEventCalculationController {

    ClientEventCalculation clientEventCalculationService;

    @GetMapping("/life-expectancy")
    public ResponseEntity<String> calculateLifeExpectancy() {
        return ResponseEntity.ok(clientEventCalculationService.calculateLifeExpectancy());
    }
}
