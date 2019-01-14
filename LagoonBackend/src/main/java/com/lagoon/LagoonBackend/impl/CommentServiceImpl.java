package com.lagoon.LagoonBackend.impl;

import com.lagoon.LagoonBackend.dao.CommentDao;
import com.lagoon.LagoonBackend.model.Comment;
import com.lagoon.LagoonBackend.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentDao commentDao;

    @Override
    public Comment save(Comment comment) {
        return commentDao.save(comment);
    }

    @Override
    public List<Comment> findByPhotoId(Long photoId) {
        return commentDao.findByPhotoId(photoId);
    }

    @Override
    public Comment findOne(Long commentId) {
        return commentDao.findOne(commentId);
    }
}
