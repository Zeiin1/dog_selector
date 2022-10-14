package com.example.dog_selector.src.selection_options;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Service;

@Data
@Getter
@Setter
@ToString
public class Behavior_options {
    public String intellect;
    public String size;
    public String mood;
    public String lifeStyle;


    public Behavior_options(String intellect, String size, String mood, String lifeStyle) {
        this.intellect = intellect;
        this.size = size;
        this.mood = mood;
        this.lifeStyle = lifeStyle;
    }
    public Behavior_options()
    {

    }
}
