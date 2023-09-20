package com.example.client.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientRequest {

    private String name;
    private String lastName;


    private Double telephoneNumber;
    private String address;
    private String email;

}
