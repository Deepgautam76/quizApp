package com.kamal.quizapp.controller;

import com.kamal.quizapp.model.Question;
import com.kamal.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    @GetMapping("/questions")
    public ResponseEntity<List<Question>> allQuestion(){
        return questionService.getAllQuestion();
    }
    @PostMapping("/add")
    public ResponseEntity<Question> addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Question> updateQuestionById(@PathVariable Long id,
                                       @RequestBody Question question){
        return questionService.updateQuestionById(id,question);
    }
    @DeleteMapping("/remove/{id}")
    public ResponseEntity<String> deleteQuestionById(@PathVariable Long id) {
        return questionService.deleteQuestionById(id);
    }
    @GetMapping("/category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category){
        return questionService.getQuestionByCategory(category);
    }
}
