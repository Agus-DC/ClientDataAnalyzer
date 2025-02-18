package com.challenge.client.controller;

import com.challenge.client.dto.in.ClientRequest;
import com.challenge.client.service.CrudClient;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clients")
@AllArgsConstructor
public class ClientCrudController {

    CrudClient crudClientService;

    @RequestMapping(method = RequestMethod.POST, path = "/create")
    public ResponseEntity<String> createClient(@RequestBody @Validated ClientRequest clientRequest) {
        crudClientService.createClient(clientRequest);
        return ResponseEntity.ok("client created");
    }
}

