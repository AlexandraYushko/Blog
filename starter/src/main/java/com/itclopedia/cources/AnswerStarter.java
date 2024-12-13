package com.itclopedia.cources;

import com.itclopedia.cources.models.Answer;

public class AnswerStarter {
    public static void main(String[] args) {
        AnswerDAO answerDAO = new AnswerDAO();
        AnswerService answerService = new AnswerService(answerDAO);

        Answer answer = new Answer();
        answer.setAnswer("Answer.");
        answer.setCorrect(true);
        answerService.createAnswer(answer);

        answer.setAnswer("New answer.");
        answerService.updateAnswer(answer);

        int answerId = answer.getId();
        Answer newAnswer = answerService.getAnswerById(answerId);
        System.out.println("Ответ " + newAnswer);

        int delAnswer = 3;
        answerService.deleteAnswer(delAnswer);
    }
}
