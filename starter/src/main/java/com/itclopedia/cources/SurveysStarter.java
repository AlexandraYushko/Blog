package com.itclopedia.cources;

import com.itclopedia.cources.models.Surveys;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SurveysStarter {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        SurveysService surveysService = context.getBean(SurveysService.class);

        Surveys survey = new Surveys();
        survey.setQuestion("Question?");
        survey.setType("Type");
        survey.setDescription("Description");
        surveysService.createSurveys(survey);

        survey.setDescription("New description");
        surveysService.updateSurveys(survey);

        int surveyId = survey.getId();
        Surveys newSurvey = surveysService.getSurveyById(surveyId);
        System.out.println("Ответ " + newSurvey);

        int delSurvey = 2;
        surveysService.deleteSurveys(delSurvey);

        context.close();
    }
}
