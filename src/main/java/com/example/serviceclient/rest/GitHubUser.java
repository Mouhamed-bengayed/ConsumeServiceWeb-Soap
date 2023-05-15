package com.example.serviceclient.rest;

public class GitHubUser {
    private String login;
    private int id;
    private String name;
    private String email;

    // add other properties as needed

    // default constructor


    // getters and setters
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public GitHubUser() {}
    // add other getters and setters as needed
}