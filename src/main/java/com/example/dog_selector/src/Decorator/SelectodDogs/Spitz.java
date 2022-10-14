package com.example.dog_selector.src.Decorator.SelectodDogs;

import com.example.dog_selector.src.Decorator.SelectedDog;

public class Spitz extends SelectedDog {

    public Spitz() {
        description = "Spitz";
    }

    @Override
    public double cost() {
        return 1.37;
    }
}
