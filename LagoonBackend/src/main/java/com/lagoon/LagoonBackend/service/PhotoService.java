package com.lagoon.LagoonBackend.service;

import com.lagoon.LagoonBackend.model.Photo;
import com.lagoon.LagoonBackend.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PhotoService {
    Photo save(Photo photo);
    List<Photo> findAll();
    List<Photo> findByUser(User user);
    Photo findByPhotoId(Long photoId);
}
