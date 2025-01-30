package com.kamal.quizapp.controller;

import com.kamal.quizapp.model.Question;
import com.kamal.quizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @GetMapping
    public ResponseEntity<List<Question>> quizQuestion(){
        return null;
    }

    @GetMapping("/create")
    public ResponseEntity<?> getQuiz(@RequestParam(required = false) String category,
                                     @RequestParam(required = false) Long numQ,
                                     @RequestParam(required = false) String title){
        return quizService.getQuiz(category,numQ,title);
    }
}
