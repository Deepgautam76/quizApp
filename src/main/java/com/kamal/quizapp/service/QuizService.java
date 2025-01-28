package com.kamal.quizapp.service;

import com.kamal.quizapp.model.Quiz;
import com.kamal.quizapp.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuizService {
    @Autowired
    private QuizRepository quizRepository;

    public Quiz getQuiz(String category, Long noOfQ, String title) {
        Quiz quiz=new Quiz();
        quiz.setTitle(title);
        quiz.setNoOfQ(noOfQ);
        quiz.setCategory(category);
        quizRepository.save(quiz);

        return null;
    }
}
