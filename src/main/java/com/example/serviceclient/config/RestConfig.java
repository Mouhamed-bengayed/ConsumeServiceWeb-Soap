package com.example.serviceclient.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Configuration

@Slf4j
public class RestConfig {
    @Bean
    public RestTemplate restTemplate(){
        RestTemplate restTemplate = new RestTemplate();
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        messageConverters.add(new MappingJackson2HttpMessageConverter());
        restTemplate.setMessageConverters(messageConverters);
        restTemplate.setInterceptors(Collections.singletonList((request, body, execution) -> {
            ClientHttpResponse response = execution.execute(request, body);
            // log request and response
            log.info("Request: {} {}", request.getMethod(), request.getURI());
            log.info("Request body: {}", body);
            log.info("Response status: {}", response.getStatusCode());
            return response;
        }));

        return  restTemplate;
    }
}
