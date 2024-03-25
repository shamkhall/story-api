package com.app.story.service;

import com.app.story.models.Story;
import com.app.story.models.StoryEntity;

import java.util.Collection;
import java.util.Optional;

public interface StoryService {
    Collection<StoryEntity> findAll ();

    Story create (Story story);

    Optional<Story> findById(int id);

    Story update (int id, Story story);

    void delete (int id);
}
