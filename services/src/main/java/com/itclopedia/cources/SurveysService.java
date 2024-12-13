package com.itclopedia.cources;

import com.itclopedia.cources.models.Surveys;

public class SurveysService {
    private final SurveysDAO surveysDAO;

    public SurveysService(SurveysDAO surveysDAO) {
        this.surveysDAO = new SurveysDAO();
    }

    public void createSurveys(Surveys surveys) {
        surveysDAO.addSurveys(surveys);
    }

    public void updateSurveys(Surveys surveys) {
        surveysDAO.updateSurveys(surveys);
    }

    public void deleteSurveys(int surveysId) {
        surveysDAO.deleteSurveys(surveysId);
    }

    public Surveys getSurveyById(int surveyId) {
        return surveysDAO.getSurveysById(surveyId);
    }
}
