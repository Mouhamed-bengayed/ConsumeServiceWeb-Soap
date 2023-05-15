package com.example.serviceclient.soap;

import com.example.generated.CelsiusToFahrenheit;
import com.example.generated.CelsiusToFahrenheitResponse;
import com.example.generated.FahrenheitToCelsius;
import com.example.generated.FahrenheitToCelsiusResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.client.core.SoapActionCallback;

@Service

public class ClientSoap {

    @Autowired
    private WebServiceTemplate template;
    @Autowired
    private  Jaxb2Marshaller marshaller;
    public CelsiusToFahrenheitResponse celsiusToFahrenheit(CelsiusToFahrenheit request){
        template=new WebServiceTemplate(marshaller);
        System.out.println(request);
        SoapActionCallback callback = new SoapActionCallback("https://www.w3schools.com/xml/CelsiusToFahrenheit");



        CelsiusToFahrenheitResponse response= (CelsiusToFahrenheitResponse) template.marshalSendAndReceive("https://www.w3schools.com/xml/tempconvert.asmx",request,callback);
        System.out.println(response);
        return response;


    }
    public FahrenheitToCelsiusResponse fahrenheitToCelsius(FahrenheitToCelsius request){
        template=new WebServiceTemplate(marshaller);
        System.out.println(request);
        SoapActionCallback callback = new SoapActionCallback("https://www.w3schools.com/xml/FahrenheitToCelsius");



        FahrenheitToCelsiusResponse response= (FahrenheitToCelsiusResponse) template.marshalSendAndReceive("https://www.w3schools.com/xml/tempconvert.asmx",request,callback);
        System.out.println(response);
        return response;


    }
}
