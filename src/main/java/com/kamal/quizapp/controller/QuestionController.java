package com.kamal.quizapp.controller;

import com.kamal.quizapp.model.Question;
import com.kamal.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    @GetMapping("/allQuestions")
    public List<Question> allQuestion(){
        return questionService.getAllQuestion();
    }

}
