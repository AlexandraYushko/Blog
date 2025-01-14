package com.itclopedia.cources;

import com.itclopedia.cources.models.Surveys;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class SurveysServiceTest {
    private SurveysService surveysService;
    private SurveysRepository surveysRepository;

    @BeforeEach
    public void setup() {
        surveysRepository = Mockito.mock(SurveysRepository.class);
        surveysService = new SurveysService(surveysRepository);
    }

    @Test
    public void testCreate() {
        Surveys surveys = new Surveys();
        surveys.setDescription("Desc");
        surveys.setQuestion("Question");
        surveys.setType("Type");
        surveysService.createSurveys(surveys);
        verify(surveysRepository, times(1)).save(surveys);
        assertEquals("Desc", surveys.getDescription());
    }

    @Test
    public void testUpdate() {
        Surveys surveys = new Surveys();
        surveys.setDescription("Description");
        surveys.setQuestion("Question");
        when(surveysRepository.existsById(surveys.getId())).thenReturn(true);
        surveysService.updateSurveys(surveys);
        verify(surveysRepository, times(1)).save(surveys);
        assertEquals("Description", surveys.getDescription());
    }

    @Test
    public void testDelete() {
        int id = 2;
        when(surveysRepository.existsById(id)).thenReturn(null);
        surveysService.deleteSurveys(id);
        verify(surveysRepository, times(1)).deleteById(id);
    }
}
