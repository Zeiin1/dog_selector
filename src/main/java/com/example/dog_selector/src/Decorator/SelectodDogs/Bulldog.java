package com.example.dog_selector.src.Decorator.SelectodDogs;

import com.example.dog_selector.src.Decorator.SelectedDog;

public class Bulldog extends SelectedDog {

    public Bulldog() {
        description = "Bulldog";
    }

    @Override
    public double cost() {
        return 1.27;
    }
}
