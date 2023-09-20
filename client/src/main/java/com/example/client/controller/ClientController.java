package com.example.client.controller;

import com.example.client.entity.ClientRequest;
import com.example.client.entity.ClientResponse;
import com.example.client.service.ClientDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class ClientController {

    @Autowired
    private ClientDataService clientDataService;

    @PostMapping("/clientInfo")
    public ClientResponse clientResponse(@RequestBody ClientRequest clientRequest) {
        return clientDataService.getData(clientRequest);
    }
}
