package com.example.client_consum.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class GetDataRouteSoap extends RouteBuilder {
    @Override
    public void configure() throws Exception {

        from("cxf:bean:endpointClientSoap").id("SOAP")
                .log("initialized");

    }
}
