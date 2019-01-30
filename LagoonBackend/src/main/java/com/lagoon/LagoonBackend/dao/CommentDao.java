package com.lagoon.LagoonBackend.dao;

import com.lagoon.LagoonBackend.model.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentDao extends CrudRepository<Comment, Long> {
    Comment save(Comment comment);
    List<Comment> findByPhotoId(Long photoId);
    Comment findByCommentId(Long commentId);
}
