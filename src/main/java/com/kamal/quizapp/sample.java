package com.kamal.quizapp;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
public class sample {
    @RequestMapping("/")
    public String greet(){
        return "Hello kamal";
    }
}
