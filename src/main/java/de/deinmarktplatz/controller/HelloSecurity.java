package de.deinmarktplatz.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloSecurity {

    @GetMapping
    public String hello(){
        return "hello";
    }
    @GetMapping
    public String login(){
        return "enter login";
    }
}
