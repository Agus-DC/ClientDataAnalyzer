package com.challenge.client.controller;

import com.challenge.client.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users/event")
@RequiredArgsConstructor
public class ClientEventCalculationController {

    ClientService clientService;

    @GetMapping("/life-expectancy")
    public ResponseEntity<String> calculateLifeExpectancy() {
        return ResponseEntity.ok(clientService.calculateLifeExpectancy());
    }
}
