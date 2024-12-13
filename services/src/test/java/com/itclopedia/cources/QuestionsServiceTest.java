package com.itclopedia.cources;

import com.itclopedia.cources.models.Questions;
import org.junit.Test;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class QuestionsServiceTest {
    private QuestionsService questionsService;
    private QuestionsDAO questionsDAO;

    @BeforeEach
    public void setup() {
        questionsDAO = Mockito.mock(QuestionsDAO.class);
        questionsService = new QuestionsService(questionsDAO);
    }

    @Test
    public void testCreate() {
        Questions question = new Questions();
        question.setQuestion("Question");
        doNothing().when(questionsDAO).addQuestion(question);
        questionsService.createQuestion(question);
        verify(questionsDAO, times(1)).addQuestion(question);
    }

    @Test
    public void testUpdate() {
        Questions questions = new Questions();
        questions.setQuestion("Quest");
        doNothing().when(questionsDAO).updateQuestion(questions);
        questionsService.updateQuestion(questions);
        verify(questionsDAO, times(1)).updateQuestion(questions);
        assertEquals("Quest", questions.getQuestion());
    }

    @Test
    public void testDelete() {
        int id = 4;
        doNothing().when(questionsDAO).deleteQuestion(id);
        when(questionsDAO.getQuestionById(id)).thenReturn(null);
        questionsService.deleteQuestion(id);
        verify(questionsDAO, times(1)).deleteQuestion(id);
        assertNull(questionsService.getQuestionById(id));
    }
}
