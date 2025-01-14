package com.itclopedia.cources;

import com.itclopedia.cources.models.Answer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class AnswerServiceTest {
    private AnswerRepository answerRepository;
    private AnswerService answerService;

    @BeforeEach
    public void setup() {
        answerRepository = Mockito.mock(AnswerRepository.class);
        answerService = new AnswerService(answerRepository);
    }

    @Test
    public void testCreate() {
        Answer answer = new Answer();
        answer.setAnswer("Answer");
        answer.setCorrect(true);
        answerService.createAnswer(answer);
        verify(answerRepository, times(1)).save(answer);
        assertEquals("Answer", answer.getAnswer());
    }

    @Test
    public void testUpdate() {
        Answer answer = new Answer();
        answer.setId(1);
        answer.setAnswer("Answer");
        answer.setCorrect(true);
        when(answerRepository.existsById(answer.getId())).thenReturn(true);
        answerService.updateAnswer(answer);
        verify(answerRepository, times(1)).save(answer);
        assertEquals("Answer", answer.getAnswer());
    }

    @Test
    public void testRead() {
        int id = 3;
        Answer answer = new Answer();
        answer.setAnswer("Answer");
        when(answerRepository.findById(id)).thenReturn(Optional.of(answer));
        Answer foundAnswer = answerService.getAnswerById(id);
        assertEquals("Answer", foundAnswer.getAnswer());
    }

    @Test
    public void testDelete() {
        int id = 2;
        when(answerRepository.existsById(id)).thenReturn(null);
        answerService.deleteAnswer(id);
        verify(answerRepository, times(1)).deleteById(id);
    }
}
