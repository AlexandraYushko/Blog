package com.itclopedia.cources;

import com.itclopedia.cources.models.Questions;

public class QuestionsService {
    private QuestionsDAO questionsDAO;

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

}
