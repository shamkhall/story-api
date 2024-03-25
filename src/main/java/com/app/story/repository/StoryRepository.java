package com.app.story.repository;

import com.app.story.models.StoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoryRepository extends JpaRepository<StoryEntity, Integer> {
}
