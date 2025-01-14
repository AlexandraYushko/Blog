package com.itclopedia.cources;

import com.itclopedia.cources.models.Surveys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SurveysService {
    private final SurveysRepository surveysRepository;

    @Autowired
    public SurveysService(SurveysRepository surveysRepository) {
        this.surveysRepository = surveysRepository;
    }

    public void createSurveys(Surveys surveys) {
        surveysRepository.save(surveys);
    }

    public void updateSurveys(Surveys surveys) {
        surveysRepository.save(surveys);
    }

    public void deleteSurveys(int surveysId) {
        surveysRepository.deleteById(surveysId);
    }

    public Surveys getSurveyById(int surveyId) {
        return surveysRepository.findById(surveyId).orElse(null);
    }
}
