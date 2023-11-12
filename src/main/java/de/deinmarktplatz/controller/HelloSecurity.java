package de.deinmarktplatz.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloSecurity {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
    @GetMapping("/login")
    public String login(){
        return "enter login";
    }
}
