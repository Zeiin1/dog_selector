package com.example.dog_selector.src.Decorator.SelectodDogs;

import com.example.dog_selector.src.Decorator.SelectedDog;

public class Labrador extends SelectedDog {

    public Labrador() {
        description = "Labrador";
    }

    @Override
    public double cost() {
        return 1.33;
    }
}
