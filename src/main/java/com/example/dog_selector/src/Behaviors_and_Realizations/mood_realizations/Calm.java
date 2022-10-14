package com.example.dog_selector.src.Behaviors_and_Realizations.mood_realizations;


import com.example.dog_selector.src.Behaviors_and_Realizations.MoodBehavior;

public class Calm implements MoodBehavior {
    @Override
    public String mood() { return "CALM"; }

    @Override
    public boolean mood(String mood) {
        return mood().equals(mood);
    }
}
