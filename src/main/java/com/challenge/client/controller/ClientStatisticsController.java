package com.challenge.client.controller;

import com.challenge.client.dto.out.ClientStatistic;
import com.challenge.client.service.ClientStatistics;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users/statistics")
@AllArgsConstructor
public class ClientStatisticsController {

    ClientStatistics clientStatisticsService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<ClientStatistic> getUserStatistics() {
        return ResponseEntity.ok(clientStatisticsService.calculateStatistics());
    }
}