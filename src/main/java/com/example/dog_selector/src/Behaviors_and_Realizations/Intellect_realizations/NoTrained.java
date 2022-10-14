package com.example.dog_selector.src.Behaviors_and_Realizations.Intellect_realizations;


import com.example.dog_selector.src.Behaviors_and_Realizations.IntellectBehavior;

public class NoTrained implements IntellectBehavior {
    @Override
    public String intellect() {
        return "NOTRAINED";
    }

    @Override
    public boolean intellect(String intellect) {
        return intellect().equals(intellect);
    }
}
