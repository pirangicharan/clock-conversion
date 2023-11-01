package com.ramcharan.Alien_Clock.controller;

import com.ramcharan.Alien_Clock.service.AlienClockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/clock")
@CrossOrigin
public class AlienClockController {


    @Autowired
    private AlienClockService alienClockService;

    @GetMapping("/alien-clock")
    public CompletableFuture<String> getAlienClock(){
        return alienClockService.calculateAlienTimeAsync();
    }

    @GetMapping("/alien-date")
    public CompletableFuture<String> getAlienDate(){
        return alienClockService.calculateAlienDateAsync();
    }

    @GetMapping("/earth-clock")
    public CompletableFuture<String> getEarthClock(){
        return alienClockService.calculateEarthTimeAsync();
    }

    @GetMapping("/earth-date")
    public CompletableFuture<String> getEarthDate(){
        return alienClockService.calculateEarthDateAsync();
    }
}
