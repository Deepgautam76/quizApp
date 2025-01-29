package com.kamal.quizapp.service;

import com.kamal.quizapp.model.Question;
import com.kamal.quizapp.model.Quiz;
import com.kamal.quizapp.repository.QuestionRepository;
import com.kamal.quizapp.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {
    @Autowired
    private QuizRepository quizRepository;
    @Autowired
    private QuestionRepository questionRepository;

    public ResponseEntity<String> getQuiz(String category, Long numQ, String title) {
        List<Question> questions=questionRepository.findRandomQuestionsByCategory(category,numQ);
        Quiz quiz=new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizRepository.save(quiz);

        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }
}
