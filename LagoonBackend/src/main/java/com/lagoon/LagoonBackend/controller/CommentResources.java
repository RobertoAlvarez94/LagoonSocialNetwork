package com.lagoon.LagoonBackend.controller;

import com.lagoon.LagoonBackend.model.Comment;
import com.lagoon.LagoonBackend.model.Photo;
import com.lagoon.LagoonBackend.service.CommentService;
import com.lagoon.LagoonBackend.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class CommentResources {

    @Autowired
    PhotoService photoService;

    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/comment/add", method = RequestMethod.POST)
    public void addComment(@RequestBody Comment comment){
        Photo photo = photoService.findByPhotoId(comment.getPhotoId());
        List<Comment> commentList = photo.getComments();
        comment.setPhoto(photo);
        commentService.save(comment);
    }
}
