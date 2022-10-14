package com.example.dog_selector.src.Behaviors_and_Realizations.size_realizations;


import com.example.dog_selector.src.Behaviors_and_Realizations.SizeBehavior;

public class Small implements SizeBehavior {
    @Override
    public String size() {
        return "SMALL";
    }

    @Override
    public boolean size(String size) {
        return size().equals(size);
    }
}
