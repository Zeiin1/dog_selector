package com.example.dog_selector.src.Decorator.SelectodDogs;

import com.example.dog_selector.src.Decorator.SelectedDog;

public class Doberman extends SelectedDog {

    public Doberman() {
        description = "Doberman";
    }

    @Override
    public double cost() {
        return 1.31;
    }
}
