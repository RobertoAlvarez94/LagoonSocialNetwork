package com.lagoon.LagoonBackend.dao;

import com.lagoon.LagoonBackend.model.Comment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentDao extends CrudRepository<Comment, Long> {
    Comment save(Comment comment);
    List<Comment> findByPhotoId(Long photoId);
    Comment findOne(Long commentId);
}
