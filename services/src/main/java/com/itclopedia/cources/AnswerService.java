package com.itclopedia.cources;

import com.itclopedia.cources.models.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class AnswerService {
    private final AnswerDAO answerDAO;

    @Autowired
    public AnswerService(AnswerDAO answerDAO) {
        this.answerDAO = answerDAO;
    }

    public void createAnswer(Answer answer) {
        answerDAO.addAnswer(answer);
    }

    public void updateAnswer(Answer answer) {
        answerDAO.updateAnswer(answer);
    }

    public void deleteAnswer(int answerId) {
        answerDAO.deleteAnswer(answerId);
    }

    public Answer getAnswerById(int answerId) {
        return answerDAO.getAnswerById(answerId);
    }

    public List<Answer> getAllAnswer() throws SQLException {
        return answerDAO.getAllAnswer();
    }
}
