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
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    private QuizRepository quizRepository;
    @Autowired
    private QuestionRepository questionRepository;

    public ResponseEntity<String> createQuiz(String category, Long numQ, String title) {
        List<Question> questions=questionRepository.findRandomQuestionsByCategory(category,numQ);
        Quiz quiz=new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizRepository.save(quiz);

        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public ResponseEntity<?> getQuizById(Long id) {
        Optional<Quiz> quiz=quizRepository.findById(id);
        return new ResponseEntity<>(quiz,HttpStatus.OK);
    }
}
