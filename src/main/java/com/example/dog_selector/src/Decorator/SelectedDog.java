package com.example.dog_selector.src.Decorator;

public abstract class SelectedDog {
    public String description = "Unknown Dog";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}
