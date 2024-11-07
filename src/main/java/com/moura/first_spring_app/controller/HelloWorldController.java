package com.moura.first_spring_app.controller;

import com.moura.first_spring_app.domain.User;
import com.moura.first_spring_app.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello-world")
public class HelloWorldController {

    @Autowired
    private HelloWorldService helloWorldService;

    // GET /hello-world
    @GetMapping("/get")
    public String helloWorld() {
        return helloWorldService.helloWorld("Igor");
    }

    @PostMapping("/{id}")
    public String helloWorldPost(@PathVariable("id") String id, @RequestParam(value = "filter", defaultValue = "any") String filter, @RequestBody User body) {
        return "Hello World " + body.getName() + ", " + id + ", " + filter;
    }
}
