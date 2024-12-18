package com.itclopedia.cources;

import com.itclopedia.cources.models.Questions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionsService {
    private final QuestionsDAO questionsDAO;

    @Autowired
    public QuestionsService(QuestionsDAO questionsDAO) {
        this.questionsDAO = questionsDAO;
    }

    public void createQuestion(Questions question) {
        questionsDAO.addQuestion(question);
    }

    public void updateQuestion(Questions question) {
        questionsDAO.updateQuestion(question);
    }

    public void deleteQuestion(int questionId) {
        questionsDAO.deleteQuestion(questionId);
    }

    public Questions getQuestionById(int questionId) {
        return questionsDAO.getQuestionById(questionId);
    }

}
