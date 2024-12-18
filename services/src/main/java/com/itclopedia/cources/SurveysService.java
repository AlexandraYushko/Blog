package com.itclopedia.cources;

import com.itclopedia.cources.models.Surveys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SurveysService {
    private final SurveysDAO surveysDAO;

    @Autowired
    public SurveysService(SurveysDAO surveysDAO) {
        this.surveysDAO = surveysDAO;
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
