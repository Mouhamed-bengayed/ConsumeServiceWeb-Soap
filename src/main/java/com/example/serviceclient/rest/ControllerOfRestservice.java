package com.example.serviceclient.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ControllerOfRestservice {

    @Autowired
    RestTemplate restTemplate;
    @PostMapping("/github")
    public GitHubUser get(@RequestBody RequestGithub request){


        String url = "https://api.github.com/users/"+request.getUsername();
        System.out.println(url);
        GitHubUser user = restTemplate.getForObject(url, GitHubUser.class);

        return user;


    }
    @GetMapping("/getPosts")
    public List<Post> getPosts( ){
        String url = "https://jsonplaceholder.typicode.com/posts";
        List<Post> posts = restTemplate.getForObject(url, List.class);
        return posts;
    }
    @PostMapping("/setPost")
    public Post setPost(@RequestBody Post post ){
        String url = "https://jsonplaceholder.typicode.com/posts";
        System.out.println(post);
        Post response = restTemplate.postForObject(url, post, Post.class);


        return response;
    }
}
