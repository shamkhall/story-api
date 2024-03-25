package com.app.story.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "story", schema = "public")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Override
    public String toString () {
        return "id: " + this.getId() + ", name: " + this.getName();
    }
}
