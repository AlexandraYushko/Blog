package com.itclopedia.cources;

import com.itclopedia.cources.models.Comments;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CommentsStarter {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        CommentsService commentsService = context.getBean(CommentsService.class);

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

        context.close();
    }
}
