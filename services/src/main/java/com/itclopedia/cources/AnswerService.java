package com.itclopedia.cources;

import com.itclopedia.cources.models.Answer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class AnswerService {
    private final AnswerRepository answerRepository;

    @Autowired
    public AnswerService(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    public void createAnswer(Answer answer) {
        answerRepository.save(answer);
    }

    public void updateAnswer(Answer answer) {
        answerRepository.save(answer);
    }

    public void deleteAnswer(int answerId) {
        answerRepository.deleteById(answerId);
    }

    public Answer getAnswerById(int answerId) {
        return answerRepository.findById(answerId).orElse(null);
    }

    public List<Answer> getAllAnswer() {
        return answerRepository.findAll();
    }

}
