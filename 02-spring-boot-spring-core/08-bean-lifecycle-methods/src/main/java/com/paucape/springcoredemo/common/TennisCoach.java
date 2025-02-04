package com.paucape.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{

    public TennisCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    // Define init method
    @PostConstruct
    public void doMyStartupStuff() {
        System.out.println("I doMyStartupStuff(): " + getClass().getSimpleName());
    }

    // Define destroy method
    @PreDestroy
    public void doMyCleanupStuff() {
        System.out.println("I doMyCleanupStuff(): " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }
}
