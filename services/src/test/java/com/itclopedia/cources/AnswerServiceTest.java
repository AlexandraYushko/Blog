package com.itclopedia.cources;

import com.itclopedia.cources.models.Answer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

public class AnswerServiceTest {
    private AnswerDAO answerDAO;
    private AnswerService answerService;

    @BeforeEach
    public void setup() {
        answerDAO = Mockito.mock(AnswerDAO.class);
        answerService = new AnswerService(answerDAO);
    }

    @Test
    public void testCreate() {
        Answer answer = new Answer();
        answer.setAnswer("Answer");
        answer.setCorrect(true);
        answerService.createAnswer(answer);
        verify(answerDAO, times(1)).addAnswer(answer);
        assertEquals("Answer", answer.getAnswer());
    }

    @Test
    public void testUpdate() {
        Answer answer = new Answer();
        answer.setAnswer("Answer");
        answer.setCorrect(true);
        answerService.updateAnswer(answer);
        verify(answerDAO, times(1)).updateAnswer(answer);
        assertEquals("Answer", answer.getAnswer());
    }

    @Test
    public void testRead() {
        int id = 3;
        Answer answer = new Answer();
        answer.setAnswer("Answer");
        when(answerDAO.getAnswerById(id)).thenReturn(answer);
        Answer foundAnswer = answerService.getAnswerById(id);
        assertEquals("Answer", foundAnswer.getAnswer());
    }

    @Test
    public void testDelete() {
        int id = 2;
        when(answerDAO.getAnswerById(id)).thenReturn(null);
        answerService.deleteAnswer(id);
        verify(answerDAO, times(1)).deleteAnswer(id);
        assertNull(answerService.getAnswerById(id));
    }
}
