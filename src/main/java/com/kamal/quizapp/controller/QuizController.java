package com.kamal.quizapp.controller;

import com.kamal.quizapp.model.Question;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @GetMapping
    public ResponseEntity<List<Question>> quizQuestion(){
        return null;
    }
}
