package com.itclopedia.cources;

import com.itclopedia.cources.models.Comments;

import java.sql.SQLException;
import java.util.List;

public class CommentsService {
    private final CommentsDAO commentsDAO;

    public CommentsService(CommentsDAO commentsDAO) {
        this.commentsDAO = new CommentsDAO();
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
