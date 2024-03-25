package com.app.story;

import com.app.story.models.ResponseMessage;
import com.app.story.models.Story;
import com.app.story.models.StoryEntity;
import com.app.story.service.impl.StoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("story")
public class StoryController {
    @Autowired
    private StoryServiceImpl storyService;

    @GetMapping("all")
    public Collection<StoryEntity> getAllStory () {
        return storyService.findAll();
    }

    @PostMapping()
    public @ResponseBody ResponseMessage create (@RequestBody Story story) {
        storyService.create(story);
        return new ResponseMessage("A story has been created");
    }

    @GetMapping("{id}")
    public @ResponseBody Optional<Story> findById (@PathVariable int id) {
        return storyService.findById(id);
    }

    @PatchMapping("{id}")
    public Story update (@PathVariable int id, @RequestBody Story story) {
        return storyService.update(id, story);
    }

    @DeleteMapping("{id}")
    public ResponseMessage delete (@PathVariable int id) {
        storyService.delete(id);
        return new ResponseMessage("A story has been deleted");
    }
}
