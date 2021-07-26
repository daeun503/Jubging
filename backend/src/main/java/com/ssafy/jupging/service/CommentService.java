package com.ssafy.jupging.service;

import com.ssafy.jupging.domain.entity.Comment;
import com.ssafy.jupging.domain.repository.CommentRepository;
import com.ssafy.jupging.dto.CommentSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;

    @Transactional
    public void saveComment(Comment comment) {
        commentRepository.save(comment);
    }

    @Transactional
    public void deleteComment(int comment_id) {
        Optional<Comment> comment = commentRepository.findByCommentId(comment_id);
        commentRepository.delete(comment.get());
    }

    @Transactional
    public int countByArticleId(int article_id) {
        return Math.toIntExact(commentRepository.countByArticleId(article_id));
    }
}