package com.challenge.client.controller;

import com.challenge.client.service.ClientStatistics;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clients/statistics")
@AllArgsConstructor
public class ClientStatisticsController {

    ClientStatistics clientStatisticsService;

    @RequestMapping(method = RequestMethod.GET, path = "/age/average")
    public ResponseEntity<Double> getClientAgeAverage() {
        return ResponseEntity.ok(clientStatisticsService.getClientAgeAverage());
    }

    @RequestMapping(method = RequestMethod.GET, path = "/age/standard-deviation")
    public ResponseEntity<Double> getClientAgeStandardDeviation() {
        return ResponseEntity.ok(clientStatisticsService.getClientAgeStandardDeviation());
    }
}