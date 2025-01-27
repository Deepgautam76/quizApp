package com.kamal.quizapp.controller;

import com.kamal.quizapp.model.Question;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @GetMapping
    public ResponseEntity<List<Question>> quizQuestion(){
        return null;
    }

    @GetMapping("/start")
    public ResponseEntity<?> getQuiz(@RequestParam(required = false) String category,
                                     @RequestParam(required = false) Long noOfQuestion,
                                     @RequestParam(required = false) String title){
        System.out.println("all values:");
        System.out.println("Category: "+category);
        System.out.println("NoOfQuestion: "+noOfQuestion);
        System.out.println("Title: "+title);
        return new ResponseEntity<>("It's working perfectly",HttpStatus.OK);
    }
}
