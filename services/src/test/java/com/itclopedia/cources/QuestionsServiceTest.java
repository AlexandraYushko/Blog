package com.itclopedia.cources;

import com.itclopedia.cources.models.Questions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class QuestionsServiceTest {
    private QuestionsService questionsService;
    private QuestionRepository questionRepository;

    @BeforeEach
    public void setup() {
        questionRepository = Mockito.mock(QuestionRepository.class);
        questionsService = new QuestionsService(questionRepository);
    }

    @Test
    public void testCreate() {
        Questions question = new Questions();
        question.setQuestion("Question");
        questionsService.createQuestion(question);
        verify(questionRepository, times(1)).save(question);
        assertEquals("Question", question.getQuestion());
    }

    @Test
    public void testUpdate() {
        Questions questions = new Questions();
        questions.setQuestion("Quest");
        when(questionRepository.existsById(questions.getId())).thenReturn(true);
        questionsService.updateQuestion(questions);
        verify(questionRepository, times(1)).save(questions);
        assertEquals("Quest", questions.getQuestion());
    }

    @Test
    public void testDelete() {
        int id = 4;
        when(questionRepository.existsById(id)).thenReturn(null);
        questionsService.deleteQuestion(id);
        verify(questionRepository, times(1)).deleteById(id);
    }
}
