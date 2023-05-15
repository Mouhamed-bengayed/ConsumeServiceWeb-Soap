package com.example.serviceclient.soap;

import com.example.generated.CelsiusToFahrenheit;
import com.example.generated.CelsiusToFahrenheitResponse;
import com.example.generated.FahrenheitToCelsius;
import com.example.generated.FahrenheitToCelsiusResponse;
import com.example.serviceclient.soap.ClientSoap;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ControllerOfSoap {
    @Autowired
    private ClientSoap clientSoap;
    @PostMapping("/CtoF")
    public CelsiusToFahrenheitResponse convertFromCelsiusToFahrenheit(@RequestBody String request) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        CelsiusToFahrenheit r = objectMapper.readValue(request, CelsiusToFahrenheit.class);
        System.out.println("***********************************************");
        return clientSoap.celsiusToFahrenheit(r);
    }
    @PostMapping("/FtoC")
    public FahrenheitToCelsiusResponse convertFromFahrenheitToCelsius(@RequestBody String request) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        FahrenheitToCelsius r = objectMapper.readValue(request, FahrenheitToCelsius.class);
        System.out.println("***********************************************");
        return clientSoap.fahrenheitToCelsius(r);
    }
}
