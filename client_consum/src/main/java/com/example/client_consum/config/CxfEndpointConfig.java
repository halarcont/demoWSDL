package com.example.client_consum.config;

import com.wsdlpackage.ClientDemo;
import org.apache.camel.component.cxf.CxfEndpoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CxfEndpointConfig {

    @Bean("endpointClientSoap")
    public CxfEndpoint wsClientSoap(){
        CxfEndpoint cxfEndpoint = new CxfEndpoint();
        cxfEndpoint.setAddress("/WSClient");
        cxfEndpoint.setLoggingFeatureEnabled(true);
        cxfEndpoint.setServiceClass(ClientDemo.class);
        return cxfEndpoint;
    }

}
