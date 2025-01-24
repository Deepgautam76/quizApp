package com.kamal.quizapp.service;

import com.kamal.quizapp.model.Question;
import com.kamal.quizapp.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;
    public List<Question> getAllQuestion() {
        return questionRepository.findAll();
    }
}
