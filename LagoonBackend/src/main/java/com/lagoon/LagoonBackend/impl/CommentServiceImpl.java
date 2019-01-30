package com.lagoon.LagoonBackend.impl;

import com.lagoon.LagoonBackend.dao.CommentDao;
import com.lagoon.LagoonBackend.model.Comment;
import com.lagoon.LagoonBackend.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
    public Comment findByCommentId(Long commentId) {
        return commentDao.findByCommentId(commentId);
    }


}
