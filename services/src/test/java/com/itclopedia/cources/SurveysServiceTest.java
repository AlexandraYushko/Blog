package com.itclopedia.cources;

import com.itclopedia.cources.models.Surveys;
import org.junit.Test;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class SurveysServiceTest {
    private SurveysService surveysService;
    private SurveysDAO surveysDAO;

    @BeforeEach
    public void setup() {
        surveysDAO = Mockito.mock(SurveysDAO.class);
        surveysService = new SurveysService(surveysDAO);
    }

    @Test
    public void testCreate() {
        Surveys surveys = new Surveys();
        surveys.setDescription("Desc");
        surveys.setQuestion("Question");
        surveys.setType("Type");
        doNothing().when(surveysDAO).addSurveys(surveys);
        surveysService.createSurveys(surveys);
        verify(surveysDAO, times(1)).addSurveys(surveys);
    }

    @Test
    public void testUpdate() {
        Surveys surveys = new Surveys();
        surveys.setDescription("Description");
        surveys.setQuestion("Question");
        doNothing().when(surveysDAO).updateSurveys(surveys);
        surveysService.updateSurveys(surveys);
        verify(surveysDAO, times(1)).updateSurveys(surveys);
        assertEquals("Description", surveys.getDescription());
    }

    @Test
    public void testDelete() {
        int id = 2;
        doNothing().when(surveysDAO).deleteSurveys(id);
        when(surveysDAO.getSurveysById(id)).thenReturn(null);
        surveysService.deleteSurveys(id);
        verify(surveysDAO, times(1)).deleteSurveys(id);
        assertNull(surveysService.getSurveyById(id));
    }
}
