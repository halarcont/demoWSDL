package com.example.client_consum.config;

import com.wsdlpackage.ClientDemo;
import com.wsdlpackage.ClientDemo_Service;
import org.apache.camel.component.cxf.CxfEndpoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

@Configuration
public class CxfEndpointConfig {

    @Bean("endpointClientSoap")
    public CxfEndpoint wsClientSoap(){
        CxfEndpoint cxfEndpoint = new CxfEndpoint();
        cxfEndpoint.setServiceClass(ClientDemo.class);
        cxfEndpoint.setAddress("/WSClient");
        cxfEndpoint.setProperties(new HashMap<>());
        cxfEndpoint.getProperties().put("schema-validation-enabled", "true");
        cxfEndpoint.setLoggingFeatureEnabled(true);
        return cxfEndpoint;
    }

}
