package com.charlly.sistema_entregas.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloControler {
    
    @GetMapping("/hello")
    public String hello() {
        return "Sistema de entregas funcionando";
    }
}
