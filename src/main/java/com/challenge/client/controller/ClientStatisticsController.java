package com.challenge.client.controller;

import com.challenge.client.dto.out.ClientStatistic;
import com.challenge.client.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users/statistics")
@RequiredArgsConstructor
public class ClientStatisticsController {

    ClientService clientService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<ClientStatistic> getUserStatistics() {
        return ResponseEntity.ok(clientService.calculateStatistics());
    }
}