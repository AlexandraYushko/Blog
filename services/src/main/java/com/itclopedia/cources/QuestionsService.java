package com.itclopedia.cources;

import com.itclopedia.cources.models.Questions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class QuestionsService {
    private final QuestionRepository questionRepository;

    @Autowired
    public QuestionsService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public void createQuestion(Questions question) {
        questionRepository.save(question);
    }

    public void updateQuestion(Questions question) {
        questionRepository.save(question);
    }

    public void deleteQuestion(int questionId) {
        questionRepository.deleteById(questionId);
    }

    public Questions getQuestionById(int questionId) {
        return questionRepository.findById(questionId).orElse(null);
    }
}
