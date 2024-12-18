package com.itclopedia.cources;

import com.itclopedia.cources.models.Comments;
import org.junit.Test;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

public class CommentsServiceTest {
    private CommentsService commentsService;
    private CommentsDAO commentsDAO;

    @BeforeEach
    public void setup() {
        commentsDAO = Mockito.mock(CommentsDAO.class);
        commentsService = new CommentsService(commentsDAO);
    }

    @Test
    public void testCreate() {
        Comments comments = new Comments();
        comments.setArticleId(2);
        comments.setAuthorId(3);
        comments.setText("Text");
        doNothing().when(commentsDAO).addComments(comments);
        commentsService.createComment(comments);
        verify(commentsDAO, times(1)).addComments(comments);
    }

    @Test
    public void testUpdate() {
        Comments comments = new Comments();
        comments.setText("Text");
        doNothing().when(commentsDAO).updateComments(comments);
        commentsService.updateComment(comments);
        verify(commentsDAO, times(1)).updateComments(comments);
        assertEquals("Text", comments.getText());
    }

    @Test
    public void testDelete() {
        int id = 2;
        when(commentsDAO.getCommentsById(id)).thenReturn(null);
        commentsService.deleteComment(id);
        verify(commentsDAO, times(1)).deleteComments(id);
        assertNull(commentsService.getCommentById(id));
    }
}
