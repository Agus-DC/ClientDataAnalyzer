package com.challenge.client.controller;

import com.challenge.client.dto.in.ClientRequest;
import com.challenge.client.dto.out.ClientResponse;
import com.challenge.client.service.ClientCommand;
import com.challenge.client.service.ClientQuery;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients")
@AllArgsConstructor
public class ClientController {

    ClientCommand clientCommandService;
    ClientQuery clientQueryService;

    @PostMapping(path = "/create")
    public ResponseEntity<String> createClient(@RequestBody @Validated ClientRequest clientRequest) {
        clientCommandService.createClient(clientRequest);
        return ResponseEntity.ok("client created");
    }

    @GetMapping(path = "/get-all")
    public ResponseEntity<Page<ClientResponse>> getAllUsers(Pageable pageable) {
        return ResponseEntity.ok(clientQueryService.getAllClients(pageable));
    }
}

