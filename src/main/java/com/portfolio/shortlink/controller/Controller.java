package com.portfolio.shortlink.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import com.portfolio.shortlink.model.ShortLink;
import com.portfolio.shortlink.service.MyService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class Controller {

    @Autowired
    private MyService service;

    @GetMapping("/")
    public String initialize() {
        return "Initilize Sucess";
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ShortLink sorteLink) {
        return service.create(sorteLink);
    }

    @GetMapping("/shortLink")
    public ResponseEntity<?> getAll() {
        return service.getAll();
    }

    @GetMapping("/{cod}")
    public ResponseEntity<?> getCod(@PathVariable int cod, HttpServletResponse response) {
        return service.getByCod(cod);
    }
}
