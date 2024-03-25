package com.app.story.service.impl;

import com.app.story.models.Story;
import com.app.story.models.StoryEntity;
import com.app.story.repository.StoryRepository;
import com.app.story.service.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class StoryServiceImpl implements StoryService {
    private final StoryRepository storyRepository;

    @Autowired
    public StoryServiceImpl (StoryRepository storyRepository) {
        this.storyRepository = storyRepository;
    }

    @Override
    public Collection<StoryEntity> findAll() {
        return storyRepository.findAll();
    }

    @Override
    public Story create(Story story) {
        final StoryEntity storyEntity = storyToStoryEntity(story);
        final StoryEntity savedStoryEntity = storyRepository.save(storyEntity);
        return storyEntityToStory(savedStoryEntity);
    }

    @Override
    public Optional<Story> findById(int id) {
        final Optional<StoryEntity> findStory = storyRepository.findById(id);
        return findStory.map(this::storyEntityToStory);
    }

    @Override
    public Story update(int id, Story story) {
        StoryEntity storyEntity = storyRepository.findById(id).get();

        storyEntity.setName(story.getName());

        StoryEntity newStoryEntity = storyRepository.save(storyEntity);
        return storyEntityToStory(newStoryEntity);
    }

    @Override
    public void delete(int id) {
        storyRepository.deleteById(id);
    }

    public StoryEntity storyToStoryEntity (Story story) {
        return StoryEntity.builder()
                .name(story.getName())
                .build();
    }

    public Story storyEntityToStory (StoryEntity storyEntity) {
        return Story.builder()
                .name(storyEntity.getName()).build();
    }
}






