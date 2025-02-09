package com.kamal.quizapp.service;

import com.kamal.quizapp.model.Question;
import com.kamal.quizapp.model.QuestionWrapper;
import com.kamal.quizapp.model.Quiz;
import com.kamal.quizapp.model.Response;
import com.kamal.quizapp.repository.QuestionRepository;
import com.kamal.quizapp.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Long id) {
        Optional<Quiz> quiz=quizRepository.findById(id);
        List<Question> questionFromDb=quiz.get().getQuestions();
        List<QuestionWrapper> questionForUser=new ArrayList<>();
        for(Question q:questionFromDb){
            QuestionWrapper qw=new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
            questionForUser.add(qw);
        }

        return new ResponseEntity<>(questionForUser,HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateResult(Long id, List<Response> responses) {
        Quiz quiz=quizRepository.findById(id).get();
        List<Question> questions=quiz.getQuestions();
        int totalCountRightAns=0;
        int index=0;
        /* Here is the checking the right answer */
        for(Response response:responses){
            if(response.getResponse().equals(questions.get(index).getRightAnswer())){
                totalCountRightAns++;
            }
            index++;
        }
        return new ResponseEntity<>(totalCountRightAns,HttpStatus.OK);
    }
}
