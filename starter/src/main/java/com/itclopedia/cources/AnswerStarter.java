package com.itclopedia.cources;

import com.itclopedia.cources.models.Answer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnswerStarter {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        AnswerService answerService = context.getBean(AnswerService.class);

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

        context.close();
    }
}
