package com.kamal.quizapp.controller;


import com.kamal.quizapp.model.QuestionWrapper;
import com.kamal.quizapp.model.Response;
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

    @PostMapping("/create")
    public ResponseEntity<?> createQuiz(@RequestParam(required = false) String category,
                                     @RequestParam(required = false) Long numQ,
                                     @RequestParam(required = false) String title){
        return quizService.createQuiz(category,numQ,title);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<List<QuestionWrapper>> quizQuizQuestion(@PathVariable Long id){
        return quizService.getQuizQuestions(id);
    }

    @PostMapping("/submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Long id,
                                              @RequestBody List<Response> responses){
        return quizService.calculateResult(id,responses);
    }

}
