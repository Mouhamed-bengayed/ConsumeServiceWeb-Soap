package com.example.serviceclient.rest;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Post {
    @JsonProperty("userId")
    private Long userId;
    @JsonProperty("title")
    private String title;
    @JsonProperty("body")
    private String body;

    public Post() {
    }

    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }

    // Getters and setters omitted for brevity

    @Override
    public String toString() {
        return "Post{" +
                "id=" + userId +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}






