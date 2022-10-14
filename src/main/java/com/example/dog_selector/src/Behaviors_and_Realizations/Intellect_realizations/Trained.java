package com.example.dog_selector.src.Behaviors_and_Realizations.Intellect_realizations;


import com.example.dog_selector.src.Behaviors_and_Realizations.IntellectBehavior;

public class Trained implements IntellectBehavior {
    @Override
    public String intellect() { return "TRAINED"; }

    @Override
    public boolean intellect(String intellect) {
        return intellect().equals(intellect);
    }
}
