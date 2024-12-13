package com.itclopedia.cources;

import com.itclopedia.cources.models.Questions;

public class QuestionsService {
    private final QuestionsDAO questionsDAO;

    public QuestionsService(QuestionsDAO questionsDAO) {
        this.questionsDAO = new QuestionsDAO();
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
