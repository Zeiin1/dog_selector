package com.example.dog_selector.src.Behaviors_and_Realizations.lifestyle_realizations;


import com.example.dog_selector.src.Behaviors_and_Realizations.LifestyleBehavior;

public class Street implements LifestyleBehavior {
    @Override
    public String lifestyle() {
        return "STREET";
    }

    @Override
    public boolean lifestyle(String lifestyle) {
        return lifestyle().equals(lifestyle);
    }
}
