package com.app.story.service.impl;

import com.app.story.models.Story;
import com.app.story.models.StoryEntity;
import com.app.story.repository.StoryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class StoryServiceImplTests {
    @Mock
    private StoryRepository storyRepository;

    @InjectMocks
    private StoryServiceImpl storyService;

    @Test
    public void testThatStoryIsSaved () {
        final Story story = Story.builder().name("new").build();

        final StoryEntity storyEntity = StoryEntity.builder().name("new").build();

        when(storyRepository.save(eq(storyEntity))).thenReturn(storyEntity);

        Story result = storyService.create(story);

        Assertions.assertEquals(result, story);
    }
}
