package com.example.serviceclient.rest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestGithub {
    @JsonProperty("username")

    private String username;
    public RequestGithub(String username) {
        this.username = username;
    }


    public RequestGithub() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
