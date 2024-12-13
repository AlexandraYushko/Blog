package com.itclopedia.cources;

import com.itclopedia.cources.models.Surveys;

public class SurveysStarter {
    public static void main(String[] args) {
        SurveysDAO surveysDAO = new SurveysDAO();
        SurveysService surveysService = new SurveysService(surveysDAO);

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
    }
}
