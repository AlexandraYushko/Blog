package com.itclopedia.cources;

import com.itclopedia.cources.models.Comments;

public class CommentsStarter {
    public static void main(String[] args) {
        CommentsDAO commentsDAO = new CommentsDAO();
        CommentsService commentsService = new CommentsService(commentsDAO);

        Comments comment = new Comments();
        comment.setText("Comment");
        comment.setArticleId(1);
        comment.setAuthorId(1);
        commentsService.createComment(comment);

        comment.setText("New Comment");
        commentsService.updateComment(comment);

        int commentId = comment.getId();
        Comments newComment = commentsService.getCommentById(commentId);
        System.out.println("Ответ " + newComment);

        int delComment = 2;
        commentsService.deleteComment(delComment);
    }
}
