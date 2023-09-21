package com.example.client_consum.routes;

import com.wsdlpackage.ClientRequest;
import com.wsdlpackage.ClientResponse;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

@Component
public class GetDataRouteRest extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        onException(com.fasterxml.jackson.databind.exc.MismatchedInputException.class)
                .handled(true)
                .setHeader(Exchange.HTTP_RESPONSE_CODE, constant(400))
                .setBody().constant("El cuerpo de la solicitud estaba vacío o no era un JSON válido.");

        rest("/demo")
                .bindingMode(RestBindingMode.off)

                .post("/clientInfo")
                .consumes(MediaType.APPLICATION_JSON_VALUE)
                .produces(MediaType.APPLICATION_JSON_VALUE)
                .to("direct:clientInfo");

        from("direct:clientInfo")
                .routeId("direct:clientInfo").noMessageHistory().noTracing().noStreamCaching()
                .choice()
                .when(body().isNotNull())
                .unmarshal().json(JsonLibrary.Jackson, ClientRequest.class)
                .setBody(exchange -> {
                    ClientRequest clientRequest = exchange.getIn().getBody(ClientRequest.class);
                    ClientResponse clientResponse = new ClientResponse();
                    clientResponse.setFullName(clientRequest.getName() + " " + clientRequest.getLastName());
                    clientResponse.setPersonalData("Telephone: " + clientRequest.getTelephoneNumber() + " " + "Address: " + clientRequest.getAddress() + " " + "Email: " + clientRequest.getEmail());
                    return clientResponse;
                })
                .marshal().json(JsonLibrary.Jackson, ClientResponse.class)
                .endChoice()
                .otherwise()
                .setHeader(Exchange.HTTP_RESPONSE_CODE, constant(400))
                .setBody().constant("El cuerpo de la solicitud no puede estar vacío.");
    }
}
