package com.paucape.springcoredemo.rest;

import com.paucape.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // Define a private field for a dependency
    private Coach myCoach;
    private Coach anotherCoach;

    // Setter injection with qualifier
    @Autowired
    public DemoController(
            @Qualifier("tennisCoach") Coach theCoach,
            @Qualifier("tennisCoach") Coach theAnotherCoach) {
        System.out.println("In constructor: " + getClass().getSimpleName());
        myCoach = theCoach;
        anotherCoach = theAnotherCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }

    // Check if the bean is a Singleton (Same instance) or a Prototype (Different instance)
    @GetMapping("/check")
    public String check(){
        return "Comparing beans: myCoach == anotherCoach, " + (myCoach == anotherCoach);
    }

}
