package com.itclopedia.cources;

import com.itclopedia.cources.models.Comments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentsService {
    private final CommentsDAO commentsDAO;

    @Autowired
    public CommentsService(CommentsDAO commentsDAO) {
        this.commentsDAO = commentsDAO;
    }

    public void createComment(Comments comment) {
        commentsDAO.addComments(comment);
    }

    public void updateComment(Comments comment) {
        commentsDAO.updateComments(comment);
    }

    public void deleteComment(int commentId) {
        commentsDAO.deleteComments(commentId);
    }

    public Comments getCommentById(int commentId) {
        return commentsDAO.getCommentsById(commentId);
    }
}
