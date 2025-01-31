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
    public ResponseEntity<?> quizQuiz(@PathVariable Long id){
        return quizService.getQuizById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createQuiz(@RequestParam(required = false) String category,
                                     @RequestParam(required = false) Long numQ,
                                     @RequestParam(required = false) String title){
        return quizService.createQuiz(category,numQ,title);
    }

}
