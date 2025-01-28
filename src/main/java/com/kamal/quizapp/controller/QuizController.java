package com.kamal.quizapp.controller;

import com.kamal.quizapp.model.Question;
import com.kamal.quizapp.model.Quiz;
import com.kamal.quizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @GetMapping
    public ResponseEntity<List<Question>> quizQuestion(){
        return null;
    }

    @GetMapping("/create")
    public ResponseEntity<?> getQuiz(@RequestParam(required = false) String category,
                                     @RequestParam(required = false) Long noOfQ,
                                     @RequestParam(required = false) String title){
        Quiz quiz=quizService.getQuiz(category,noOfQ,title);
        return new ResponseEntity<>("It's working perfectly",HttpStatus.OK);
    }
}
