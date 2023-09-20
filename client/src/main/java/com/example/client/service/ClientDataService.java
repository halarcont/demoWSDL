package com.example.client.service;

import com.example.client.entity.ClientRequest;
import com.example.client.entity.ClientResponse;
import org.springframework.stereotype.Service;

@Service
public class ClientDataService {

    public ClientResponse getData(ClientRequest clientRequest) {
        ClientResponse clientResponse = new ClientResponse();
        clientResponse.setFullName(clientRequest.getName() + " " + clientRequest.getLastName());
        clientResponse.setPersonalData("Tel: " + clientRequest.getTelephoneNumber() + ", Dirección: " + clientRequest.getAddress() + ", Email: " + clientRequest.getEmail());
        return clientResponse;
    }
}
