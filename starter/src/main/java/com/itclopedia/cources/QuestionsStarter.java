package com.itclopedia.cources;

import com.itclopedia.cources.models.Questions;

public class QuestionsStarter {
    public static void main(String[] args) {
        QuestionsDAO questionsDAO = new QuestionsDAO();
        QuestionsService questionsService = new QuestionsService(questionsDAO);

        Questions question = new Questions();
        question.setQuestion("Question?");
        questionsService.createQuestion(question);

        question.setQuestion("New question?");
        questionsService.updateQuestion(question);

        int questionId = question.getId();
        Questions newQuestion = questionsService.getQuestionById(questionId);
        System.out.println("Ответ " + newQuestion);

        int delQuestion = 3;
        questionsService.deleteQuestion(delQuestion);
    }
}
