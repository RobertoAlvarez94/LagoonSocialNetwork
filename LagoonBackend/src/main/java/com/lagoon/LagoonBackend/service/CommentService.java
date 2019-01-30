package com.lagoon.LagoonBackend.service;

import com.lagoon.LagoonBackend.model.Comment;

import java.util.List;


public interface CommentService {
    Comment save(Comment comment);
    List<Comment> findByPhotoId(Long photoId);
    Comment findByCommentId(Long commentId);
}
