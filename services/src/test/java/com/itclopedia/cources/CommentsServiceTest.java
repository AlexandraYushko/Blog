package com.itclopedia.cources;

import com.itclopedia.cources.models.Comments;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

public class CommentsServiceTest {
    private CommentsService commentsService;
    private CommentsRepository commentsRepository;

    @BeforeEach
    public void setup() {
        commentsRepository = Mockito.mock(CommentsRepository.class);
        commentsService = new CommentsService(commentsRepository);
    }

    @Test
    public void testCreate() {
        Comments comments = new Comments();
        comments.setArticleId(2);
        comments.setAuthorId(3);
        comments.setText("Text");
        commentsService.createComment(comments);
        verify(commentsRepository, times(1)).save(comments);
    }

    @Test
    public void testUpdate() {
        Comments comments = new Comments();
        comments.setText("Text");
        when(commentsRepository.existsById(comments.getId())).thenReturn(true);
        commentsService.updateComment(comments);
        verify(commentsRepository, times(1)).save(comments);
        assertEquals("Text", comments.getText());
    }

    @Test
    public void testDelete() {
        int id = 2;
        when(commentsRepository.existsById(id)).thenReturn(null);
        commentsService.deleteComment(id);
        verify(commentsRepository, times(1)).deleteById(id);
    }
}
