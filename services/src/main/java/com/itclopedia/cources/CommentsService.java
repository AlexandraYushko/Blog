package com.itclopedia.cources;

import com.itclopedia.cources.models.Comments;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CommentsService {
    private final CommentsRepository commentsRepository;

    @Autowired
    public CommentsService(CommentsRepository commentsRepository) {
        this.commentsRepository = commentsRepository;
    }

    public void createComment(Comments comment) {
        commentsRepository.save(comment);
    }

    public void updateComment(Comments comment) {
        commentsRepository.save(comment);
    }

    public void deleteComment(int commentId) {
        commentsRepository.deleteById(commentId);
    }

    public Comments getCommentById(int commentId) {
        return commentsRepository.findById(commentId).orElse(null);
    }
}
