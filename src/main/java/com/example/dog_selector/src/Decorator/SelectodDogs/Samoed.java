package com.example.dog_selector.src.Decorator.SelectodDogs;

import com.example.dog_selector.src.Decorator.SelectedDog;

public class Samoed extends SelectedDog {

    public Samoed() {
        description = "Samoed";
    }

    @Override
    public double cost() {
        return 1.36;
    }
}
