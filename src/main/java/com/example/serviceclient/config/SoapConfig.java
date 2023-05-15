package com.example.serviceclient.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;

import java.util.Collections;

//that it contains configuration for a Spring application context.
// The class defines a method named marshaller() which creates a Jaxb2Marshaller bean
// and sets its packagesToScan property to "com.example.generated"

@Configuration
public class SoapConfig {
    @Bean
    public Jaxb2Marshaller marshaller(){
        Jaxb2Marshaller marshaller=new Jaxb2Marshaller();
        marshaller.setPackagesToScan("com.example.generated");


        marshaller.setMarshallerProperties(Collections.singletonMap("jaxb.encoding", "UTF-8"));

        return marshaller;
    }
    @Bean
    public WebServiceTemplate webServiceTemplate(Jaxb2Marshaller marshalle) {
        WebServiceTemplate template = new WebServiceTemplate();
        template.setDefaultUri("http://www.w3schools.com/xml/tempconvert.asmx"); // replace with your service URL
        template.setMarshaller(marshalle);
        template.setUnmarshaller(marshalle);
        return template;
    }


}
